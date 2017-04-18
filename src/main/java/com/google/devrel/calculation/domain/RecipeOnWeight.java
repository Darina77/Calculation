package com.google.devrel.calculation.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * Рецепти страв з розрахунком на вагу
 * Вносяться необхідні інгредієнти з розрахунком на 10кг
 * @author  Darina
 */
public class RecipeOnWeight implements Recipe
{
    private String name;
    private int recipeId;
    private Map<Product, Double> ingredients; // продукти та іх необхідна норма (вага в кг)


    /**
     * Конструктор рецептів
     * @param recipeId id рецепта
     * @param name назва рецепта
     */
    public RecipeOnWeight(int recipeId, String name)
    {
        this.recipeId = recipeId;
        this.name = name;
        ingredients = new HashMap<>();
    }

    /**
     * Друга варіація конструктору
     * @param recipeId id рецепта
     * @param name назва рецепта
     * @param ingredients набір інгрідієнтів
     */
    public RecipeOnWeight(int recipeId, String name, Map<Product, Double> ingredients)
    {
        this.recipeId = recipeId;
        this.name = name;
        this.ingredients = ingredients;
    }

    /**
     * Додавання нового інгрідієнту в рецепт
     * @param product продукт
     * @param norm норма продкуту (кількість в кг)
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
