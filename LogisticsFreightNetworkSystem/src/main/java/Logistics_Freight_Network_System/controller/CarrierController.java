package Logistics_Freight_Network_System.controller;

// ---------------- CarrierController ----------------
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
    public Carrier addCarrier(@RequestBody Carrier carrier) {
        return carrierService.create(carrier);
    }

    @GetMapping("getAll")
    public List<Carrier> getAllCarriers() {
        return carrierService.getAll();
    }

    @GetMapping("getById")
    public Carrier getById(@RequestParam Long id) {
        return carrierService.getById(id);
    }

    @PutMapping("update")
    public Carrier updateCarrier(@RequestBody Carrier carrier) {
        return carrierService.update(carrier.getId(), carrier);
    }

    @DeleteMapping("deleteById")
    public Boolean deleteById(@RequestParam Long id) {
        carrierService.softDelete(id);
        return true;
    }
}