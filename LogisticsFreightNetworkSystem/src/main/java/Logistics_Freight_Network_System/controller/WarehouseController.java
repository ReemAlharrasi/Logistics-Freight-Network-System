package Logistics_Freight_Network_System.controller;

// ---------------- WarehouseController ----------------
import Logistics_Freight_Network_System.dto.WarehouseDTO;
import Logistics_Freight_Network_System.entity.Warehouse;
import Logistics_Freight_Network_System.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("warehouse")
public class WarehouseController {

    WarehouseService warehouseService;

    @Autowired
    public WarehouseController(WarehouseService warehouseService) {
        this.warehouseService = warehouseService;
    }

    @PostMapping("add")
    public WarehouseDTO addWarehouse(@RequestBody Warehouse warehouse) {
        return WarehouseDTO.convertToDTO(warehouseService.create(warehouse));
    }

    @GetMapping("getAll")
    public List<WarehouseDTO> getAllWarehouses() {
        return WarehouseDTO.convertToDTO(warehouseService.getAll());
    }

    @GetMapping("getById")
    public WarehouseDTO getById(@RequestParam Long id) {
        return WarehouseDTO.convertToDTO(warehouseService.getById(id));
    }

    @PutMapping("update")
    public WarehouseDTO updateWarehouse(@RequestBody Warehouse warehouse) {
        return WarehouseDTO.convertToDTO(warehouseService.update(warehouse.getId(), warehouse));
    }

    @DeleteMapping("deleteById")
    public Boolean deleteById(@RequestParam Long id) {
        warehouseService.softDelete(id);
        return true;
    }
}