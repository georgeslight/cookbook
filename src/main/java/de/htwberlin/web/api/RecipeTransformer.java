package de.htwberlin.web.api;

import de.htwberlin.persistence.IngredientEntity;
import de.htwberlin.persistence.RecipeEntity;
import de.htwberlin.persistence.StepEntity;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class RecipeTransformer {

    public Recipe transformEntity(RecipeEntity recipeEntity) {
        Set<Ingredient> ingredients = recipeEntity.getIngredients()
                .stream()
                .map(IngredientEntity::transformEntity)
                .collect(Collectors.toSet());

        Set<Step> steps = recipeEntity.getSteps()
                .stream()
                .map(StepEntity::transformEntity)
                .collect(Collectors.toSet());

        return new Recipe(
                recipeEntity.getId(),
                recipeEntity.getName(),
                recipeEntity.getImage(),
                recipeEntity.getSummary(),
                steps,
                ingredients,
                recipeEntity.getLiked());
    }
}
