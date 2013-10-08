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
 * ShortUUIDTest 是
 * 
 * @author <a href="mailto:svoflee@gmail.com">svoflee@gmail.com</a>
 * @since 1.0.0
 * @version 1.0.0
 */
public class ShortUUIDTest {

    private static final Logger log = Logger.getLogger(ShortUUIDTest.class.getName());

    /**
     * @param args
     */
    public static void main(String[] args) {
        // U.p(ShortUUID.randomUUID());
        U.p(IdUtils.getGlobleUniqueId());
        // test2(1000000);

    }

    public static void test2(int size) {
        long begin = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            ShortUUID.randomUUID();
        }
        long end = System.currentTimeMillis();
        U.p(end - begin);
    }

    /**
     * 
     */
    public static void test1(int size) {
        long begin = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            IdUtils.getGlobleUniqueId();
        }
        long end = System.currentTimeMillis();
        U.p(end - begin);
    }
}
