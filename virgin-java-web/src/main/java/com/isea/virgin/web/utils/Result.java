package com.isea.virgin.web.utils;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

/**
 * @author ifseayou@gmail.com
 * @date 2020/1/3 12:30
 * @target:
 */

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class Result<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    private int code = 200;
    private String msg;
    private T data;

    public static Result success() {
        Result r = new Result();
        r.setMsg("操作成功");
        return r;
    }

    public static Result success(Object data) {
        Result r = new Result();
        r.setMsg("操作成功");
        r.setData(data);
        return r;
    }

    public static Result error() {
        return error(HttpStatus.INTERNAL_SERVER_ERROR.value(), "未知异常，请联系管理员");
    }

    public static Result error(String msg) {
        return error(HttpStatus.INTERNAL_SERVER_ERROR.value(), msg);
    }

    public static Result error(int code, String msg) {
        Result r = new Result();
        r.setCode(code);
        r.setMsg(msg);
        return r;
    }
}

