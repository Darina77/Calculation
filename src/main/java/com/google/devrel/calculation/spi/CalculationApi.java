package com.google.devrel.calculation.spi;

import com.google.api.server.spi.config.ApiMethod;
import com.google.devrel.calculation.domain.Recipe;
import com.google.devrel.calculation.form.ProductForm;
import com.google.devrel.calculation.form.RecipeForm;
import com.googlecode.objectify.Key;

import java.util.List;

import static com.google.devrel.calculation.service.OfyService.ofy;
/**
 * Created by Darina on 12.04.2017.
 */
public class CalculationApi {

    @ApiMethod(name = "createRecipe", path = "createRecipe", httpMethod = ApiMethod.HttpMethod.POST)
    public Recipe createRecipe(RecipeForm recipeForm)
            throws NullPointerException
    {
        String name = recipeForm.getName();
        double standardPortionSize = recipeForm.getStandartWeight();
        List<ProductForm> productForms = recipeForm.getProducts();
        if (name == null
                || standardPortionSize == 0
                || productForms == null
                || productForms.isEmpty())
                    throw  new NullPointerException();



        Recipe result = getRecipe(name);
        if (result == null){
            result = new Recipe(name, standardPortionSize);
            result.add(productForms);
        } else {
            result.update(standardPortionSize, productForms);
        }
        ofy().save().entity(result).now();
        return result;
    }

    @ApiMethod(name = "getRecipe", path = "getRecipe", httpMethod = ApiMethod.HttpMethod.GET)
    public Recipe getRecipe(String name) {
        Key<Recipe> recipeKey =  Key.create(Recipe.class, name);
        Recipe recipe = (Recipe) ofy().load().key(recipeKey).now();
        return recipe;
    }
}
