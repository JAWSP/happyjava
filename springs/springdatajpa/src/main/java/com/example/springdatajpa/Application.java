package com.example.springdatajpa;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.weaver.ast.Or;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(SpringdatajpaApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(CustomerRepository repository) {
        return args -> {
            repository.findAll().forEach(customer -> {log.info(customer.getName());});
            Customer customer = getCustomer(1L, repository);//repository.findById(1L).get();
//            List<Order> o = customer.getOrders();
//            log.info(o.isEmpty()+"");
//            if (customer.getOrders().isEmpty())
//                log.info("응 없어");
//            repository.FindUserToSelect("홍길동").forEach(customer -> log.info(customer.getName()));
//            repository.FindEmailToSelect("hong@example.com").forEach(customer -> log.info(customer.toString()));
//            repository.FindNameLike("홍").forEach(customer -> log.info(customer.toString()));
//            repository.FindCustomerAJae().forEach(customer -> log.info(customer.toString()));
//            repository.FindCustomerWithOrderCount().forEach(objects -> {
//                log.info(objects[0].toString() + " + " + objects[1]);
//            });
//            Pageable pageable = PageRequest.of(0, 3);
//            repository.findByEmailContaining("@example.com", pageable).forEach(customer -> log.info(customer.toString()));
        };
    }
    @Transactional
    public Customer getCustomer(Long id, CustomerRepository repository) {
        Customer customer = repository.findById(id).get();
        log.info("짠");
        List<Order> orders = customer.getOrders();
        orders.forEach(order -> log.info(order.getProduct()));
        return customer;
    }
}
