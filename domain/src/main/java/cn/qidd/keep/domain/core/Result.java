package cn.qidd.keep.domain.core;

import java.io.Serializable;

/**
 * 返回封装对象
 * Created by sunyanping on 2017/1/18.
 */
public class Result<T> implements Serializable {
    public enum Status {
        SUCCESS, FAILURE
    }

    private String status;
    private String msg;
    private T data;
    public Result(){

    }
    public Result(Status status, String msg) {
        this.status = status.name();
        this.msg = msg;
    }

    public Result(Status status, T data) {
        this.status = status.name();
        this.data = data;
    }

    public Result(Status status, String msg, T  data) {
        this.status = status.name();
        this.msg = msg;
        this.data=data;
    }

    public Boolean isSuccess(){
        return "SUCCESS".equals(getReturnValue());
    }

    public String getReturnValue() {
        return status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "status='" + status + '\'' +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
