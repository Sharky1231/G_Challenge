package pizza;

import java.util.ArrayList;

/**
 * Created by Sharky on 20/02/2017.
 */
public class Slice {
    int startRow;
    int startCol;
    int endRow;
    int endCol;
    ArrayList<Ingredient> ingredients;

    public Slice(int startRow, int startCol, int endRow, int endCol) {
        this.startRow = startRow;
        this.startCol = startCol;
        this.endRow = endRow;
        this.endCol = endCol;
        ingredients = new ArrayList<>();
    }

    public boolean containsEachIngredient(int minimum){
        return containIngredients(minimum, Ingredient.T) && containIngredients(minimum, Ingredient.M);
    }

    private boolean containIngredients(int numberOf, Ingredient ingredientType) {
        int number = 0;
        for (Ingredient ingredient : ingredients)
            if (ingredient == ingredientType)
                number++;

        return number >= numberOf;
    }


    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public int getStartRow() {
        return startRow;
    }

    public void setStartRow(int startRow) {
        this.startRow = startRow;
    }

    public int getStartCol() {
        return startCol;
    }

    public void setStartCol(int startCol) {
        this.startCol = startCol;
    }

    public int getEndRow() {
        return endRow;
    }

    public void setEndRow(int endRow) {
        this.endRow = endRow;
    }

    public int getEndCol() {
        return endCol;
    }

    public void setEndCol(int endCol) {
        this.endCol = endCol;
    }

    public void addIngredient(Ingredient ing) {
        ingredients.add(ing);
    }
}
