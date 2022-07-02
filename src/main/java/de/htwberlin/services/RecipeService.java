package de.htwberlin.services;

import de.htwberlin.persistence.IngredientEntity;
import de.htwberlin.persistence.RecipeEntity;
import de.htwberlin.persistence.RecipeRepository;
import de.htwberlin.persistence.StepEntity;
import de.htwberlin.web.api.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;
    private final RecipeTransformer recipeTransformer;

    public RecipeService(RecipeRepository recipeRepository, RecipeTransformer recipeTransformer, WebClient.Builder builder) {
        this.recipeRepository = recipeRepository;
        this.client = builder.baseUrl(ENDPOINT).build();
        this.recipeTransformer = recipeTransformer;
    }

//    Database
    @Transactional
    public List<Recipe> findAll() {
        List<RecipeEntity> recipes = recipeRepository.findAll();
        return recipes.stream()
                .map(recipeTransformer::transformEntity)
                .collect(Collectors.toList());
    }

    public Recipe create(RecipeManipulationRequest request) {
        var recipeEntity = new RecipeEntity(
                request.getTitle(),
                request.getSummary(),
                request.getImage());

        Set<IngredientEntity> ingredientsEntity = request.getExtendedIngredients()
                .stream()
                .map(ingredient -> new IngredientEntity(ingredient.getName()))
                .collect(Collectors.toSet());

        RecipeEntity finalRecipeEntity = recipeEntity;
        Set<StepEntity> stepsEntity = request.getSteps()
                .stream()
                .map(step -> new StepEntity(step.getNumber(), step.getStep(), finalRecipeEntity))
                .collect(Collectors.toSet());

        recipeEntity.setIngredients(ingredientsEntity);
        recipeEntity.setSteps(stepsEntity);
        recipeEntity = recipeRepository.save(recipeEntity);

        return recipeTransformer.transformEntity(recipeEntity);
    }

    public boolean deleteById(Long id) {
        if(!recipeRepository.existsById(id)) {
            return false;
        }
        recipeRepository.deleteById(id);
        return true;
    }


//    Client
    @Value("${API_KEY}")
    private String apiKey;

    private static final String ENDPOINT = "https://api.spoonacular.com";

    private static final String API_KEY_NAME = "apiKey";

    private final WebClient client;

    public Flux<Recipe> getRecipe(List<String> ingredients) {

        return client.get()
                .uri(builder -> builder.path("/recipes/findByIngredients")
                        .queryParam(API_KEY_NAME, this.apiKey)
                        .queryParam("ingredients", String.join(",+", ingredients))
                        .build())
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(Recipe.class);
    }

    public Mono<Recipe> getRecipeInformation(long id) {
        return client.get()
                .uri(builder -> builder.path("/recipes")
                        .pathSegment(Long.toString(id), "information").path("/")
                        .queryParam(API_KEY_NAME, this.apiKey)
                        .build())
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Recipe.class);
    }

    public Mono<Recipe> summarizeRecipe(long id) {
        return client.get()
                .uri(builder -> builder.path("/recipes")
                        .pathSegment(Long.toString(id), "summary").path("/")
                        .queryParam(API_KEY_NAME, this.apiKey)
                        .build())
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Recipe.class);
    }

    public Flux<Recipe> recipeInstructions(long id) {
        return client.get()
                .uri(builder -> builder.path("/recipes")
                        .pathSegment(Long.toString(id), "analyzedInstructions").path("/")
                        .queryParam(API_KEY_NAME, this.apiKey)
                        .build())
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(Recipe.class);
    }
}
