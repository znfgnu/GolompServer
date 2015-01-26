package pl.golomp.restserver.requests;

/**
 * Created by konrad on 25.01.15.
 */
public class LogoutRequest {
    private String token;

    public LogoutRequest() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
