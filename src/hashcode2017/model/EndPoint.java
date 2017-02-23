package hashcode2017.model;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by The One on 23-Feb-17.
 */
public class EndPoint {
    private int endPointID;
    private int dataCenterLatency;
    private int connectedToAmountOfCashes;
    private List<Cache> cacheLatency;
    private List<Request> requests;

    public EndPoint(int endPointID, int dataCenterLatency, int connectedToAmountOfCashes) {
        this.endPointID = endPointID;
        this.dataCenterLatency = dataCenterLatency;
        this.connectedToAmountOfCashes = connectedToAmountOfCashes;
        cacheLatency = new ArrayList<>();
        requests = new ArrayList<>();
    }

    public int getEndPointID() {
        return endPointID;
    }

    public void setEndPointID(int endPointID) {
        this.endPointID = endPointID;
    }

    public int getDataCenterLatency() {
        return dataCenterLatency;
    }

    public void setDataCenterLatency(int dataCenterLatency) {
        this.dataCenterLatency = dataCenterLatency;
    }

    public void addToCacheLatency(Cache cache){
        cacheLatency.add(cache);
    }

    public List<Cache> getCacheLatencies(){
        return cacheLatency;
    }

    public void addRequest(Request request){
        requests.add(request);
    }

    public int getConnectedToAmountOfCashes() {
        return connectedToAmountOfCashes;
    }

    public void setConnectedToAmountOfCashes(int connectedToAmountOfCashes) {
        this.connectedToAmountOfCashes = connectedToAmountOfCashes;
    }

    public List getRequests() {
        return requests;
    }

    public void setRequests(List requests) {
        this.requests = requests;
    }




}
