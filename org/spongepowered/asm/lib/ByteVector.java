/*
 * Decompiled with CFR 0.150.
 */
package org.spongepowered.asm.lib;

public class ByteVector {
    byte[] data;
    int length;

    public ByteVector() {
        this.data = new byte[64];
    }

    public ByteVector(int initialSize) {
        this.data = new byte[initialSize];
    }

    public ByteVector putByte(int b) {
        int length = this.length;
        if (length + 1 > this.data.length) {
            this.enlarge(1);
        }
        this.data[length++] = (byte)b;
        this.length = length;
        return this;
    }

    ByteVector put11(int b1, int b2) {
        int length = this.length;
        if (length + 2 > this.data.length) {
            this.enlarge(2);
        }
        byte[] data = this.data;
        data[length++] = (byte)b1;
        data[length++] = (byte)b2;
        this.length = length;
        return this;
    }

    public ByteVector putShort(int s) {
        int length = this.length;
        if (length + 2 > this.data.length) {
            this.enlarge(2);
        }
        byte[] data = this.data;
        data[length++] = (byte)(s >>> 8);
        data[length++] = (byte)s;
        this.length = length;
        return this;
    }

    ByteVector put12(int b, int s) {
        int length = this.length;
        if (length + 3 > this.data.length) {
            this.enlarge(3);
        }
        byte[] data = this.data;
        data[length++] = (byte)b;
        data[length++] = (byte)(s >>> 8);
        data[length++] = (byte)s;
        this.length = length;
        return this;
    }

    public ByteVector putInt(int i2) {
        int length = this.length;
        if (length + 4 > this.data.length) {
            this.enlarge(4);
        }
        byte[] data = this.data;
        data[length++] = (byte)(i2 >>> 24);
        data[length++] = (byte)(i2 >>> 16);
        data[length++] = (byte)(i2 >>> 8);
        data[length++] = (byte)i2;
        this.length = length;
        return this;
    }

    public ByteVector putLong(long l2) {
        int length = this.length;
        if (length + 8 > this.data.length) {
            this.enlarge(8);
        }
        byte[] data = this.data;
        int i2 = (int)(l2 >>> 32);
        data[length++] = (byte)(i2 >>> 24);
        data[length++] = (byte)(i2 >>> 16);
        data[length++] = (byte)(i2 >>> 8);
        data[length++] = (byte)i2;
        i2 = (int)l2;
        data[length++] = (byte)(i2 >>> 24);
        data[length++] = (byte)(i2 >>> 16);
        data[length++] = (byte)(i2 >>> 8);
        data[length++] = (byte)i2;
        this.length = length;
        return this;
    }

    public ByteVector putUTF8(String s) {
        int charLength = s.length();
        if (charLength > 65535) {
            throw new IllegalArgumentException();
        }
        int len = this.length;
        if (len + 2 + charLength > this.data.length) {
            this.enlarge(2 + charLength);
        }
        byte[] data = this.data;
        data[len++] = (byte)(charLength >>> 8);
        data[len++] = (byte)charLength;
        for (int i2 = 0; i2 < charLength; ++i2) {
            char c = s.charAt(i2);
            if (c < '\u0001' || c > '\u007f') {
                this.length = len;
                return this.encodeUTF8(s, i2, 65535);
            }
            data[len++] = (byte)c;
        }
        this.length = len;
        return this;
    }

    ByteVector encodeUTF8(String s, int i2, int maxByteLength) {
        char c;
        int charLength = s.length();
        int byteLength = i2;
        for (int j = i2; j < charLength; ++j) {
            c = s.charAt(j);
            if (c >= '\u0001' && c <= '\u007f') {
                ++byteLength;
                continue;
            }
            if (c > '\u07ff') {
                byteLength += 3;
                continue;
            }
            byteLength += 2;
        }
        if (byteLength > maxByteLength) {
            throw new IllegalArgumentException();
        }
        int start = this.length - i2 - 2;
        if (start >= 0) {
            this.data[start] = (byte)(byteLength >>> 8);
            this.data[start + 1] = (byte)byteLength;
        }
        if (this.length + byteLength - i2 > this.data.length) {
            this.enlarge(byteLength - i2);
        }
        int len = this.length;
        for (int j = i2; j < charLength; ++j) {
            c = s.charAt(j);
            if (c >= '\u0001' && c <= '\u007f') {
                this.data[len++] = (byte)c;
                continue;
            }
            if (c > '\u07ff') {
                this.data[len++] = (byte)(0xE0 | c >> 12 & 0xF);
                this.data[len++] = (byte)(0x80 | c >> 6 & 0x3F);
                this.data[len++] = (byte)(0x80 | c & 0x3F);
                continue;
            }
            this.data[len++] = (byte)(0xC0 | c >> 6 & 0x1F);
            this.data[len++] = (byte)(0x80 | c & 0x3F);
        }
        this.length = len;
        return this;
    }

    public ByteVector putByteArray(byte[] b, int off, int len) {
        if (this.length + len > this.data.length) {
            this.enlarge(len);
        }
        if (b != null) {
            System.arraycopy(b, off, this.data, this.length, len);
        }
        this.length += len;
        return this;
    }

    private void enlarge(int size) {
        int length1 = 2 * this.data.length;
        int length2 = this.length + size;
        byte[] newData = new byte[length1 > length2 ? length1 : length2];
        System.arraycopy(this.data, 0, newData, 0, this.length);
        this.data = newData;
    }
}

