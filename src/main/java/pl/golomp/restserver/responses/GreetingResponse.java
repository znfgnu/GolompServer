package pl.golomp.restserver.responses;

/**
 * Created by konrad on 24.01.15.
 */

public class GreetingResponse {
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    private String text;

    public GreetingResponse(String text) {
        this.text = text;
    }
}
