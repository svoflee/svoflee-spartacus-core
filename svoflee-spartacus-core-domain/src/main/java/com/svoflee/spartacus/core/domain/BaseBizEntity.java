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

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import com.google.code.morphia.annotations.Property;
import com.svoflee.spartacus.core.ui.annotation.Editable;
import com.svoflee.spartacus.core.ui.annotation.ShowType;
import com.svoflee.spartacus.core.ui.annotation.UI;
import com.svoflee.spartacus.core.ui.model.FieldType;

/**
 * BaseBizEntity 是
 * 
 * @author <a href="mailto:svoflee@gmail.com">svoflee@gmail.com</a>
 * @since 1.0.0
 * @version 1.0.0
 */
@MappedSuperclass
public abstract class BaseBizEntity<PK extends Serializable> extends BaseAuditableEntity<PK> implements DataExtended {

    private static final long serialVersionUID = 6645267329826854787L;

    /**
     * 默认的扩展字段,分为10个字段，满足10个字段扩展,长度为80
     */
    public static final String DEFAULT_EXTEND_FEILD_CODE = "0-0-0-0-0-0-0-0-0-0";//

    @UI(caption = "扩展码", index = 9920, editable = Editable.NONE, fieldType = FieldType.STRING, showType = ShowType.FORM)
    @Property("ext")
    @Column(name = "EXTEND", nullable = false, length = 30)
    private String extend = BaseBizEntity.DEFAULT_EXTEND_FEILD_CODE;

    @Override
    public void setExtend(String extend) {
        this.extend = extend;
    }

    @Override
    public String getExtend() {
        return this.extend;
    }

}
