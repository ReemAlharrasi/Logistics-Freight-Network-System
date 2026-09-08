package Logistics_Freight_Network_System.dto;

// ---------------- CustomerDTO (hides email, phoneNumber) ----------------
import Logistics_Freight_Network_System.entity.Customer;
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
public class CustomerDTO {

    private Long id;
    private String name;
    private String type;

    public static CustomerDTO convertToDTO(Customer entity) {
        if (entity == null) return null;
        return CustomerDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .type(entity.getType())
                .build();
    }

    public static List<CustomerDTO> convertToDTO(List<Customer> entities) {
        return entities.stream().map(CustomerDTO::convertToDTO).collect(Collectors.toList());
    }
}
