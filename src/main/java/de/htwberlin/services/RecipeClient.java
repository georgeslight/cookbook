//package de.htwberlin.services;
//
//import de.htwberlin.api.RecipeCard;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.stereotype.Service;
//import org.springframework.web.reactive.function.client.WebClient;
//import org.springframework.web.reactive.function.client.WebClient.*;
//import reactor.core.publisher.Mono;
//
//import java.nio.charset.StandardCharsets;
//import java.time.ZonedDateTime;
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
//    private RecipeCard recipeCard;
//
//    public RecipeClient () {
//        this.client = WebClient.create();
//    }
//
//    public Mono<String> getRecipe(String query) {
//        UriSpec<RequestBodySpec> uriSpec = client.method(HttpMethod.GET);
//
//        RequestBodySpec bodySpec = uriSpec.uri(builder -> builder.path("/recipes/complexSearch")
//                .queryParam("apiKey", "30b0ba6660f343a581c3f5123022eb73")
//                .queryParam("query", query)
//                .build());
//
//        RequestHeadersSpec<?> headersSpec = bodySpec.bodyValue(recipeCard);
//
//        ResponseSpec responseSpec = headersSpec.header(
//                        HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
//                .accept(MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML)
//                .acceptCharset(StandardCharsets.UTF_8)
//                .ifNoneMatch("*")
//                .ifModifiedSince(ZonedDateTime.now())
//                .retrieve();
//
//        return headersSpec.exchangeToMono(response -> {
//            if (response.statusCode().equals(HttpStatus.OK)) {
//                return response.bodyToMono(String.class);
//            } else if (response.statusCode().is4xxClientError()) {
//                return Mono.just("Error response");
//            } else {
//                return response.createException()
//                        .flatMap(Mono::error);
//            }
//        });
//    }
//}
