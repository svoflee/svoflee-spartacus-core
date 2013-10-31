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

package com.svoflee.spartacus.core.domain.meta;

import java.io.Serializable;

/**
 * Column 是
 * 
 * @author <a href="mailto:svoflee@gmail.com">svoflee</a>
 * @since 1.0.0
 * @version 1.0.0
 */
public class Column implements Serializable {

    private static final long serialVersionUID = -2147176657514827500L;

    private DataType dataType;

    private String name;

    private int type;

    private String typeName;

    private int columnSize;

    /**
     * @param name 字段的名称
     */
    public Column(String name) {
        super();
        this.name = name;
    }

    public Column() {
        super();

    }

    public DataType getDataType() {
        return dataType;
    }

    public void setDataType(DataType dataType) {
        this.dataType = dataType;
        // this.setTypeName(dataType.name());//
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //
    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public int getColumnSize() {
        return columnSize;
    }

    public void setColumnSize(int columnSize) {
        this.columnSize = columnSize;
    }

    @Override
    public String toString() {
        return "Column [name=" + name + ", dataType=" + dataType + ", columnSize=" + columnSize + "]";
    }

    // public Column(String name, int type, String typeName, int columnSize) {
    // super();
    // this.name = name;
    // this.dataType = type;
    // this.typeName = typeName;
    // this.columnSize = columnSize;
    // }

    /**************************** Public Methods ****************************/

    /**************************** Private Methods ****************************/

}
