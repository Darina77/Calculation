package com.google.devrel.calculation.form;

import java.util.List;

/**
 * Created by Darina on 12.04.2017.
 */
public class RecipeForm {
    private List<ProductForm> products;
    private double standartWeight;
    private String name;
    private RecipeType type;

    public RecipeForm(String name, RecipeType type, List<ProductForm> products, double standartWeight){
        this.name = name;
        this.type = type;
        this.products = products;
        this.standartWeight = standartWeight;
    }

    private RecipeForm() {}

    public List<ProductForm> getProducts() { return products; }

    public double getStandartWeight() { return standartWeight; }

    public String getName() { return name; }

    public RecipeType getType() {return type;}

    public static enum RecipeType {
       COLD,
       POULTY_RABBIT,
       SAUCES,
       SOUPS,
       FISH_SEAFOOD,
       MEAT,
       POTATOES_VEGETABLES_MUSHROOMS,
       SWEET,
       CURD,
       MACARONI,
       GARNISH,
       BEAN,
       CROUP,
       FLOUR,
       EGG,
       BEVERAGES
    }
}
