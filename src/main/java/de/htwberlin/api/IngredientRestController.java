package de.htwberlin.api;

import de.htwberlin.services.IngredientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class IngredientRestController {

    private final IngredientService ingredientService;

    public IngredientRestController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @GetMapping(path = "/api/v1/ingredient")
    public ResponseEntity<List<Ingredient>> fetchIngredient() {
        return ResponseEntity.ok(ingredientService.findAll());
    }

    @PostMapping(path = "api/v1/ingredient")
    public ResponseEntity<Void> createIngredient(@RequestBody IngredientCreateRequest request) throws URISyntaxException {
        var ingredient =ingredientService.create(request);
        URI uri = new URI("api/v1/ingredient/" + ingredient.getId());
        return ResponseEntity.created(uri).build();
    }
}
