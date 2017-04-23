package com.google.devrel.calculation.domain;

/**
 * Created by Darina on 12.04.2017.
 */
public class Portion
{

    private double weight;
    private Recipe onThisRecipe;
    private double onePortionPrice;

    public Portion(double weight, Recipe recipe, double onePortionPrice)
    {
        this.weight = weight;
        this.onePortionPrice = onePortionPrice;
        this.onThisRecipe = recipe;
    }

    public double getWeight() { return weight;}
    public Recipe getOnThisRecipe() { return onThisRecipe;}
    public double getOnePortionPrice() { return onePortionPrice;}


}
