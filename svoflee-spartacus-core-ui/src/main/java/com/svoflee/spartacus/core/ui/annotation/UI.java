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

package com.svoflee.spartacus.core.ui.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.svoflee.spartacus.core.ui.model.FieldType;

/**
 * UI 是对UI界面中显示的设置
 * 
 * @author <a href="mailto:svoflee@gmail.com">svoflee@gmail.com</a>
 * @since 1.0.0
 * @version 1.0.0
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UI {

    /**
     * 显示在界面中对应字段的Caption
     */
    String caption() default "Model Caption";

    /**
     * 界面显示的顺序，默认从20开始，编码规范为200，210，220递进
     */
    int index() default 200;

    /**
     * 设置在界面中是否对该属性进行显示,默认 显示
     */
    ShowType showType() default ShowType.ALL;

    /**
     * 标识字段是否可以编辑，当新建状态下和在修改状态下时是否可编辑，默认为在所有状态下均可编辑
     */
    Editable editable() default Editable.ALL;

    /**
     * 标识字段在界面显示时的属性，默认为 String类型
     */
    FieldType fieldType() default FieldType.STRING;

}
