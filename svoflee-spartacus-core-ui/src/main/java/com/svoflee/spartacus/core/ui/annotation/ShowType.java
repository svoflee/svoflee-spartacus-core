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

/**
 * ShowType 是显示属性，设置对某个属性的显示设置
 * 
 * @author svoflee(svoflee@gmail.com)
 * @since 1.0.0
 */
public enum ShowType {

    /**
     * 均显示
     */
    ALL("均显示"),

    /**
     * 仅表格显示
     */
    TABLE("仅表格显示"),

    /**
     * 仅表单显示
     */
    FORM("仅表单显示"),

    /**
     * 均不显示
     */
    NO("均不显示");

    private final String txt;

    ShowType(String txt) {
        this.txt = txt;
    }

    public String getTxt() {
        return txt;
    }

    @Override
    public String toString() {
        return txt;
    }
}
