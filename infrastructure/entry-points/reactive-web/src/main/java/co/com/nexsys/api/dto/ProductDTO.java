package co.com.nexsys.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class ProductDTO {
    private Integer pid;
    private String name;
    private Integer priceFinal;
    private String description;
}
