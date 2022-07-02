package de.htwberlin.persistence;

import de.htwberlin.web.api.Ingredient;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "ingredients")
public class IngredientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToMany(mappedBy = "ingredients")
    private Set<RecipeEntity> recipes;

    public IngredientEntity(String name) {
        this.name = name;
    }

    protected IngredientEntity() {
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static Ingredient transformEntity(IngredientEntity ingredientEntity) {
        return new Ingredient(
                ingredientEntity.getId(),
                ingredientEntity.getName());
    }
}
