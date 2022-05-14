package de.htwberlin.api;


import de.htwberlin.api.Ingredient;
import de.htwberlin.api.Recipe;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RecipeRestController {

    private List<Recipe> recipe;
    private List<Ingredient> ingredients;
    private List<Ingredient> ingredients2;

    public RecipeRestController() {
        recipe = new ArrayList<>();
        ingredients = new ArrayList<>();
        ingredients2 = new ArrayList<>();

        ingredients.add(new Ingredient(1, "Tomate", true, true));
        ingredients.add(new Ingredient(2, "Mozarella", true, false));

        ingredients2.add(new Ingredient(2, "Mozarella", true, false));
        ingredients2.add(new Ingredient(3, "Lachs", false, false));

        recipe.add(new Recipe(1, "Caprese", (ArrayList<Ingredient>) ingredients));
        recipe.add(new Recipe(2, "überbackener Fisch", (ArrayList<Ingredient>) ingredients2));


    }

    @GetMapping(path = "/api/v1/Recipe")
    public ResponseEntity<List<Recipe>> fetchRecipes() {
        return ResponseEntity.ok(recipe);
    }

}
