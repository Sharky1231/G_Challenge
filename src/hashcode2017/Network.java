package hashcode2017;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;

/**
 * Created by Sharky on 23/02/2017.
 */
public class Network {
    Rules rules;


    public Network(String pathToFile) throws IOException {
        File file = new File("src\\inputFiles\\" + pathToFile + ".in");
        rules = getRules(file);
        createNetwork(file);
    }

    public void createNetwork(File file) throws IOException {
        Files.lines(file.toPath()).forEach(line -> parseLine(line));
    }

    public void parseLine(String file) {

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
}
