package de.htwberlin.persistence;

import de.htwberlin.API.Amount;

import javax.persistence.*;

@Entity
public class AmountEntity {

    @EmbeddedId
    Amount id;

    @ManyToOne
    @MapsId("ingredientId")
    @JoinColumn(name = "ingredient_id")
    IngredientEntity ingredient;

    @ManyToOne
    @MapsId("recipeId")
    @JoinColumn(name = "recipe_id")
    RecipeEntity recipe;

    int amount;
    String units;

    public AmountEntity() {

    }


    public Amount getId() {
        return id;
    }

    public void setId(Amount id) {
        this.id = id;
    }

    public IngredientEntity getIngredient() {
        return ingredient;
    }

    public void setIngredient(IngredientEntity ingredient) {
        this.ingredient = ingredient;
    }

    public RecipeEntity getRecipe() {
        return recipe;
    }

    public void setRecipe(RecipeEntity recipe) {
        this.recipe = recipe;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
