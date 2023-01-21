package co.com.nexsys.api.helper;

import co.com.nexsys.api.dto.CategoryDTO;
import co.com.nexsys.api.dto.ProductDTO;
import co.com.nexsys.api.dto.ProductRequestDTO;
import co.com.nexsys.model.Category;
import co.com.nexsys.model.Product;
import reactor.core.publisher.Flux;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ProductBuilder {

    public static Flux<ProductDTO> getProducts(Flux<Product> products) {

        return products.map(p->ProductDTO.builder()
                .description(p.getDescription())
                .name(p.getTitle())
                .pid(p.getId())
                .priceFinal(p.getPrice())
                .build());
    }

    public static Flux<CategoryDTO> getCategories(Flux<Category> categories) {
        return categories
                .map(c->CategoryDTO.builder()
                        .cid(c.getId())
                        .title(c.getName())
                        .build());
    }

    public static Product getRequestProduct(ProductRequestDTO product) {

        return Product.builder()
                .title(product.getName())
                .price(product.getPriceFinal())
                .description(product.getDescription())
                .category(Category.builder()
                        .id(product.getCategoryId())
                        .build())
                .images(List.of(product.getImageUrl()))
                .build();
    }
}
