package com.google.devrel.calculation.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * Рецепти страв з розрахунком на вагу
 * Вносяться необхідні інгредієнти з розрахунком на 10кг
 * @author  Darina
 */
public class Recipe
{
    private String name;
    private int recipeId;
    private Map<Product, Double> ingredients; // продукти та іх необхідна норма (вага в кг)
    private double standartPortionSize;

    /**
     * Конструктор рецептів
     * @param name назва рецепта
     */
    public Recipe(String name, double standartPortionSize)
    {
        this.name = name;
        this.standartPortionSize = standartPortionSize;
        ingredients = new HashMap<>();
    }


    /**
     * Додавання нового інгрідієнту в рецепт
     * @param product продукт
     */
    public void add(Product product)
    {
        if (product == null) throw  new NullPointerException();
        ingredients.put(product, countNorm(product));
    }

    private double countNorm(Product product){
        double norm = 0;
        double weight = productWeight(product);

        if (standartPortionSize == 1000) {
            norm = weight;
        } else {
           norm = (weight * 100)/ 1000;
        }
        return norm;
    }

    private double productWeight(Product product){
        double productBrutto = product.getBruttoWeight();
        if (productBrutto == 0)
            return product.getNettoWeight();
        else return productBrutto;
    }

    /**
     * Видалення продукту з рецепту
     * @param product продукт який необхідно видалити
     */
    public void delete(Product product)
    {
        if (product == null) throw new NullPointerException();
        if (ingredients.containsKey(product))
        {
            ingredients.remove(product);
        }
        else throw new NoSuchElementException();
    }

    /**
     * @param product для якого продукту необхідно взяти норму з рецепту
     * @return норму продукту в цьому рецепті
     */
    public double getNorm(Product product)
    {
        if (product == null) throw new NullPointerException();

        if (ingredients.containsKey(product))
            return ingredients.get(product);

        else throw new NoSuchElementException();
    }

    /**
     * @param product для якого продукту визначити сумму
     * @return сумму грошей за всю вагу продукту
     */
    public double getSum(Product product)
    {
        if (product == null) throw new NullPointerException();

        if (ingredients.containsKey(product))
            return product.sum(ingredients.get(product));

        else throw new NoSuchElementException();
    }

    public String getName()
    {
        return name;
    }

    public int getRecipeId()
    {
        return recipeId;
    }

}
