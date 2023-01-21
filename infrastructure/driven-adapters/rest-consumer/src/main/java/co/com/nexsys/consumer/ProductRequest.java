package co.com.nexsys.consumer;

import co.com.nexsys.model.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class ProductRequest {
    private String title;
    private Integer price;
    private String description;
    private Integer categoryId;
    private List<String> images;
}
