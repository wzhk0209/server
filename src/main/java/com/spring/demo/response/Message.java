package com.spring.demo.response;

public class Message {

    private String message = "success";

    private int code = 0;

    private Object data;

    public Message(Object data) {
    }

    public static Message getSuccessData(){
        return new Message();
    }

    public static Message getSuccessData(Object data){
        return new Message(data);
    }

    public static Message getErrorData(int code, String message){
        return getErrorData(code, message, null);
    }

    public static Message getErrorData(int code, String message, Object data){
        return new Message(message, code, data);
    }

    public Message() {
    }

    public Message(String message, int code) {
        this.message = message;
        this.code = code;
    }

    public Message(String message, int code, Object data) {
        this.message = message;
        this.code = code;
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
