package de.htwberlin.api;

import java.util.List;

public class Ingredient {

    private long id;
    private double amount;
    private String unit;
    private String name;
    private String image;
    private boolean vegetarian;
    private boolean vegan;

    public Ingredient(long id, String name, boolean vegetarian, boolean vegan) {
        this.id = id;
        this.name = name;
        this.vegetarian = vegetarian;
        this. vegan = vegan;
    };

    public Ingredient() {};

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

    @Override
    public String toString() {
        return "Ingredient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

//    private long id;
//    private String ingName;
//    private boolean vegetarian;
//    private boolean vegan;
//
//    public Ingredient(long id, String ingName, boolean vegetarian, boolean vegan) {
//        this.id = id;
//        this.ingName = ingName;
//        this.vegan = vegan;
//        this.vegetarian = vegetarian;
//    }
//
//    public long getId() {
//        return id;
//    }
//
//    public String getIngName() {
//        return ingName;
//    }
//
//    public void setIngName(String ingName) {
//        this.ingName = ingName;
//    }
//
//    public boolean isVegetarian() {
//        return vegetarian;
//    }
//
//    public void setVegetarian(boolean vegetarian) {
//        this.vegetarian = vegetarian;
//    }
//
//    public boolean isVegan() {
//        return vegan;
//    }
//
//    public void setVegan(boolean vegan) {
//        this.vegan = vegan;
//    }
}

