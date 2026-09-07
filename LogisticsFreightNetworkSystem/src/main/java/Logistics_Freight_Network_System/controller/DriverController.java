package Logistics_Freight_Network_System.controller;

// ---------------- DriverController ----------------
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
    public Driver addDriver(@RequestBody Driver driver) {
        return driverService.create(driver);
    }

    @GetMapping("getAll")
    public List<Driver> getAllDrivers() {
        return driverService.getAll();
    }

    @GetMapping("getById")
    public Driver getById(@RequestParam Long id) {
        return driverService.getById(id);
    }

    @PutMapping("update")
    public Driver updateDriver(@RequestBody Driver driver) {
        return driverService.update(driver.getId(), driver);
    }

    @DeleteMapping("deleteById")
    public Boolean deleteById(@RequestParam Long id) {
        driverService.softDelete(id);
        return true;
    }
}
