package de.htwberlin.api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Recipe {

    private long id;
    private String title;
    private String image;
    private String imageType;
    private int usedIngredientCount;
    private int missedIngredientCount;
    private Ingredient[] missedIngredients;
    private Ingredient[] usedIngredients;
    private Ingredient[] unusedIngredients;
    private int likes;
    private List<Ingredient> ingredients;

    public Recipe(long id, String title, List<Ingredient> ingredients) {
        this.id = id;
        this.title = title;
        this.ingredients = ingredients;
    };

    public Recipe() {};

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImageType() {
        return imageType;
    }

    public void setImageType(String imageType) {
        this.imageType = imageType;
    }

    public int getUsedIngredientCount() {
        return usedIngredientCount;
    }

    public void setUsedIngredientCount(int usedIngredientCount) {
        this.usedIngredientCount = usedIngredientCount;
    }

    public int getMissedIngredientCount() {
        return missedIngredientCount;
    }

    public void setMissedIngredientCount(int missedIngredientCount) {
        this.missedIngredientCount = missedIngredientCount;
    }

    public Ingredient[] getMissedIngredients() {
        return missedIngredients;
    }

    public void setMissedIngredients(Ingredient[] missedIngredients) {
        this.missedIngredients = missedIngredients;
    }

    public Ingredient[] getUsedIngredients() {
        return usedIngredients;
    }

    public void setUsedIngredients(Ingredient[] usedIngredients) {
        this.usedIngredients = usedIngredients;
    }

    public Ingredient[] getUnusedIngredients() {
        return unusedIngredients;
    }

    public void setUnusedIngredients(Ingredient[] unusedIngredients) {
        this.unusedIngredients = unusedIngredients;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", missedIngredients=" + Arrays.toString(missedIngredients) +
                ", usedIngredients=" + Arrays.toString(usedIngredients) +
                ", unusedIngredients=" + Arrays.toString(unusedIngredients) +
                '}';
    }

//    private List<Ingredient> ingredients;
//    private String recipeName;
//    private long id;
//
//    public Recipe(long id, String recipeName, ArrayList<Ingredient> ing) {
//        this.id = id;
//        this.recipeName = recipeName;
//        this.ingredients = ing;
//    }
//
//    public List<Ingredient> getIngredients() {
//        return ingredients;
//    }
//
//    public void setIngredients(List<Ingredient> ingredients) {
//        this.ingredients = ingredients;
//    }
//
//    public String getRecipeName() {
//        return recipeName;
//    }
//
//    public void setRecipeName(String recipeName) {
//        this.recipeName = recipeName;
//    }
//
//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
}