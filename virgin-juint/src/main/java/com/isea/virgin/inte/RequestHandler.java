package com.isea.virgin.inte;

/**
 * @author isea_you
 * @date 2019/10/30
 * @time 17:41
 * @target: 处理request，返回response
 */
public interface RequestHandler {
    Responce process(Request request) throws Exception;
}
