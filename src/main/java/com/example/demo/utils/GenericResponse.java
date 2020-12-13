package com.example.demo.utils;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

public class GenericResponse <T>{
    private int code;
    private T body;
    private String errorMessage;
    public GenericResponse(T body) {
        this.code= Response.Status.OK.getStatusCode();
        this.body = body;
    }

    public GenericResponse(Response.Status code, String errorMessage) {
        this.code = code.getStatusCode();
        this.errorMessage = errorMessage;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
