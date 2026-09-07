package Logistics_Freight_Network_System.controller;

// ---------------- DeliveryStopController ----------------
import Logistics_Freight_Network_System.entity.DeliveryStop;
import Logistics_Freight_Network_System.service.DeliveryStopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("deliveryStop")
public class DeliveryStopController {

    DeliveryStopService deliveryStopService;

    @Autowired
    public DeliveryStopController(DeliveryStopService deliveryStopService) {
        this.deliveryStopService = deliveryStopService;
    }

    @PostMapping("add")
    public DeliveryStop addDeliveryStop(@RequestBody DeliveryStop deliveryStop) {
        return deliveryStopService.create(deliveryStop);
    }

    @GetMapping("getAll")
    public List<DeliveryStop> getAllDeliveryStops() {
        return deliveryStopService.getAll();
    }

    @GetMapping("getById")
    public DeliveryStop getById(@RequestParam Long id) {
        return deliveryStopService.getById(id);
    }

    @PutMapping("update")
    public DeliveryStop updateDeliveryStop(@RequestBody DeliveryStop deliveryStop) {
        return deliveryStopService.update(deliveryStop.getId(), deliveryStop);
    }

    @DeleteMapping("deleteById")
    public Boolean deleteById(@RequestParam Long id) {
        deliveryStopService.softDelete(id);
        return true;
    }
}
