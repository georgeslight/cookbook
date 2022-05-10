package de.htwberlin.services;

import de.htwberlin.API.Ingredient;
import de.htwberlin.API.IngredientManipulationRequest;
import org.springframework.stereotype.Service;
import de.htwberlin.persistence.IngredientEntity;
import de.htwberlin.persistence.IngredientRepository;

import java.util.List;

@Service
public class IngredientService {
   private final IngredientRepository ingredientRepository;

    public IngredientService(IngredientRepository ingredientRepository){
        this.ingredientRepository = ingredientRepository;
    }

    public List<Ingredient> findAll(){
        List<IngredientEntity> ingredients = ingredientRepository.findAll();
        return null;//ingredients.stream().map(this::transformEntity).collect(Collectors.toList());
    }

    public Ingredient create(IngredientManipulationRequest request){
        return null;
    }
}
