package com.snva.sms.service.exception;

public class StudentServiceException extends Exception {

    public static final String NO_STUDENT_FOUND = "No Student found in list";

    public StudentServiceException(String msg) {
        super(msg);
    }
}
