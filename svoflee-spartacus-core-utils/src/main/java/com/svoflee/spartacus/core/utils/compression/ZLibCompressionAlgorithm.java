
package com.svoflee.spartacus.core.utils.compression;

import java.io.IOException;

/**
 * ZLibCompressionAlgorithm 是ZLib压缩算法实现
 * 
 * @author <a href="mailto:svoflee@gmail.com">svoflee@gmail.com</a>
 * @since 1.0.0
 * @version 1.0.0
 */
public class ZLibCompressionAlgorithm implements CompressionAlgorithm {

    @Override
    public byte[] compress(byte[] buffer) throws IOException {
        return ZLibUtils.compress(buffer);
    }

    @Override
    public byte[] decompress(byte[] buffer) throws IOException {
        return ZLibUtils.decompress(buffer);
    }
}
