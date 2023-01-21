package co.com.nexsys.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Product {
    private Integer id;
    private String title;
    private Integer price;
    private String description;
    private Category category;
    private List<String> images;
    private String creationAt;
    private String updatedAt;
}
