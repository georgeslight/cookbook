package de.htwberlin.services;

import de.htwberlin.api.Ingredient;
import de.htwberlin.api.Recipe;
import de.htwberlin.persistence.AmountEntity;
import de.htwberlin.persistence.RecipeEntity;
import de.htwberlin.persistence.RecipeRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

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
                ingredients.add(new Ingredient(amount.getIngredient().getId(), amount.getIngredient().getIngName()));
            }
            Recipe recipe = new Recipe(recipeEntity.getId(), recipeEntity.getRecipeName(), ingredients);
            recipeList.add(recipe);
        }
        return recipeList;
    }

    @Value("${API_KEY}")
    private String apiKey;

    private static final String ENDPOINT = "https://api.spoonacular.com";

    private static final String ENDPOINT_PATH = "/recipes/findByIngredients";

    private static final String API_KEY_NAME = "apiKey";

    private static final String QUERY_PARAM_NAME = "ingredients";

    private final WebClient client;

//    public RecipeService(WebClient.Builder builder) {
//        this.client = builder.baseUrl(ENDPOINT).build();
//    }

    public Flux<Recipe> getRecipe(List<String> ingredients) {

        return client.get()
                .uri(builder -> builder.path(ENDPOINT_PATH)
                        .queryParam(API_KEY_NAME, this.apiKey)
                        .queryParam(QUERY_PARAM_NAME, String.join(",+", ingredients))
                        .build())
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(Recipe.class);
    }
}
