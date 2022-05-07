package de.htwberlin.API;

public class Ingredient {
    private long id;
    private String ingName;
    private boolean vegetarian;
    private boolean vegan;

    public Ingredient(long id, String ingName, boolean vegetarian, boolean vegan) {
        this.id = id;
        this.ingName = ingName;
        this.vegan = vegan;
        this.vegetarian = vegetarian;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

