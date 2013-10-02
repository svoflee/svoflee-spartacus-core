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

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * GZipCompressionAlgorithm 是GZip压缩算法实现
 * 
 * @author <a href="mailto:svoflee@gmail.com">svoflee@gmail.com</a>
 * @since 1.0.0
 * @version 1.0.0
 */
public class GZipCompressionAlgorithm implements CompressionAlgorithm {

    int unit = 2048;

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    @Override
    public byte[] compress(byte[] buffer) throws IOException {
        ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream gzip = new GZIPOutputStream(arrayOutputStream);
        ByteArrayInputStream inputStream = new ByteArrayInputStream(buffer);

        try {
            byte[] buf = new byte[unit];
            int len = 0;
            while ((len = inputStream.read(buf)) != -1) {
                gzip.write(buf, 0, len);
            }

            gzip.finish();

            byte[] result = arrayOutputStream.toByteArray();

            return result;
        }
        catch (IOException e) {
            throw e;
        }
        finally {
            gzip.close();
            arrayOutputStream.close();
            inputStream.close();
        }
    }

    @Override
    public byte[] decompress(byte[] buffer) throws IOException {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(buffer);
        // Open the compressed stream
        GZIPInputStream gzip = new GZIPInputStream(inputStream);

        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {
            // Transfer bytes from the compressed stream to the output stream
            byte[] buf = new byte[unit];
            int len;
            while ((len = gzip.read(buf)) > 0) {
                out.write(buf, 0, len);
            }

            return out.toByteArray();
        }
        catch (IOException e) {
            throw e;
        }
        finally {
            // Close the file and stream
            gzip.close();
            out.close();
            inputStream.close();
        }
    }

}
