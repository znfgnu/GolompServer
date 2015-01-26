package pl.golomp.restserver.responses;

import java.util.List;

/**
 * Created by konrad on 26.01.15.
 */
public class IncomingResponse {
    private List<Long> msgIdList;

    public IncomingResponse(List<Long> msgIdList) {
        this.msgIdList = msgIdList;
    }

    public List<Long> getMsgIdList() {
        return msgIdList;
    }

    public void setMsgIdList(List<Long> msgIdList) {
        this.msgIdList = msgIdList;
    }
}
