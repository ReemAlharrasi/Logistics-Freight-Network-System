package Logistics_Freight_Network_System.dto;

// ---------------- WarehouseDTO ----------------
import Logistics_Freight_Network_System.entity.Warehouse;
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
public class WarehouseDTO {

    private Long id;
    private String name;
    private String location;
    private Integer capacity;

    public static WarehouseDTO convertToDTO(Warehouse entity) {
        if (entity == null) return null;
        return WarehouseDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .location(entity.getLocation())
                .capacity(entity.getCapacity())
                .build();
    }

    public static List<WarehouseDTO> convertToDTO(List<Warehouse> entities) {
        return entities.stream().map(WarehouseDTO::convertToDTO).collect(Collectors.toList());
    }
}