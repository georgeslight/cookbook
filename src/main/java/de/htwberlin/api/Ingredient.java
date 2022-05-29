package de.htwberlin.api;

import java.util.List;

public class Ingredient {

    private long id;
    private double amount;
    private String unit;
    private String unitLong;
    private String unitShort;
    private String aisle;
    private String name;
    private String original;
    private String originalName;
    private List<String> meta;
    private String image;

    public Ingredient(long id, String name) {
        this.id = id;
        this.name = name;
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

    public String getUnitLong() {
        return unitLong;
    }

    public void setUnitLong(String unitLong) {
        this.unitLong = unitLong;
    }

    public String getUnitShort() {
        return unitShort;
    }

    public void setUnitShort(String unitShort) {
        this.unitShort = unitShort;
    }

    public String getAisle() {
        return aisle;
    }

    public void setAisle(String aisle) {
        this.aisle = aisle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }

    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }

    public List<String> getMeta() {
        return meta;
    }

    public void setMeta(List<String> meta) {
        this.meta = meta;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

