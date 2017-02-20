import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Main {

    static int row;
    static int col;
    static int minIngredient;
    static int maxCellsPerSliece;
    static int currentRow = 0;

    static String[][] pizza;

    static boolean isFirstLine = true;

    public static void main(String[] args) throws IOException {

        File f = new File("D:\\Downloads\\example.in");

        Files.lines(f.toPath()).forEach(Main::parse);


        System.out.println();
    }


    public static void parse(String line) {
        if (isFirstLine) {
            isFirstLine = false;
            String[] rules = line.split(" ");
            row = Integer.parseInt(rules[0]);
            col = Integer.parseInt(rules[1]);
            minIngredient = Integer.parseInt(rules[2]);
            maxCellsPerSliece = Integer.parseInt(rules[3]);

            pizza = new String[row][col];
        }

        else{
            String[] letters = line.split("");

            for(int i = 0; i < letters.length; i++){
                pizza[currentRow][i] = letters[i];
            }
            currentRow++;
        }
    }
}
