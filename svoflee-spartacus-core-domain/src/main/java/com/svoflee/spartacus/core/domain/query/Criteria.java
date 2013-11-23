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

import java.io.Serializable;

/**
 * Criteria 是查询条件
 * 
 * @author <a href="mailto:svoflee@gmail.com">svoflee@gmail.com</a>
 * @since 1.0.0
 * @version 1.0.0
 */
public interface Criteria extends Serializable, Query {

    /**
     * 添加查询条件
     * 
     * @param criteria
     * @return
     */
    public Criteria add(Criteria... criteria);

    /**
     * @param criteriaOperator
     * @param value
     * @return
     */
    public Criteria and(CriteriaOperator criteriaOperator, Object value);

    /**
     * @param criteriaOperator
     * @param value
     * @return
     */
    public Criteria or(CriteriaOperator criteriaOperator, Object value);

    /**
     * 查询条件对应的字段名称
     * 
     * @return
     */
    public String getColumnName();

    /**
     * 设置该条件的连接符
     * 
     * @param criteriaJoin
     */
    public void setCriteriaJoin(CriteriaJoin criteriaJoin);

    /**
     * 获取一个单一查询条件的值，XXX:思考
     * 
     * @return
     */
    public Object getValue();

}
