package com.google.devrel.calculation.domain;

/**
 * Created by Darina on 12.04.2017.
 */
public class Calculation
{

    private Recipe recipe;
    private double onePortionWeight; // грами

    public Calculation(Recipe recipe){
        this.recipe = recipe;
        onePortionWeight = 100;
    }

    public Calculation(Recipe recipe, double onePortionWeight) {
        this.recipe = recipe;
        this.onePortionWeight = onePortionWeight;
    }
}
