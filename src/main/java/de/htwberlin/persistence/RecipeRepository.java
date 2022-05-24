package de.htwberlin.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<RecipeEntity, Long> {

    List<RecipeEntity> findAllByRecipeName(String recipeName);
    // List<RecipeEntity> findRecipeByIngredientsName(List<String> ingredientsName);
//    How to make a method that finds a Recipe by Ingredients(1 or +) name?
}
