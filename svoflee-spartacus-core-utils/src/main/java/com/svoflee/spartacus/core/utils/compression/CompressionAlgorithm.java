
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
