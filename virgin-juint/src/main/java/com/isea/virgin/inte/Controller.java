package com.isea.virgin.inte;

/**
 * @author isea_you
 * @date 2019/10/30
 * @time 17:42
 * @target: 处理收到的请求，在接收请求之后，controller就将请求分发给相应的RequestHandler，
 */
public interface Controller {
    Responce processRequest(Request request);
    void addHandler(Request request,RequestHandler requestHandler);
}
