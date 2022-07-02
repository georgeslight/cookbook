package de.htwberlin.web.api;

import java.util.List;
import java.util.Set;

public class RecipeManipulationRequest {

    private String title;
    private String name;
    private String image;
    private Integer likes;
    private String summary;
    private Set<Step> steps;
    private Set<Ingredient> extendedIngredients;

    public RecipeManipulationRequest(String title/*, String name*/, String image/*, Integer likes*/, String summary, Set<Step> steps, Set<Ingredient> extendedIngredients) {
        this.title = title;
//        this.name = name;
        this.image = image;
//        this.likes = likes;
        this.summary = summary;
        this.steps = steps;
        this.extendedIngredients = extendedIngredients;
    }

    public RecipeManipulationRequest() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
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

    public Set<Ingredient> getExtendedIngredients() {
        return extendedIngredients;
    }

    public void setExtendedIngredients(Set<Ingredient> extendedIngredients) {
        this.extendedIngredients = extendedIngredients;
    }
}
