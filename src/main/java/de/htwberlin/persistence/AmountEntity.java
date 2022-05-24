package de.htwberlin.persistence;


import javax.persistence.*;

@Entity(name="amount")
public class AmountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "ingredient_id", referencedColumnName = "id")
    private IngredientEntity ingredient;

    @ManyToOne
    @JoinColumn(name = "recipe_id", referencedColumnName = "id")
    private RecipeEntity recipe;

    int amount;
    String units;

    public AmountEntity() {

    }

    public long getId() {
        return id;
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
