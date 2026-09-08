package Logistics_Freight_Network_System.dto;

import Logistics_Freight_Network_System.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

    private Long id;
    private String name;
    private String sku;
    private Double weightKg;
    private String category;

    public static ProductDTO convertToDTO(Product entity) {
        if (entity == null) return null;
        return ProductDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .sku(entity.getSku())
                .weightKg(entity.getWeightKg())
                .category(entity.getCategory())
                .build();
    }

    public static List<ProductDTO> convertToDTO(List<Product> entities) {
        return entities.stream().map(ProductDTO::convertToDTO).collect(Collectors.toList());
    }
}