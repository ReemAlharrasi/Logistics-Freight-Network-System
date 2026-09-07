package Logistics_Freight_Network_System.service;

// ---------------- ShipmentService ----------------
import Logistics_Freight_Network_System.entity.*;
import Logistics_Freight_Network_System.repository.ShipmentRepository;
import Logistics_Freight_Network_System.repository.WarehouseRepository;
import Logistics_Freight_Network_System.repository.CustomerRepository;
import Logistics_Freight_Network_System.repository.CarrierRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ShipmentService {

    private final ShipmentRepository shipmentRepository;
    private final WarehouseRepository warehouseRepository;
    private final CustomerRepository customerRepository;
    private final CarrierRepository carrierRepository;

    public ShipmentService(ShipmentRepository shipmentRepository,
                           WarehouseRepository warehouseRepository,
                           CustomerRepository customerRepository,
                           CarrierRepository carrierRepository) {
        this.shipmentRepository = shipmentRepository;
        this.warehouseRepository = warehouseRepository;
        this.customerRepository = customerRepository;
        this.carrierRepository = carrierRepository;
    }

    public List<Shipment> getAll() {
        return shipmentRepository.getAllShipments();
    }

    public Shipment getById(Long id) {
        return shipmentRepository.getShipmentById(id);
    }

    public Shipment create(Shipment shipment) {
        if (shipment.getWarehouse() == null || shipment.getWarehouse().getId() == null) {
            return new Shipment();
        }
        if (shipment.getCustomer() == null || shipment.getCustomer().getId() == null) {
            return new Shipment();
        }
        shipment.setWarehouse(warehouseRepository.getWarehouseById(shipment.getWarehouse().getId()));
        shipment.setCustomer(customerRepository.getCustomerById(shipment.getCustomer().getId()));

        if (shipment.getCarrier() != null && shipment.getCarrier().getId() != null) {
            shipment.setCarrier(carrierRepository.getCarrierById(shipment.getCarrier().getId()));
        }
        return shipmentRepository.save(shipment);
    }

    public Shipment update(Long id, Shipment updated) {
        Shipment existing = getById(id);
        existing.setShipmentDate(updated.getShipmentDate());
        existing.setStatus(updated.getStatus());
        existing.setTotalWeight(updated.getTotalWeight());
        if (updated.getCarrier() != null && updated.getCarrier().getId() != null) {
            existing.setCarrier(carrierRepository.getCarrierById(updated.getCarrier().getId()));
        }
        return shipmentRepository.save(existing);
    }

    public void softDelete(Long id) {
        Shipment existing = getById(id);
        existing.setActive(false);
        shipmentRepository.save(existing);
    }
}
