package pl.golomp.restserver.requests;

import java.sql.Timestamp;

/**
 * Created by konrad on 26.01.15.
 */
public class SendRequest {
    private String token;

    private String recipient;
    private Timestamp deliveryTime;
    private String content;

    public SendRequest() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public Timestamp getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Timestamp deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
