package com.example.teamsalary.exception;

public class APIException   extends RuntimeException{
    private static final long serialVersionUId=1L;

    public APIException(String message){
        super(message);
    }

}
