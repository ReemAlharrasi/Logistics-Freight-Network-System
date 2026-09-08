package Logistics_Freight_Network_System.dto;

// ---------------- TrackingEventDTO ----------------
import Logistics_Freight_Network_System.entity.TrackingEvent;
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
public class TrackingEventDTO {

    private Long id;
    private LocalDateTime eventTime;
    private String location;
    private String status;
    private String note;
    private Long shipmentId;

    public static TrackingEventDTO convertToDTO(TrackingEvent entity) {
        if (entity == null) return null;
        return TrackingEventDTO.builder()
                .id(entity.getId())
                .eventTime(entity.getEventTime())
                .location(entity.getLocation())
                .status(entity.getStatus())
                .note(entity.getNote())
                .shipmentId(entity.getShipment() != null ? entity.getShipment().getId() : null)
                .build();
    }

    public static List<TrackingEventDTO> convertToDTO(List<TrackingEvent> entities) {
        return entities.stream().map(TrackingEventDTO::convertToDTO).collect(Collectors.toList());
    }
}

