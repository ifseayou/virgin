package com.isea.learn.virginwebsocket.service;

import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author isea_you
 * @date 2019/9/2
 * @time 13:28
 * @target:
 *  @ServerEndpoint 注解是一个类层次的注解，它的功能主要是将目前的类定义成一个websocket服务器端,
 *                 注解的值将被用于监听用户连接的终端访问URL地址,客户端可以通过这个URL来连接到WebSocket服务器端
 */

@Component
@ServerEndpoint("/webSocket")
public class WebSocket {

    // 与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;

    // concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。若要实现服务端与单一客户端通信的话，可以使用Map来存放，其中Key可以为用户标识
    private static CopyOnWriteArraySet<WebSocket> webSockets=new CopyOnWriteArraySet<>();

    @OnOpen
    public void onOpen(Session session){
        this.session=session;
        webSockets.add(this);
        System.out.println("有新的连接，总数"+webSockets.size());
    }

    @OnClose
    public void onClose(){
        webSockets.remove(this);
        System.out.println("有新的断开，总数"+webSockets.size());
    }

    @OnMessage
    public void onMessage(String message){

        System.out.println(message);
        send(message);
    }

    public void send(String message){
        for (WebSocket webSocket:webSockets){
            try {
                webSocket.session.getBasicRemote().sendText(message);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
