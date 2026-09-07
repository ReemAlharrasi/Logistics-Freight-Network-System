package Logistics_Freight_Network_System.controller;

// ---------------- ShipmentController ----------------
import Logistics_Freight_Network_System.entity.Shipment;
import Logistics_Freight_Network_System.service.ShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("shipment")
public class ShipmentController {

    ShipmentService shipmentService;

    @Autowired
    public ShipmentController(ShipmentService shipmentService) {
        this.shipmentService = shipmentService;
    }

    @PostMapping("add")
    public Shipment addShipment(@RequestBody Shipment shipment) {
        return shipmentService.create(shipment);
    }

    @GetMapping("getAll")
    public List<Shipment> getAllShipments() {
        return shipmentService.getAll();
    }

    @GetMapping("getById")
    public Shipment getById(@RequestParam Long id) {
        return shipmentService.getById(id);
    }

    @PutMapping("update")
    public Shipment updateShipment(@RequestBody Shipment shipment) {
        return shipmentService.update(shipment.getId(), shipment);
    }

    @DeleteMapping("deleteById")
    public Boolean deleteById(@RequestParam Long id) {
        shipmentService.softDelete(id);
        return true;
    }
}