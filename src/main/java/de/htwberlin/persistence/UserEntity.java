//package de.htwberlin.persistence;
//
//
//import javax.persistence.*;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Stellt Tabelle und Spalten der Klasse Ingredient in der Datenbank her.
// */
//@Entity(name = "userlikes")
//public class UserEntity {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
//    private long id;
//
//    @Column (name = "recipeId",nullable = false )
//    private long recipeId;
//
//    public UserEntity( long recipeId) {
//        this.recipeId = recipeId;
//    }
//
//
//    @OneToMany(mappedBy = "user" ,fetch = FetchType.EAGER)
//        private List<RecipeEntity> recipes = new ArrayList<>();
//
//    protected UserEntity() {
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
//    public long getRecipeId() {
//        return recipeId;
//    }
//
//    public void setRecipeId(long recipeId) {
//        this.recipeId = recipeId;
//    }
//
//    public List<RecipeEntity> getRecipes() {
//        return recipes;
//    }
//
//    public void setRecipes(List<RecipeEntity> recipes) {
//        this.recipes = recipes;
//    }
//}
