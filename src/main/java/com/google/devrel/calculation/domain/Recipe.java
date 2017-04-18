package com.google.devrel.calculation.domain;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Darina on 18.04.2017.
 */
public interface Recipe
{
     Map<Product, Double> ingredients = new HashMap<>(); // продукти та норма в порціях або в
                                                       // кг відповідно ціна одиниці товару (за кг або за штуку)
     void add(Product product, double norm);
     void delete(Product product);
     double getNorm(Product product);
     double getSum(Product product);
     String getName();
     int getRecipeId();
}
