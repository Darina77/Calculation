package com.google.devrel.calculation.domain;

/**
 * Created by Darina on 12.04.2017.
 */
public class Calculation
{

    private Recipe recipe;
    private double onePortionWeight; // грами
    private static final double PDV = 0.2;
    private double extra; // відсотки поділені на 100

    public Calculation(Recipe recipe){
        this.recipe = recipe;
        onePortionWeight = 100;
        extra = 1;
    }

    public Calculation(Recipe recipe, double onePortionWeight, double extra) {
        this.recipe = recipe;
        this.onePortionWeight = onePortionWeight;
        this.extra = extra;
    }

    //todo
    public double calculate(){
        return 0;
    }


}
