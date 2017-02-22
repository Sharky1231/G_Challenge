import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;

public class Main {

    static int row;
    static int col;
    static int minIngredient;
    static int maxCellsPerSliece;
    static int maxLineSize;
    static int maxRectangularSize;
    static ArrayList<Slice> slices = new ArrayList<>();
    static int currentRow = 0;

    static Pizza pizza;

    static boolean isFirstLine = true;

    public static void main(String[] args) throws IOException {

        File f = new File("D:\\Downloads\\example.in");

        // Load a file with rules and make pizza
        Files.lines(f.toPath()).forEach(Main::parseFile);

        // Print out pizza
        System.out.println(row + " " + col + " " + minIngredient + " " + maxCellsPerSliece);
        System.out.println(pizza.toString());

        // Make a slice and print pizza
        Slice s = pizza.makeCut(0, 0, 2, 1);
        System.out.println(s.containsEachIngredient(1));
        System.out.println(pizza.toString());


        cutPizza(0, 0, maxRectangularSize, maxRectangularSize, maxLineSize);
        System.out.println(pizza.toString());
    }

    public static void cutPizza(int startRow, int startCol, int endRow, int maxRectangularSize, int maxLineSize){

        int rectSize = maxRectangularSize / 2;
        int lineSize = maxLineSize;

        if(rectSize > 0 && rectCut(startRow, startCol, rectSize)){
            if(startRow + rectSize < pizza.getHeight())
            {
                cutPizza(startRow + rectSize, startCol, endRow + rectSize, maxRectangularSize, maxLineSize);
            }

            else{
                cutPizza(startRow + rectSize, startCol, endRow + rectSize, rectSize, maxLineSize);
            }
        }

        if(maxLineSize > 0 && lineDownCut(startRow, startCol, maxLineSize)){
            if(!lineDownCut(startRow, startCol + 1, maxLineSize))
            {
                lineDownCut(startRow, startCol + 1, maxLineSize-1);
            }
        }
    }

    public static boolean rectCut(int startRow, int startCol, int rectSize){
        Slice slice = pizza.makeCut(startRow, startCol, startRow + rectSize, startCol + rectSize);

        return slice != null;
    }

    public static boolean lineDownCut(int startRow, int startCol, int size){
        Slice slice = pizza.makeCut(startRow, startCol, startRow + size, startCol);

        return slice != null;
    }


    public static void parseFile(String line) {
        if (isFirstLine) {
            isFirstLine = false;
            String[] rules = line.split(" ");
            row = Integer.parseInt(rules[0]);
            col = Integer.parseInt(rules[1]);
            minIngredient = Integer.parseInt(rules[2]);
            maxCellsPerSliece = Integer.parseInt(rules[3]);

            maxLineSize = maxCellsPerSliece;

            if (isEven(maxCellsPerSliece)) {
                maxRectangularSize = maxCellsPerSliece;
            } else maxRectangularSize = maxCellsPerSliece - 1;

            pizza = new Pizza(row, col, minIngredient);
        } else {
            String[] letters = line.split("");

            for (int i = 0; i < letters.length; i++) {
                Ingredient ingredient = pizza.getIngredient(letters[i]);
                pizza.insertIngredient(currentRow, i, ingredient);
            }
            currentRow++;
        }
    }

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }
}
