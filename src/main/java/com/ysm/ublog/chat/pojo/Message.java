package com.ysm.ublog.chat.pojo;

import java.util.Date;

/**
 * @author hua
 * @date 2018/11/8 14:48.
 */
//用于记录用户的消息
public class Message {

    private String content;
    private int senderid;
    private int receiverid;
    private Date sendtime;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getSenderid() {
        return senderid;
    }

    public void setSenderid(int senderid) {
        this.senderid = senderid;
    }

    public int getReceiverid() {
        return receiverid;
    }

    public void setReceiverid(int receiverid) {
        this.receiverid = receiverid;
    }

    public Date getSendtime() {
        return sendtime;
    }

    public void setSendtime(Date sendtime) {
        this.sendtime = sendtime;
    }

    @Override
    public String toString() {
        return "Message{" +
                "content='" + content + '\'' +
                ", senderid=" + senderid +
                ", receiverid=" + receiverid +
                ", sendtime=" + sendtime +
                '}';
    }
}
