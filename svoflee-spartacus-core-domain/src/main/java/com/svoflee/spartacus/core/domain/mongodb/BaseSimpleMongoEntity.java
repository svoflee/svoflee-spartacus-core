/*
 * Copyright (c)  http://www.svoflee.com All rights reserved.
 *  
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
 *       
 * Product:  svoflee-spartacus
 * Author:   svoflee@gmail.com 
 */

package com.svoflee.spartacus.core.domain.mongodb;

import java.io.Serializable;

import com.svoflee.spartacus.core.domain.BasePersistableEntity;
import com.svoflee.spartacus.core.ui.annotation.Editable;
import com.svoflee.spartacus.core.ui.annotation.UI;
import com.svoflee.spartacus.core.ui.model.FieldType;

@Deprecated
public abstract class BaseSimpleMongoEntity<PK extends Serializable> extends BasePersistableEntity<PK> {

    private static final long serialVersionUID = -7768327880213730763L;

    @com.google.code.morphia.annotations.Id
    @UI(caption = "ID标识", index = 0, editable = Editable.NONE, fieldType = FieldType.STRING)
    private PK id;

    // private String id = new ObjectId().toString();

    @Override
    public void setId(PK id) {
        this.id = id;
    }

    @Override
    public PK getId() {
        return this.id;
    }
}
