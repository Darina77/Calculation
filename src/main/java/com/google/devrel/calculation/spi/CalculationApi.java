package com.google.devrel.calculation.spi;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.Named;
import com.google.devrel.calculation.Constants;
import com.google.devrel.calculation.domain.Recipe;
import com.google.devrel.calculation.form.ProductForm;
import com.google.devrel.calculation.form.RecipeForm;
import com.google.devrel.calculation.form.RecipeForm.RecipeType;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.cmd.Query;

import java.util.List;

import static com.google.devrel.calculation.service.OfyService.ofy;
/**
 * Created by Darina on 12.04.2017.
 */
@Api(name = "calculation", scopes = (Constants.EMAIL_SCOPE) , clientIds = {
        Constants.WEB_CLIENT_ID,
        Constants.API_EXPLORER_CLIENT_ID },version = "v1", description = "API for the Calculation Backend application.")

public class CalculationApi {

    @ApiMethod( name="getRecipesByType", path = "getRecipesByType", httpMethod = ApiMethod.HttpMethod.GET)
    public List<Recipe> getRecipesByType(@Named("type") RecipeType type)
    {
        Query<Recipe> query = ofy().load().type(Recipe.class).order("name");
        query = query.filter("type =", type);
        return query.list();
    }


    @ApiMethod(name = "createRecipe", path = "createRecipe", httpMethod = ApiMethod.HttpMethod.POST)
    public Recipe createRecipe(RecipeForm recipeForm)
            throws NullPointerException
    {
        String name = recipeForm.getName();
        double standardPortionSize = recipeForm.getStandartWeight();
        RecipeType type = recipeForm.getType();
        List<ProductForm> productForms = recipeForm.getProducts();

       if (name == null || type == null
                || standardPortionSize == 0
                || productForms == null
                || productForms.isEmpty())
                    throw  new NullPointerException();

        Recipe result = getRecipe(name);
        if (result == null){
            result = new Recipe(name, type, standardPortionSize);
            result.add(productForms);
        } else {
            result.update(standardPortionSize, type, productForms);
        }
        try {
            ofy().save().entity(result).now();
        } catch (Exception e){
            e.printStackTrace();
        }

        return result;
    }

    @ApiMethod(name = "getRecipe", path = "getRecipe", httpMethod = ApiMethod.HttpMethod.GET)
    public Recipe getRecipe(@Named("name") String name) {
        Key<Recipe> recipeKey =  Key.create(Recipe.class, name);
        Recipe recipe = (Recipe) ofy().load().key(recipeKey).now();
        return recipe;
    }
}
