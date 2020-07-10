package com.example.asd.common;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("ResponseBean系统响应对象")
public class ResponseBean {
    /**
     * HTTP状态码
     */
    @ApiModelProperty(value = "响应编码")
    private Integer success;

    /**
     * 返回的数据
     */
    @ApiModelProperty(value = "响应数据")
    private Object result;

    /**
     * 返回信息
     */
    @ApiModelProperty(value = "响应信息")
    private String msg;

    public ResponseBean(int success, String msg, Object result) {
        this.success = success;
        this.result = result;
        this.msg = msg;
    }

    public Integer getSuccess() {
        return success;
    }

    public void setSuccess(Integer success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}