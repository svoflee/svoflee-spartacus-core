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

package com.svoflee.spartacus.core.domain;

import java.io.Serializable;

/**
 * DataPersistable
 * 
 * @author <a href="mailto:svoflee@gmail.com">svoflee</a>
 * @since 1.0.0
 * @version 1.0.0
 */
public interface DataPersistable<PK extends Serializable> {

    /**
     * Returns the id of the entity.
     * 
     * @return the id
     */
    PK getId();

    public void setId(PK id);

    /**
     * Returns if the {@code DataPersistable} is new or was persisted already.
     * 
     * @return if the object is new
     */
    boolean isNew();

    public Boolean getIsAvailable();

    public void setIsAvailable(Boolean isAvailable);
}
