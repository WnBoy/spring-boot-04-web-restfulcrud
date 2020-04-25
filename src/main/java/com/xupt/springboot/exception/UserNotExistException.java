package com.xupt.springboot.exception;

/**
 * @author Wnlife
 * @create 2020-04-23 19:19
 */
public class UserNotExistException extends RuntimeException{
    public UserNotExistException() {
        super("User信息有问题");
    }
}
