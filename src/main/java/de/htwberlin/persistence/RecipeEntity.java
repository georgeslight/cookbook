package de.htwberlin.persistence;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity(name = "recipes")
public class RecipeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "recipeName", nullable = false)
    private String recipeName;


    @OneToMany(mappedBy = "recipe", fetch = FetchType.EAGER)
    private List<IngredientEntity> ingredients = new ArrayList<>();


    public RecipeEntity(long id, String recipeName) {
        this.id = id;
        this.recipeName = recipeName;
    }

    protected RecipeEntity() {
    }

    public long getId() {
        return id;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public List<IngredientEntity> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<IngredientEntity> ingredients) {
        this.ingredients = ingredients;
    }


}
