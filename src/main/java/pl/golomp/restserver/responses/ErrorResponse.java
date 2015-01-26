package pl.golomp.restserver.responses;

/**
 * Created by konrad on 25.01.15.
 */
public class ErrorResponse {
    private int errno;
    private String Content;

    public ErrorResponse(int errno, String content) {
        this.errno = errno;
        Content = content;
    }

    public int getErrno() {
        return errno;
    }

    public void setErrno(int errno) {
        this.errno = errno;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

}
