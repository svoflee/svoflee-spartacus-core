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

package com.svoflee.spartacus.core.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.google.code.morphia.annotations.Property;
import com.svoflee.spartacus.core.ui.annotation.Editable;
import com.svoflee.spartacus.core.ui.annotation.ShowType;
import com.svoflee.spartacus.core.ui.annotation.UI;
import com.svoflee.spartacus.core.ui.model.FieldType;

/**
 * BaseAuditableEntity 是默认的通用的Domain Entity定义,
 * 它包含了通用的属性定义,包括数据审计信息及默认扩展码
 * 
 * @author <a href="mailto:svoflee@gmail.com">svoflee</a>
 * @since 1.0.0
 * @version 1.0.0
 * @param <PK>
 */
@MappedSuperclass
public abstract class BaseAuditableEntity<PK extends Serializable> extends BasePersistableEntity<PK> implements
        DataAuditable {

    // public static final String STATUS_PROPERTY_NAME = "status";

    // public static final String IS_AVAILABLE_PROPERTY_NAME = "isAvailable";

    private static final long serialVersionUID = -5134920365779298970L;

    public static final String DEFAULT_OPERATOR = "SYS";

    @UI(caption = "创建时间", index = 9911, editable = Editable.NONE, fieldType = FieldType.DATETIME, showType = ShowType.FORM)
    @Property("ct")
    @Column(name = "CREATED_TIME", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdTime = new Date();

    @UI(caption = "创建者", index = 9920, editable = Editable.NONE, fieldType = FieldType.STRING, showType = ShowType.FORM)
    @Property("cb")
    @Column(name = "CREATED_BY", nullable = false, length = 20)
    private String createdBy = BaseAuditableEntity.DEFAULT_OPERATOR;

    @UI(caption = "更新时间", index = 9910, editable = Editable.NONE, fieldType = FieldType.DATETIME, showType = ShowType.FORM)
    @Property("ut")
    @Column(name = "UPDATED_TIME", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedTime = new Date();

    @UI(caption = "更新者", index = 9920, editable = Editable.NONE, fieldType = FieldType.STRING, showType = ShowType.FORM)
    @Property("ub")
    @Column(name = "UPDATED_BY", nullable = false, length = 20)
    private String updatedBy = BaseAuditableEntity.DEFAULT_OPERATOR;

    // @UI(caption = "版本号", index = 9830, editable = Editable.NONE, fieldType = FieldType.NUMBER, showType =
    // ShowType.NO)
    // @Version("m_v")
    // @Column(name = "M_VERSION", nullable = false)
    // private Long version = 1L;
    // public void setVersion(Long version) {
    // this.version = version;
    // }
    //
    // public Long getVersion() {
    // return this.version;
    // }

    @Override
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    @Override
    public Date getCreatedTime() {
        return this.createdTime;
    }

    @Override
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Override
    public String getCreatedBy() {
        return this.createdBy;
    }

    @Override
    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    @Override
    public String getUpdatedBy() {
        return this.updatedBy;
    }

    @Override
    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    @Override
    public Date getUpdatedTime() {
        return this.updatedTime;
    }

}
