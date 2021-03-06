package com.google.devrel.calculation.form;


public class ProductForm {

    private String name;
    private int price;
    private double bruttoWeight;
    private double nettoWeight;

    public ProductForm(String name, int price, double bruttoWeight, double nettoWeight){
        this.name = name;
        this.price = price;
        this.bruttoWeight = bruttoWeight;
        this.nettoWeight = nettoWeight;
    }

    private ProductForm() {}

    public String getName(){return name;}

    public int getPrice(){return price;}

    public double getBruttoWeight(){return bruttoWeight;}

    public double getNettoWeight(){return nettoWeight;}


}
