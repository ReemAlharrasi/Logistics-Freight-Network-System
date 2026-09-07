package Logistics_Freight_Network_System.service;


// ---------------- ShipmentItemService ----------------
import Logistics_Freight_Network_System.entity.Route;
import Logistics_Freight_Network_System.entity.ShipmentItem;
import Logistics_Freight_Network_System.entity.Shipment;
import Logistics_Freight_Network_System.entity.Product;
import Logistics_Freight_Network_System.repository.ShipmentItemRepository;
import Logistics_Freight_Network_System.repository.ShipmentRepository;
import Logistics_Freight_Network_System.repository.ProductRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ShipmentItemService {

    private final ShipmentItemRepository shipmentItemRepository;
    private final ShipmentRepository shipmentRepository;
    private final ProductRepository productRepository;

    public ShipmentItemService(ShipmentItemRepository shipmentItemRepository,
                               ShipmentRepository shipmentRepository,
                               ProductRepository productRepository) {
        this.shipmentItemRepository = shipmentItemRepository;
        this.shipmentRepository = shipmentRepository;
        this.productRepository = productRepository;
    }

    public List<ShipmentItem> getAll() {
        return shipmentItemRepository.getAllShipmentItems();
    }

    public ShipmentItem getById(Long id) {
        return shipmentItemRepository.getShipmentItemById(id);
    }

    public ShipmentItem create(ShipmentItem item) {
        if (item.getShipment() == null || item.getShipment().getId() == null) {
            return new ShipmentItem();
        }
        if (item.getProduct() == null || item.getProduct().getId() == null) {
            return new ShipmentItem();
        }
        item.setShipment(shipmentRepository.getShipmentById(item.getShipment().getId()));
        item.setProduct(productRepository.getProductById(item.getProduct().getId()));
        return shipmentItemRepository.save(item);
    }

    public ShipmentItem update(Long id, ShipmentItem updated) {
        ShipmentItem existing = getById(id);
        existing.setQuantity(updated.getQuantity());
        if (updated.getProduct() != null && updated.getProduct().getId() != null) {
            existing.setProduct(productRepository.getProductById(updated.getProduct().getId()));
        }
        return shipmentItemRepository.save(existing);
    }

    public void softDelete(Long id) {
        ShipmentItem existing = getById(id);
        existing.setActive(false);
        shipmentItemRepository.save(existing);
    }
}
