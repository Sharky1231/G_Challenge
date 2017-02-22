/**
 * Created by Sharky on 20/02/2017.
 */
public class Pizza {
    Ingredient[][] grid;
    int minimumIngredients;

    public Pizza(int rows, int cols, int minimumIngrediences) {
        grid = new Ingredient[rows][cols];
        minimumIngredients = minimumIngrediences;
    }

    public void insertIngredient(int row, int col, Ingredient ingredient) {
        grid[row][col] = ingredient;
    }

    public Slice makeCut(int rowStart, int colStart, int rowEnd, int colEnd){
        Slice slice = new Slice(rowStart, colStart, rowEnd, colEnd);

        if(!isWithinAGrid(slice))
            return null;

        if(!isValidSlice(slice))
            return null;

        if(!slice.containsEachIngredient(minimumIngredients))
            return null;

        markSliceOnPizza(slice);
        return slice;
    }

    public boolean isValidSlice(Slice slice) {
        for (int r = slice.startRow; r < slice.endRow + 1; r++) {
            for (int c = slice.startCol; c < slice.endCol + 1; c++) {
                Ingredient ingredient = grid[r][c];
                slice.addIngredient(ingredient);
                if(ingredient == Ingredient.O)
                    return false;
            }
        }

        return true;
    }

    public void markSliceOnPizza(Slice slice) {
        // Mark "cut parts" with 'O' ingredient
        for (int r = slice.startRow; r < slice.endRow + 1; r++) {
            for (int c = slice.startCol; c < slice.endCol + 1; c++) {
                grid[r][c] = Ingredient.O;
            }
        }
    }


    public Ingredient getIngredient(String stringIngredient) {
        if (stringIngredient.equals("T"))
            return Ingredient.T;

        else return Ingredient.M;
    }

    public String toString() {
        String s = "";
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                s += grid[r][c] + " ";
            }

            s += "\n";
        }

        return s;
    }

    public int getWidth(){
        return grid[0].length;
    }

    public int getHeight(){
        return grid.length;
    }

    public boolean isWithinAGrid(Slice slice){
        return slice.endRow < grid.length && slice.endCol < grid[0].length;
    }
}
