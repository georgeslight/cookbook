package de.htwberlin.persistence;

import de.htwberlin.web.api.Step;

import javax.persistence.*;

@Entity(name = "steps")
public class StepEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "number")
    private Long number;

    @Column(name = "step", columnDefinition = "text")
    private String step;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "recipe_id", referencedColumnName = "id")
    private RecipeEntity recipe;

    public StepEntity() {
    }

    public StepEntity(Long number, String step, RecipeEntity recipe) {
        this.number = number;
        this.step = step;
        this.recipe = recipe;
    }

    public Long getId() {
        return id;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public String getStep() {
        return step;
    }

    public void setStep(String step) {
        this.step = step;
    }

    public RecipeEntity getRecipe() {
        return recipe;
    }

    public void setRecipe(RecipeEntity recipe) {
        this.recipe = recipe;
    }

    public static Step transformEntity(StepEntity stepEntity) {
        return new Step(
                stepEntity.getId(),
                stepEntity.getNumber(),
                stepEntity.getStep()
        );
    }
}
