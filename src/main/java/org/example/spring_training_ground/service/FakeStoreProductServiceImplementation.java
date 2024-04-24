package org.example.spring_training_ground.service;

import lombok.val;
import org.example.spring_training_ground.dtos.FakeStoreDto;
import org.example.spring_training_ground.model.Category;
import org.example.spring_training_ground.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;
@Service
public class FakeStoreProductServiceImplementation implements ProductService{
//    private RestTemplate restTemplate;
    private WebClient webClient;
    @Autowired
    public FakeStoreProductServiceImplementation(WebClient webClient) {
        this.webClient = webClient;
    }

    private Product convertDtoToProduct(FakeStoreDto dto){
        Product product=new Product();
        product.setId(dto.getId());
        product.setTitle(dto.getTitle());
        product.setPrice(dto.getPrice());
        product.setDescription(dto.getDescription());
        product.setImage(dto.getImage());
        Category category=new Category();
        category.setName(dto.getCategory());
        product.setCategory(category);
        return product;
    }
    @Override
    public Product geProductById(long id) {
//        FakeStoreDto product = this.restTemplate.getForObject("https://fakestoreapi.com/products/" + id, FakeStoreDto.class);
        FakeStoreDto product=webClient.get()
                .uri("https://fakestoreapi.com/products/"+id)
                .retrieve()
                .bodyToMono(FakeStoreDto.class).block();
        assert product != null;
        return convertDtoToProduct(product);
    }

    @Override
    public List<Product> getProducts() {
        FakeStoreDto[] productsDto=webClient.get()
                                            .uri("https://fakestoreapi.com/products/")
                                            .retrieve()
                                            .bodyToMono(FakeStoreDto[].class).block();

        List<Product> products=new ArrayList<>();

        for(FakeStoreDto dto: productsDto){
            Product product=convertDtoToProduct(dto);
            products.add(product);
        }
        return products;
    }
}
