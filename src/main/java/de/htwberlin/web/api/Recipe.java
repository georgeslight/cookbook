package de.htwberlin.web.api;

import de.htwberlin.persistence.IngredientEntity;
import de.htwberlin.persistence.RecipeEntity;
import de.htwberlin.persistence.StepEntity;

import java.util.Set;
import java.util.stream.Collectors;

public class Recipe {

    private long id;
    private String name;
    private String image;
    private String summary;
    private Set<Ingredient> ingredients;
    private Set<Step> steps;
    private boolean liked;

    public Recipe(long id, String name, String image, String summary, Set<Step> steps, Set<Ingredient> ingredients, boolean liked) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.summary = summary;
        this.steps = steps;
        this.ingredients = ingredients;
        this.liked = liked;

    }

    public Recipe(RecipeEntity recipeEntity) {
        this.id = recipeEntity.getId();
        this.name = recipeEntity.getName();
        this.image = recipeEntity.getImage();
        this.summary = recipeEntity.getSummary();
        this.ingredients = recipeEntity.getIngredients()
                .stream().
                map(IngredientEntity::transformEntity)
                .collect(Collectors.toSet());
        this.steps = recipeEntity.getSteps()
                .stream()
                .map(StepEntity::transformEntity)
                .collect(Collectors.toSet());
        this.liked = recipeEntity.getLiked();
    }

    public boolean isLiked() {
        return liked;
    }

    public void setLiked(boolean liked) {
        this.liked = liked;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public Set<Step> getSteps() {
        return steps;
    }

    public void setSteps(Set<Step> steps) {
        this.steps = steps;
    }

    //    private Long id;
//    private String title;
//    private String name;
//    private String image;
//    private Integer likes;
//    private String summary;
//    private Set<Step> steps;
//    private Set<Ingredient> extendedIngredients;
//
//    public Recipe(Long id, String title, String name, String image, Integer likes, String summary, Set<Step> steps, Set<Ingredient> extendedIngredients) {
//        this.id = id;
//        this.title = title;
//        this.name = name;
//        this.image = image;
//        this.likes = likes;
//        this.summary = summary;
//        this.steps = steps;
//        this.extendedIngredients = extendedIngredients;
//    }
//
//    public Recipe(Long id, String title, String image, String summary, Set<Step> steps, Set<Ingredient> extendedIngredients) {
//        this.id = id;
//        this.title = title;
//        this.image = image;
//        this.summary = summary;
//        this.steps = steps;
//        this.extendedIngredients = extendedIngredients;
//    }
//
//    public Recipe() {
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getImage() {
//        return image;
//    }
//
//    public void setImage(String image) {
//        this.image = image;
//    }
//
//    public Integer getLikes() {
//        return likes;
//    }
//
//    public void setLikes(Integer likes) {
//        this.likes = likes;
//    }
//
//    public String getSummary() {
//        return summary;
//    }
//
//    public void setSummary(String summary) {
//        this.summary = summary;
//    }
//
//    public Set<Step> getSteps() {
//        return steps;
//    }
//
//    public void setSteps(Set<Step> steps) {
//        this.steps = steps;
//    }
//
//    public Set<Ingredient> getExtendedIngredients() {
//        return extendedIngredients;
//    }
//
//    public void setExtendedIngredients(Set<Ingredient> extendedIngredients) {
//        this.extendedIngredients = extendedIngredients;
//    }
}
