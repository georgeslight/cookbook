package de.htwberlin.API;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class IngredientRestController {

    private List<Ingredient> ingredients;

    public IngredientRestController(){
        ingredients = new ArrayList<>();
        ingredients.add(new Ingredient(1,"Tomate",true,true ));
        ingredients.add(new Ingredient(2,"Mozzarella",true,false ));
        ingredients.add(new Ingredient(2,"Lachs",false,false ));

    }
    @GetMapping(path = "/api/v1/Ingredient")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Ingredient> fetchIngredient(){
        return ingredients;
    }

}
