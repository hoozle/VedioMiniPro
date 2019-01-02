package com.hnuc.common.util;

public class JSONResult {
    //状态码
    private Integer status;

    //响应信息
    private String msg;

    //响应数据
    private Object data;

    public JSONResult(Object data) {
        this.data = data;
        this.status = 200;
        this.msg = "OK";
    }

    public JSONResult(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static JSONResult errorMsg(String msg){
        return new JSONResult(500, msg,null);
    }
}
