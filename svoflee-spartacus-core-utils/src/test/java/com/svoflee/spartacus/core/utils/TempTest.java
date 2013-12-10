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

import com.svoflee.spartacus.core.log.Logger;

/**
 * TempTest 是
 * 
 * @author <a href="mailto:svoflee@gmail.com">svoflee@gmail.com</a>
 * @since 1.0.0
 * @version 1.0.0
 */
public class TempTest {

    private static final Logger log = Logger.getLogger(TempTest.class.getName());

    public static void main(String[] args) {
        String testHash = "hello";
        int hash = testHash.hashCode();
        U.p(testHash.hashCode());
        double r = Math.pow(2, 32);
        U.p(r);
        U.p(hash % r);
    }

}
