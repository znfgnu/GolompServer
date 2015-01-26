package pl.golomp.restserver.responses;

import java.sql.Timestamp;

/**
 * Created by konrad on 26.01.15.
 */
public class StatusResponse {
    private Boolean ready;
    private Timestamp deliveryDate;

    public StatusResponse(Boolean ready, Timestamp deliveryDate) {
        this.ready = ready;
        this.deliveryDate = deliveryDate;
    }

    public Boolean getReady() {
        return ready;
    }

    public void setReady(Boolean ready) {
        this.ready = ready;
    }

    public Timestamp getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Timestamp deliveryDate) {
        this.deliveryDate = deliveryDate;
    }
}
