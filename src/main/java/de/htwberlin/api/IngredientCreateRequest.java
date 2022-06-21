package de.htwberlin.api;

public class IngredientCreateRequest {
    private long id;
    private String ingName;
    private boolean vegetarian;
    private boolean vegan;

    public IngredientCreateRequest(String ingName, boolean vegetarian, boolean vegan) {
        this.ingName = ingName;
        this.vegetarian = vegetarian;
        this.vegan = vegan;
    }

    public IngredientCreateRequest(){}

    public String getIngName() {
        return ingName;
    }

    public void setIngName(String ingName) {
        this.ingName = ingName;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public void setVegetarian(boolean vegetarian) {
        this.vegetarian = vegetarian;
    }

    public boolean isVegan() {
        return vegan;
    }

    public void setVegan(boolean vegan) {
        this.vegan = vegan;
    }
}
