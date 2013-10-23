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

package com.svoflee.spartacus.core.utils.security;

/**
 * PwdUtils 是默认密码生成工具
 * 
 * @author <a href="mailto:svoflee@gmail.com">svoflee</a>
 * @since 1.0.0
 * @version 1.0.0
 */
public class PwdUtils {

    public static String encryptPassword(String plainPassword) {
        String cryptPassword = MD5Utils.getMd5String(plainPassword);
        return cryptPassword;
    }

    /**
     * @param userPwd
     * @param enPassword
     * @return
     */
    public static boolean isEqualWithPlain(String plainPassword, String encryptPassword) {
        return encryptPassword(plainPassword).equals(encryptPassword);
    }

}
