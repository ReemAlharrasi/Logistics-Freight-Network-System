package Logistics_Freight_Network_System.dto;

// ---------------- InventoryItemDTO ----------------
import Logistics_Freight_Network_System.entity.InventoryItem;
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
public class InventoryItemDTO {

    private Long id;
    private Integer quantity;
    private String shelfLocation;
    private Long warehouseId;
    private String warehouseName;
    private Long productId;
    private String productName;

    public static InventoryItemDTO convertToDTO(InventoryItem entity) {
        if (entity == null) return null;
        return InventoryItemDTO.builder()
                .id(entity.getId())
                .quantity(entity.getQuantity())
                .shelfLocation(entity.getShelfLocation())
                .warehouseId(entity.getWarehouse() != null ? entity.getWarehouse().getId() : null)
                .warehouseName(entity.getWarehouse() != null ? entity.getWarehouse().getName() : null)
                .productId(entity.getProduct() != null ? entity.getProduct().getId() : null)
                .productName(entity.getProduct() != null ? entity.getProduct().getName() : null)
                .build();
    }

    public static List<InventoryItemDTO> convertToDTO(List<InventoryItem> entities) {
        return entities.stream().map(InventoryItemDTO::convertToDTO).collect(Collectors.toList());
    }
}
