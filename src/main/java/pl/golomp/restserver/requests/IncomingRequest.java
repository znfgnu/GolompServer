package pl.golomp.restserver.requests;

/**
 * Created by konrad on 26.01.15.
 */
public class IncomingRequest {
    private String token;

    public IncomingRequest() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
