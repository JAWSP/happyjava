package com.example.rest.service;

import com.example.rest.domain.Product;
import com.example.rest.dto.ProductDTO;
import com.example.rest.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final ProductRepository productRepository;
    //post
    @Transactional
    public ProductDTO createProductService(ProductDTO productDTO) {
        try {
            //DTO를 엔티티로 변환
           //Product product = new Product(null, productDTO.getName(), productDTO.getPrice());
            //DTO를 엔티티로 변환하고 저장하기
            Product createProduct = productRepository.save(Product.formDTO(productDTO));
            return ProductDTO.toDTO(createProduct);
        } catch (RuntimeException e) {
            throw new RuntimeException("생성안됨 ㅅㄱ", e);
        }
    }

    //get
    @Transactional(readOnly = true)
    public List<ProductDTO> findAllProductsService() {
        return productRepository.findAll()
                .stream()
                .map(ProductDTO::toDTO)
                .collect(Collectors.toList());
    }

    //get
    @Transactional(readOnly = true)
    public ProductDTO findProductByIdService(Long id) {
        if (!productRepository.existsById(id))
            throw new IllegalArgumentException("그거 없는데?");
        return ProductDTO.toDTO(productRepository.findById(id).get());
    }

    //put
    @Transactional
    public ProductDTO updateProductService(Long id, ProductDTO product) {
        if (!productRepository.existsById(id))
            throw new IllegalArgumentException("그거 없는데?");
        Product target = productRepository.findById(id).get();
        if (product.getName() != null)
            target.setName(product.getName());
        //얘도 널체크를 하고싶다면 double대신 Double로 쓰던
        //이렇게도 됨
        //Optional.ofNullable(product.getPrice()).ifPresent(product::setPrice);
        //혹은
        if (product.getPrice() != 0.00)
            target.setPrice(product.getPrice());
        return ProductDTO.toDTO(target);
    }

    //delete
    @Transactional
    public void deleteProductService(Long id) {
        if (!productRepository.existsById(id))
            throw new IllegalArgumentException("그거 없는데?");
        productRepository.deleteById(id);
    }
}
