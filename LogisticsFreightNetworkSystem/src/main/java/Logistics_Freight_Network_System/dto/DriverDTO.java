package Logistics_Freight_Network_System.dto;

// ---------------- DriverDTO (hides licenseNumber, phoneNumber) ----------------
import Logistics_Freight_Network_System.entity.Driver;
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
public class DriverDTO {

    private Long id;
    private String name;
    private String status;
    private Long carrierId;
    private String carrierName;

    public static DriverDTO convertToDTO(Driver entity) {
        if (entity == null) return null;
        return DriverDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .status(entity.getStatus())
                .carrierId(entity.getCarrier() != null ? entity.getCarrier().getId() : null)
                .carrierName(entity.getCarrier() != null ? entity.getCarrier().getName() : null)
                .build();
    }

    public static List<DriverDTO> convertToDTO(List<Driver> entities) {
        return entities.stream().map(DriverDTO::convertToDTO).collect(Collectors.toList());
    }
}
