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

package com.svoflee.spartacus.core.utils;

import java.util.Collection;
import java.util.Map;

/**
 * Assert utility class that assists in validating arguments. Useful for identifying programmer errors early and
 * obviously at runtime.
 * <p>
 * For example, if the contract of a public method states it does not allow null arguments, Assert can be used to
 * validate that contract. Doing this clearly indicates a contract violation when it occurs and protects the class's
 * invariants.
 * <p>
 * Typically used to validate method arguments rather than configuration properties, to check for cases that are usually
 * programmer errors rather than configuration errors. In contrast to config initialization code, there is usally no
 * point in falling back to defaults in such methods.
 * <p>
 * This class is similar to JUnit's assertion library. If an argument value is deemed invalid, an
 * IllegalArgumentException is thrown. For example:
 * 
 * <pre>
 * Assert.notNull(clazz, &quot;The class must not be null&quot;);
 * Assert.isTrue(i &gt; 0, &quot;The value must be greater than zero&quot;);
 * </pre>
 * 
 * Mainly for internal use within the framework; consider Jakarta's Commons Lang >= 2.0 for a more comprehensive suite
 * of assertion utilities.
 * 
 * @author kimchy
 * @since 1.0.0
 * @version 1.0.0
 */
public abstract class Assert {

    /**
     * Assert a boolean expression, throwing <code>IllegalArgumentException</code> if the test result is
     * <code>false</code>.
     * 
     * <pre>
     * Assert.isTrue(i &gt; 0, &quot;The value must be greater than zero&quot;);
     * </pre>
     * 
     * @param expression
     *            a boolean expression
     * @param message
     *            the exception message to use if the assertion fails
     * @throws IllegalArgumentException
     *             if expression is <code>false</code>
     */
    public static void isTrue(boolean expression, String message) {
        if (!expression) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * Assert a boolean expression, throwing <code>IllegalArgumentException</code> if the test result is
     * <code>false</code>.
     * 
     * <pre>
     * Assert.isTrue(i &gt; 0);
     * </pre>
     * 
     * @param expression
     *            a boolean expression
     * @throws IllegalArgumentException
     *             if expression is <code>false</code>
     */
    public static void isTrue(boolean expression) {
        isTrue(expression, "[Assertion failed] - this expression must be true");
    }

    /**
     * Assert that an object is not null.
     * 
     * <pre>
     * Assert.notNull(clazz, &quot;The class must not be null&quot;);
     * </pre>
     * 
     * @param object
     *            the object to check
     * @param message
     *            the exception message to use if the assertion fails
     * @throws IllegalArgumentException
     *             if the object is <code>null</code>
     */
    public static void notNull(Object object, String message) {
        if (object == null) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * Assert that an object is not null.
     * 
     * <pre>
     * Assert.notNull(clazz);
     * </pre>
     * 
     * @param object
     *            the object to check
     * @throws IllegalArgumentException
     *             if the object is <code>null</code>
     */
    public static void notNull(Object object) {
        notNull(object, "[Assertion failed] - this argument is required; it cannot be null");
    }

    /**
     * Assert that a string is not empty; that is, it must not be <code>null</code> and not empty.
     * 
     * <pre>
     * Assert.hasLength(name, &quot;Name must not be empty&quot;);
     * </pre>
     * 
     * @param text
     *            the string to check
     * @param message
     *            the exception message to use if the assertion fails
     * @see AnotherStringUtils#hasLength
     */
    public static void hasLength(String text, String message) {
        if (!AnotherStringUtils.hasLength(text)) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * Assert that a string is not empty; that is, it must not be <code>null</code> and not empty.
     * 
     * <pre>
     * Assert.hasLength(name);
     * </pre>
     * 
     * @param text
     *            the string to check
     * @see AnotherStringUtils#hasLength
     */
    public static void hasLength(String text) {
        hasLength(text,
                "[Assertion failed] - this String argument must have length; it cannot be <code>null</code> or empty");
    }

    /**
     * Assert that a string has valid text content; that is, it must not be <code>null</code> and must contain at least
     * one non-whitespace character.
     * 
     * <pre>
     * Assert.hasText(name, &quot;Name must not be empty&quot;);
     * </pre>
     * 
     * @param text
     *            the string to check
     * @param message
     *            the exception message to use if the assertion fails
     * @see AnotherStringUtils#hasText
     */
    public static void hasText(String text, String message) {
        if (!AnotherStringUtils.hasText(text)) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * Assert that a string has valid text content; that is, it must not be <code>null</code> and must contain at least
     * one non-whitespace character.
     * 
     * <pre>
     * Assert.hasText(name, &quot;Name must not be empty&quot;);
     * </pre>
     * 
     * @param text
     *            the string to check
     * @see AnotherStringUtils#hasText
     */
    public static void hasText(String text) {
        hasText(text,
                "[Assertion failed] - this String argument must have text; it cannot be <code>null</code>, empty, or blank");
    }

    /**
     * Assert that the given text does not contain the given substring.
     * 
     * <pre>
     * Assert.doesNotContain(name, &quot;rod&quot;, &quot;Name must not contain 'rod'&quot;);
     * </pre>
     * 
     * @param textToSearch
     *            the text to search
     * @param substring
     *            the substring to find within the text
     * @param message
     *            the exception message to use if the assertion fails
     */
    public static void doesNotContain(String textToSearch, String substring, String message) {
        if (textToSearch.indexOf(substring) != -1) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * Assert that the given text does not contain the given substring.
     * 
     * <pre>
     * Assert.doesNotContain(name, &quot;rod&quot;);
     * </pre>
     * 
     * @param textToSearch
     *            the text to search
     * @param substring
     *            the substring to find within the text
     */
    public static void doesNotContain(String textToSearch, String substring) {
        doesNotContain(textToSearch, substring,
                "[Assertion failed] - this String argument must not contain the substring [" + substring + "]");
    }

    /**
     * Assert that an array has elements; that is, it must not be <code>null</code> and must have at least one element.
     * 
     * <pre>
     * Assert.notEmpty(array, &quot;The array must have elements&quot;);
     * </pre>
     * 
     * @param array
     *            the array to check
     * @param message
     *            the exception message to use if the assertion fails
     * @throws IllegalArgumentException
     *             if the object array is <code>null</code> or has no elements
     */
    public static void notEmpty(Object[] array, String message) {
        if ((array == null) || (array.length == 0)) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * Assert that an array has elements; that is, it must not be <code>null</code> and must have at least one element.
     * 
     * <pre>
     * Assert.notEmpty(array);
     * </pre>
     * 
     * @param array
     *            the array to check
     * @throws IllegalArgumentException
     *             if the object array is <code>null</code> or has no elements
     */
    public static void notEmpty(Object[] array) {
        notEmpty(array, "[Assertion failed] - this array must not be empty: it must contain at least 1 element");
    }

    /**
     * Assert that a collection has elements; that is, it must not be <code>null</code> and must have at least one
     * element.
     * 
     * <pre>
     * Assert.notEmpty(collection, &quot;Collection must have elements&quot;);
     * </pre>
     * 
     * @param collection
     *            the collection to check
     * @param message
     *            the exception message to use if the assertion fails
     * @throws IllegalArgumentException
     *             if the collection is <code>null</code> or has no elements
     */
    public static void notEmpty(Collection collection, String message) {
        if ((collection == null) || collection.isEmpty()) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * Assert that a collection has elements; that is, it must not be <code>null</code> and must have at least one
     * element.
     * 
     * <pre>
     * Assert.notEmpty(collection, &quot;Collection must have elements&quot;);
     * </pre>
     * 
     * @param collection
     *            the collection to check
     * @throws IllegalArgumentException
     *             if the collection is <code>null</code> or has no elements
     */
    public static void notEmpty(Collection collection) {
        notEmpty(collection,
                "[Assertion failed] - this collection must not be empty: it must contain at least 1 element");
    }

    /**
     * Assert that a Map has entries; that is, it must not be <code>null</code> and must have at least one entry.
     * 
     * <pre>
     * Assert.notEmpty(map, &quot;Map must have entries&quot;);
     * </pre>
     * 
     * @param map
     *            the map to check
     * @param message
     *            the exception message to use if the assertion fails
     * @throws IllegalArgumentException
     *             if the map is <code>null</code> or has no entries
     */
    public static void notEmpty(Map map, String message) {
        if ((map == null) || map.isEmpty()) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * Assert that a Map has entries; that is, it must not be <code>null</code> and must have at least one entry.
     * 
     * <pre>
     * Assert.notEmpty(map);
     * </pre>
     * 
     * @param map
     *            the map to check
     * @throws IllegalArgumentException
     *             if the map is <code>null</code> or has no entries
     */
    public static void notEmpty(Map map) {
        notEmpty(map, "[Assertion failed] - this map must not be empty; it must contain at least one entry");
    }

    /**
     * Assert that the provided object is an instance of the provided class.
     * 
     * <pre>
     * Assert.instanceOf(Foo.class, foo);
     * </pre>
     * 
     * @param clazz
     *            the required class
     * @param obj
     *            the object to check
     * @throws IllegalArgumentException
     *             if the object is not an instance of clazz
     * @see Class#isInstance
     */
    public static void isInstanceOf(Class clazz, Object obj) {
        isInstanceOf(clazz, obj, "");
    }

    /**
     * Assert that the provided object is an instance of the provided class.
     * 
     * <pre>
     * Assert.instanceOf(Foo.class, foo);
     * </pre>
     * 
     * @param clazz
     *            the required class
     * @param obj
     *            the object to check
     * @param message
     *            a message which will be prepended to the message produced by the function itself, and which may be
     *            used to provide context. It should normally end in a ":" or ". " so that the function generate message
     *            looks ok when prepended to it.
     * @throws IllegalArgumentException
     *             if the object is not an instance of clazz
     * @see Class#isInstance
     */
    public static void isInstanceOf(Class clazz, Object obj, String message) {
        Assert.notNull(clazz, "The clazz to perform the instanceof assertion cannot be null");
        Assert.isTrue(clazz.isInstance(obj), message + "Object of class '"
                + (obj != null ? obj.getClass().getName() : "[null]") + "' must be an instance of '" + clazz.getName()
                + "'");
    }

    /**
     * Assert a boolean expression, throwing <code>IllegalStateException</code> if the test result is <code>false</code>
     * . Call isTrue if you wish to throw IllegalArgumentException on an assertion failure.
     * 
     * <pre>
     * Assert.state(id == null, &quot;The id property must not already be initialized&quot;);
     * </pre>
     * 
     * @param expression
     *            a boolean expression
     * @param message
     *            the exception message to use if the assertion fails
     * @throws IllegalStateException
     *             if expression is <code>false</code>
     */
    public static void state(boolean expression, String message) {
        if (!expression) {
            throw new IllegalStateException(message);
        }
    }

    /**
     * Assert a boolean expression, throwing <code>IllegalStateException</code> if the test result is <code>false</code>
     * . Call isTrue if you wish to throw IllegalArgumentException on an assertion failure.
     * 
     * <pre>
     * Assert.state(id == null);
     * </pre>
     * 
     * @param expression
     *            a boolean expression
     * @throws IllegalStateException
     *             if expression is <code>false</code>
     */
    public static void state(boolean expression) {
        state(expression, "[Assertion failed] - this state invariant must be true");
    }

}
