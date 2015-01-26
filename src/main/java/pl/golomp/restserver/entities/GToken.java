package pl.golomp.restserver.entities;

import com.sun.org.apache.xpath.internal.operations.Bool;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.UUID;

/**
 * Created by konrad on 25.01.15.
 */
@Entity
public class GToken {
    @Id @GeneratedValue
    private Long id;
    @Column(unique = true, nullable = false)
    private String token;
    @ManyToOne(fetch = FetchType.LAZY)
    private GUser gUser;
    @Column(nullable = false)
    private Timestamp expDate;
    @Column(nullable = false)
    private Timestamp createDate;
    @Column(nullable = false)
    private Boolean loggedOut;

    public GToken() {
    }

    public GToken(GUser gUser, Long durationMillis) {
        long now = System.currentTimeMillis();
        long exp = now + durationMillis;
        this.token = UUID.randomUUID().toString();  // random token
        this.gUser = gUser;
        this.expDate = new Timestamp(exp);
        this.createDate = new Timestamp(now);
        this.loggedOut = Boolean.FALSE;
    }

    @Override
    public String toString() {
        return "GToken{" +
                "id=" + id +
                ", token='" + token + '\'' +
                ", gUser=" + gUser +
                ", expDate=" + expDate +
                ", createDate=" + createDate +
                ", loggedOut=" + loggedOut +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public GUser getgUser() {
        return gUser;
    }

    public void setgUser(GUser gUser) {
        this.gUser = gUser;
    }

    public Timestamp getExpDate() {
        return expDate;
    }

    public void setExpDate(Timestamp expDate) {
        this.expDate = expDate;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public Boolean getLoggedOut() {
        return loggedOut;
    }

    public void setLoggedOut(Boolean loggedOut) {
        this.loggedOut = loggedOut;
    }
}
