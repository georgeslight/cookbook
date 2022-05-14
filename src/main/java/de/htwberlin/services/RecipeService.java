package de.htwberlin.services;

import de.htwberlin.api.Recipe;
import de.htwberlin.persistence.RecipeEntity;
import de.htwberlin.persistence.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;

    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public List<Recipe> findAll() {
        List<RecipeEntity> recipe = recipeRepository.findAll();
        return recipe.stream()
                .map(recipeEntity -> new Recipe(recipeEntity.getId(),
                        recipeEntity.getRecipeName()))
                .collect(Collectors.toList());
    }
}
