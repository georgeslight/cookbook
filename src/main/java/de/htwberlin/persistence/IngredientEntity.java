package de.htwberlin.persistence;

import javax.persistence.*;

@Entity(name = "ingredients")
public class IngredientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private long id;

    @Column(name ="ingName",nullable = false)
    private String ingName;

    @Column(name ="vegetarian",nullable = false)
    private boolean vegetarian;

    @Column(name ="vegan",nullable = false)
    private boolean vegan;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "recipe_id",referencedColumnName = "id")
    private RecipeEntity recipe;

    public IngredientEntity(long id, String ingName, boolean vegetarian, boolean vegan) {
        this.id = id;
        this.ingName = ingName;
        this.vegetarian = vegetarian;
        this.vegan = vegan;
    }

    protected IngredientEntity() {
    }

    public long getId() {
        return id;
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
