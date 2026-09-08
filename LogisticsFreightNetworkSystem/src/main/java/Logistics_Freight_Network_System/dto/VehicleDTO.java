package Logistics_Freight_Network_System.dto;

// ---------------- VehicleDTO ----------------
import Logistics_Freight_Network_System.entity.Vehicle;
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
public class VehicleDTO {

    private Long id;
    private String plateNumber;
    private String type;
    private Double capacityKg;
    private String status;
    private Long carrierId;
    private String carrierName;

    public static VehicleDTO convertToDTO(Vehicle entity) {
        if (entity == null) return null;
        return VehicleDTO.builder()
                .id(entity.getId())
                .plateNumber(entity.getPlateNumber())
                .type(entity.getType())
                .capacityKg(entity.getCapacityKg())
                .status(entity.getStatus())
                .carrierId(entity.getCarrier() != null ? entity.getCarrier().getId() : null)
                .carrierName(entity.getCarrier() != null ? entity.getCarrier().getName() : null)
                .build();
    }

    public static List<VehicleDTO> convertToDTO(List<Vehicle> entities) {
        return entities.stream().map(VehicleDTO::convertToDTO).collect(Collectors.toList());
    }
}
