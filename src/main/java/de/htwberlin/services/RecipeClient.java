//package de.htwberlin.services;
//
//import de.htwberlin.api.Recipe;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.MediaType;
//import org.springframework.stereotype.Service;
//import org.springframework.web.reactive.function.client.WebClient;
//import reactor.core.publisher.Flux;
//import reactor.core.publisher.Mono;
//
//import java.util.List;
//
//@Service
//public class RecipeClient {
//
//    @Value("${API_KEY}")
//    private String apiKey;
//
//    private static final String ENDPOINT = "https://api.spoonacular.com";
//
//    private final WebClient client;
//
//    public RecipeClient(WebClient.Builder builder) {
//        this.client = builder.baseUrl(ENDPOINT).build();
//    }
//
//    public Flux<Recipe> getByIngredients(List<String> ingredients) {
//
//        return client.get()
//                .uri(builder -> builder.path("/recipes/findByIngredients")
//                        .queryParam("apiKey", this.apiKey)
//                        .queryParam("ingredients", String.join(",+", ingredients))
//                        .build())
//                .accept(MediaType.APPLICATION_JSON)
//                .retrieve()
//                .bodyToFlux(Recipe.class);
//    }
//
//    public Mono<Recipe> getInformationById(long id) {
//
//        return client.get()
//                .uri(builder -> builder.path("/recipes")
//                        .pathSegment(Long.toString(id), "information").path("/")
//                        .queryParam("apiKey", this.apiKey)
//                        .build())
//                .accept(MediaType.APPLICATION_JSON)
//                .retrieve()
//                .bodyToMono(Recipe.class);
//    }
//
//}
