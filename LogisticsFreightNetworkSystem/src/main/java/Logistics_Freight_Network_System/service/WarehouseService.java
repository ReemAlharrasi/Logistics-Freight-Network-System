package Logistics_Freight_Network_System.service;

// ---------------- WarehouseService ----------------
import Logistics_Freight_Network_System.entity.Warehouse;
import Logistics_Freight_Network_System.repository.WarehouseRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class WarehouseService {

    private final WarehouseRepository warehouseRepository;

    public WarehouseService(WarehouseRepository warehouseRepository) {
        this.warehouseRepository = warehouseRepository;
    }

    public List<Warehouse> getAll() {
        return warehouseRepository.getAllWarehouses();
    }

    public Warehouse getById(Long id) {
        return warehouseRepository.getWarehouseById(id);
    }

    public Warehouse create(Warehouse warehouse) {
        if (warehouse.getName() == null || warehouse.getName().isBlank()) {
            return new Warehouse();
        }
        return warehouseRepository.save(warehouse);
    }

    public Warehouse update(Long id, Warehouse updated) {
        Warehouse existing = getById(id);
        existing.setName(updated.getName());
        existing.setLocation(updated.getLocation());
        existing.setCapacity(updated.getCapacity());
        return warehouseRepository.save(existing);
    }

    public void softDelete(Long id) {
        Warehouse existing = getById(id);
        existing.setActive(false);
        warehouseRepository.save(existing);
    }
}
