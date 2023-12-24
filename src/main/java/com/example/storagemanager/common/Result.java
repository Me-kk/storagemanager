package com.example.storagemanager.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Result<T>{
    private Integer code;
    private String msg;
    private T data;

    public static <T> Result<T> success(T data){
        return new Result<T>().setCode(200).setMsg("success").setData(data);
    }

    public static <T> Result<T> fail(String msg,T data) {
        return new Result<T>().setCode(200).setMsg(msg).setData(data);
    }

    public static <T> Result<T> fail(String msg) {
        return new Result<T>().setCode(200).setMsg(msg);
    }
}
