package com.ysm.ublog.utils;
import com.google.gson.Gson;
import com.ysm.ublog.contact.pojo.Contact;
import com.ysm.ublog.contact.service.ContactService;
import com.ysm.ublog.contact.service.impl.ContactServiceImpl;
import com.ysm.ublog.mapper.ContactMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import sun.util.resources.cldr.yo.CurrencyNames_yo;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
/**
 * Created by jackiechan on 10/28/18/8:04 PM
 * 这个对象是单例的
 * 当前类是一个消息的处理类
 *
 * @Author jackiechan
 */

@Component
public class ChatMessageHandler extends TextWebSocketHandler {
    //这个map集合中存储的时所有的进行连接的人，key为name,value每个人单独的连接
    private Map<String, WebSocketSession> allClient = new ConcurrentHashMap<>();
    @Autowired
    private ContactMapper mapper;
    /**
     * 当链接建立的时候执行, 相当于我们普通情况下 onOpen
     * 在建立连接的时候，你需要看一下你的好友是否在线，如果没有在线的话是没有办法发送消息的。
     * <p>
     * 在判断在线之前先判断一下你的好友是否登陆，
     * 1.如果登陆再判断在不在线
     * 2.如果没有在线，就发送当前的好友不在线
     *
     * @param session
     * @throws Exception
     */
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        super.afterConnectionEstablished(session);
        //保存到map中
        Map<String, Object> attributes = session.getAttributes();//拦截器中的那个map,里面放着我们的name
        String uid = ((String) attributes.get("uid"));
        allClient.put(uid, session);//保存了所有的链接session,key指的是连接者
//        获取当前用户的所有的好友
        List<Contact> friend = mapper.getAllContact(Integer.parseInt(uid));
//        获取现在所有在线的人
        Set<String> online = allClient.keySet();
        Set<String> ids = new HashSet<>();
//        在所有在线的人中查出自己的好友
        String onlinefriend = "";
        int id_ = 0;
        for (int i = 0; i < friend.size(); i++) {
            if (online.contains(friend.get(i).getId()+"")){
                ids.add(friend.get(i).getId()+"");
            }
        }
        session.sendMessage(new TextMessage("当前您在线的好友有:"+ ids.toString()));
        System.out.println("当前在线人数:" + allClient.size());
    }

    /**
     * 处理文本消息 相当于我们的onMessage
     *
     * @param session
     * @param message
     * @throws Exception
     */
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {

        byte[] bytes = message.asBytes();
//        从前端获取到的消息
        String tomessage = new String(bytes, "utf-8");
//        得到接收者的id
        String touserid = tomessage.substring(0,tomessage.indexOf(","));
//        得到接收者要接收的信息
        String tousermessage = tomessage.substring(tomessage.indexOf(",")+1);
        System.out.println(touserid+"-----"+tousermessage);

//        取出接收者所对应的WebSocketSession
        WebSocketSession touserSession = allClient.get(touserid);
        if (touserSession!=null&&touserSession.isOpen()){
            touserSession.sendMessage(new TextMessage(tousermessage));
        }else {
            session.sendMessage(new TextMessage("您所要聊天的用户不在线..."));
        }
    }


    /**
     * 连接关闭 相当于 onClose
     *
     * @param session
     * @param status
     * @throws Exception
     */
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        super.afterConnectionClosed(session, status);
    }
}
