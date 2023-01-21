package co.com.nexsys.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Category {
    private Integer id;
    private String name;
    private String image;
    private String creationAt;
    private String updatedAt;
}
