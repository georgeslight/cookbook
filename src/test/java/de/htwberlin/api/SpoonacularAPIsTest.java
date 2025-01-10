package de.htwberlin.api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class SpoonacularAPIsTest {

    @Value("${API_KEY}")
    private String apiKey;

    private static final String ENDPOINT = "https://api.spoonacular.com";

    private static final String ENDPOINT_PATH = "/recipes/findByIngredients";

    private static final String API_KEY_NAME = "apiKey";

    private static final String QUERY_PARAM_NAME = "ingredients";

    private static final List<String> QUERY_PARAM_VALUE = List.of("avocado", "apple", "butter");

    //Spring WebClient
    @Test
    public void getRecipesTest() {

        WebClient client = WebClient.create(ENDPOINT);

        Mono<ResponseEntity<String>> mono = client.get()
                .uri(builder -> builder.path(ENDPOINT_PATH)
                        .queryParam(API_KEY_NAME, this.apiKey)
                        .queryParam(QUERY_PARAM_NAME, String.join(",+", QUERY_PARAM_VALUE))
                        .build())
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .toEntity(String.class);

        //Sync Call
        ResponseEntity<String> response = mono.block();

        assert response != null;
        System.out.println(response.getBody());
        assertEquals(200, response.getStatusCodeValue());
    }

}
