package de.htwberlin.persistence;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "recipes")
public class RecipeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name ="id")
    private Long id;

    @Column(name ="title")
    private String title;

    @Column (name = "summary", columnDefinition = "text")
    private String summary;

    @Column (name ="image")
    private String image;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "recipe_ingredients", joinColumns = @JoinColumn(name = "recipe_id"), inverseJoinColumns = @JoinColumn(name = "ingredient_id"))
    private Set<IngredientEntity> ingredients;

    @OneToMany(mappedBy = "recipe", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private Set<StepEntity> steps = new HashSet<>();


    public RecipeEntity(String title, String summary, String image) {
        this.title = title;
        this.summary = summary;
        this.image = image;
    }

    public RecipeEntity() {
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Set<IngredientEntity> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<IngredientEntity> ingredients) {
        this.ingredients = ingredients;
    }

    public Set<StepEntity> getSteps() {
        return steps;
    }

    public void setSteps(Set<StepEntity> steps) {
        this.steps = steps;
    }
}
