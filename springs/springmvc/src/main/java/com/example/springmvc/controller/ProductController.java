package com.example.springmvc.controller;

import com.example.springmvc.domain.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class ProductController {
    @GetMapping("product")
    public String getAll(Model model) {
       List<Product> lists = Arrays.asList(
               new Product(0, "a", 10),
               new Product(1, "b", 1212),
               new Product(0, "c", 2147483647)

       );
       model.addAttribute("lists", lists);
        return "product";
    }
}
