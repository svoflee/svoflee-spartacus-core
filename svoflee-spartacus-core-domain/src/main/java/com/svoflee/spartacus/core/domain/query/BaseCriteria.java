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
 * BaseCriteria 是
 * 
 * @author <a href="mailto:svoflee@gmail.com">svoflee@gmail.com</a>
 * @since 1.0.0
 * @version 1.0.0
 */
public abstract class BaseCriteria implements Criteria {

    private static final long serialVersionUID = 6743262009518909729L;

    /**
     * 该条件与相同字段的查询条件之间的Join关系，And或者 Or
     */
    private CriteriaJoin criteriaJoin = CriteriaJoin.AND;

    @Override
    public void setCriteriaJoin(CriteriaJoin criteriaJoin) {
        this.criteriaJoin = criteriaJoin;
    }

    public CriteriaJoin getCriteriaJoin() {
        return criteriaJoin;
    }

}
