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

import java.util.List;

/**
 * Pageable 是独立于持久框架的分页接口
 * 
 * @author <a href="mailto:svoflee@gmail.com">svoflee@gmail.com</a>
 * @since 1.0.0
 * @version 1.0.0
 */
public interface Pageable {

    public int getPrePage();

    public boolean isHasPre();

    public int getNextPage();

    public boolean isHasNext();

    public void setTotalCount(long totalCount);

    public void setContent(List aContent);

    public List getContent();

    public boolean isAutoCount();

    public int getFirst();

    public Pageable pageSize(int thePageSize);

    public void setPageSize(int pageSize);

    public Pageable pageNo(int thePageNo);

    public void setPageNo(int pageNo);

    public int getPageNo();

    public long getTotalPages();

    public long getTotalCount();

    public int getPageSize();

}
