package pl.golomp.restserver.requests;

/**
 * Created by konrad on 26.01.15.
 */
public class StatusGetRequest {
    private  String token;
    private Long msgId;

    public StatusGetRequest() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getMsgId() {
        return msgId;
    }

    public void setMsgId(Long msgId) {
        this.msgId = msgId;
    }
}
