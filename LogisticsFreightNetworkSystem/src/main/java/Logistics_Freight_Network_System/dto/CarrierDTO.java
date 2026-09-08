package Logistics_Freight_Network_System.dto;

// ---------------- CarrierDTO (hides contactEmail, phoneNumber) ----------------
import Logistics_Freight_Network_System.entity.Carrier;
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
public class CarrierDTO {

    private Long id;
    private String name;
    private String country;

    public static CarrierDTO convertToDTO(Carrier entity) {
        if (entity == null) return null;
        return CarrierDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .country(entity.getCountry())
                .build();
    }

    public static List<CarrierDTO> convertToDTO(List<Carrier> entities) {
        return entities.stream().map(CarrierDTO::convertToDTO).collect(Collectors.toList());
    }
}

