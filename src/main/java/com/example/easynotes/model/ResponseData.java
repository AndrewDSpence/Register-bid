package com.example.easynotes.model;

import javax.validation.constraints.NotBlank;

public class ResponseData {
    @NotBlank
    private String code;
    @NotBlank
    private String message;
    private Object user;
    public ResponseData(String code,String message,Object user){
        this.code = code;
        this.message = message;
        this.user = user;
    }
    public void setCode(String code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setUser(Object user) {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public Object getUser() {
        return user;
    }

    public String getCode() {
        return code;
    }
}
