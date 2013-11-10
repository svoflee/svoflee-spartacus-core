package com.svoflee.spartacus.core.domain.query;

import java.util.Map;

/**
 * 忽略查询条件，仅仅支持分页的的查询条件构建器实现
 * 
 * @author V.L.
 * 
 * @since 1.0
 * @param <T>
 */
// @Component
@Deprecated
public class NullConditionPageSupportCriteriaBuilder<T> implements CriteriaBuilder<T, CriteriaConditon> {

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
	//
	// /*
	// * (non-Javadoc)
	// *
	// * @see com.omaha.core.query.CriteriaBuilder#buildCriteria(java.lang.Object,
	// * java.util.Map, java.util.Map, boolean)
	// */
	// @Override
	// public CriteriaConditon buildCriteria(T entity, Map<String, String> params,
	// Map<String, String> sorts, boolean isCount) {
	// DetachedCriteria aDetachedCriteria = DetachedCriteria.forClass(entity
	// .getClass());
	//
	// if (isCount) {
	// aDetachedCriteria.setProjection(Projections.rowCount());
	// }
	// CriteriaConditon aCriteriaConditon = new CriteriaConditon(
	// aDetachedCriteria);
	//
	// return aCriteriaConditon;
	//
	// }
	//
	// /*
	// * (non-Javadoc)
	// *
	// * @see com.omaha.core.query.CriteriaBuilder#buildCriteria(java.lang.Object,
	// * java.util.Map, java.util.Map, int, int, boolean)
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

	/**************************** Fields ****************************/

	/**************************** Public Methods ****************************/

	/**************************** Private Methods ****************************/

}
