package com.google.devrel.calculation.spi;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.Named;
import com.google.devrel.calculation.Constants;
import com.google.devrel.calculation.domain.Calculation;
import com.google.devrel.calculation.domain.Portion;
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


    @ApiMethod( name="calculateRecipe", path = "calculateRecipe", httpMethod = ApiMethod.HttpMethod.GET)
    public Portion calculateRecipe(final Recipe recipe,
                                   @Named("onePortionWeight") final double onePortionWeight,
                                   @Named("extra") final double extra)
    {
        if(recipe == null) throw new NullPointerException("Recipe cann`t be null");
        Calculation calculation;
        if (onePortionWeight == 0 || extra == 0)
            calculation = new Calculation(recipe);
        else
            calculation = new Calculation(recipe, onePortionWeight, extra);
        Portion resPortion = calculation.getPortion();
        return resPortion;
    }

    @ApiMethod( name="getRecipesByType", path = "getRecipesByType", httpMethod = ApiMethod.HttpMethod.GET)
    public List<Recipe> getRecipesByType(@Named("type") final RecipeType type)
    {
        Query<Recipe> query = ofy().load().type(Recipe.class);
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
            result = new Recipe(name, productForms, type, standardPortionSize);
            //result.add(productForms);
        } else {
            result.update(standardPortionSize, type, productForms);
        }
        ofy().save().entity(result).now();

        return result;
    }

    @ApiMethod(name = "getRecipe", path = "getRecipe", httpMethod = ApiMethod.HttpMethod.GET)
    public Recipe getRecipe(@Named("name")final String name) {
        Key recipeKey =  Key.create(Recipe.class, name);
        Recipe recipe = (Recipe) ofy().load().key(recipeKey).now();
        return recipe;
    }
}
