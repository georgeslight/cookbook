package de.htwberlin.persistence;

import de.htwberlin.api.Ingredient;

import javax.persistence.*;
import java.util.List;
import java.util.Set;


@Entity(name = "recipe")
public class RecipeEntity {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name ="id")
    private long id;
    @Column(name ="title")
    private String title;
    @Column (name ="image")
    private String image;
    @Column (name = "likes")
    private int likes;
    @Column (name = "summary")
    private String summary;

    //private List<Ingredient> extendedIngredients;

    public RecipeEntity(String title, String image, int likes, String summary) {
        this.title = title;
        this.image = image;
        this.likes = likes;
        this.summary = summary;
    }

    public RecipeEntity() {
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

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

//    public List<Ingredient> getExtendedIngredients() {
//        return extendedIngredients;
//    }
//
//    public void setExtendedIngredients(List<Ingredient> extendedIngredients) {
//        this.extendedIngredients = extendedIngredients;
//    }
}
