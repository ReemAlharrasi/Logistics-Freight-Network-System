package Logistics_Freight_Network_System.controller;

// ---------------- WarehouseController ----------------
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
    public Warehouse addWarehouse(@RequestBody Warehouse warehouse) {
        return warehouseService.create(warehouse);
    }

    @GetMapping("getAll")
    public List<Warehouse> getAllWarehouses() {
        return warehouseService.getAll();
    }

    @GetMapping("getById")
    public Warehouse getById(@RequestParam Long id) {
        return warehouseService.getById(id);
    }

    @PutMapping("update")
    public Warehouse updateWarehouse(@RequestBody Warehouse warehouse) {
        return warehouseService.update(warehouse.getId(), warehouse);
    }

    @DeleteMapping("deleteById")
    public Boolean deleteById(@RequestParam Long id) {
        warehouseService.softDelete(id);
        return true;
    }
}