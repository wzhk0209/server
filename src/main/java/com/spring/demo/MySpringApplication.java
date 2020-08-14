package com.spring.demo;

import com.spring.demo.repository.BaseRepositoryFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableAutoConfiguration
@EnableJpaRepositories(basePackages = {"com.spring.demo.dao"}, repositoryFactoryBeanClass = BaseRepositoryFactoryBean.class)
@ComponentScan(basePackages = {"com.spring.demo.**"})
@EntityScan(basePackages = "com.spring.demo.entity")
@EnableTransactionManagement
public class MySpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(MySpringApplication.class);
    }
}
