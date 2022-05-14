package de.htwberlin.services;

import de.htwberlin.api.Ingredient;
import org.springframework.stereotype.Service;
import de.htwberlin.persistence.IngredientEntity;
import de.htwberlin.persistence.IngredientRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IngredientService {
    private final IngredientRepository ingredientRepository;

    public IngredientService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    public List<Ingredient> findAll() {
        List<IngredientEntity> ingredients = ingredientRepository.findAll();
        return ingredients.stream().map(ingredientEntity -> new Ingredient(ingredientEntity.getId(),ingredientEntity.getIngName(),ingredientEntity.isVegetarian(),ingredientEntity.isVegan())).collect(Collectors.toList());
    }
}
