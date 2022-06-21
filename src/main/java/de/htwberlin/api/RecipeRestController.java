package de.htwberlin.api;

import de.htwberlin.services.RecipeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
public class RecipeRestController {

    private final RecipeService recipeService;

    public RecipeRestController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping(path = "/api/v1/recipe")
    public ResponseEntity<List<Recipe>> fetchRecipes() {
        return ResponseEntity.ok(recipeService.findAll());
    }

    @GetMapping(value = "/recipeByIngredients/{ingredients}")
    public Flux<Recipe> findByIngredientName(@PathVariable("ingredients") List<String> ingredients) {
        return recipeService.getRecipe(ingredients);
    }

    @GetMapping(value = "/recipeInformation/{id}")
    public Mono<Recipe> getRecipeInformation(@PathVariable("id") long id) {
        return recipeService.getRecipeInformation(id);
    }

    @GetMapping(value="/randomRecipe/{number}")
    public Flux<Recipe> getRandomRecipe(@PathVariable("number") long number) {
        return recipeService.getRandomRecipe(number);
    }
}
