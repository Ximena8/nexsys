package co.com.nexsys.usecase;

import co.com.nexsys.model.Category;
import co.com.nexsys.model.Product;
import co.com.nexsys.model.gateways.IProductGateway;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
public class ProductUseCase {

    private final IProductGateway iProductGateway;

    public Mono<Product> createProduct(Product product) {
        return iProductGateway.createProduct(product);
    }

    public Flux<Product> getAllProducts() {
        return iProductGateway.getAllProducts();
    }

    public Flux<Category> getAllCategories() {
        return iProductGateway.getAllCategories();
    }


}