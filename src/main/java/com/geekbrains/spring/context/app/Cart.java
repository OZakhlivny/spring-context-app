package com.geekbrains.spring.context.app;

import org.springframework.aop.scope.ScopedProxyUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
@Scope("prototype")
public class Cart {
    public static Long countId = 0L;
    private Long id;
    private List<Product> productList;

    @PostConstruct
    public void init() {
        productList = new ArrayList<>();
        id = ++Cart.countId;
    }

    public void addToCart(ProductRepository productRepository, long productId){
        Product product = productRepository.findItemById(productId);
        if(product != null) productList.add(product);
        else System.out.printf("Product with id = %d doesn't exist!\n", productId);
    }

    public void deleteFromCart(long productId){
        for (Product i : productList) {
            if (i.getId().equals(productId)) {
                productList.remove(i);
                break;
            }
        }
    }

    public long getId(){ return id;}

    public List<Product> showCart() {
        return Collections.unmodifiableList(productList);
    }

}
