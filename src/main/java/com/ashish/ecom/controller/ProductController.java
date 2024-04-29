package com.ashish.ecom.controller;

import com.ashish.ecom.dto.ProductRequestDTO;
import com.ashish.ecom.dto.ProductResponseDTO;
import com.ashish.ecom.service.SampleProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
//    @Qualifier("productServiceImpl")
    private SampleProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductResponseDTO>> getProduct(){
        List<ProductResponseDTO> product =  productService.getAllProduct();
        return ResponseEntity.ok(product);

    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> getProductBasedOnID(@PathVariable("id") UUID id){
        ProductResponseDTO product = productService.getProduct(id);
        return ResponseEntity.ok(product);
    }

    @PostMapping("/createProduct")
    public ResponseEntity<ProductResponseDTO> createProduct(@RequestBody ProductRequestDTO product){
        ProductResponseDTO saveProduct = productService.createProduct(product);
        return ResponseEntity.ok(saveProduct);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ProductResponseDTO> updateProduct(@PathVariable("id") UUID id, @RequestBody ProductRequestDTO product){
        return ResponseEntity.ok(productService.updateProduct(product,id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteProduct(@PathVariable("id") UUID id){
        return ResponseEntity.ok(productService.deleteProduct(id));
    }

    @GetMapping("/{price1}/{price2}")
    public ResponseEntity<List<ProductResponseDTO>> getProductBetween(@PathVariable("price1") double p1, @PathVariable("price2") double p2){
        return  ResponseEntity.ok(productService.getProductBetween(p1,p2));
    }

    @GetMapping("/title/{name}")
    public  ResponseEntity<ProductResponseDTO> getProductBasedOnTitle(@PathVariable("name") String title){
        return ResponseEntity.ok(productService.getProductBasedOnTitle(title));
    }

    @GetMapping("/titlelike/{name}")
    public  ResponseEntity<List<ProductResponseDTO>> getProductBasedOnTitleLike(@PathVariable("name") String title){
        return ResponseEntity.ok(productService.getProductBasedOnTitleLike(title));
    }
}
