package com.google.devrel.calculation.form;

import java.util.List;

/**
 * Created by Darina on 12.04.2017.
 */
public class RecipeForm {
    private List<ProductForm> products;
    private double standartWeight;
    private String name;

    public RecipeForm(String name, List<ProductForm> products, double standartWeight){
        this.name = name;
        this.products = products;
        this.standartWeight = standartWeight;
    }

    public List<ProductForm> getProducts() { return products; }

    public double getStandartWeight() { return standartWeight; }

    public String getName() { return name; }
}
