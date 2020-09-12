package com.geekbrains.spring.context.app;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class ProductRepository {
    private List<Product> products;

    @PostConstruct
    public void init() {
        products = new ArrayList<>(Arrays.asList(
                new Product(1L, "CD", 20),
                new Product(2L, "LP", 25),
                new Product(3L, "2LP", 35),
                new Product(4L, "DVD", 25),
                new Product(5L, "Blu-Ray", 30)
        ));
    }

    public List<Product> findAll() {
        return Collections.unmodifiableList(products);
    }

    public Product findItemById(Long id) {
        for (Product i : products) {
            if (i.getId().equals(id)) {
                return i;
            }
        }
        return null;
    }
}
