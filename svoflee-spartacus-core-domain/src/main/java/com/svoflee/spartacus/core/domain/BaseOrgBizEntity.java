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
 * BaseOrgBizEntity 是
 * 
 * @author <a href="mailto:svoflee@gmail.com">svoflee@gmail.com</a>
 * @since 1.0.0
 * @version 1.0.0
 */
@MappedSuperclass
public abstract class BaseOrgBizEntity<PK extends Serializable> extends BaseBizEntity<PK> implements DataOrganized {

    private static final long serialVersionUID = -7730811297967977917L;

    /**
     * 默认组织代码
     */
    private static final String DEFAULT_ORG_CODE = "00";

    @UI(caption = "组织码", index = 9920, editable = Editable.NONE, fieldType = FieldType.STRING, showType = ShowType.FORM)
    @Property("oc")
    @Column(name = "org_code", nullable = false, length = 30)
    private String orgCode = DEFAULT_ORG_CODE;

    //

    /**
     * {@inheritDoc}
     */
    @Override
    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getOrgCode() {
        return this.orgCode;
    }

}
