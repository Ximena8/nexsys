package co.com.nexsys.consumer;

import co.com.nexsys.model.Category;
import co.com.nexsys.model.Product;
import co.com.nexsys.model.gateways.IProductGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RestConsumer implements IProductGateway {

    private final WebClient client;

    @Override
    public Mono<Product> createProduct(Product product) {
        ProductRequest request = ProductRequest.builder()
                .title(product.getTitle())
                .price(product.getPrice())
                .description(product.getDescription())
                .categoryId(product.getCategory().getId())
                .images(product.getImages())
                .build();

        return client
                .post()
                .uri("/products/")
                .body(Mono.just(request), ProductRequest.class)
                .retrieve()
                .bodyToMono(Product.class);
    }

    @Override
    public Flux<Product> getAllProducts() {
        return client
                .get()
                .uri("/products")
                .retrieve()
                .bodyToFlux(Product.class);
    }

    @Override
    public Flux<Category> getAllCategories() {
        return client
                .get()
                .uri("/categories")
                .retrieve()
                .bodyToFlux(Category.class);
    }

}