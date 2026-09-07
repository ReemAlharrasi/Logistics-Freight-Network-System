package Logistics_Freight_Network_System.controller;

// ---------------- VehicleController ----------------
import Logistics_Freight_Network_System.entity.Vehicle;
import Logistics_Freight_Network_System.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("vehicle")
public class VehicleController {

    VehicleService vehicleService;

    @Autowired
    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping("add")
    public Vehicle addVehicle(@RequestBody Vehicle vehicle) {
        return vehicleService.create(vehicle);
    }

    @GetMapping("getAll")
    public List<Vehicle> getAllVehicles() {
        return vehicleService.getAll();
    }

    @GetMapping("getById")
    public Vehicle getById(@RequestParam Long id) {
        return vehicleService.getById(id);
    }

    @PutMapping("update")
    public Vehicle updateVehicle(@RequestBody Vehicle vehicle) {
        return vehicleService.update(vehicle.getId(), vehicle);
    }

    @DeleteMapping("deleteById")
    public Boolean deleteById(@RequestParam Long id) {
        vehicleService.softDelete(id);
        return true;
    }
}
