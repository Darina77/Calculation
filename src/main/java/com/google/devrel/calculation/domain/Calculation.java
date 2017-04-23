package com.google.devrel.calculation.domain;

/**
 * Created by Darina on 12.04.2017.
 */
public class Calculation
{

    private Recipe recipe;
    private Portion gettedPortion;
    private double onePortionWeight; // грами
    private static final double PDV = 0.2;
    private double extra; // відсотки поділені на 100

    public Calculation(Recipe recipe){
        this.recipe = recipe;
        onePortionWeight = 100;
        extra = 1;
        gettedPortion = new Portion(onePortionWeight, recipe, calculate());
    }

    public Calculation(Recipe recipe, double onePortionWeight, double extra) {
        this.recipe = recipe;
        this.onePortionWeight = onePortionWeight;
        this.extra = extra;
        gettedPortion = new Portion(onePortionWeight, recipe, calculate());
    }

    private double calculate(){
        double clearSum = recipe.countSumOfAll(); //загальнв ціна за всі продукти
        double sumWithExtra = clearSum * extra; // ціна з націнкою
        double pdvSum = (clearSum + sumWithExtra)*PDV; // розрахунок пдв
        double commonPrice = clearSum + sumWithExtra + pdvSum;//загальна ціна
        double oneKiloPrice = commonPrice/10; //ціна за один кілограм
        double onePortionPrice = (oneKiloPrice*onePortionWeight)/1000; //ціна за одну порцію
        return onePortionPrice;
    }

    public Portion getPortion(){return gettedPortion;}

}
