package de.htwberlin.web.api;

public class Step {

    private Long id;
    private Long number;
    private String step;
//    private Set<Ingredient> ingredients;

    public Step(Long id,Long number, String step/*, Set<Ingredient> ingredients*/) {
        this.id = id;
        this.number = number;
        this.step = step;
//        this.ingredients = ingredients;
    }

    public Step() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNumber(Long number) {
        this.number = number;
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

//    public Set<Ingredient> getIngredients() {
//        return ingredients;
//    }
//
//    public void setIngredients(Set<Ingredient> ingredients) {
//        this.ingredients = ingredients;
//    }
}
