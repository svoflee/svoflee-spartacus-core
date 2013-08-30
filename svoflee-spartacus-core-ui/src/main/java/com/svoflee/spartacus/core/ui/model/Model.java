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
 * Model 是UI界面中显示模型的接口
 * 
 * @author <a href="mailto:svoflee@gmail.com">svoflee@gmail.com</a>
 * @since 1.0.0
 * @version 1.0.0
 */
public interface Model {

    /**
     * 获取模型唯一标识的属性名称，通常为"id"
     * 
     * @return
     */
    public String modelPrimaryKeyPropertyName();

    /**
     * 获取模型唯一标识对应的值
     * 
     * @return
     */
    public Object modelPrimaryKeyValue();

    /**
     * 模型显示时的Caption值
     * 
     * @return
     */
    public String modelCaption();

}
