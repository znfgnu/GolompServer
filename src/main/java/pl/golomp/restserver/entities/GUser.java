package pl.golomp.restserver.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * Created by konrad on 25.01.15.
 */
@Entity
public class GUser {
    @Id @GeneratedValue
    private Long id;
    @Column(unique = true, nullable = false)
    private String login;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private Timestamp createDate;
    @Column(nullable = false)
    private String hashAlg;

    public Boolean checkPassword(String password) {
        // only plaintext now
        if (this.password.equals(password)) return Boolean.TRUE;
        return Boolean.FALSE;
    }

    @Override
    public String toString() {
        return "GUser{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", createDate=" + createDate +
                ", hashAlg='" + hashAlg + '\'' +
                '}';
    }

    public GUser() {
    }

    public GUser(String login, String password) {
        this.login = login;
        this.password = password;;
        this.createDate = new Timestamp(System.currentTimeMillis());
        this.hashAlg = "plain";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public String getHashAlg() {
        return hashAlg;
    }

    public void setHashAlg(String hashAlg) {
        this.hashAlg = hashAlg;
    }
}
