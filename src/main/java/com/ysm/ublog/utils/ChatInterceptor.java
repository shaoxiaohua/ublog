package com.ysm.ublog.utils;




import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

import javax.servlet.http.HttpSession;
import java.util.Map;

public class ChatInterceptor extends HttpSessionHandshakeInterceptor {
    /**
     *
     * @param request 请求
     * @param response 响应
     * @param wsHandler 处理器
     * @param attributes 请求的属性,会被传递到我们的handler中
     * @return  返回true代表放行 ,false代表拦截
     * @throws Exception
     */
//    握手之前
    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception {
       //我们可以在这里向属性中添加一个值,这个值我们可以用作标记, map的key我们随意,只要能保证唯一性以及记住就行
        String s = request.getURI().toString();//获取请求地址,我们要求了 最后一个/后面是标记
//      name指的是连接者的名字
        String uid = s.substring(s.lastIndexOf("/" )+ 1);
        attributes.put("uid", uid);
        ServletServerHttpRequest servletServerHttpRequest = (ServletServerHttpRequest) request;
        HttpSession session = servletServerHttpRequest.getServletRequest().getSession();
        if (session!=null){
            String touserid = (String) session.getAttribute("touserid");
            if(touserid!=null){
                attributes.put("websocket_touser", touserid);
                System.out.println("存入websocket_touser" + touserid);
            }
        }

        return super.beforeHandshake(request, response, wsHandler, attributes);
    }
//  建立连接之后
    @Override
    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Exception ex) {

        super.afterHandshake(request, response, wsHandler, ex);
    }
}
