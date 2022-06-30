package de.htwberlin.persistence;

import javax.persistence.*;

public class likedAmountEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "userlikes_id", referencedColumnName = "id")
    private UserLikesEntity userLikes;

    @ManyToOne
    @JoinColumn(name = "recipe_id", referencedColumnName = "id")
    private RecipeEntity recipe;


    public likedAmountEntity() {

    }

    public long getId() {
        return id;
    }

    public UserLikesEntity getUserLikes() {
        return userLikes;
    }

    public void setUserLikes(UserLikesEntity userLikes) {
        this.userLikes = userLikes;
    }

    public RecipeEntity getRecipe() {
        return recipe;
    }

    public void setRecipe(RecipeEntity recipe) {
        this.recipe = recipe;
    }

}
