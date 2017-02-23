package hashcode2017.model;


import java.util.List;

/**
 * Created by The One on 23-Feb-17.
 */
public class EndPoints {
    private int endPointID;
    private int dataCenterLatency;
    private List cashe;
    private int connectedToAmountOfCashes;
    private List requests;

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

    public List getCashe() {
        return cashe;
    }

    public void setCashe(List cashe) {
        this.cashe = cashe;
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
