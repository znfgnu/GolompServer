package pl.golomp.restserver;

/**
 * Created by konrad on 25.01.15.
 */
public final class Constants {
    private Constants() {
    }

    public static final int nowProtocol = 1;
    public static final int lowestProtocol = 0;
    public static final Long sessionDuration = new Long(1000*60*20);    // 20 minutes
}
