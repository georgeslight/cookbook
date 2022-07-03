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

    @Column(name = "name", nullable = false, columnDefinition = "text")
    private String name;

    @Column(name = "amount")
    private double amount;

    @Column(name = "unit")
    private String unit;

    @ManyToMany(mappedBy = "ingredients")
    private Set<RecipeEntity> recipes;

    public IngredientEntity(String name, double amount, String unit) {
        this.name = name;
        this.amount = amount;
        this.unit = unit;
    }

    public IngredientEntity(String name) {
        this.name = name;
    }

    protected IngredientEntity() {
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Set<RecipeEntity> getRecipes() {
        return recipes;
    }

    public void setRecipes(Set<RecipeEntity> recipes) {
        this.recipes = recipes;
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
                ingredientEntity.getName(),
                ingredientEntity.getAmount(),
                ingredientEntity.getUnit());
    }
}
