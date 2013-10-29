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
import javax.persistence.GeneratedValue;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;

import com.google.code.morphia.annotations.Property;
import com.google.code.morphia.annotations.Version;
import com.svoflee.spartacus.core.ui.annotation.Editable;
import com.svoflee.spartacus.core.ui.annotation.ShowType;
import com.svoflee.spartacus.core.ui.annotation.UI;
import com.svoflee.spartacus.core.ui.model.FieldType;
import com.svoflee.spartacus.core.ui.model.Model;

/**
 * BasePersistableEntity 是基本的Domain实体定义基类，
 * spartacus框架中所有Domain继承至该基类或者它的不同类型的子类
 * 
 * @author <a href="mailto:svoflee@gmail.com">svoflee@gmail.com</a>
 * @since 1.0.0
 * @version 1.0.0
 * @see DataVersionable
 * @see DataPersistable
 * @see Model
 * @see BaseAuditableEntity
 * @see BaseBizEntity
 * @see BaseOrgBizEntity
 */
@MappedSuperclass
public abstract class BasePersistableEntity<PK extends Serializable> implements Model, DataVersionable,
        DataPersistable<PK>
// , Persistable<PK>
{

    private static final long serialVersionUID = -4773715733208503203L;

    private static final long INIT_VERSION = 1L;

    /**
     * 默认的entity的id属性名
     */
    public static final String ID_PROPERTY_NAME = "id";

    // 主键生产机制说明:
    // 1、JPA的方式，统一采用UUID机制生成主键
    // 2、Mongodb，采用Mongodb的唯一ID生成机制
    @UI(caption = "ID标识", index = 0, editable = Editable.NONE, fieldType = FieldType.STRING)
    @com.google.code.morphia.annotations.Id
    @com.google.code.morphia.annotations.Indexed(value = com.google.code.morphia.utils.IndexDirection.ASC, unique = true, background = true)
    @javax.persistence.Id
    // @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    // hibernate的注解
    @GeneratedValue(generator = "idGenerator")
    // 使用uuid的生成策略
    private PK id;

    @UI(caption = "版本号", index = 9830, editable = Editable.NONE, fieldType = FieldType.NUMBER, showType = ShowType.NO)
    @Version("v")
    @Column(name = "VERSION", nullable = false)
    private Long version = INIT_VERSION;

    @UI(caption = "有效", index = 9990, editable = Editable.NONE, fieldType = FieldType.BOOLEAN, showType = ShowType.FORM)
    @Property("ia")
    @Column(name = "IS_AVAILABLE", nullable = false)
    private Boolean isAvailable = true;

    @Override
    public Boolean getIsAvailable() {
        return this.isAvailable;
    }

    @Override
    public void setIsAvailable(Boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    @Override
    public void setId(PK id) {
        this.id = id;
    }

    @Override
    public PK getId() {
        return this.id;
    }

    @Override
    public void setVersion(Long version) {
        this.version = version;
    }

    @Override
    public Long getVersion() {
        return this.version;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @javax.persistence.Transient
    public String modelPrimaryKeyPropertyName() {
        return ID_PROPERTY_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @javax.persistence.Transient
    public Object modelPrimaryKeyValue() {
        return this.getId();
    }

    /**
     * 是否是为未持久化新的Entity判断，如果getId()为NULL，则为新的Entity
     * 
     * @return
     */
    @Override
    @javax.persistence.Transient
    public boolean isNew() {
        if (this.getId() == null) {
            return true;
        }
        else {
            return false;
        }
    }

}
