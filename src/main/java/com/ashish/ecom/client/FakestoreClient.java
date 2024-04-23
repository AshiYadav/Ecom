package com.ashish.ecom.client;

import com.ashish.ecom.dto.CartResponseDTO;
import com.ashish.ecom.dto.FakestoreRessponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class FakestoreClient {

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;
    @Value("${fakestore.api.base.url}")
    private String baseUrl;
    @Value("${fakestore.api.product.path}")
    private String productUrl;

    @Value("${fakestore.api.cartUser.path}")
    private String cartUrl;

    public List<FakestoreRessponseDTO> getAllProduct(){
        String completeUrl = baseUrl.concat(productUrl);
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakestoreRessponseDTO[]> res = restTemplate.getForEntity(completeUrl,FakestoreRessponseDTO[].class);
        return List.of(res.getBody());
    }

    public FakestoreRessponseDTO getProductBasedOnID(int id){
        String completerUrl = baseUrl.concat(productUrl).concat("/"+id);
        //RestTemplateBuilder builder = new RestTemplateBuilder();
        RestTemplate template  = restTemplateBuilder.build();
        ResponseEntity<FakestoreRessponseDTO> dto = template.getForEntity(completerUrl, FakestoreRessponseDTO.class);
        return dto.getBody();

    }

    public List<CartResponseDTO> getCartBasedOnUserId(int id){
        //RestTemplateBuilder builder = new RestTemplateBuilder();
        String completeUrl = baseUrl.concat(cartUrl+id);
        RestTemplate tem = restTemplateBuilder.build();
        ResponseEntity<CartResponseDTO[]> dto = tem.getForEntity(completeUrl, CartResponseDTO[].class);
        return List.of(dto.getBody());
    }
}
