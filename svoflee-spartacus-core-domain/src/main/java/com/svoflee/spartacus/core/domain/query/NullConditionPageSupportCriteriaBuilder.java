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

package com.svoflee.spartacus.core.domain.query;

import java.util.Map;

/**
 * NullConditionPageSupportCriteriaBuilder 是忽略查询条件，仅仅支持分页的的查询条件构建器实现
 * 
 * @author <a href="mailto:svoflee@gmail.com">svoflee@gmail.com</a>
 * @since 1.0.0
 * @version 1.0.0
 * @param <T>
 */
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
