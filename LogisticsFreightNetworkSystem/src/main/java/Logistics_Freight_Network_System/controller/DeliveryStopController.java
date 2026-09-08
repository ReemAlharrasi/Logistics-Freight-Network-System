package Logistics_Freight_Network_System.controller;

// ---------------- DeliveryStopController ----------------
import Logistics_Freight_Network_System.dto.DeliveryStopDTO;
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
    public DeliveryStopDTO addDeliveryStop(@RequestBody DeliveryStop deliveryStop) {
        return DeliveryStopDTO.convertToDTO(deliveryStopService.create(deliveryStop));
    }

    @GetMapping("getAll")
    public List<DeliveryStopDTO> getAllDeliveryStops() {
        return DeliveryStopDTO.convertToDTO(deliveryStopService.getAll());
    }

    @GetMapping("getById")
    public DeliveryStopDTO getById(@RequestParam Long id) {
        return DeliveryStopDTO.convertToDTO(deliveryStopService.getById(id));
    }

    @PutMapping("update")
    public DeliveryStopDTO updateDeliveryStop(@RequestBody DeliveryStop deliveryStop) {
        return DeliveryStopDTO.convertToDTO(deliveryStopService.update(deliveryStop.getId(), deliveryStop));
    }

    @DeleteMapping("deleteById")
    public Boolean deleteById(@RequestParam Long id) {
        deliveryStopService.softDelete(id);
        return true;
    }
}