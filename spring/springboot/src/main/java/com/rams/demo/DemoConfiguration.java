package com.rams.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DemoConfiguration {

    @Bean
    private InventoryService getInventoryService() {
        return new InventoryService();
    }

    @Bean
    private ProductService getProductService() {
        return new ProductService();
    }
}
