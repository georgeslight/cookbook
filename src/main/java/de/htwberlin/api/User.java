//package de.htwberlin.api;
//
//import javax.persistence.Id;
//import java.util.List;
//
//public class User {
//
//    private long id;
//    private List<Recipe> recipes;
//    private long recipeId;
//
//
//
//    public User(long id,long recipeId) {
//        this.id = id;
//        this.recipeId = recipeId;
//    }
//    public User(){};
//
//    public long getRecipeId() {
//        return recipeId;
//    }
//
//    public void setRecipeId(long recipeId) {
//        this.recipeId = recipeId;
//    }
//
//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public List<Recipe> getRecipes() {
//        return recipes;
//    }
//
//    public void setRecipes(List<Recipe> recipes) {
//        this.recipes = recipes;
//    }
//    @Override
//    public String toString() {
//        return "User{" +
//                "id=" + id +
//                '}';
//    }
//}
