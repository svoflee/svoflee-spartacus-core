
package com.svoflee.spartacus.core.utils.compression;

/**
 * CompressionResult 是压缩结果
 * 
 * @author <a href="mailto:svoflee@gmail.com">svoflee@gmail.com</a>
 * @since 1.0.0
 * @version 1.0.0
 */
public class CompressionResult {

    boolean isCompressed;

    byte[] buffer;

    public boolean isCompressed() {
        return isCompressed;
    }

    public void setCompressed(boolean isCompressed) {
        this.isCompressed = isCompressed;
    }

    public byte[] getBuffer() {
        return buffer;
    }

    public void setBuffer(byte[] buffer) {
        this.buffer = buffer;
    }

    public CompressionResult() {

    }

    public CompressionResult(boolean isCompressed, byte[] buffer) {
        this.isCompressed = isCompressed;
        this.buffer = buffer;
    }
}
