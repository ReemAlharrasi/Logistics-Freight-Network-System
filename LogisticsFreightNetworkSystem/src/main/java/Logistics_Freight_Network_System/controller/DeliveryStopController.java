package Logistics_Freight_Network_System.controller;

// ---------------- DeliveryStopController ----------------
import Logistics_Freight_Network_System.entity.DeliveryStop;
import Logistics_Freight_Network_System.service.DeliveryStopService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/delivery-stops")
public class DeliveryStopController {

    private final DeliveryStopService deliveryStopService;

    public DeliveryStopController(DeliveryStopService deliveryStopService) {
        this.deliveryStopService = deliveryStopService;
    }

    @GetMapping
    public List<DeliveryStop> getAll() {
        return deliveryStopService.getAll();
    }

    @GetMapping("/{id}")
    public DeliveryStop getById(@PathVariable Long id) {
        return deliveryStopService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DeliveryStop create(@RequestBody DeliveryStop deliveryStop) {
        return deliveryStopService.create(deliveryStop);
    }

    @PutMapping("/{id}")
    public DeliveryStop update(@PathVariable Long id, @RequestBody DeliveryStop deliveryStop) {
        return deliveryStopService.update(id, deliveryStop);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void softDelete(@PathVariable Long id) {
        deliveryStopService.softDelete(id);
    }
}