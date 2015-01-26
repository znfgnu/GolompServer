package pl.golomp.restserver.entities;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by konrad on 26.01.15.
 */
@Entity
public class GMessage {
    @Id @GeneratedValue
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private GUser sender;
    @ManyToOne(fetch = FetchType.LAZY)
    private GUser recipient;
    @Column(nullable = false)
    private Timestamp sendDate;
    @Column(nullable = false)
    private Timestamp deliveryDate;
    @Column(nullable = true)
    private Timestamp recvDate;
    @Column(nullable = false)
    private Boolean deletedSender;
    @Column(nullable = false)
    private Boolean deletedRecipient;
    @Column(nullable = false)
    private String content;

    public Boolean readyToGet() {
        Timestamp now = new Timestamp(System.currentTimeMillis());
        return now.after(this.deliveryDate);
    }

    public GMessage(String content, GUser sender, GUser recipient, Timestamp deliveryDate) {
        this.content = content;
        this.sender = sender;
        this.recipient = recipient;
        this.deliveryDate = deliveryDate;
        this.sendDate = new Timestamp(System.currentTimeMillis());
        this.recvDate = null;
        this.deletedSender = Boolean.FALSE;
        this.deletedRecipient = Boolean.FALSE;
    }

    @Override
    public String toString() {
        return "GMessage{" +
                "id=" + id +
                ", sender=" + sender +
                ", recipient=" + recipient +
                ", sendDate=" + sendDate +
                ", deliveryDate=" + deliveryDate +
                ", recvDate=" + recvDate +
                ", deletedSender=" + deletedSender +
                ", deletedRecipient=" + deletedRecipient +
                ", content='" + content + '\'' +
                '}';
    }

    public GMessage() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public GUser getSender() {
        return sender;
    }

    public void setSender(GUser sender) {
        this.sender = sender;
    }

    public GUser getRecipient() {
        return recipient;
    }

    public void setRecipient(GUser recipient) {
        this.recipient = recipient;
    }

    public Timestamp getSendDate() {
        return sendDate;
    }

    public void setSendDate(Timestamp sendDate) {
        this.sendDate = sendDate;
    }

    public Timestamp getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Timestamp deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Timestamp getRecvDate() {
        return recvDate;
    }

    public void setRecvDate(Timestamp recvDate) {
        this.recvDate = recvDate;
    }

    public Boolean getDeletedSender() {
        return deletedSender;
    }

    public void setDeletedSender(Boolean deletedSender) {
        this.deletedSender = deletedSender;
    }

    public Boolean getDeletedRecipient() {
        return deletedRecipient;
    }

    public void setDeletedRecipient(Boolean deletedRecipient) {
        this.deletedRecipient = deletedRecipient;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
