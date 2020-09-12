package com.geekbrains.spring.context.app;

public class Product {
    private Long id;
    private String name;
    private float price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Product(Long id, String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Product() {}

    @Override
    public String toString() {
        return String.format("Product: {id = %d, name = \"%s\", price = %.2f}", id, name, price);
    }
}
