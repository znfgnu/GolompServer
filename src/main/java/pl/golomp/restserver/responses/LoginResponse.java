package pl.golomp.restserver.responses;

import pl.golomp.restserver.entities.GToken;

import java.sql.Timestamp;

/**
 * Created by konrad on 25.01.15.
 */
public class LoginResponse {
    private String token;
    private Timestamp expDate;

    public LoginResponse(GToken token) {
        this.token = token.getToken();
        this.expDate = token.getExpDate();
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Timestamp getExpDate() {
        return expDate;
    }

    public void setExpDate(Timestamp expDate) {
        this.expDate = expDate;
    }
}
