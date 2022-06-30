package de.htwberlin.api;

import java.util.Arrays;
import java.util.List;

public class RecipeManipulationRequest {

    private String title;
    private String image;
    private int likes;
    private String summary;
    private List<Ingredient> extendedIngredients;

    public RecipeManipulationRequest(long id, String title, List<Ingredient> ingredients) {
        this.title = title;
        this.extendedIngredients = ingredients;
    }

    public RecipeManipulationRequest() {}

    public List<Ingredient> getExtendedIngredients() {
        return extendedIngredients;
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

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
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
