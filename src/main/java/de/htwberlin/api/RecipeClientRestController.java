//package de.htwberlin.api;
//
//import de.htwberlin.services.RecipeClient;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import reactor.core.publisher.Flux;
//import reactor.core.publisher.Mono;
//
//import java.util.List;
//
//@Controller
//public class RecipeClientRestController {
//
//    private final RecipeClient recipeClient;
//
//    public RecipeClientRestController(RecipeClient recipeClient) {
//        this.recipeClient = recipeClient;
//    }
//
//    @GetMapping(value = "/recipeByIngredients/{ingredients}")
//    public Flux<Recipe> findByIngredientName(@PathVariable("ingredients") List<String> ingredients) {
//        return recipeClient.getByIngredients(ingredients);
//    }
//
//    @GetMapping(value = "/recipeInformation/{id}")
//    public Mono<Recipe> getRecipeInformation(@PathVariable("id") long id) {
//        return recipeClient.getInformationById(id);
//    }
//}