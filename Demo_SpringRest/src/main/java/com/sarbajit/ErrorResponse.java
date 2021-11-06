package com.sarbajit;

public class ErrorResponse {
    private final String msg;
    private final int status;

    public String getMsg() {
        return msg;
    }
    public int getStatus() {
        return status;
    }
    public ErrorResponse(String msg, int status) {
        this.msg = msg;
        this.status = status;
    }
}
