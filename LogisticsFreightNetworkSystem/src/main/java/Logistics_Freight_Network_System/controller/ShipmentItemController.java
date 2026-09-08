package Logistics_Freight_Network_System.controller;

// ---------------- ShipmentItemController ----------------
import Logistics_Freight_Network_System.dto.ShipmentItemDTO;
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
    public ShipmentItemDTO addShipmentItem(@RequestBody ShipmentItem shipmentItem) {
        return ShipmentItemDTO.convertToDTO(shipmentItemService.create(shipmentItem));
    }

    @GetMapping("getAll")
    public List<ShipmentItemDTO> getAllShipmentItems() {
        return ShipmentItemDTO.convertToDTO(shipmentItemService.getAll());
    }

    @GetMapping("getById")
    public ShipmentItemDTO getById(@RequestParam Long id) {
        return ShipmentItemDTO.convertToDTO(shipmentItemService.getById(id));
    }

    @PutMapping("update")
    public ShipmentItemDTO updateShipmentItem(@RequestBody ShipmentItem shipmentItem) {
        return ShipmentItemDTO.convertToDTO(shipmentItemService.update(shipmentItem.getId(), shipmentItem));
    }

    @DeleteMapping("deleteById")
    public Boolean deleteById(@RequestParam Long id) {
        shipmentItemService.softDelete(id);
        return true;
    }
}