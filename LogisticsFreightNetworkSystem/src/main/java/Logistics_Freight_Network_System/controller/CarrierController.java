package Logistics_Freight_Network_System.controller;

// ---------------- CarrierController ----------------
import Logistics_Freight_Network_System.entity.Carrier;
import Logistics_Freight_Network_System.service.CarrierService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/carriers")
public class CarrierController {

    private final CarrierService carrierService;

    public CarrierController(CarrierService carrierService) {
        this.carrierService = carrierService;
    }

    @GetMapping
    public List<Carrier> getAll() {
        return carrierService.getAll();
    }

    @GetMapping("/{id}")
    public Carrier getById(@PathVariable Long id) {
        return carrierService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Carrier create(@RequestBody Carrier carrier) {
        return carrierService.create(carrier);
    }

    @PutMapping("/{id}")
    public Carrier update(@PathVariable Long id, @RequestBody Carrier carrier) {
        return carrierService.update(id, carrier);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void softDelete(@PathVariable Long id) {
        carrierService.softDelete(id);
    }
}