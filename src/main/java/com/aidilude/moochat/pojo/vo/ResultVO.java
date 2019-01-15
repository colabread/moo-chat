package com.aidilude.moochat.pojo.vo;

import lombok.Data;

@Data
public class ResultVO {

    /**
     * 200：成功
     * 500：错误
     * 501：bean验证错误，不管多少个错误都以map形式返回
     * 502：拦截器拦截到用户token出错
     * 555：异常抛出信息
     */
    private Integer status;

    // 响应消息
    private String msg;

    // 响应数据
    private Object data;

    public static ResultVO newResultVO(Integer status, String msg, Object data) {
        return new ResultVO(status, msg, data);
    }

    public static ResultVO ok(Object data) {
        return new ResultVO(data);
    }

    public static ResultVO ok() {
        return new ResultVO(null);
    }

    public static ResultVO errorMsg(String msg) {
        return new ResultVO(500, msg, null);
    }

    public static ResultVO errorMap(Object data) {
        return new ResultVO(501, "error", data);
    }

    public static ResultVO errorTokenMsg(String msg) {
        return new ResultVO(502, msg, null);
    }

    public static ResultVO errorException(String msg) {
        return new ResultVO(555, msg, null);
    }

    public ResultVO() {

    }

    public ResultVO(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public ResultVO(Object data) {
        this.status = 200;
        this.msg = "OK";
        this.data = data;
    }

    public Boolean isOK() {
        return this.status == 200;
    }

}