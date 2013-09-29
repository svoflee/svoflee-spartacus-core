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

package com.svoflee.spartacus.core.utils.compression;

import java.io.IOException;

/**
 * CompressionStrategy 是压缩策略接口
 * 
 * @author <a href="mailto:svoflee@gmail.com">svoflee@gmail.com</a>
 * @since 1.0.0
 * @version 1.0.0
 */
public interface CompressionStrategy {

    /**
     * @Title: compress
     * @Description: 根据策略压缩
     * @author 简道
     * @param buffer
     *            待压缩内容
     * @throws IOException
     *             设定文件
     * @return CompressionResult 返回类型
     */
    CompressionResult compress(byte[] buffer) throws IOException;

    /**
     * @Title: decompress
     * @Description: 解压
     * @author 简道
     * @param buffer
     *            待解压内容
     * @throws IOException
     *             设定文件
     * @return byte[] 返回类型
     */
    byte[] decompress(byte[] buffer) throws IOException;
}
