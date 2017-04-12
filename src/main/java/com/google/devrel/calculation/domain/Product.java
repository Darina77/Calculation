package com.google.devrel.calculation.domain;

/**
 * Клас продуктів
 * @author Darina
 */
public class Product
{
    private int productID;
    private String name;
    private int price; //ціна в копійках за один кг


    /**
     * @param productID унікальний id продукта
     * @param name назва продукта
     * @param price закупівельна ціна за кілограм
     */
    public Product(int productID, String name, int price)
    {
        this.productID = productID;
        this.name = name;
        this.price = price;
    }

    /**
     * @return  унікальний номер продукту
     */
    public int getProductID(){ return productID; }

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
    public boolean equals(Product that){ return productID == that.productID; }

    /**
     * Обраховує ціну якоїсь маси продукту
     * @param norm вага продукту в кг
     * @return сумму, ціну за якусь норму продукту
     */
    public double sum(double norm){ return price*norm;}
}
