package co.com.nexsys.api;

import co.com.nexsys.api.dto.CategoryDTO;
import co.com.nexsys.api.dto.ProductDTO;
import co.com.nexsys.api.dto.ProductRequestDTO;
import co.com.nexsys.api.dto.ProductResponseDTO;
import co.com.nexsys.model.Category;
import co.com.nexsys.model.Product;
import co.com.nexsys.usecase.ProductUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.net.URI;

import  static co.com.nexsys.api.helper.ProductBuilder.getProducts;
import  static co.com.nexsys.api.helper.ProductBuilder.getCategories;
import  static co.com.nexsys.api.helper.ProductBuilder.getRequestProduct;

@Component
@RequiredArgsConstructor
public class Handler {

    private final ProductUseCase useCase;

    public Mono<ServerResponse> listProducts(ServerRequest serverRequest) {
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(getProducts(useCase.getAllProducts()), ProductDTO.class);
    }

    public Mono<ServerResponse> listCategories(ServerRequest serverRequest) {
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(getCategories(useCase.getAllCategories()), CategoryDTO.class);
    }

    public Mono<ServerResponse> addProduct(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(ProductRequestDTO.class)
                .flatMap(p -> useCase.createProduct(getRequestProduct(p))
                        .flatMap(response -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                                .body(Mono.just(ProductResponseDTO.builder()
                                                .pid(response.getId()).build()),ProductResponseDTO.class)));


    }


}
