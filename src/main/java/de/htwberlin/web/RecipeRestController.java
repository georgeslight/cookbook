package de.htwberlin.web;


import de.htwberlin.services.RecipeService;
import de.htwberlin.web.api.Recipe;
import de.htwberlin.web.api.RecipeManipulationRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
public class RecipeRestController {

    private final RecipeService recipeService;

    public RecipeRestController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

//    Database
    @GetMapping(path = "/api/v1/getRecipe/{id}")
    public ResponseEntity<Optional<Recipe>> findById(@PathVariable Long id) {
        return ResponseEntity.ok(recipeService.findById(id));
    }

    @GetMapping(path = "/api/v1/recipeByName/{name}")
    public ResponseEntity<List<Recipe>> recipeByName(@PathVariable String name) {
        return ResponseEntity.ok(recipeService.findAllByName(name));
    }

    @GetMapping(path = "/api/v1/likedRecipes/{liked}")
    public ResponseEntity<List<Recipe>> getLikedRecipes(@PathVariable Boolean liked) {
        return ResponseEntity.ok(recipeService.findAllByLiked(liked));
    }

    @GetMapping(path = "/api/v1/recipe")
    public ResponseEntity<List<Recipe>> fetchRecipes() {
        return ResponseEntity.ok(recipeService.findAll());
    }

    @PostMapping(path = "/api/v1/recipe")
    public ResponseEntity<Void> createRecipe(@RequestBody RecipeManipulationRequest request) throws URISyntaxException {
        var recipe = recipeService.create(request);
        URI uri = new URI("/api/v1/recipe/" + recipe.getId());
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping(path = "/api/v1/recipe/{id}")
    public ResponseEntity<Void> deleteRecipe(@PathVariable Long id) {
        boolean successful = recipeService.deleteById(id);
        return successful? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    @PutMapping(path = "/api/v1/recipe/{id}")
    public ResponseEntity<Recipe> updateRecipe(@PathVariable Long id, @RequestBody RecipeManipulationRequest request) {
        var recipe = recipeService.update(id, request);
        return recipe != null? ResponseEntity.ok(recipe) : ResponseEntity.notFound().build();
    }

////    Client
//    @GetMapping(value = "/recipeByIngredients/{ingredients}")
//    public Flux<Recipe> findByIngredientName(@PathVariable("ingredients") List<String> ingredients) {
//        return recipeService.getRecipe(ingredients);
//    }
//
//    @GetMapping(value = "/recipeInformation/{id}")
//    public Mono<Recipe> getRecipeInformation(@PathVariable("id") long id) {
//        return recipeService.getRecipeInformation(id);
//    }
//
//    @GetMapping(value="/recipeSummary/{id}")
//    public Mono<Recipe> getSummary(@PathVariable("id") long id) {
//        return recipeService.summarizeRecipe(id);
//    }
//
//    @GetMapping(value="/getRecipeInstructions/{id}")
//    public Flux<Recipe> getInstructions(@PathVariable("id") long id) {
//        return recipeService.recipeInstructions(id);
//    }
}
