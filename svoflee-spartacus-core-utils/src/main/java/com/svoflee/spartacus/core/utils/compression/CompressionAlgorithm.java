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
 * CompressionAlgorithm 是压缩算法接口
 * 
 * @author <a href="mailto:svoflee@gmail.com">svoflee@gmail.com</a>
 * @since 1.0.0
 * @version 1.0.0
 */
public interface CompressionAlgorithm {

    /**
     * @Description: 压缩
     * @param buffer 待压缩内容
     * @throws IOException 设定文件
     * @return byte[] 返回类型
     */
    byte[] compress(byte[] buffer) throws IOException;

    /**
     * @Title: decompress
     * @param buffer 待解压内容
     * @throws IOException 设定文件
     * @return byte[] 返回类型
     */
    byte[] decompress(byte[] buffer) throws IOException;
}
