package Logistics_Freight_Network_System.dto;

// ---------------- DeliveryStopDTO ----------------
import Logistics_Freight_Network_System.entity.DeliveryStop;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryStopDTO {

    private Long id;
    private Integer sequence;
    private String address;
    private String status;
    private LocalDateTime eta;
    private Long routeId;
    private Long shipmentId;

    public static DeliveryStopDTO convertToDTO(DeliveryStop entity) {
        if (entity == null) return null;
        return DeliveryStopDTO.builder()
                .id(entity.getId())
                .sequence(entity.getSequence())
                .address(entity.getAddress())
                .status(entity.getStatus())
                .eta(entity.getEta())
                .routeId(entity.getRoute() != null ? entity.getRoute().getId() : null)
                .shipmentId(entity.getShipment() != null ? entity.getShipment().getId() : null)
                .build();
    }

    public static List<DeliveryStopDTO> convertToDTO(List<DeliveryStop> entities) {
        return entities.stream().map(DeliveryStopDTO::convertToDTO).collect(Collectors.toList());
    }
}

