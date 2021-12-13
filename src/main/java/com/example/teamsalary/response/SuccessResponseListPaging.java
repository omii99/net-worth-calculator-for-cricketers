package com.example.teamsalary.response;

import java.util.List;

public class SuccessResponseListPaging {
    private int code;
    private List data;
    private int total;
    private String message;

    public SuccessResponseListPaging(int code, List data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
    }

    public SuccessResponseListPaging(int code, List data, int total, String message) {
        this.code = code;
        this.data = data;
        this.total = total;
        this.message = message;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
