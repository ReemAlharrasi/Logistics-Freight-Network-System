package Logistics_Freight_Network_System.controller;

// ---------------- InventoryItemController ----------------
import Logistics_Freight_Network_System.dto.InventoryItemDTO;
import Logistics_Freight_Network_System.entity.InventoryItem;
import Logistics_Freight_Network_System.service.InventoryItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("inventoryItem")
public class InventoryItemController {

    InventoryItemService inventoryItemService;

    @Autowired
    public InventoryItemController(InventoryItemService inventoryItemService) {
        this.inventoryItemService = inventoryItemService;
    }

    @PostMapping("add")
    public InventoryItemDTO addInventoryItem(@RequestBody InventoryItem inventoryItem) {
        return InventoryItemDTO.convertToDTO(inventoryItemService.create(inventoryItem));
    }

    @GetMapping("getAll")
    public List<InventoryItemDTO> getAllInventoryItems() {
        return InventoryItemDTO.convertToDTO(inventoryItemService.getAll());
    }

    @GetMapping("getById")
    public InventoryItemDTO getById(@RequestParam Long id) {
        return InventoryItemDTO.convertToDTO(inventoryItemService.getById(id));
    }

    @PutMapping("update")
    public InventoryItemDTO updateInventoryItem(@RequestBody InventoryItem inventoryItem) {
        return InventoryItemDTO.convertToDTO(inventoryItemService.update(inventoryItem.getId(), inventoryItem));
    }

    @DeleteMapping("deleteById")
    public Boolean deleteById(@RequestParam Long id) {
        inventoryItemService.softDelete(id);
        return true;
    }
}