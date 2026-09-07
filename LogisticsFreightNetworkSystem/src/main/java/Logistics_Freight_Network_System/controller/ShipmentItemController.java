package Logistics_Freight_Network_System.controller;

// ---------------- ShipmentItemController ----------------
import Logistics_Freight_Network_System.entity.ShipmentItem;
import Logistics_Freight_Network_System.service.ShipmentItemService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/shipment-items")
public class ShipmentItemController {

    private final ShipmentItemService shipmentItemService;

    public ShipmentItemController(ShipmentItemService shipmentItemService) {
        this.shipmentItemService = shipmentItemService;
    }

    @GetMapping
    public List<ShipmentItem> getAll() {
        return shipmentItemService.getAll();
    }

    @GetMapping("/{id}")
    public ShipmentItem getById(@PathVariable Long id) {
        return shipmentItemService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ShipmentItem create(@RequestBody ShipmentItem shipmentItem) {
        return shipmentItemService.create(shipmentItem);
    }

    @PutMapping("/{id}")
    public ShipmentItem update(@PathVariable Long id, @RequestBody ShipmentItem shipmentItem) {
        return shipmentItemService.update(id, shipmentItem);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void softDelete(@PathVariable Long id) {
        shipmentItemService.softDelete(id);
    }
}