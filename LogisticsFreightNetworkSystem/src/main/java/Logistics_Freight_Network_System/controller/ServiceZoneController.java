package Logistics_Freight_Network_System.controller;

// ---------------- ServiceZoneController ----------------
import Logistics_Freight_Network_System.entity.ServiceZone;
import Logistics_Freight_Network_System.service.ServiceZoneService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/service-zones")
public class ServiceZoneController {

    private final ServiceZoneService serviceZoneService;

    public ServiceZoneController(ServiceZoneService serviceZoneService) {
        this.serviceZoneService = serviceZoneService;
    }

    @GetMapping
    public List<ServiceZone> getAll() {
        return serviceZoneService.getAll();
    }

    @GetMapping("/{id}")
    public ServiceZone getById(@PathVariable Long id) {
        return serviceZoneService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ServiceZone create(@RequestBody ServiceZone serviceZone) {
        return serviceZoneService.create(serviceZone);
    }

    @PutMapping("/{id}")
    public ServiceZone update(@PathVariable Long id, @RequestBody ServiceZone serviceZone) {
        return serviceZoneService.update(id, serviceZone);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void softDelete(@PathVariable Long id) {
        serviceZoneService.softDelete(id);
    }
}