package de.htwberlin.api;

import java.util.List;

public class Steps {

    private long number;
    private String step;
    private List<Ingredient> ingredients;

    public Steps(long number, String step, List<Ingredient> ingredients) {
        this.number = number;
        this.step = step;
        this.ingredients = ingredients;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public String getStep() {
        return step;
    }

    public void setStep(String step) {
        this.step = step;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
}
