package Logistics_Freight_Network_System.controller;

// ---------------- ShipmentItemController ----------------
import Logistics_Freight_Network_System.entity.ShipmentItem;
import Logistics_Freight_Network_System.service.ShipmentItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("shipmentItem")
public class ShipmentItemController {

    ShipmentItemService shipmentItemService;

    @Autowired
    public ShipmentItemController(ShipmentItemService shipmentItemService) {
        this.shipmentItemService = shipmentItemService;
    }

    @PostMapping("add")
    public ShipmentItem addShipmentItem(@RequestBody ShipmentItem shipmentItem) {
        return shipmentItemService.create(shipmentItem);
    }

    @GetMapping("getAll")
    public List<ShipmentItem> getAllShipmentItems() {
        return shipmentItemService.getAll();
    }

    @GetMapping("getById")
    public ShipmentItem getById(@RequestParam Long id) {
        return shipmentItemService.getById(id);
    }

    @PutMapping("update")
    public ShipmentItem updateShipmentItem(@RequestBody ShipmentItem shipmentItem) {
        return shipmentItemService.update(shipmentItem.getId(), shipmentItem);
    }

    @DeleteMapping("deleteById")
    public Boolean deleteById(@RequestParam Long id) {
        shipmentItemService.softDelete(id);
        return true;
    }
}