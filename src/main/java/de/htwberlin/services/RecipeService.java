package de.htwberlin.services;

import de.htwberlin.api.*;
import de.htwberlin.persistence.AmountEntity;
import de.htwberlin.persistence.RecipeEntity;
import de.htwberlin.persistence.RecipeRepository;
import jdk.jfr.ContentType;
import org.apache.logging.log4j.util.PropertiesUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;

    public RecipeService(RecipeRepository recipeRepository, WebClient.Builder builder) {
        this.recipeRepository = recipeRepository;
        this.client = builder.baseUrl(ENDPOINT).build();
    }

    @Transactional
    public List<Recipe> findAll() {
        List<RecipeEntity> recipes = recipeRepository.findAll();
        List<Recipe> recipeList = new ArrayList<>();

        for (RecipeEntity recipeEntity : recipes) {
            ArrayList<Ingredient> ingredients = new ArrayList<>();
            Set<AmountEntity> amounts = recipeEntity.getAmount();
            for (AmountEntity amount : amounts) {
                ingredients.add(new Ingredient(amount.getIngredient().getId(), amount.getIngredient().getIngName(), amount.getIngredient().isVegetarian(), amount.getIngredient().isVegan()));
            }
            Recipe recipe = new Recipe(recipeEntity.getId(), recipeEntity.getRecipeName(), ingredients);
            recipeList.add(recipe);
        }
        return recipeList;
    }

    public Recipe create(RecipeManipulationRequest request) {
        var recipeEntity = new RecipeEntity(
                request.
        )
    }

    @Value("${API_KEY}")
    private String apiKey;

    private static final String ENDPOINT = "https://api.spoonacular.com";

    private static final String RECIPE_BY_INGREDIENTS_PATH = "/recipes/findByIngredients";

    private static final String RECIPE_INFORMATION_PATH = "/recipes";

    private static final String API_KEY_NAME = "apiKey";

    private static final String RANDOM_RECIPE = "/recipes/random";

    private final WebClient client;

    public Flux<Recipe> getRecipe(List<String> ingredients) {

        return client.get()
                .uri(builder -> builder.path(RECIPE_BY_INGREDIENTS_PATH)
                        .queryParam(API_KEY_NAME, this.apiKey)
                        .queryParam("ingredients", String.join(",+", ingredients))
                        .build())
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(Recipe.class);
    }

    public Mono<Recipe> getRecipeInformation(long id) {
        return client.get()
                .uri(builder -> builder.path(RECIPE_INFORMATION_PATH)
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

    public Flux<RecipeInstructions> recipeInstructions(long id) {
        return client.get()
                .uri(builder -> builder.path("/recipes")
                        .pathSegment(Long.toString(id), "analyzedInstructions").path("/")
                        .queryParam(API_KEY_NAME, this.apiKey)
                        .build())
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(RecipeInstructions.class);
    }
}
