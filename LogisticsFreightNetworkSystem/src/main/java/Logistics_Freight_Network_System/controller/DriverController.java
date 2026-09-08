package Logistics_Freight_Network_System.controller;

// ---------------- DriverController ----------------
import Logistics_Freight_Network_System.dto.DriverDTO;
import Logistics_Freight_Network_System.entity.Driver;
import Logistics_Freight_Network_System.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("driver")
public class DriverController {

    DriverService driverService;

    @Autowired
    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    @PostMapping("add")
    public DriverDTO addDriver(@RequestBody Driver driver) {
        return DriverDTO.convertToDTO(driverService.create(driver));
    }

    @GetMapping("getAll")
    public List<DriverDTO> getAllDrivers() {
        return DriverDTO.convertToDTO(driverService.getAll());
    }

    @GetMapping("getById")
    public DriverDTO getById(@RequestParam Long id) {
        return DriverDTO.convertToDTO(driverService.getById(id));
    }

    @PutMapping("update")
    public DriverDTO updateDriver(@RequestBody Driver driver) {
        return DriverDTO.convertToDTO(driverService.update(driver.getId(), driver));
    }

    @DeleteMapping("deleteById")
    public Boolean deleteById(@RequestParam Long id) {
        driverService.softDelete(id);
        return true;
    }
}