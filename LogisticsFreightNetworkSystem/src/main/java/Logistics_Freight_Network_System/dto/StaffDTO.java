package Logistics_Freight_Network_System.dto;

// ---------------- StaffDTO (hides phoneNumber) ----------------
import Logistics_Freight_Network_System.entity.Staff;
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
public class StaffDTO {

    private Long id;
    private String name;
    private String role;
    private Long warehouseId;
    private String warehouseName;

    public static StaffDTO convertToDTO(Staff entity) {
        if (entity == null) return null;
        return StaffDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .role(entity.getRole())
                .warehouseId(entity.getWarehouse() != null ? entity.getWarehouse().getId() : null)
                .warehouseName(entity.getWarehouse() != null ? entity.getWarehouse().getName() : null)
                .build();
    }

    public static List<StaffDTO> convertToDTO(List<Staff> entities) {
        return entities.stream().map(StaffDTO::convertToDTO).collect(Collectors.toList());
    }
}
