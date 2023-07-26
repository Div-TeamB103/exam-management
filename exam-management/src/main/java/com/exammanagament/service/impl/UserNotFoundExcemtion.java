package com.exammanagament.service.impl;

public class UserNotFoundExcemtion extends Throwable {
    public UserNotFoundExcemtion(String message) {
        super(message);
    }
}
