package co.com.nexsys.model.gateways;

import co.com.nexsys.model.Category;
import co.com.nexsys.model.Product;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.util.List;

public interface IProductGateway {

    Mono<Product> createProduct(Product product);

    Flux<Product> getAllProducts();

    Flux<Category> getAllCategories();

}
