package de.htwberlin.services;

import de.htwberlin.api.Ingredient;
import de.htwberlin.api.Recipe;
import de.htwberlin.persistence.AmountEntity;
import de.htwberlin.persistence.RecipeEntity;
import de.htwberlin.persistence.RecipeRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;

    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Transactional
    public List<Recipe> findAll() {
        List<RecipeEntity> recipes = recipeRepository.findAll();
        List<Recipe> recipeList = new ArrayList<>();

        for (RecipeEntity recipeEntity : recipes) {
            ArrayList<Ingredient> ingredients = new ArrayList<>();
            Set<AmountEntity> amounts = recipeEntity.getAmount();
            for (AmountEntity amount : amounts) {
                ingredients.add(new Ingredient(amount.getIngredient().getId(), amount.getIngredient().getIngName(),
                        amount.getIngredient().isVegetarian(), amount.getIngredient().isVegan()));
            }
            Recipe recipe = new Recipe(recipeEntity.getId(), recipeEntity.getRecipeName(), ingredients);
            recipeList.add(recipe);
        }
        return recipeList;
    }
}
