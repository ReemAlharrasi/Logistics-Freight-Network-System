package Logistics_Freight_Network_System.dto;

// ---------------- AddressDTO ----------------
import Logistics_Freight_Network_System.entity.Address;
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
public class AddressDTO {

    private Long id;
    private String street;
    private String city;
    private String postalCode;
    private String country;
    private Long customerId;
    private Long serviceZoneId;
    private String serviceZoneName;

    public static AddressDTO convertToDTO(Address entity) {
        if (entity == null) return null;
        return AddressDTO.builder()
                .id(entity.getId())
                .street(entity.getStreet())
                .city(entity.getCity())
                .postalCode(entity.getPostalCode())
                .country(entity.getCountry())
                .customerId(entity.getCustomer() != null ? entity.getCustomer().getId() : null)
                .serviceZoneId(entity.getServiceZone() != null ? entity.getServiceZone().getId() : null)
                .serviceZoneName(entity.getServiceZone() != null ? entity.getServiceZone().getName() : null)
                .build();
    }

    public static List<AddressDTO> convertToDTO(List<Address> entities) {
        return entities.stream().map(AddressDTO::convertToDTO).collect(Collectors.toList());
    }
}
