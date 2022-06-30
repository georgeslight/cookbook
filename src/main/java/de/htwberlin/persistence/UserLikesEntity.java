package de.htwberlin.persistence;


import javax.persistence.*;
import java.util.Set;

/**
 * Stellt Tabelle und Spalten der Klasse Ingredient in der Datenbank her.
 */
@Entity(name = "userlikes")
public class UserLikesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column (name = "recipe",nullable = false )
    private String recipe;

    @Column (name = "likes",nullable = false )
    private boolean likes;

    public UserLikesEntity(String recipe, boolean likes) {
        this.recipe = recipe;
        this.likes = likes;
    }
    protected UserLikesEntity() {
    }

    public long getId() {
        return id;
    }

    public String getRecipe() {
        return recipe;
    }

    public void setRecipe(String recipe) {
        this.recipe = recipe;
    }

    public boolean getLikes() {
        return likes;
    }

    public void setLikes(boolean likes) {
        this.likes = likes;
    }
}
