package Logistics_Freight_Network_System.controller;

// ---------------- ServiceZoneController ----------------
import Logistics_Freight_Network_System.dto.ServiceZoneDTO;
import Logistics_Freight_Network_System.entity.ServiceZone;
import Logistics_Freight_Network_System.service.ServiceZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("serviceZone")
public class ServiceZoneController {

    ServiceZoneService serviceZoneService;

    @Autowired
    public ServiceZoneController(ServiceZoneService serviceZoneService) {
        this.serviceZoneService = serviceZoneService;
    }

    @PostMapping("add")
    public ServiceZoneDTO addServiceZone(@RequestBody ServiceZone serviceZone) {
        return ServiceZoneDTO.convertToDTO(serviceZoneService.create(serviceZone));
    }

    @GetMapping("getAll")
    public List<ServiceZoneDTO> getAllServiceZones() {
        return ServiceZoneDTO.convertToDTO(serviceZoneService.getAll());
    }

    @GetMapping("getById")
    public ServiceZoneDTO getById(@RequestParam Long id) {
        return ServiceZoneDTO.convertToDTO(serviceZoneService.getById(id));
    }

    @PutMapping("update")
    public ServiceZoneDTO updateServiceZone(@RequestBody ServiceZone serviceZone) {
        return ServiceZoneDTO.convertToDTO(serviceZoneService.update(serviceZone.getId(), serviceZone));
    }

    @DeleteMapping("deleteById")
    public Boolean deleteById(@RequestParam Long id) {
        serviceZoneService.softDelete(id);
        return true;
    }
}