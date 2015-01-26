package pl.golomp.restserver.responses;

import pl.golomp.restserver.entities.GMessage;

/**
 * Created by konrad on 26.01.15.
 */
public class GetResponse {
    private String sender;
    private String content;

    public GetResponse(GMessage gMessage) {
        this.sender = gMessage.getSender().getLogin();
        this.content = gMessage.getContent();
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
