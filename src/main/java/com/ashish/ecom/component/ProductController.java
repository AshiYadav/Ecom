package com.ashish.ecom.component;

import com.ashish.ecom.dto.FakestoreRessponseDTO;
import com.ashish.ecom.entity.Product;
import com.ashish.ecom.mapper.ProductEntityToProductResponseDTO;
import com.ashish.ecom.service.ProductService;
import com.ashish.ecom.service.SampleProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
    public ResponseEntity getProduct(){
        List<Product> product =  productService.getAllProduct();
        return ResponseEntity.ok(product);

    }

    @GetMapping("/{id}")
    public ResponseEntity getProductBasedOnID(@PathVariable("id") UUID id){
        Product product = productService.getProduct(id);
        return ResponseEntity.ok(product);
    }

    @PostMapping("/createProduct")
    public ResponseEntity createProduct(@RequestBody Product product){
        Product saveProduct = productService.createProduct(product);
        return ResponseEntity.ok(saveProduct);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateProduct(@PathVariable("id") UUID id, @RequestBody Product product){
        return ResponseEntity.ok(productService.updateProduct(product,id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteProduct(@PathVariable("id") UUID id){
        return ResponseEntity.ok(productService.deleteProduct(id));
    }

    @GetMapping("/{price1}/{price2}")
    public ResponseEntity getProductBetween(@PathVariable("price1") double p1, @PathVariable("price2") double p2){
        return  ResponseEntity.ok(productService.getProductBetween(p1,p2));
    }

    @GetMapping("/title/{name}")
    public  ResponseEntity getProductBasedOnTitle(@PathVariable("name") String title){
        return ResponseEntity.ok(productService.getProductBasedOnTitle(title));
    }

    @GetMapping("/titlelike/{name}")
    public  ResponseEntity getProductBasedOnTitleLike(@PathVariable("name") String title){
        return ResponseEntity.ok(productService.getProductBasedOnTitleLike(title));
    }
}
