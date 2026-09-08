package Logistics_Freight_Network_System.dto;

// ---------------- ShipmentItemDTO ----------------
import Logistics_Freight_Network_System.entity.ShipmentItem;
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
public class ShipmentItemDTO {

    private Long id;
    private Integer quantity;
    private Long shipmentId;
    private Long productId;
    private String productName;

    public static ShipmentItemDTO convertToDTO(ShipmentItem entity) {
        if (entity == null) return null;
        return ShipmentItemDTO.builder()
                .id(entity.getId())
                .quantity(entity.getQuantity())
                .shipmentId(entity.getShipment() != null ? entity.getShipment().getId() : null)
                .productId(entity.getProduct() != null ? entity.getProduct().getId() : null)
                .productName(entity.getProduct() != null ? entity.getProduct().getName() : null)
                .build();
    }

    public static List<ShipmentItemDTO> convertToDTO(List<ShipmentItem> entities) {
        return entities.stream().map(ShipmentItemDTO::convertToDTO).collect(Collectors.toList());
    }
}

