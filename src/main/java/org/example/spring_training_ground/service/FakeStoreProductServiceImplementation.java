package org.example.spring_training_ground.service;

import lombok.val;
import org.example.spring_training_ground.dtos.FakeStoreDto;
import org.example.spring_training_ground.model.Category;
import org.example.spring_training_ground.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
@Service
public class FakeStoreProductServiceImplementation implements ProductService{
    private RestTemplate restTemplate;

    @Autowired
    public FakeStoreProductServiceImplementation(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
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
        FakeStoreDto product = this.restTemplate.getForObject("https://fakestoreapi.com/products/" + id, FakeStoreDto.class);
        assert product != null;
        return convertDtoToProduct(product);
    }

    @Override
    public List<Product> getProducts() {
        return null;
    }
}
