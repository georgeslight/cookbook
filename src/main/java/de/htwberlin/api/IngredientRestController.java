package de.htwberlin.api;

import de.htwberlin.services.IngredientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class IngredientRestController {

    private final IngredientService ingredientService;

    public IngredientRestController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }


    @GetMapping(path = "/api/v1/Ingredient")
    public ResponseEntity<List<Ingredient>> fetchIngredient() {
        return ResponseEntity.ok(ingredientService.findAll());
    }

}
