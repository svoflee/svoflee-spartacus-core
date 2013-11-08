package com.svoflee.spartacus.core.domain.query;

import java.util.Map;

import org.springframework.stereotype.Component;

/**
 * @author V.L.
 * @param <T>
 * 
 */
@Component("defaultHibernateCriteriaBuilder")
@Deprecated
public class DefaultHibernateCriteriaBuilder<T> implements CriteriaBuilder<T, CriteriaConditon> {

	@Override
	public CriteriaConditon buildCriteria(T entity, Map<String, String> params, boolean isCount) {
		return null;
	}

	@Override
	public CriteriaConditon buildCriteria(T entity, Map<String, String> params, Map<String, String> sorts,
			boolean isCount) {
		return null;
	}

	@Override
	public CriteriaConditon buildCriteria(T entity, Map<String, String> params, Map<String, String> sorts,
			int rowStart, int rowEnd, boolean isCount) {
		return null;
	}
	//
	// private final Logger logger = Logger
	// .getLogger(DefaultHibernateCriteriaBuilder.class);
	//
	// /*
	// * (non-Javadoc)
	// *
	// * @see com.omaha.core.query.CriteriaBuilder#buildCriteria(java.lang.Object,
	// * java.util.Map, java.util.Map)
	// */
	// @Override
	// public CriteriaConditon buildCriteria(T entity, Map<String, String> params,
	// Map<String, String> sorts, boolean isCount) {
	// Assert.notNull(params, "查询条件不能为空");
	//
	// // Assert.isTrue(params.size() > 0, "至少要包含一个查询条件");
	// DetachedCriteria aDetachedCriteria = DetachedCriteria.forClass(entity
	// .getClass());
	// for (String propertyName : params.keySet()) {
	// String value = params.get(propertyName);
	// try {
	// com.ofsp.lib.utils.BeanUtils.setProperty(entity, propertyName,
	// value);
	// Object realTypeValue = PropertyUtils.getProperty(entity,
	// propertyName);
	// if (realTypeValue instanceof String) {
	// // 如果是字符串类型，则使用like查询
	// aDetachedCriteria.add(Restrictions.like(propertyName,
	// realTypeValue.toString(), MatchMode.ANYWHERE)
	// .ignoreCase());
	// } else {
	// // 非字符串类型，使用相等查询
	// aDetachedCriteria.add(Restrictions.eq(propertyName,
	// realTypeValue));
	// }
	//
	// } catch (Exception e) {
	// logger.error(e.toString());
	// }
	// //
	// // //Date dateValue = DateTimeUtils.formatDate(value,
	// // WebConstants.TIMESTAMP_FORMAT);
	// // //默认的处理方法为值采用模糊查询，将来可考虑实现 复杂的查询方式支持
	// // //aDetachedCriteria.add(Restrictions.like(key,value,MatchMode.ANYWHERE).ignoreCase());
	// // aDetachedCriteria.add(Restrictions.like(propertyName,
	// // value).ignoreCase());
	//
	// }
	//
	// if (sorts != null && sorts.size() > 0) {
	//
	// for (String key : sorts.keySet()) {
	// String order = sorts.get(key);
	// if (order.equals(CriteriaBuilder.ASC)) {
	// aDetachedCriteria.addOrder(Order.asc(key));
	// } else if (order.equals(CriteriaBuilder.DESC)) {
	// aDetachedCriteria.addOrder(Order.desc(key));
	// }
	//
	// }
	// }
	// if (isCount) {
	// aDetachedCriteria.setProjection(Projections.rowCount());
	// }
	// CriteriaConditon aCriteriaConditon = new CriteriaConditon(
	// aDetachedCriteria);
	//
	// return aCriteriaConditon;
	// }
	//
	// //
	// // /**
	// // * @param entity
	// // * @param propertyName
	// // * @param value
	// // * @return
	// // * @throws IllegalAccessException
	// // * @throws InstantiationException
	// // * @throws InvocationTargetException
	// // * @throws NoSuchMethodException
	// // * @throws NoSuchFieldException
	// // * @throws SecurityException
	// // */
	// // private Class getType(T entity, String propertyName, String value) throws
	// // InstantiationException,
	// // IllegalAccessException, InvocationTargetException, NoSuchMethodException,
	// // SecurityException,
	// // NoSuchFieldException {
	// // // Class entityClazz=entity.getClass();
	// // // Field f = entityClazz.getField(propertyName);
	// // // Class ftype=f.getClass();
	// //
	// // Object o = entity.getClass().newInstance();
	// // BeanUtils.copyProperty(o, propertyName, value);
	// // Object realTypeValue = PropertyUtils.getProperty(o, propertyName);
	// //
	// // Class<? extends Object> type = realTypeValue.getClass();
	// // if (type == Integer.TYPE) {
	// // return Integer.class;
	// // } else if (type == Double.TYPE) {
	// // return Double.class;
	// // } else if (type == Long.TYPE) {
	// // return Long.class;
	// // } else if (type == Boolean.TYPE) {
	// // return Boolean.class;
	// // } else if (type == Float.TYPE) {
	// // return Float.class;
	// // } else if (type == Short.TYPE) {
	// // return Short.class;
	// // } else if (type == Byte.TYPE) {
	// // return Byte.class;
	// // } else if (type == Character.TYPE) {
	// // return Character.class;
	// // } else {
	// // return type;
	// // }
	// // }
	//
	// /*
	// * (non-Javadoc)
	// *
	// * @see com.omaha.core.query.CriteriaBuilder#buildCriteria(java.lang.Object,
	// * java.util.Map, java.util.Map, int, int)
	// */
	// @Override
	// public CriteriaConditon buildCriteria(T entity, Map<String, String> params,
	// Map<String, String> sorts, int rowStart, int rowEnd, boolean isCount) {
	// CriteriaConditon aCriteriaConditon = this.buildCriteria(entity, params,
	// sorts, isCount);
	// aCriteriaConditon.setFirstRow(rowStart);
	// aCriteriaConditon.setMaxRows(rowEnd - rowStart);
	// return aCriteriaConditon;
	// }
	//
	// /*
	// * (non-Javadoc)
	// *
	// * @see com.omaha.core.query.CriteriaBuilder#buildCriteria(java.lang.Object,
	// * java.util.Map, boolean)
	// */
	// @Override
	// public CriteriaConditon buildCriteria(T entity, Map<String, String> params,
	// boolean isCount) {
	// return this.buildCriteria(entity, params, null, isCount);
	// }

	/**************************** Fields ****************************/

	/**************************** Public Methods ****************************/

	/**************************** Private Methods ****************************/

}
