/*
 * Copyright (c) http://www.svoflee.com All rights reserved.
 **************************************************************************
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *  
 *      http://www.apache.org/licenses/LICENSE-2.0
 *  
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 **************************************************************************      
 */

package com.svoflee.spartacus.core.utils.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.UndeclaredThrowableException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import com.svoflee.spartacus.core.log.Logger;
import com.svoflee.spartacus.core.utils.Assert;
import com.svoflee.spartacus.core.utils.StringUtils;

/**
 * ReflectionUtils 是反射工具类.
 * 提供访问私有变量,获取泛型类型Class, 提取集合中元素的属性, 转换字符串到对象等Util函数.
 * 
 * @author <a href="mailto:svoflee@gmail.com">svoflee</a>
 * @since 1.0.0
 * @version 1.0.0
 */
public class ReflectionUtils {

    private static final transient Logger logger = Logger.getLogger(ReflectionUtils.class.getName());

    /**
     * 直接读取对象属性值, 无视private/protected修饰符, 不经过getter函数.
     */
    public static Object getFieldValue(final Object obj, final String fieldName) {
        Field field = getAccessibleField(obj, fieldName);

        if (field == null) {
            throw new IllegalArgumentException("Could not find field [" + fieldName + "] on target [" + obj + "]");
        }

        Object result = null;
        try {
            result = field.get(obj);
        }
        catch (IllegalAccessException e) {
            logger.error("不可能抛出的异常:{}", e.getMessage());
        }
        return result;
    }

    /**
     * 直接设置对象属性值, 无视private/protected修饰符, 不经过setter函数.
     */
    public static void setFieldValue(final Object obj, final String fieldName, final Object value) {
        Field field = getAccessibleField(obj, fieldName);

        if (field == null) {
            throw new IllegalArgumentException("Could not find field [" + fieldName + "] on target [" + obj + "]");
        }

        try {
            field.set(obj, value);
        }
        catch (IllegalAccessException e) {
            logger.error("不可能抛出的异常:{}", e.getMessage());
        }
    }

    /**
     * 循环向上转型, 获取对象的DeclaredField, 并强制设置为可访问.
     * 如向上转型到Object仍无法找到, 返回null.
     */
    public static Field getAccessibleField(final Object obj, final String fieldName) {
        Assert.notNull(obj, "object不能为空");
        Assert.hasText(fieldName, "fieldName");
        for (Class<?> superClass = obj.getClass(); superClass != Object.class; superClass = superClass.getSuperclass()) {
            try {
                Field field = superClass.getDeclaredField(fieldName);
                field.setAccessible(true);
                return field;
            }
            catch (NoSuchFieldException e) {// NOSONAR
                // Field不在当前类定义,继续向上转型
            }
        }
        return null;
    }

    /**
     * 直接调用对象方法, 无视private/protected修饰符. 用于一次性调用的情况.
     */
    public static Object invokeMethod(final Object obj, final String methodName, final Class<?>[] parameterTypes,
            final Object[] args) {
        Method method = getAccessibleMethod(obj, methodName, parameterTypes);
        if (method == null) {
            throw new IllegalArgumentException("Could not find method [" + methodName + "] on target [" + obj + "]");
        }

        try {
            return method.invoke(obj, args);
        }
        catch (Exception e) {
            throw convertReflectionExceptionToUnchecked(e);
        }
    }

    /**
     * 通过反射, 获得Class定义中声明的父类的泛型参数的类型. 如无法找到, 返回Object.class.
     * 如public UserDao extends BaseHibernateDao<User,Long>
     * 
     * @param clazz
     *            clazz The class to introspect
     * @param index
     *            the Index of the generic ddeclaration,start from 0.
     * @return the index generic declaration, or Object.class if cannot be
     *         determined
     */
    @SuppressWarnings("unchecked")
    public static Class getSuperClassGenricType(final Class clazz, final int index) {
        Type genType = clazz.getGenericSuperclass();

        if (!(genType instanceof ParameterizedType)) {
            logger.warn(clazz.getSimpleName() + "'s superclass not ParameterizedType");
            return Object.class;
        }

        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();

        if ((index >= params.length) || (index < 0)) {
            logger.warn("Index: " + index + ", Size of " + clazz.getSimpleName() + "'s Parameterized DataType: "
                    + params.length);
            return Object.class;
        }
        if (!(params[index] instanceof Class)) {
            logger.warn(clazz.getSimpleName() + " not set the actual class on superclass generic parameter");
            return Object.class;
        }

        return (Class) params[index];
    }

    /**
     * 将反射时的checked exception转换为unchecked exception.
     */
    public static RuntimeException convertReflectionExceptionToUnchecked(Exception e) {
        if ((e instanceof IllegalAccessException) || (e instanceof IllegalArgumentException)
                || (e instanceof NoSuchMethodException)) {
            return new IllegalArgumentException("Reflection Exception.", e);
        }
        else if (e instanceof InvocationTargetException) {
            return new RuntimeException("Reflection Exception.", ((InvocationTargetException) e).getTargetException());
        }
        else if (e instanceof RuntimeException) {
            return (RuntimeException) e;
        }
        return new RuntimeException("Unexpected Checked Exception.", e);
    }

    /**
     * 调用Getter方法.
     */
    public static Object invokeGetterMethod(Object obj, String propertyName) {
        String getterMethodName = "get" + StringUtils.capitalize(propertyName);
        return invokeMethod(obj, getterMethodName, new Class[] {}, new Object[] {});
    }

    /**
     * 调用Setter方法.使用value的Class来查找Setter方法.
     */
    public static void invokeSetterMethod(Object obj, String propertyName, Object value) {
        invokeSetterMethod(obj, propertyName, value, null);
    }

    /**
     * 调用Setter方法.
     * 
     * @param propertyType 用于查找Setter方法,为空时使用value的Class替代.
     */
    public static void invokeSetterMethod(Object obj, String propertyName, Object value, Class<?> propertyType) {
        Class<?> type = propertyType != null ? propertyType : value.getClass();
        String setterMethodName = "set" + StringUtils.capitalize(propertyName);
        invokeMethod(obj, setterMethodName, new Class[] { type }, new Object[] { value });
    }

    /**
     * 循环向上转型, 获取对象的DeclaredMethod,并强制设置为可访问.
     * 如向上转型到Object仍无法找到, 返回null.
     * 用于方法需要被多次调用的情况. 先使用本函数先取得Method,然后调用Method.invoke(Object obj, Object... args)
     */
    public static Method getAccessibleMethod(final Object obj, final String methodName,
            final Class<?>... parameterTypes) {
        Assert.notNull(obj, "object不能为空");

        for (Class<?> superClass = obj.getClass(); superClass != Object.class; superClass = superClass.getSuperclass()) {
            try {
                Method method = superClass.getDeclaredMethod(methodName, parameterTypes);

                method.setAccessible(true);

                return method;

            }
            catch (NoSuchMethodException e) {// NOSONAR
                // Method不在当前类定义,继续向上转型
            }
        }
        return null;
    }

    /**
     * 通过反射, 获得Class定义中声明的父类的泛型参数的类型.
     * 如无法找到, 返回Object.class.
     * eg.
     * public UserDao extends HibernateDao<User>
     * 
     * @param clazz The class to introspect
     * @return the first generic declaration, or Object.class if cannot be determined
     */
    @SuppressWarnings("unchecked")
    public static <T> Class<T> getSuperClassGenricType(final Class clazz) {
        return getSuperClassGenricType(clazz, 0);
    }

    /**
     * 返回该类的所有非静态字段
     * 
     * @param clazz
     * @return
     */
    public static List<Field> getNotStaticFields(Class clazz) {
        List<Field> r = new ArrayList();
        Field[] fs = clazz.getDeclaredFields();
        for (Field element : fs) {
            Field f = element;
            if (!Modifier.isStatic(f.getModifiers())) {
                // 如果是静态常量，则跳过
                r.add(f);
            }
        }
        return r;
    }

    // /**
    // * 判断该属性是否为Entity类型，通过它的完整包名进行判断
    // *
    // * @param f
    // * @return
    // */
    // public static boolean isEntityProperty(Field f) {
    // Class<?> fType = f.getType();
    // String typeNm = fType.getName();
    // if (StringUtils.contains(typeNm, "entity"))// 如果是entity包下面的，则为关联对象
    // {
    // // XXX:可能这种判断entity包下面的方式存在bug
    // return true;
    // }
    // return false;
    // }

    /**
     * 返回一个字段属性的简单类型名，比如private com.system.entity.User user;此时返回User
     * 
     * @param f
     * @return
     */
    public static String getPropertyTypeSimpleName(Field f) {
        Class<?> fType = f.getType();
        // StringUtils.substringAfterLast(fType.getSimpleName(), separator)
        return fType.getSimpleName();
    }

    /**
     * Map Collection Array 返回true
     * 
     * @param entityClass
     * @param f
     * @return
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public static boolean isMapOrCollectionType(Class entityClass, Field f) throws InstantiationException,
            IllegalAccessException {
        Class<?> fType = f.getType();
        if (fType.isArray()) {
            return true;
        }
        // Object entityObj = entityClass.newInstance();
        // Object fTypeObj = f.get(entityObj);
        // Object fTypeObj = fType.newInstance();
        String fTypeName = fType.getName();
        // XXX:通过类型名进行判断的方式有问题，需要更改
        if (StringUtils.contains(fTypeName, "Set")) {
            return true;
        }
        if (StringUtils.contains(fTypeName, "List") || StringUtils.contains(fTypeName, "Collection")) {
            return true;
        }
        if (StringUtils.contains(fTypeName, "Map")) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        Field[] fs = TestClass.class.getDeclaredFields();
        System.out.println(fs.length);
        for (Field f : fs) {
            System.out.println(f.getName() + "   " + ReflectionUtils.isMapOrCollectionType(TestClass.class, f));
            // logger.debug("{}",ReflectionUtils.isMapOrCollectionType(TestClass.class, f));
        }
    }

    private static final Pattern CGLIB_RENAMED_METHOD_PATTERN = Pattern.compile("CGLIB\\$(.+)\\$\\d+");

    /**
     * Attempt to find a {@link Field field} on the supplied {@link Class} with the
     * supplied {@code name}. Searches all superclasses up to {@link Object}.
     * 
     * @param clazz the class to introspect
     * @param name the name of the field
     * @return the corresponding Field object, or {@code null} if not found
     */
    public static Field findField(Class<?> clazz, String name) {
        return findField(clazz, name, null);
    }

    /**
     * Attempt to find a {@link Field field} on the supplied {@link Class} with the
     * supplied {@code name} and/or {@link Class type}. Searches all superclasses
     * up to {@link Object}.
     * 
     * @param clazz the class to introspect
     * @param name the name of the field (may be {@code null} if type is specified)
     * @param type the type of the field (may be {@code null} if name is specified)
     * @return the corresponding Field object, or {@code null} if not found
     */
    public static Field findField(Class<?> clazz, String name, Class<?> type) {
        Assert.notNull(clazz, "Class must not be null");
        Assert.isTrue((name != null) || (type != null), "Either name or type of the field must be specified");
        Class<?> searchType = clazz;
        while (!Object.class.equals(searchType) && (searchType != null)) {
            Field[] fields = searchType.getDeclaredFields();
            for (Field field : fields) {
                if (((name == null) || name.equals(field.getName()))
                        && ((type == null) || type.equals(field.getType()))) {
                    return field;
                }
            }
            searchType = searchType.getSuperclass();
        }
        return null;
    }

    /**
     * Set the field represented by the supplied {@link Field field object} on the
     * specified {@link Object target object} to the specified {@code value}.
     * In accordance with {@link Field#set(Object, Object)} semantics, the new value
     * is automatically unwrapped if the underlying field has a primitive type.
     * <p>
     * Thrown exceptions are handled via a call to {@link #handleReflectionException(Exception)}.
     * 
     * @param field the field to set
     * @param target the target object on which to set the field
     * @param value the value to set; may be {@code null}
     */
    public static void setField(Field field, Object target, Object value) {
        try {
            field.set(target, value);
        }
        catch (IllegalAccessException ex) {
            handleReflectionException(ex);
            throw new IllegalStateException("Unexpected reflection exception - " + ex.getClass().getName() + ": "
                    + ex.getMessage());
        }
    }

    /**
     * Get the field represented by the supplied {@link Field field object} on the
     * specified {@link Object target object}. In accordance with {@link Field#get(Object)} semantics, the returned
     * value is automatically wrapped if the underlying field
     * has a primitive type.
     * <p>
     * Thrown exceptions are handled via a call to {@link #handleReflectionException(Exception)}.
     * 
     * @param field the field to get
     * @param target the target object from which to get the field
     * @return the field's current value
     */
    public static Object getField(Field field, Object target) {
        try {
            return field.get(target);
        }
        catch (IllegalAccessException ex) {
            handleReflectionException(ex);
            throw new IllegalStateException("Unexpected reflection exception - " + ex.getClass().getName() + ": "
                    + ex.getMessage());
        }
    }

    /**
     * Attempt to find a {@link Method} on the supplied class with the supplied name
     * and no parameters. Searches all superclasses up to {@code Object}.
     * <p>
     * Returns {@code null} if no {@link Method} can be found.
     * 
     * @param clazz the class to introspect
     * @param name the name of the method
     * @return the Method object, or {@code null} if none found
     */
    public static Method findMethod(Class<?> clazz, String name) {
        return findMethod(clazz, name, new Class[0]);
    }

    /**
     * Attempt to find a {@link Method} on the supplied class with the supplied name
     * and parameter types. Searches all superclasses up to {@code Object}.
     * <p>
     * Returns {@code null} if no {@link Method} can be found.
     * 
     * @param clazz the class to introspect
     * @param name the name of the method
     * @param paramTypes the parameter types of the method
     *            (may be {@code null} to indicate any signature)
     * @return the Method object, or {@code null} if none found
     */
    public static Method findMethod(Class<?> clazz, String name, Class<?>... paramTypes) {
        Assert.notNull(clazz, "Class must not be null");
        Assert.notNull(name, "Method name must not be null");
        Class<?> searchType = clazz;
        while (searchType != null) {
            Method[] methods = (searchType.isInterface() ? searchType.getMethods() : searchType.getDeclaredMethods());
            for (Method method : methods) {
                if (name.equals(method.getName())
                        && ((paramTypes == null) || Arrays.equals(paramTypes, method.getParameterTypes()))) {
                    return method;
                }
            }
            searchType = searchType.getSuperclass();
        }
        return null;
    }

    /**
     * Invoke the specified {@link Method} against the supplied target object with no arguments.
     * The target object can be {@code null} when invoking a static {@link Method}.
     * <p>
     * Thrown exceptions are handled via a call to {@link #handleReflectionException}.
     * 
     * @param method the method to invoke
     * @param target the target object to invoke the method on
     * @return the invocation result, if any
     * @see #invokeMethod(java.lang.reflect.Method, Object, Object[])
     */
    public static Object invokeMethod(Method method, Object target) {
        return invokeMethod(method, target, new Object[0]);
    }

    /**
     * Invoke the specified {@link Method} against the supplied target object with the
     * supplied arguments. The target object can be {@code null} when invoking a
     * static {@link Method}.
     * <p>
     * Thrown exceptions are handled via a call to {@link #handleReflectionException}.
     * 
     * @param method the method to invoke
     * @param target the target object to invoke the method on
     * @param args the invocation arguments (may be {@code null})
     * @return the invocation result, if any
     */
    public static Object invokeMethod(Method method, Object target, Object... args) {
        try {
            return method.invoke(target, args);
        }
        catch (Exception ex) {
            handleReflectionException(ex);
        }
        throw new IllegalStateException("Should never get here");
    }

    /**
     * Invoke the specified JDBC API {@link Method} against the supplied target
     * object with no arguments.
     * 
     * @param method the method to invoke
     * @param target the target object to invoke the method on
     * @return the invocation result, if any
     * @throws SQLException the JDBC API SQLException to rethrow (if any)
     * @see #invokeJdbcMethod(java.lang.reflect.Method, Object, Object[])
     */
    public static Object invokeJdbcMethod(Method method, Object target) throws SQLException {
        return invokeJdbcMethod(method, target, new Object[0]);
    }

    /**
     * Invoke the specified JDBC API {@link Method} against the supplied target
     * object with the supplied arguments.
     * 
     * @param method the method to invoke
     * @param target the target object to invoke the method on
     * @param args the invocation arguments (may be {@code null})
     * @return the invocation result, if any
     * @throws SQLException the JDBC API SQLException to rethrow (if any)
     * @see #invokeMethod(java.lang.reflect.Method, Object, Object[])
     */
    public static Object invokeJdbcMethod(Method method, Object target, Object... args) throws SQLException {
        try {
            return method.invoke(target, args);
        }
        catch (IllegalAccessException ex) {
            handleReflectionException(ex);
        }
        catch (InvocationTargetException ex) {
            if (ex.getTargetException() instanceof SQLException) {
                throw (SQLException) ex.getTargetException();
            }
            handleInvocationTargetException(ex);
        }
        throw new IllegalStateException("Should never get here");
    }

    /**
     * Handle the given reflection exception. Should only be called if no
     * checked exception is expected to be thrown by the target method.
     * <p>
     * Throws the underlying RuntimeException or Error in case of an InvocationTargetException with such a root cause.
     * Throws an IllegalStateException with an appropriate message else.
     * 
     * @param ex the reflection exception to handle
     */
    public static void handleReflectionException(Exception ex) {
        if (ex instanceof NoSuchMethodException) {
            throw new IllegalStateException("Method not found: " + ex.getMessage());
        }
        if (ex instanceof IllegalAccessException) {
            throw new IllegalStateException("Could not access method: " + ex.getMessage());
        }
        if (ex instanceof InvocationTargetException) {
            handleInvocationTargetException((InvocationTargetException) ex);
        }
        if (ex instanceof RuntimeException) {
            throw (RuntimeException) ex;
        }
        throw new UndeclaredThrowableException(ex);
    }

    /**
     * Handle the given invocation target exception. Should only be called if no
     * checked exception is expected to be thrown by the target method.
     * <p>
     * Throws the underlying RuntimeException or Error in case of such a root cause. Throws an IllegalStateException
     * else.
     * 
     * @param ex the invocation target exception to handle
     */
    public static void handleInvocationTargetException(InvocationTargetException ex) {
        rethrowRuntimeException(ex.getTargetException());
    }

    /**
     * Rethrow the given {@link Throwable exception}, which is presumably the <em>target exception</em> of an
     * {@link InvocationTargetException}. Should
     * only be called if no checked exception is expected to be thrown by the
     * target method.
     * <p>
     * Rethrows the underlying exception cast to an {@link RuntimeException} or {@link Error} if appropriate; otherwise,
     * throws an {@link IllegalStateException}.
     * 
     * @param ex the exception to rethrow
     * @throws RuntimeException the rethrown exception
     */
    public static void rethrowRuntimeException(Throwable ex) {
        if (ex instanceof RuntimeException) {
            throw (RuntimeException) ex;
        }
        if (ex instanceof Error) {
            throw (Error) ex;
        }
        throw new UndeclaredThrowableException(ex);
    }

    /**
     * Rethrow the given {@link Throwable exception}, which is presumably the <em>target exception</em> of an
     * {@link InvocationTargetException}. Should
     * only be called if no checked exception is expected to be thrown by the
     * target method.
     * <p>
     * Rethrows the underlying exception cast to an {@link Exception} or {@link Error} if appropriate; otherwise, throws
     * an {@link IllegalStateException}.
     * 
     * @param ex the exception to rethrow
     * @throws Exception the rethrown exception (in case of a checked exception)
     */
    public static void rethrowException(Throwable ex) throws Exception {
        if (ex instanceof Exception) {
            throw (Exception) ex;
        }
        if (ex instanceof Error) {
            throw (Error) ex;
        }
        throw new UndeclaredThrowableException(ex);
    }

    /**
     * Determine whether the given method explicitly declares the given
     * exception or one of its superclasses, which means that an exception of
     * that type can be propagated as-is within a reflective invocation.
     * 
     * @param method the declaring method
     * @param exceptionType the exception to throw
     * @return {@code true} if the exception can be thrown as-is; {@code false} if it needs to be wrapped
     */
    public static boolean declaresException(Method method, Class<?> exceptionType) {
        Assert.notNull(method, "Method must not be null");
        Class<?>[] declaredExceptions = method.getExceptionTypes();
        for (Class<?> declaredException : declaredExceptions) {
            if (declaredException.isAssignableFrom(exceptionType)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Determine whether the given field is a "public static final" constant.
     * 
     * @param field the field to check
     */
    public static boolean isPublicStaticFinal(Field field) {
        int modifiers = field.getModifiers();
        return (Modifier.isPublic(modifiers) && Modifier.isStatic(modifiers) && Modifier.isFinal(modifiers));
    }

    /**
     * Determine whether the given method is an "equals" method.
     * 
     * @see java.lang.Object#equals(Object)
     */
    public static boolean isEqualsMethod(Method method) {
        if ((method == null) || !method.getName().equals("equals")) {
            return false;
        }
        Class<?>[] paramTypes = method.getParameterTypes();
        return ((paramTypes.length == 1) && (paramTypes[0] == Object.class));
    }

    /**
     * Determine whether the given method is a "hashCode" method.
     * 
     * @see java.lang.Object#hashCode()
     */
    public static boolean isHashCodeMethod(Method method) {
        return ((method != null) && method.getName().equals("hashCode") && (method.getParameterTypes().length == 0));
    }

    /**
     * Determine whether the given method is a "toString" method.
     * 
     * @see java.lang.Object#toString()
     */
    public static boolean isToStringMethod(Method method) {
        return ((method != null) && method.getName().equals("toString") && (method.getParameterTypes().length == 0));
    }

    /**
     * Determine whether the given method is originally declared by {@link java.lang.Object}.
     */
    public static boolean isObjectMethod(Method method) {
        try {
            Object.class.getDeclaredMethod(method.getName(), method.getParameterTypes());
            return true;
        }
        catch (SecurityException ex) {
            return false;
        }
        catch (NoSuchMethodException ex) {
            return false;
        }
    }

    /**
     * Determine whether the given method is a CGLIB 'renamed' method, following
     * the pattern "CGLIB$methodName$0".
     * 
     * @param renamedMethod the method to check
     * @see org.springframework.cglib.proxy.Enhancer#rename
     */
    public static boolean isCglibRenamedMethod(Method renamedMethod) {
        return CGLIB_RENAMED_METHOD_PATTERN.matcher(renamedMethod.getName()).matches();
    }

    /**
     * Make the given field accessible, explicitly setting it accessible if
     * necessary. The {@code setAccessible(true)} method is only called
     * when actually necessary, to avoid unnecessary conflicts with a JVM
     * SecurityManager (if active).
     * 
     * @param field the field to make accessible
     * @see java.lang.reflect.Field#setAccessible
     */
    public static void makeAccessible(Field field) {
        if ((!Modifier.isPublic(field.getModifiers()) || !Modifier.isPublic(field.getDeclaringClass().getModifiers()) || Modifier
                .isFinal(field.getModifiers())) && !field.isAccessible()) {
            field.setAccessible(true);
        }
    }

    /**
     * Make the given method accessible, explicitly setting it accessible if
     * necessary. The {@code setAccessible(true)} method is only called
     * when actually necessary, to avoid unnecessary conflicts with a JVM
     * SecurityManager (if active).
     * 
     * @param method the method to make accessible
     * @see java.lang.reflect.Method#setAccessible
     */
    public static void makeAccessible(Method method) {
        if ((!Modifier.isPublic(method.getModifiers()) || !Modifier.isPublic(method.getDeclaringClass().getModifiers()))
                && !method.isAccessible()) {
            method.setAccessible(true);
        }
    }

    /**
     * Make the given constructor accessible, explicitly setting it accessible
     * if necessary. The {@code setAccessible(true)} method is only called
     * when actually necessary, to avoid unnecessary conflicts with a JVM
     * SecurityManager (if active).
     * 
     * @param ctor the constructor to make accessible
     * @see java.lang.reflect.Constructor#setAccessible
     */
    public static void makeAccessible(Constructor<?> ctor) {
        if ((!Modifier.isPublic(ctor.getModifiers()) || !Modifier.isPublic(ctor.getDeclaringClass().getModifiers()))
                && !ctor.isAccessible()) {
            ctor.setAccessible(true);
        }
    }

    /**
     * Perform the given callback operation on all matching methods of the given
     * class and superclasses.
     * <p>
     * The same named method occurring on subclass and superclass will appear twice, unless excluded by a
     * {@link MethodFilter}.
     * 
     * @param clazz class to start looking at
     * @param mc the callback to invoke for each method
     * @see #doWithMethods(Class, MethodCallback, MethodFilter)
     */
    public static void doWithMethods(Class<?> clazz, MethodCallback mc) throws IllegalArgumentException {
        doWithMethods(clazz, mc, null);
    }

    /**
     * Perform the given callback operation on all matching methods of the given
     * class and superclasses (or given interface and super-interfaces).
     * <p>
     * The same named method occurring on subclass and superclass will appear twice, unless excluded by the specified
     * {@link MethodFilter}.
     * 
     * @param clazz class to start looking at
     * @param mc the callback to invoke for each method
     * @param mf the filter that determines the methods to apply the callback to
     */
    public static void doWithMethods(Class<?> clazz, MethodCallback mc, MethodFilter mf)
            throws IllegalArgumentException {

        // Keep backing up the inheritance hierarchy.
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            if ((mf != null) && !mf.matches(method)) {
                continue;
            }
            try {
                mc.doWith(method);
            }
            catch (IllegalAccessException ex) {
                throw new IllegalStateException("Shouldn't be illegal to access method '" + method.getName() + "': "
                        + ex);
            }
        }
        if (clazz.getSuperclass() != null) {
            doWithMethods(clazz.getSuperclass(), mc, mf);
        }
        else if (clazz.isInterface()) {
            for (Class<?> superIfc : clazz.getInterfaces()) {
                doWithMethods(superIfc, mc, mf);
            }
        }
    }

    /**
     * Get all declared methods on the leaf class and all superclasses. Leaf
     * class methods are included first.
     */
    public static Method[] getAllDeclaredMethods(Class<?> leafClass) throws IllegalArgumentException {
        final List<Method> methods = new ArrayList<Method>(32);
        doWithMethods(leafClass, new MethodCallback() {

            @Override
            public void doWith(Method method) {
                methods.add(method);
            }
        });
        return methods.toArray(new Method[methods.size()]);
    }

    /**
     * Get the unique set of declared methods on the leaf class and all superclasses. Leaf
     * class methods are included first and while traversing the superclass hierarchy any methods found
     * with signatures matching a method already included are filtered out.
     */
    public static Method[] getUniqueDeclaredMethods(Class<?> leafClass) throws IllegalArgumentException {
        final List<Method> methods = new ArrayList<Method>(32);
        doWithMethods(leafClass, new MethodCallback() {

            @Override
            public void doWith(Method method) {
                boolean knownSignature = false;
                Method methodBeingOverriddenWithCovariantReturnType = null;

                for (Method existingMethod : methods) {
                    if (method.getName().equals(existingMethod.getName())
                            && Arrays.equals(method.getParameterTypes(), existingMethod.getParameterTypes())) {
                        // is this a covariant return type situation?
                        if ((existingMethod.getReturnType() != method.getReturnType())
                                && existingMethod.getReturnType().isAssignableFrom(method.getReturnType())) {
                            methodBeingOverriddenWithCovariantReturnType = existingMethod;
                        }
                        else {
                            knownSignature = true;
                        }
                        break;
                    }
                }
                if (methodBeingOverriddenWithCovariantReturnType != null) {
                    methods.remove(methodBeingOverriddenWithCovariantReturnType);
                }
                if (!knownSignature && !isCglibRenamedMethod(method)) {
                    methods.add(method);
                }
            }
        });
        return methods.toArray(new Method[methods.size()]);
    }

    /**
     * Invoke the given callback on all fields in the target class, going up the
     * class hierarchy to get all declared fields.
     * 
     * @param clazz the target class to analyze
     * @param fc the callback to invoke for each field
     */
    public static void doWithFields(Class<?> clazz, FieldCallback fc) throws IllegalArgumentException {
        doWithFields(clazz, fc, null);
    }

    /**
     * Invoke the given callback on all fields in the target class, going up the
     * class hierarchy to get all declared fields.
     * 
     * @param clazz the target class to analyze
     * @param fc the callback to invoke for each field
     * @param ff the filter that determines the fields to apply the callback to
     */
    public static void doWithFields(Class<?> clazz, FieldCallback fc, FieldFilter ff) throws IllegalArgumentException {

        // Keep backing up the inheritance hierarchy.
        Class<?> targetClass = clazz;
        do {
            Field[] fields = targetClass.getDeclaredFields();
            for (Field field : fields) {
                // Skip static and final fields.
                if ((ff != null) && !ff.matches(field)) {
                    continue;
                }
                try {
                    fc.doWith(field);
                }
                catch (IllegalAccessException ex) {
                    throw new IllegalStateException("Shouldn't be illegal to access field '" + field.getName() + "': "
                            + ex);
                }
            }
            targetClass = targetClass.getSuperclass();
        }
        while ((targetClass != null) && (targetClass != Object.class));
    }

    /**
     * Given the source object and the destination, which must be the same class
     * or a subclass, copy all fields, including inherited fields. Designed to
     * work on objects with public no-arg constructors.
     * 
     * @throws IllegalArgumentException if the arguments are incompatible
     */
    public static void shallowCopyFieldState(final Object src, final Object dest) throws IllegalArgumentException {
        if (src == null) {
            throw new IllegalArgumentException("Source for field copy cannot be null");
        }
        if (dest == null) {
            throw new IllegalArgumentException("Destination for field copy cannot be null");
        }
        if (!src.getClass().isAssignableFrom(dest.getClass())) {
            throw new IllegalArgumentException("Destination class [" + dest.getClass().getName()
                    + "] must be same or subclass as source class [" + src.getClass().getName() + "]");
        }
        doWithFields(src.getClass(), new FieldCallback() {

            @Override
            public void doWith(Field field) throws IllegalArgumentException, IllegalAccessException {
                makeAccessible(field);
                Object srcValue = field.get(src);
                field.set(dest, srcValue);
            }
        }, COPYABLE_FIELDS);
    }

    /**
     * Action to take on each method.
     */
    public interface MethodCallback {

        /**
         * Perform an operation using the given method.
         * 
         * @param method the method to operate on
         */
        void doWith(Method method) throws IllegalArgumentException, IllegalAccessException;
    }

    /**
     * Callback optionally used to filter methods to be operated on by a method callback.
     */
    public interface MethodFilter {

        /**
         * Determine whether the given method matches.
         * 
         * @param method the method to check
         */
        boolean matches(Method method);
    }

    /**
     * Callback interface invoked on each field in the hierarchy.
     */
    public interface FieldCallback {

        /**
         * Perform an operation using the given field.
         * 
         * @param field the field to operate on
         */
        void doWith(Field field) throws IllegalArgumentException, IllegalAccessException;
    }

    /**
     * Callback optionally used to filter fields to be operated on by a field callback.
     */
    public interface FieldFilter {

        /**
         * Determine whether the given field matches.
         * 
         * @param field the field to check
         */
        boolean matches(Field field);
    }

    /**
     * Pre-built FieldFilter that matches all non-static, non-final fields.
     */
    public static FieldFilter COPYABLE_FIELDS = new FieldFilter() {

        @Override
        public boolean matches(Field field) {
            return !(Modifier.isStatic(field.getModifiers()) || Modifier.isFinal(field.getModifiers()));
        }
    };

    /**
     * Pre-built MethodFilter that matches all non-bridge methods.
     */
    public static MethodFilter NON_BRIDGED_METHODS = new MethodFilter() {

        @Override
        public boolean matches(Method method) {
            return !method.isBridge();
        }
    };

    /**
     * Pre-built MethodFilter that matches all non-bridge methods
     * which are not declared on {@code java.lang.Object}.
     */
    public static MethodFilter USER_DECLARED_METHODS = new MethodFilter() {

        @Override
        public boolean matches(Method method) {
            return (!method.isBridge() && (method.getDeclaringClass() != Object.class));
        }
    };

    private class TestClass {

        private Map pn = new HashMap(0);

        private String[] a1;

        private Collection c1;

        public TestClass() {
            super();
        }

        public void setPn(Map pn) {
            this.pn = pn;
        }

        public Map getPn() {
            return pn;
        }
    }

}
