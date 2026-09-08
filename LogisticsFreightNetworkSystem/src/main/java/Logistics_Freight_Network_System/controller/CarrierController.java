package Logistics_Freight_Network_System.controller;

// ---------------- CarrierController ----------------
import Logistics_Freight_Network_System.dto.CarrierDTO;
import Logistics_Freight_Network_System.entity.Carrier;
import Logistics_Freight_Network_System.service.CarrierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("carrier")
public class CarrierController {

    CarrierService carrierService;

    @Autowired
    public CarrierController(CarrierService carrierService) {
        this.carrierService = carrierService;
    }

    @PostMapping("add")
    public CarrierDTO addCarrier(@RequestBody Carrier carrier) {
        return CarrierDTO.convertToDTO(carrierService.create(carrier));
    }

    @GetMapping("getAll")
    public List<CarrierDTO> getAllCarriers() {
        return CarrierDTO.convertToDTO(carrierService.getAll());
    }

    @GetMapping("getById")
    public CarrierDTO getById(@RequestParam Long id) {
        return CarrierDTO.convertToDTO(carrierService.getById(id));
    }

    @PutMapping("update")
    public CarrierDTO updateCarrier(@RequestBody Carrier carrier) {
        return CarrierDTO.convertToDTO(carrierService.update(carrier.getId(), carrier));
    }

    @DeleteMapping("deleteById")
    public Boolean deleteById(@RequestParam Long id) {
        carrierService.softDelete(id);
        return true;
    }
}