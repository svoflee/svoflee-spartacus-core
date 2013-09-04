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

package com.svoflee.spartacus.core.log;

/**
 * Logs 是日志信息工具类
 * 
 * @author <a href="mailto:svoflee@gmail.com">svoflee@gmail.com</a>
 * @since 1.0.0
 */
public final class Logs {

    public static StringBuilder createExceptionInfo(Throwable e) {
        StringBuilder result = new StringBuilder(20);
        result.append("(").append(e.toString()).append(")").append(e.getCause());
        return result;
    }

    public static void logE(Logger log, Throwable e) {
        log.error(Logs.createExceptionInfo(e).toString(), e);
    }

}
