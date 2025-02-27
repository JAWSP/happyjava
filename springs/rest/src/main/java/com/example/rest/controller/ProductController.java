package com.example.rest.controller;


import com.example.rest.domain.Product;
import com.example.rest.dto.ProductDTO;
import com.example.rest.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;

    //post
    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@Valid @RequestBody ProductDTO productDTO) {
        return ResponseEntity.status(201).body(productService.createProductService(productDTO));
    }
    //get
    @GetMapping
    public ResponseEntity<List<ProductDTO>> findAllProducts() {
        //이렇게 굳이 body로 안써도 된다고
        return ResponseEntity.ok(productService.findAllProductsService());
    }

    //get
    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> findProductById(@PathVariable(name = "id")Long id) {
        return ResponseEntity.ok().body(productService.findProductByIdService(id));
    }

    //put
    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> updateProduct(@PathVariable(name = "id")Long id, @RequestBody ProductDTO product) {
        return ResponseEntity.ok().body(productService.updateProductService(id, product));
    }

    //delete
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable(name = "id")Long id) {
        productService.deleteProductService(id);
        return ResponseEntity.ok().body("삭제 완" + id);
    }

}
