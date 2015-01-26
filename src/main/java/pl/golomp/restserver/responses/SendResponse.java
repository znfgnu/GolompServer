package pl.golomp.restserver.responses;

/**
 * Created by konrad on 26.01.15.
 */
public class SendResponse {
    private Long msgId;

    public SendResponse(Long msgId) {
        this.msgId = msgId;
    }

    public Long getMsgId() {
        return msgId;
    }

    public void setMsgId(Long msgId) {
        this.msgId = msgId;
    }
}
