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
 * ThresholdCompressionStrategy 是阀值压缩代理类，超过阀值则压缩，
 * 阀值缺省为10240(10K), 缺省使用 {@link ZLibCompressionAlgorithm}进行压缩
 * 
 * @author <a href="mailto:svoflee@gmail.com">svoflee@gmail.com</a>
 * @since 1.0.0
 * @version 1.0.0
 */
public class ThresholdCompressionStrategy implements CompressionStrategy {

    /**
     * 阀值，缺省为10240，超过阀值则压缩
     */
    int threshold;

    /**
     * 压缩算法, 缺省使用{@link ZLibCompressionAlgorithm}
     */
    CompressionAlgorithm compressionAlgorithm;

    public ThresholdCompressionStrategy() {
        this(10240);
    }

    public ThresholdCompressionStrategy(int threshold) {
        this(threshold, new ZLibCompressionAlgorithm());
    }

    public ThresholdCompressionStrategy(int threshold, CompressionAlgorithm compressionAlgorithm) {
        this.threshold = threshold;
        this.compressionAlgorithm = compressionAlgorithm;
    }

    @Override
    public CompressionResult compress(byte[] buffer) throws IOException {
        CompressionResult result = new CompressionResult(false, buffer);
        if (buffer.length > threshold) {
            byte[] bytes = compressionAlgorithm.compress(buffer);

            if (bytes.length < buffer.length) {
                result.setBuffer(bytes);
                result.setCompressed(true);
            }
        }
        return result;
    }

    @Override
    public byte[] decompress(byte[] buffer) throws IOException {
        return compressionAlgorithm.decompress(buffer);
    }

    public void setCompressionAlgorithm(CompressionAlgorithm compressionAlgorithm) {
        this.compressionAlgorithm = compressionAlgorithm;
    }

    public CompressionAlgorithm getCompressionAlgorithm() {
        return compressionAlgorithm;
    }

    public int getThreshold() {
        return threshold;
    }

    public void setThreshold(int threshold) {
        this.threshold = threshold;
    }
}
