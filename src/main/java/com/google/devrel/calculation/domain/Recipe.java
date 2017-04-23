package com.google.devrel.calculation.domain;

import com.google.devrel.calculation.form.ProductForm;
import com.google.devrel.calculation.form.RecipeForm.RecipeType;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * Рецепти страв з розрахунком на вагу
 * Вносяться необхідні інгредієнти з розрахунком на 10кг
 * @author  Darina
 */
@Entity
public class Recipe
{
    @Id
    private String name;
    private Map<Product, Double> ingredients; // продукти та іх необхідна норма (вага в кг)
    private double standardPortionSize;
    private RecipeType type;

    /**
     * Конструктор рецептів
     * @param name назва рецепта
     */
    public Recipe(String name, RecipeType type, double standardPortionSize)
    {
        this.name = name;
        this.type = type;
        this.standardPortionSize = standardPortionSize;
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
        double norm ;
        double weight = productWeight(product);

        if (standardPortionSize == 1000) {
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

    public String getName() { return name; }

    public double getStandardPortionSize() {return standardPortionSize;}

    public double countSumOfAll() {
        double sum = 0;
        for(Product product: ingredients.keySet())
            sum += product.sum(ingredients.get(product));
        return sum;
    }

    public RecipeType getType(){ return type; }

    public void update(double standardPortionSize, RecipeType type, List<ProductForm> productForms) {
        if(standardPortionSize > 0) this.standardPortionSize = standardPortionSize;
        this.type = type;
        add(productForms);
    }

    public void add(List<ProductForm> productForms) {
        for(ProductForm product: productForms)
            add(product);
    }

    public void add(ProductForm productForm){
        String name = productForm.getName();
        int price = productForm.getPrice();
        double bruttoWeight = productForm.getBruttoWeight();
        double nettoWeight = productForm.getNettoWeight();
        if (name == null) throw new NullPointerException("Name can`t be null");
        else if (price <= 0 || (bruttoWeight <= 0 && nettoWeight <= 0))
            throw new IllegalArgumentException("Arguments must be more then 0");
        else
            add(new Product(name, bruttoWeight, nettoWeight, price));
    }
}
