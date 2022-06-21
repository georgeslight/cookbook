package de.htwberlin.api;

import java.util.Arrays;
import java.util.List;

public class Recipe {

    private long id;
    private String title;
    private String image;
    private Ingredient[] missedIngredients;
    private Ingredient[] usedIngredients;
    private Ingredient[] unusedIngredients;
    private int likes;
    private int aggregateLikes;
    private boolean vegan;
    private boolean vegetarian;
    private String summary;
    private List<Ingredient> extendedIngredients;
    private int servings;
    private int readyInMinutes;
    private String[] dishTypes;

    public Recipe(long id, String title, List<Ingredient> ingredients) {
        this.id = id;
        this.title = title;
        this.extendedIngredients = ingredients;
    }

    public Recipe() {}

    public List<Ingredient> getExtendedIngredients() {
        return extendedIngredients;
    }

    public int getAggregateLikes() {
        return aggregateLikes;
    }

    public void setAggregateLikes(int aggregateLikes) {
        this.aggregateLikes = aggregateLikes;
    }

    public int getServings() {
        return servings;
    }

    public void setServings(int servings) {
        this.servings = servings;
    }

    public int getReadyInMinutes() {
        return readyInMinutes;
    }

    public void setReadyInMinutes(int readyInMinutes) {
        this.readyInMinutes = readyInMinutes;
    }

    public String[] getDishTypes() {
        return dishTypes;
    }

    public void setDishTypes(String[] dishTypes) {
        this.dishTypes = dishTypes;
    }

    public boolean isVegan() {
        return vegan;
    }

    public void setVegan(boolean vegan) {
        this.vegan = vegan;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public void setVegetarian(boolean vegetarian) {
        this.vegetarian = vegetarian;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setExtendedIngredients(List<Ingredient> extendedIngredients) {
        this.extendedIngredients = extendedIngredients;
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
