package com.rams.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DemoConfiguration {

    @Bean
    public InventoryService getInventoryService() {
        return new InventoryService();
    }

    @Bean
    public ProductService getProductService() {
        return new ProductService();
    }
}
