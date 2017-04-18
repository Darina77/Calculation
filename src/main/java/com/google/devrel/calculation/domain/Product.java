package com.google.devrel.calculation.domain;

/**
 * Клас продуктів
 * @author Darina
 */
public class Product
{
    private String name;
    private int price; //ціна в копійках за один кг або за одну штуку
    private double bruttoWeight;
    private double nettoWeight;


    /**
     * @param name назва продукта
     * @param price закупівельна ціна за кілограм
     */
    public Product(String name, double bruttoWeight, double nettoWeight, int price)
    {
        this.name = name;
        this.bruttoWeight = bruttoWeight;
        this.nettoWeight = nettoWeight;
        this.price = price;
    }


    /**
     * @return  назву продукту
     */
    public String getName() { return name; }



    /**
     * @return ціну за один кілограм
     */
    public int getPrice(){ return price; }

    public void setPrice(int price){ this.price = price; }


    /**
     * Перевіряє на рівність два продукти
     * @param that інтший продукт
     * @return результат порівняння (рівні або ні)
     */
    public boolean equals(Product that){ return name.equals(that.getName()); }

    /**
     * Обраховує ціну якоїсь маси продукту
     * @param norm вага продукту в кг
     * @return сумму, ціну за якусь норму продукту
     */
    public double sum(double norm){ return price*norm;}

    public double getBruttoWeight() {return bruttoWeight;}
    public double getNettoWeight() {return nettoWeight;}
}
