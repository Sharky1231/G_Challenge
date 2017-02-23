package hashcode2017;

import hashcode2017.model.Cache;
import hashcode2017.model.EndPoint;
import hashcode2017.model.Request;
import hashcode2017.model.Video;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

/**
 * Created by Sharky on 23/02/2017.
 */
public class Network {
    Rules rules;
    int currentLine = 1;
    int nextEndpoint = 0;
    int numOfEndpoints = 0;
    ArrayList<Video> videos;
    ArrayList<EndPoint> endPoints;
    ArrayList<Request> requests;
    ArrayList<Cache> caches;
    int toLoop = 0;



    public Network(String pathToFile) throws IOException {
        File file = new File("src\\inputFiles\\" + pathToFile + ".in");
        rules = getRules(file);
        videos = new ArrayList<>();
        endPoints = new ArrayList<>();
        requests = new ArrayList<>();
        caches = new ArrayList<>();
        createNetwork(file);
    }

    public void createNetwork(File file) throws IOException {
        Files.lines(file.toPath()).forEach(this::parseLine);
    }

    public void parseLine(String file) {
        if(currentLine == 1){

        }
        else if(currentLine == 2){
            String[] videoSizes = file.split(" ");

            for (int i = 0; i < rules.getVideos(); i++){
                videos.add(new Video(i, Integer.parseInt(videoSizes[i])));
            }
        }

        else if(currentLine == 3 || currentLine == nextEndpoint){
            String[] endPointString = file.split(" ");
            int latencyToDT = Integer.parseInt(endPointString[0]);
            int numOfCaches = Integer.parseInt(endPointString[1]);

            endPoints.add(new EndPoint(endPoints.size(), latencyToDT, numOfCaches));
            if(numOfCaches != 0 && numOfEndpoints < rules.getEndPoints()-1)
            nextEndpoint = currentLine + numOfCaches + 1;

            numOfEndpoints++;
            toLoop = 0;
        }

        else if(toLoop < endPoints.get(endPoints.size() - 1).getConnectedToAmountOfCashes()){
            String[] cacheString = file.split(" ");
            int cacheId = Integer.parseInt(cacheString[0]);
            int latency = Integer.parseInt(cacheString[1]);
            int endpoint = endPoints.size() - 1;
            Cache cache = new Cache(cacheId, latency, rules.getCacheSize());

            caches.add(cache);
            endPoints.get(endPoints.size() - 1).addToCacheLatency(cache);
            toLoop++;
        }

        else if(endPoints.size() == rules.getEndPoints() + 1){
            String[] requestData = file.split(" ");
            int videoId = Integer.parseInt(requestData[0]);
            int endPointId = Integer.parseInt(requestData[1]);
            int amountOfRequests = Integer.parseInt(requestData[2]);

            Request request = new Request(amountOfRequests, videoId, endPointId);
            endPoints.get(endPointId).addRequest(request);

            Video video = videos.get(videoId);
            video.setTotalNumberRequest(video.getTotalNumberRequest() + amountOfRequests);
        }





//        else if(currentEndpointId > rules.getEndPoints()){
//            int g = 5;
//        }
//
//        else if(currentLine > 2 && nextEndpoint == 0){
//            String[] endPointString = file.split(" ");
//            int latencyToDT = Integer.parseInt(endPointString[0]);
//            int numOfCaches = Integer.parseInt(endPointString[1]);
//
//            currentEndpointId++;
//            endPoints.add(new EndPoint(currentEndpointId, latencyToDT, numOfCaches));
//
//            if(currentEndpointId < rules.getEndPoints())
//                nextEndpoint = numOfCaches + currentLine;
//        }
//
//        else if(currentLine > 2 && currentLine < nextEndpoint)
//        {
//            String[] cacheString = file.split(" ");
//            int cacheId = Integer.parseInt(cacheString[0]);
//            int latency = Integer.parseInt(cacheString[1]);
//            endPoints.get(currentEndpointId - 1).addToCacheLatency(cacheId, latency);
//        }


//        else if(currentLine > 2 && currentLine == nextEndpoint)
//        {
//            String[] endPointString = file.split(" ");
//            int latencyToDT = Integer.parseInt(endPointString[0]);
//            int numOfCaches = Integer.parseInt(endPointString[1]);
//
//            endPoints.add(new EndPoint(currentEndpointId, latencyToDT, numOfCaches));
//            currentEndpointId++;
//
//            if(currentEndpointId < rules.getEndPoints())
//                nextEndpoint = numOfCaches + currentLine;
//        }

        currentLine++;
    }


    public Rules getRules(File file) throws IOException {
        Optional<String> opt = Files.lines(file.toPath()).findFirst();
        String rulesString = opt.get();

        String[] rules = rulesString.split(" ");
        int videos = Integer.parseInt(rules[0]);
        int endPoints = Integer.parseInt(rules[1]);
        int requestDesc = Integer.parseInt(rules[2]);
        int caches = Integer.parseInt(rules[3]);
        int cacheSize = Integer.parseInt(rules[4]);

        return new Rules(videos, endPoints, requestDesc, caches, cacheSize);
    }

    public List<Video> getVideos(){
        return  videos;
    }
    public List<Cache> getCache(){
        return caches;
    }


    public List<EndPoint> getEndpoints(){
        return endPoints;
    }
}
