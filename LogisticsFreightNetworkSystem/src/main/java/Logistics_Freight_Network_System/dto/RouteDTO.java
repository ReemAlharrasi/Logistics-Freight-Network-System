package Logistics_Freight_Network_System.dto;

// ---------------- RouteDTO ----------------
import Logistics_Freight_Network_System.entity.Route;
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
public class RouteDTO {

    private Long id;
    private LocalDate routeDate;
    private String origin;
    private String destination;
    private String status;
    private Long vehicleId;
    private String vehiclePlateNumber;
    private Long driverId;
    private String driverName;

    public static RouteDTO convertToDTO(Route entity) {
        if (entity == null) return null;
        return RouteDTO.builder()
                .id(entity.getId())
                .routeDate(entity.getRouteDate())
                .origin(entity.getOrigin())
                .destination(entity.getDestination())
                .status(entity.getStatus())
                .vehicleId(entity.getVehicle() != null ? entity.getVehicle().getId() : null)
                .vehiclePlateNumber(entity.getVehicle() != null ? entity.getVehicle().getPlateNumber() : null)
                .driverId(entity.getDriver() != null ? entity.getDriver().getId() : null)
                .driverName(entity.getDriver() != null ? entity.getDriver().getName() : null)
                .build();
    }

    public static List<RouteDTO> convertToDTO(List<Route> entities) {
        return entities.stream().map(RouteDTO::convertToDTO).collect(Collectors.toList());
    }
}
