package Logistics_Freight_Network_System.service;
// ---------------- InventoryItemService ----------------
import Logistics_Freight_Network_System.entity.InventoryItem;
import Logistics_Freight_Network_System.entity.Warehouse;
import Logistics_Freight_Network_System.entity.Product;
import Logistics_Freight_Network_System.repository.InventoryItemRepository;
import Logistics_Freight_Network_System.repository.WarehouseRepository;
import Logistics_Freight_Network_System.repository.ProductRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class InventoryItemService {

    private final InventoryItemRepository inventoryItemRepository;
    private final WarehouseRepository warehouseRepository;
    private final ProductRepository productRepository;

    public InventoryItemService(InventoryItemRepository inventoryItemRepository,
                                WarehouseRepository warehouseRepository,
                                ProductRepository productRepository) {
        this.inventoryItemRepository = inventoryItemRepository;
        this.warehouseRepository = warehouseRepository;
        this.productRepository = productRepository;
    }

    public List<InventoryItem> getAll() {
        return inventoryItemRepository.getAllInventoryItems();
    }

    public InventoryItem getById(Long id) {
        return inventoryItemRepository.getInventoryItemById(id);
    }

    public InventoryItem create(InventoryItem item) {
        if (item.getWarehouse() == null || item.getWarehouse().getId() == null) {
            return new InventoryItem();
        }
        if (item.getProduct() == null || item.getProduct().getId() == null) {
            return new InventoryItem();
        }
        Warehouse warehouse = warehouseRepository.getWarehouseById(item.getWarehouse().getId());
        Product product = productRepository.getProductById(item.getProduct().getId());
        item.setWarehouse(warehouse);
        item.setProduct(product);
        return inventoryItemRepository.save(item);
    }

    public InventoryItem update(Long id, InventoryItem updated) {
        InventoryItem existing = getById(id);
        existing.setQuantity(updated.getQuantity());
        existing.setShelfLocation(updated.getShelfLocation());
        if (updated.getWarehouse() != null && updated.getWarehouse().getId() != null) {
            existing.setWarehouse(warehouseRepository.getWarehouseById(updated.getWarehouse().getId()));
        }
        if (updated.getProduct() != null && updated.getProduct().getId() != null) {
            existing.setProduct(productRepository.getProductById(updated.getProduct().getId()));
        }
        return inventoryItemRepository.save(existing);
    }

    public void softDelete(Long id) {
        InventoryItem existing = getById(id);
        existing.setActive(false);
        inventoryItemRepository.save(existing);
    }
}