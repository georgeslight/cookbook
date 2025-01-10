package de.htwberlin.web.api;

import java.util.Set;

public class RecipeManipulationRequest {

    private String name;
    private String image;
    private String summary;
    private Set<Step> steps;
    private Set<Ingredient> ingredients;
    private boolean liked;

    public RecipeManipulationRequest(String name, String image, String summary, Set<Step> steps, Set<Ingredient> ingredients, boolean liked) {
        this.name = name;
        this.image = image;
        this.summary = summary;
        this.steps = steps;
        this.ingredients = ingredients;
        this.liked = liked;
    }

    public RecipeManipulationRequest() {
    }

    public boolean isLiked() {
        return liked;
    }

    public void setLiked(boolean liked) {
        this.liked = liked;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Set<Step> getSteps() {
        return steps;
    }

    public void setSteps(Set<Step> steps) {
        this.steps = steps;
    }

    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
}
