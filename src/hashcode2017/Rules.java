package hashcode2017;

/**
 * Created by Sharky on 23/02/2017.
 */
public class Rules {
    int videos;
    int endPoints;
    int requestDesc;
    int caches;
    int cacheSize;

    public Rules(int videos, int endPoints, int requestDesc, int caches, int cacheSize) {
        this.videos = videos;
        this.endPoints = endPoints;
        this.requestDesc = requestDesc;
        this.caches = caches;
        this.cacheSize = cacheSize;
    }

    public int getVideos() {
        return videos;
    }

    public void setVideos(int videos) {
        this.videos = videos;
    }

    public int getEndPoints() {
        return endPoints;
    }

    public void setEndPoints(int endPoints) {
        this.endPoints = endPoints;
    }

    public int getRequestDesc() {
        return requestDesc;
    }

    public void setRequestDesc(int requestDesc) {
        this.requestDesc = requestDesc;
    }

    public int getCaches() {
        return caches;
    }

    public void setCaches(int caches) {
        this.caches = caches;
    }

    public int getCacheSize() {
        return cacheSize;
    }

    public void setCacheSize(int cacheSize) {
        this.cacheSize = cacheSize;
    }
}
