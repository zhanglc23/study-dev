package com.ivan.study;

public class Msg {
    private String time;
    private String source;
    private String messageId;
    private String message;

    public Msg() {
    }

    public Msg(String time, String source, String messageId, String message, MsgType msgType, String accDate, String txCode) {
        this.time = time;
        this.source = source;
        this.messageId = messageId;
        this.message = message;
        this.msgType = msgType;
        this.accDate = accDate;
        this.txCode = txCode;
    }

    private MsgType msgType;
    private String accDate ;
    private String txCode ;



    public Msg(String time, String source, String messageId, String message, MsgType msgType) {
        this.time = time;
        this.source = source;
        this.messageId = messageId;
        this.message = message;
        this.msgType = msgType;
    }

    public Msg(String time, String source, String messageId, String message) {
        this.time = time;
        this.source = source;
        this.messageId = messageId;
        this.message = message;
    }

    public String getTime() {
        return time;
    }

    public String getSource() {
        return source;
    }

    public String getMessageId() {
        return messageId;
    }

    public String getMessage() {
        return message;
    }

    public MsgType getMsgType() {
        return msgType;
    }

    public String getAccDate() {
        return accDate;
    }

    public String getTxCode() {
        return txCode;
    }

    public void setAccDate(String accDate) {
        this.accDate = accDate;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"time\":\"").append(time).append('\"');
        sb.append(", \"source\":\"").append(source).append('\"');
        sb.append(", \"messageId\":\"").append(messageId).append('\"');
        sb.append(", \"msgType\":").append(msgType);
        sb.append(", \"accDate\":\"").append(accDate).append('\"');
        sb.append(", \"txCode\":\"").append(txCode).append('\"');
        sb.append(", \"message\":\"").append(message).append('\"');
        sb.append('}');
        return sb.toString();
    }
}
