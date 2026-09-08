package Logistics_Freight_Network_System.dto;

// ---------------- InvoiceDTO ----------------
import Logistics_Freight_Network_System.entity.Invoice;
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
public class InvoiceDTO {

    private Long id;
    private Double amount;
    private String status;
    private LocalDate issuedDate;
    private Long shipmentId;
    private Long customerId;

    public static InvoiceDTO convertToDTO(Invoice entity) {
        if (entity == null) return null;
        return InvoiceDTO.builder()
                .id(entity.getId())
                .amount(entity.getAmount())
                .status(entity.getStatus())
                .issuedDate(entity.getIssuedDate())
                .shipmentId(entity.getShipment() != null ? entity.getShipment().getId() : null)
                .customerId(entity.getCustomer() != null ? entity.getCustomer().getId() : null)
                .build();
    }

    public static List<InvoiceDTO> convertToDTO(List<Invoice> entities) {
        return entities.stream().map(InvoiceDTO::convertToDTO).collect(Collectors.toList());
    }
}
