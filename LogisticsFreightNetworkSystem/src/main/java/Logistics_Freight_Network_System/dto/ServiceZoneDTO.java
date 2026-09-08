package Logistics_Freight_Network_System.dto;

// ---------------- ServiceZoneDTO ----------------
import Logistics_Freight_Network_System.entity.ServiceZone;
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
public class ServiceZoneDTO {

    private Long id;
    private String name;
    private String region;
    private Double baseRate;

    public static ServiceZoneDTO convertToDTO(ServiceZone entity) {
        if (entity == null) return null;
        return ServiceZoneDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .region(entity.getRegion())
                .baseRate(entity.getBaseRate())
                .build();
    }

    public static List<ServiceZoneDTO> convertToDTO(List<ServiceZone> entities) {
        return entities.stream().map(ServiceZoneDTO::convertToDTO).collect(Collectors.toList());
    }
}
