package de.htwberlin;

import de.htwberlin.persistence.RecipeEntity;
import de.htwberlin.web.api.Ingredient;
import de.htwberlin.web.api.RecipeTransformer;
import de.htwberlin.web.api.Step;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.HashSet;
import java.util.Set;

import static org.mockito.Mockito.doReturn;

public class RecipeTransformerTest implements WithAssertions {

    private final RecipeTransformer test = new RecipeTransformer();
    private final Set<Ingredient> ingredients = new HashSet<>();
    private final Step step = new Step(1L,2L,"steps");
    private final Set<Step> steps = new HashSet<>();


    @Test
    @DisplayName("Should transform a RecipeEntity to a Recipe")
    void testTransform(){

        //given
        var recipeEntity = Mockito.mock(RecipeEntity.class);
        doReturn(1L).when(recipeEntity).getId();
        doReturn("Caprese Sticks").when(recipeEntity).getName();
        doReturn("foodpic").when(recipeEntity).getImage();
        doReturn("cut veggies").when(recipeEntity).getSummary();
        doReturn(steps).when(recipeEntity).getSteps();
        doReturn(ingredients).when(recipeEntity).getIngredients();

        //when
        var result = test.transformEntity(recipeEntity);


        //then

        assertThat(result.getId()).isEqualTo(1L);
        assertThat(result.getName()).isEqualTo("Caprese Sticks");
        assertThat(result.getImage()).isEqualTo("foodpic");
        assertThat(result.getSteps()).isEqualTo(steps);
        assertThat(result.getSummary()).isEqualTo("cut veggies");
        assertThat(result.getIngredients()).isEqualTo(ingredients);
        assertThat(result.getIngredients()).hasSize(0);
        assertThat(result.getSteps()).hasSize(0);
    }


}
