package hashcode2017;


import hashcode2017.model.Cache;
import hashcode2017.model.EndPoint;
import hashcode2017.model.Video;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {


    public static void main(String[] args) throws IOException {
        Network network = new Network("me_at_the_zoo");

        // Rank videos
        network.getVideos().forEach(Video::setRank);

        // Sortedranked videos
        network.getVideos().sort((lhs, rhs) -> {
            // -1 - less than, 1 - greater than, 0 - equal, all inversed for descending
            return lhs.getRank() > rhs.getRank() ? -1 : (lhs.getRank() < rhs.getRank()) ? 1 : 0;
        });

//         Sorted local cache latencies
//        for(EndPoint endPoint: network.getEndpoints()){
//            endPoint.getCacheLatencies().sort((lhs, rhs) -> {
//                // -1 - less than, 1 - greater than, 0 - equal, all inversed for descending
//                return lhs.getLatency() > rhs.getLatency() ? -1 : (lhs.getLatency() < rhs.getLatency()) ? 1 : 0;
//            });
//        }

        network.getCache().sort((lhs, rhs) -> {
            // -1 - less than, 1 - greater than, 0 - equal, all inversed for descending
            return lhs.getLatency() > rhs.getLatency() ? -1 : (lhs.getLatency() < rhs.getLatency()) ? 1 : 0;
        });

        int cacheIndex = -1;

        List<Cache> caches = network.getCache();

        for(Video video: network.getVideos()){
            if(cacheIndex == -1){
                System.out.print("\n");
                cacheIndex++;
            }

            if(cacheIndex < caches.size()) {
                Cache currentCache = caches.get(cacheIndex);
                if (currentCache.getCasheSize() > video.getVideoSize()) {
                    caches.get(cacheIndex).setCasheSize(currentCache.getCasheSize() - video.getVideoSize());
                    System.out.print(video.getVideoID() + " ");
                } else {
                    cacheIndex++;
                    if (cacheIndex < caches.size() && caches.get(cacheIndex).getCasheSize() > video.getVideoSize()) {
                        caches.get(cacheIndex).setCasheSize(currentCache.getCasheSize() - video.getVideoSize());
                    }

                    System.out.print("\n" + currentCache.getCasheID() + " ");
                    System.out.print(video.getVideoID() + " ");
                }
            }
        }







        System.out.println();
    }
}
