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

package com.svoflee.spartacus.core.constants;

/**
 * GlobalConstants 是全局常量
 * 
 * @author svoflee(svoflee@gmail.com)
 * @since 1.0.0
 */
public final class GlobalConstants {

    public static enum Version {
        V1_0_0("V1.0.0"), V2_0_0("V2.0.0");

        private final String txt;

        Version(String txt) {
            this.txt = txt;
        }

        public String txt() {
            return txt;
        }

        @Override
        public String toString() {
            return txt();
        }
    }

    /**
     * 时间序列单位
     * 
     * @author V.L.
     * @since 1.0.0
     */
    public static enum TsUnit {

        /**
         * 年度
         */
        YEARLY, /**
         * 
         */
        QUARTERLY, MONTHLY, DAILY, WEEKLY, HOURLY, MINUTELY;
    }

    public static final String DEFAULT_ERROR_MESSAGE_CODE = "sys.default.error.messagecode";

    public static final String URI_LOGIN_PAGE = "account/login";

    public static final String URI_MAINAPP_ROOT_PAGE = "main";

}
