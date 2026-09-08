package Logistics_Freight_Network_System.dto;

// ---------------- ShipmentDTO ----------------
import Logistics_Freight_Network_System.entity.Shipment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShipmentDTO {

    private Long id;
    private LocalDate shipmentDate;
    private String status;
    private Double totalWeight;
    private Long warehouseId;
    private String warehouseName;
    private Long customerId;
    private String customerName;
    private Long carrierId;
    private String carrierName;

    public static ShipmentDTO convertToDTO(Shipment entity) {
        if (entity == null) return null;
        return ShipmentDTO.builder()
                .id(entity.getId())
                .shipmentDate(entity.getShipmentDate())
                .status(entity.getStatus())
                .totalWeight(entity.getTotalWeight())
                .warehouseId(entity.getWarehouse() != null ? entity.getWarehouse().getId() : null)
                .warehouseName(entity.getWarehouse() != null ? entity.getWarehouse().getName() : null)
                .customerId(entity.getCustomer() != null ? entity.getCustomer().getId() : null)
                .customerName(entity.getCustomer() != null ? entity.getCustomer().getName() : null)
                .carrierId(entity.getCarrier() != null ? entity.getCarrier().getId() : null)
                .carrierName(entity.getCarrier() != null ? entity.getCarrier().getName() : null)
                .build();
    }

    public static List<ShipmentDTO> convertToDTO(List<Shipment> entities) {
        return entities.stream().map(ShipmentDTO::convertToDTO).collect(Collectors.toList());
    }
}

