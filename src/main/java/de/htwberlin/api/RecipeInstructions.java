package de.htwberlin.api;

import java.util.List;

public class RecipeInstructions {

    private String name;
    private List<Steps> steps;

    public RecipeInstructions(String name, List<Steps> steps) {
        this.name = name;
        this.steps = steps;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Steps> getSteps() {
        return steps;
    }

    public void setSteps(List<Steps> steps) {
        this.steps = steps;
    }
}
