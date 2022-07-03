package de.htwberlin.services;

import de.htwberlin.persistence.IngredientEntity;
import de.htwberlin.web.api.Ingredient;
import org.springframework.stereotype.Service;
import de.htwberlin.persistence.IngredientRepository;

@Service
public class IngredientService {

    private final IngredientRepository ingredientRepository;

    public IngredientService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

//    public List<Ingredient> findAll() {
//        List<IngredientEntity> ingredients = ingredientRepository.findAll();
//        return ingredients.stream().map(this::transformEntity).collect(Collectors.toList());
//    }

//    public Ingredient create(IngredientManipulationRequest request){
//        var ingredientEntity = new IngredientEntity(request.getIngName(),request.isVegan(), request.isVegetarian());
//        ingredientEntity = ingredientRepository.save(ingredientEntity);
//        return transformEntity(ingredientEntity);
//    }

    private Ingredient transformEntity(IngredientEntity ingredientEntity){
        return new Ingredient(ingredientEntity.getId(), ingredientEntity.getName(), ingredientEntity.getAmount(), ingredientEntity.getUnit());
    }
}
