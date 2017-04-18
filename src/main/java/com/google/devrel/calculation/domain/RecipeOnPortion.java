package com.google.devrel.calculation.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * Рецепти страв з розрахунком на порцію
 * Вносяться необхідні інгредієнти з розрахунком на 100 порцій
 * @author  Darina
 */
public class RecipeOnPortion implements Recipe{

    private String name;
    private int recipeId;
    private Map<Product, Double> ingredients; // продукти та іх необхідна норма (кількість )
    private double standartPortion;

    /**
     * Конструктор рецептів
     * @param recipeId id рецепта
     * @param name назва рецепта
     */
    public RecipeOnPortion(int recipeId, String name, double standartPortion)
    {
        this.recipeId = recipeId;
        this.name = name;
        ingredients = new HashMap<>();
        this.standartPortion = standartPortion;
    }

    /**
     * Друга варіація конструктору
     * @param recipeId id рецепта
     * @param name назва рецепта
     * @param ingredients набір інгрідієнтів
     */
    public RecipeOnPortion(int recipeId, String name, Map<Product, Double> ingredients, double standartPortion)
    {
        this.recipeId = recipeId;
        this.name = name;
        this.ingredients = ingredients;
        this.standartPortion = standartPortion;
    }

    /**
     * Додавання нового інгрідієнту в рецепт
     * @param product продукт
     * @param norm норма продкуту (кількість в штуках)
     */
    public void add(Product product, double norm)
    {
        if (product == null || norm == 0) throw  new NullPointerException();
        ingredients.put(product, norm);
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
