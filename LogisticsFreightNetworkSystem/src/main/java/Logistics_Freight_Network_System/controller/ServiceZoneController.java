package Logistics_Freight_Network_System.controller;

// ---------------- ServiceZoneController ----------------
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
    public ServiceZone addServiceZone(@RequestBody ServiceZone serviceZone) {
        return serviceZoneService.create(serviceZone);
    }

    @GetMapping("getAll")
    public List<ServiceZone> getAllServiceZones() {
        return serviceZoneService.getAll();
    }

    @GetMapping("getById")
    public ServiceZone getById(@RequestParam Long id) {
        return serviceZoneService.getById(id);
    }

    @PutMapping("update")
    public ServiceZone updateServiceZone(@RequestBody ServiceZone serviceZone) {
        return serviceZoneService.update(serviceZone.getId(), serviceZone);
    }

    @DeleteMapping("deleteById")
    public Boolean deleteById(@RequestParam Long id) {
        serviceZoneService.softDelete(id);
        return true;
    }
}