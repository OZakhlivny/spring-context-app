package com.geekbrains.spring.context.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        ProductRepository productRepository = context.getBean("productRepository", ProductRepository.class);

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        while(!exit) {
            Cart cart = context.getBean("cart", Cart.class);
            boolean newCart = false;
            while (!newCart && !exit) {
                System.out.println("Input command (/add <productId>, /delete <productId>, /show, /new, /exit):");
                String command = scanner.nextLine();
                String[] commandParts = command.split(" ");
                switch (commandParts[0]) {
                    case "/add": {
                        if (commandParts.length > 1) {
                            cart.addToCart(productRepository, Long.parseLong(commandParts[1]));
                        }
                        break;
                    }
                    case "/delete": {
                        if (commandParts.length > 1) {
                            cart.deleteFromCart(Long.parseLong(commandParts[1]));
                        }
                        break;
                    }
                    case "/show": {
                        System.out.println("Cart " + cart.getId() + ": " + cart.showCart());
                        break;
                    }
                    case "/new": {
                        newCart = true;
                        break;
                    }
                    case "/exit":{
                        exit = true;
                        break;
                    }
                    default: {
                        System.out.println("Unknown command!");
                    }
                }
            }
        }
        scanner.close();
        context.close();
    }
}
