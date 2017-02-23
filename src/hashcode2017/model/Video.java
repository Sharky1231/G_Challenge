package hashcode2017.model;

/**
 * Created by The One on 23-Feb-17.
 */
public class Video {
    private int videoID;
    private int videoSize;
    private int totalNumberRequest;
    private int requestMultipliedByMBrank;

    public Video(int videoID, int videoSize) {
        this.videoID = videoID;
        this.videoSize = videoSize;
        this.totalNumberRequest = 0;
        requestMultipliedByMBrank = 0;
    }

    public int getTotalNumberRequest() {
        return totalNumberRequest;
    }

    public void setTotalNumberRequest(int totalNumberRequest) {
        this.totalNumberRequest = totalNumberRequest;
    }

    public int getVideoSize() {
        return videoSize;
    }

    public void setVideoSize(int videoSize) {
        this.videoSize = videoSize;
    }

    public int getVideoID() {
        return videoID;
    }

    public void setVideoID(int videoID) {
        this.videoID = videoID;
    }

    public void setRank(){
        requestMultipliedByMBrank = totalNumberRequest * videoSize;
    }

    public int getRank(){
        return requestMultipliedByMBrank;
    }


}
