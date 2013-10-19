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

package com.svoflee.spartacus.core.utils;

import java.io.File;
import java.io.IOException;

import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.springframework.util.Assert;

import com.svoflee.spartacus.core.log.Logger;
import com.svoflee.spartacus.core.utils.exception.EUtils;

/**
 * JxlExcelUtils 是使用Jxl操作Excel的工具类
 * 
 * @author <a href="mailto:svoflee@gmail.com">svoflee@gmail.com</a>
 * @since 1.0.0
 * @version 1.0.0
 */
public class JxlExcelUtils {

    public static final Logger log = Logger.getLogger(JxlExcelUtils.class);

    /**
     * @param args
     */
    public static void main(String[] args) {

    }

    /**
     * @param excelFileName
     * @return
     */
    public static Workbook instanceWorkbook(String excelFileName) {
        Assert.notNull(excelFileName, "文件名不能为空");
        File file = new File(excelFileName);
        return instanceWorkbook(file);
    }

    public static Workbook instanceWorkbook(File file) {
        Workbook wb = null;
        try {
            wb = Workbook.getWorkbook(file);

        }
        catch (BiffException e) {
            log.error("canot get workbook " + e.getMessage());
            // EUtils.throwDefaultRuntimeException("canot get workbook " +
            // e.getMessage());
        }
        catch (IOException e) {
            log.error("canot get workbook " + e.getMessage());

            // EUtils.throwDefaultRuntimeException("canot get workbook " +
            // e.getMessage());
        }
        if (wb == null) {
            EUtils.throwDefaultRuntimeException("no workbook in " + file.getAbsolutePath());
        }
        return wb;
    }

}
