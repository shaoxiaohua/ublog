package com.ysm.ublog.myinfo.pojo;

public class Result_pojo {
    private Object object;
    private int code;
    private String msg;

    public Result_pojo(Object object, int code, String msg) {
        this.object = object;
        this.code = code;
        this.msg = msg;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
