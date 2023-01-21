package co.com.nexsys.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class ProductRequestDTO {

    private String name;
    private Integer priceFinal;
    private String description;
    private Integer categoryId;
    private String imageUrl;
}
