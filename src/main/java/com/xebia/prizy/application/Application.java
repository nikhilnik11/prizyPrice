package com.xebia.prizy.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.xebia.prizy.Repository.ProductRepository;
import com.xebia.prizy.Repository.SurveyProductRepository;
import com.xebia.prizy.model.Product;
import com.xebia.prizy.model.SurveyProduct;

@SpringBootApplication
@ComponentScan(basePackages="com.xebia.*")
@EnableJpaRepositories(basePackageClasses={ProductRepository.class, SurveyProductRepository.class})
@EntityScan(basePackageClasses={Product.class, SurveyProduct.class})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
