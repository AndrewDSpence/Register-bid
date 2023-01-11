package com.example.easynotes.model;

import javax.validation.constraints.NotBlank;

public class ResponseData {
    @NotBlank
    private String code;
    @NotBlank
    private String message;
    private Object data;
    public ResponseData(String code,String message,Object data){
        this.code = code;
        this.message = message;
        this.data = data;
    }
    public void setCode(String code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public Object getData() {
        return data;
    }

    public String getCode() {
        return code;
    }
}
