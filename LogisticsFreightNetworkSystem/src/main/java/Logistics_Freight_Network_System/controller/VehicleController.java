package Logistics_Freight_Network_System.controller;

// ---------------- VehicleController ----------------
import Logistics_Freight_Network_System.dto.VehicleDTO;
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
    public VehicleDTO addVehicle(@RequestBody Vehicle vehicle) {
        return VehicleDTO.convertToDTO(vehicleService.create(vehicle));
    }

    @GetMapping("getAll")
    public List<VehicleDTO> getAllVehicles() {
        return VehicleDTO.convertToDTO(vehicleService.getAll());
    }

    @GetMapping("getById")
    public VehicleDTO getById(@RequestParam Long id) {
        return VehicleDTO.convertToDTO(vehicleService.getById(id));
    }

    @PutMapping("update")
    public VehicleDTO updateVehicle(@RequestBody Vehicle vehicle) {
        return VehicleDTO.convertToDTO(vehicleService.update(vehicle.getId(), vehicle));
    }

    @DeleteMapping("deleteById")
    public Boolean deleteById(@RequestParam Long id) {
        vehicleService.softDelete(id);
        return true;
    }
}