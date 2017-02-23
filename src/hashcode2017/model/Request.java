package hashcode2017.model;

/**
 * Created by The One on 23-Feb-17.
 */
public class Request {

    private int requestAmount;
    private int videoID;
    private int fromEndPoint;

    public Request(int requestAmount, int videoID, int fromEndPoint) {
        this.requestAmount = requestAmount;
        this.videoID = videoID;
        this.fromEndPoint = fromEndPoint;
    }

    public int getRequestAmount() {
        return requestAmount;
    }

    public void setRequestAmount(int requestAmount) {
        this.requestAmount = requestAmount;
    }

    public int getVideoID() {
        return videoID;
    }

    public void setVideoID(int videoID) {
        this.videoID = videoID;
    }

    public int getFromEndPoint() {
        return fromEndPoint;
    }

    public void setFromEndPoint(int fromEndPoint) {
        this.fromEndPoint = fromEndPoint;
    }
}
