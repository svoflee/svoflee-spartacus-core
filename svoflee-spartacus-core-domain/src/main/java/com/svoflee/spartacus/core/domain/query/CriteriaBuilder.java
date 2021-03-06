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
 * CriteriaBuilder 是
 * 
 * @author <a href="mailto:svoflee@gmail.com">svoflee@gmail.com</a>
 * @since 1.0.0
 * @version 1.0.0
 * @param <T>
 * @param <C>
 */
@Deprecated
public interface CriteriaBuilder<T, C> {

    /**
	 * 
	 */
    public final static String ASC = "asc";

    public final static String DESC = "desc";

    public C buildCriteria(T entity, Map<String, String> params, boolean isCount);

    public C buildCriteria(T entity, Map<String, String> params, Map<String, String> sorts, boolean isCount);

    public C buildCriteria(T entity, Map<String, String> params, Map<String, String> sorts, int rowStart, int rowEnd,
            boolean isCount);

}
