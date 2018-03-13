package com.zsy;

import com.alibaba.fastjson.JSON;

/**
 * Created by Lidd on 2018/3/13.
 */
public class ZsyProtocol {

    private String filename;

    private String md5;

    private long start;

    private long len;

    private byte[] data;

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public long getStart() {
        return start;
    }

    public void setStart(long start) {
        this.start = start;
    }

    public long getLen() {
        return len;
    }

    public void setLen(long len) {
        this.len = len;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public String toJson() {
        return JSON.toJSONString(this);
    }
}
