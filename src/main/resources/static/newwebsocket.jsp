<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript" src="http://cdn.bootcss.com/jquery/3.1.0/jquery.min.js"></script>
<script type="text/javascript" src="http://cdn.bootcss.com/sockjs-client/1.1.1/sockjs.js"></script>
<!-- 云服务器加密：wss://utils.top/qiao-websocket/webSocketServer -->
<%--ws://localhost:8080/webSocketServer--%>
<script type="text/javascript">

    var msgDiv = document.getElementById("#msgDiv");
    var websocket = null;

    // websocket = new WebSocket('ws://echo.websocket.org');
    // websocket = new WebSocket('wss://utils.top/qiao-websocket/webSocketServer');
    websocket = new WebSocket("ws://"+document.location.host+"/webSocketServer");
    // websocket = new WebSocket('ws://10.9.182.159:8080/webSocketServer');
    websocket.onopen = onOpen;      
    websocket.onmessage = onMessage;
    websocket.onerror = onError;
    websocket.onclose = onClose;
    //建立连接时触发
    function onOpen(openEvt) {
        alert(openEvt.Data+"onOpen");
    }
    //接收到服务器的消息时触发
    function onMessage(evt) {
        // alert("document.location.host:  "+document.location.host);
        // alert(evt.data+"onMessage");
        $("#msgDiv").html(evt.data);
    }
    //发生错误时触发
    function onError() {
        alert("出错"+"onError");
    }
    //连接关闭时触发
    function onClose() {
        alert("关闭"+"onClose");
    }

    function doSend() {
        if (websocket.readyState == websocket.OPEN) {          
            var msg = document.getElementById("inputMsg").value;  
            websocket.send(msg); //调用后台handleTextMessage方法
            alert("发送成功!");
        } else {  
            alert("连接失败!");  
        }  
    }
    window.close=function(){
        websocket.onclose();
    }
</script>
<body align="center">
    <h3>消息推送</h3>
    请输入：<textarea rows="8" cols="50" id="inputMsg" name="inputMsg"></textarea>
    <button onclick="doSend();">发送</button>
    <hr/>
    <textarea rows="10" cols="70" id="msgDiv"></textarea>
</body>
</html>