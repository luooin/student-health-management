package com.jxau.studentdocument.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class Result<T> implements Serializable {
    /**
     * @code 200表示正常，非200表示异常
     * */
    private int code;
    private String msg;
    private Boolean isSuccess;
    private Object data;
    boolean flag;

    private LocalDateTime timestamp;

    public Result() {
        this.timestamp = LocalDateTime.now();
    }

    public Result(boolean flag, Integer code, String message, T data) {
        this.flag = flag;
        this.code = code;
        this.msg = message;
        this.data = data;
    }

    public static Result ok(){
        Result r = new Result();
        r.setCode(HttpStatus.OK.value());
        r.setData("ok");
        r.setIsSuccess(true);
        return r;
    }
   /* public static Result ok(String msg){
        Result r = new Result();
        r.setCode(HttpStatus.OK.value());
        r.setMsg(msg);
        r.setIsSuccess(true);
        return r;
    }*/

    public static Result ok(Object data){
        Result r = new Result();
        r.setCode(HttpStatus.OK.value());
//        r.setMsg("ok");
        r.setIsSuccess(true);
        r.setData(data);
        return r;
    }

    public static Result error(){
        Result r = new Result();
        r.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
//        r.setMsg("error");
        r.setData("error");
        r.setIsSuccess(false);
        return r;
    }

    public static Result error(Object msg){
        Result r = new Result();
        r.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
//        r.setMsg(msg);
        r.setData(msg);
        r.setIsSuccess(false);
        return r;
    }

    public static Result error(Integer code,Object object){
        Result r = new Result();
        r.setCode(code);
//        r.setMsg(msg);
        r.setData(object);
        r.setIsSuccess(false);
        return r;
    }

}
