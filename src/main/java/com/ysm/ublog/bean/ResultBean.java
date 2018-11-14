package com.ysm.ublog.bean;

import com.ysm.ublog.utils.ErrorCodeInterface;

/**
 * @author hua
 * @date 2018/11/6 11:20.
 * 这是一个用来返回结果的一个类
 *  用来封装响应的对象
 */
public class ResultBean {
    private int code;
    private String message;
    private Object data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
    public static ResultBean setOk(int code,String message,Object data){
        ResultBean resultBean = new ResultBean();
        resultBean.setCode(ErrorCodeInterface.SUCCESS);
        resultBean.setMessage(message);
        resultBean.setData(data);
        return  resultBean;
    }

    public static ResultBean setError(int code,String message){
        ResultBean resultBean = new ResultBean();
        resultBean.setCode(code);
        resultBean.setMessage(message);
        return resultBean;
    }
}
