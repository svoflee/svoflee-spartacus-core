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

package com.svoflee.spartacus.core.ui.model;

/**
 * FieldType 是
 * 
 * @author <a href="mailto:svoflee@gmail.com">svoflee@gmail.com</a>
 * @since 1.0.0
 * @version 1.0.0
 */
public enum FieldType {
    /**
     * 数字类型
     */
    NUMBER,
    /**
     * 布尔型
     */
    BOOLEAN,
    /**
     * 密码类型
     */
    PASSWORD,
    /**
     * 短文本类型
     */
    STRING,
    /**
     * 长文本类型
     */
    TEXT,
    /**
     * 时间类型,e.g. 2011-07-23 11:11:00
     */
    DATETIME,
    /**
     * 日期类型,e.g. 2011-07-23
     */
    DATE,
    /**
     * 时刻类型,e.g. 11:11:00
     */
    TIME,
    /**
     * ENUM类型
     */
    ENUM,
    /**
     * ENTITY类型
     */
    ENTITY,
    /**
     * 集合类型
     */
    COLLECTION

}
