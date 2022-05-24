package de.htwberlin.persistence;

import javax.persistence.*;
import java.util.Set;


@Entity(name = "recipe")
public class RecipeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "recipeName", nullable = false)
    private String recipeName;


    @OneToMany(mappedBy = "recipe")
    Set<AmountEntity> amount;


    public RecipeEntity(long id, String recipeName) {
        this.id = id;
        this.recipeName = recipeName;
    }

    protected RecipeEntity() {
    }

    public long getId() {
        return id;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public Set<AmountEntity> getAmount() {
        return amount;
    }
}
