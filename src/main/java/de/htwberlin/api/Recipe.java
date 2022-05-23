package de.htwberlin.api;

import java.util.ArrayList;
import java.util.List;

public class Recipe {


    private List<Ingredient> ingredients;
    private String recipeName;
    private long id;

    public Recipe(long id, String recipeName, ArrayList<Ingredient> ing) {
        this.id = id;
        this.recipeName = recipeName;
        this.ingredients = ing;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}