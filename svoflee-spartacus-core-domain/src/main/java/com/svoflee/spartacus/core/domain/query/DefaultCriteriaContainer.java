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

/**
 * DefaultCriteriaContainer 是
 * 
 * @author <a href="mailto:svoflee@gmail.com">svoflee@gmail.com</a>
 * @since 1.0.0
 * @version 1.0.0
 */
public class DefaultCriteriaContainer extends BaseCriteriaContainer {

    public DefaultCriteriaContainer(String tableName) {
        super(tableName);
    }

    public DefaultCriteriaContainer() {
        super();
    }

    @Override
    public Criteria and(String columnName) {
        // XXX:目前默认实现FieldCriteria
        Criteria aCriteria = new FieldCriteria(columnName);
        super.and(aCriteria);
        return aCriteria;
    }

    @Override
    public Criteria or(String columnName) {
        Criteria aCriteria = new FieldCriteria(columnName);
        super.or(aCriteria);
        return aCriteria;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(getTableName()).append("-").append(getCriterias()).append("-").append(getPage());
        return builder.toString();
    }

}
