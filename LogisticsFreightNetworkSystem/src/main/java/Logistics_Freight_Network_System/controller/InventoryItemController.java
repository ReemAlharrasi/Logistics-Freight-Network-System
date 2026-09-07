package Logistics_Freight_Network_System.controller;

// ---------------- InventoryItemController ----------------
import Logistics_Freight_Network_System.entity.InventoryItem;
import Logistics_Freight_Network_System.service.InventoryItemService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/inventory-items")
public class InventoryItemController {

    private final InventoryItemService inventoryItemService;

    public InventoryItemController(InventoryItemService inventoryItemService) {
        this.inventoryItemService = inventoryItemService;
    }

    @GetMapping
    public List<InventoryItem> getAll() {
        return inventoryItemService.getAll();
    }

    @GetMapping("/{id}")
    public InventoryItem getById(@PathVariable Long id) {
        return inventoryItemService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public InventoryItem create(@RequestBody InventoryItem inventoryItem) {
        return inventoryItemService.create(inventoryItem);
    }

    @PutMapping("/{id}")
    public InventoryItem update(@PathVariable Long id, @RequestBody InventoryItem inventoryItem) {
        return inventoryItemService.update(id, inventoryItem);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void softDelete(@PathVariable Long id) {
        inventoryItemService.softDelete(id);
    }
}
