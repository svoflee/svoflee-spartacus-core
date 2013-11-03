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
 * CriteriaContainer 是查询条件及查询语句容器
 * 
 * @author <a href="mailto:svoflee@gmail.com">svoflee@gmail.com</a>
 * @since 1.0.0
 * @version 1.0.0
 */
public interface CriteriaContainer extends Pageable {

    /**
     * 设置条件的数据表名称,不是必须的
     */
    void setTableName(String tableName);

    public String getTableName();

    /**
     * 添加多个Criteria
     * 
     * @param criterias
     * @return
     */
    CriteriaContainer add(CriteriaJoin criteriaJoin, Criteria... criterias);

    /**
     * @param criterias
     * @return
     */
    CriteriaContainer and(Criteria... criterias);

    /**
     * @param columnName
     * @return
     */
    Criteria and(String columnName);

    /**
     * @param columnName
     * @return
     */
    Criteria or(String columnName);

    CriteriaContainer or(Criteria... criterias);

    /**
     * @param aPage
     */
    void setPage(Pageable aPage);

    /**
     * 查询条件
     * 
     * @return
     */
    Map<String, Criteria> getCriterias();

    public Pageable getPage();

}
