package Logistics_Freight_Network_System.controller;

// ---------------- ShipmentController ----------------
import Logistics_Freight_Network_System.dto.ShipmentDTO;
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
    public ShipmentDTO addShipment(@RequestBody Shipment shipment) {
        return ShipmentDTO.convertToDTO(shipmentService.create(shipment));
    }

    @GetMapping("getAll")
    public List<ShipmentDTO> getAllShipments() {
        return ShipmentDTO.convertToDTO(shipmentService.getAll());
    }

    @GetMapping("getById")
    public ShipmentDTO getById(@RequestParam Long id) {
        return ShipmentDTO.convertToDTO(shipmentService.getById(id));
    }

    @PutMapping("update")
    public ShipmentDTO updateShipment(@RequestBody Shipment shipment) {
        return ShipmentDTO.convertToDTO(shipmentService.update(shipment.getId(), shipment));
    }

    @DeleteMapping("deleteById")
    public Boolean deleteById(@RequestParam Long id) {
        shipmentService.softDelete(id);
        return true;
    }
}