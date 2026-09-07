package Logistics_Freight_Network_System.service;


// ---------------- DeliveryStopService ----------------
import Logistics_Freight_Network_System.entity.DeliveryStop;
import Logistics_Freight_Network_System.entity.Route;
import Logistics_Freight_Network_System.entity.Shipment;
import Logistics_Freight_Network_System.repository.DeliveryStopRepository;
import Logistics_Freight_Network_System.repository.RouteRepository;
import Logistics_Freight_Network_System.repository.ShipmentRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DeliveryStopService {

    private final DeliveryStopRepository deliveryStopRepository;
    private final RouteRepository routeRepository;
    private final ShipmentRepository shipmentRepository;

    public DeliveryStopService(DeliveryStopRepository deliveryStopRepository, RouteRepository routeRepository, ShipmentRepository shipmentRepository) {
        this.deliveryStopRepository = deliveryStopRepository;
        this.routeRepository = routeRepository;
        this.shipmentRepository = shipmentRepository;
    }

    public List<DeliveryStop> getAll() {
        return deliveryStopRepository.getAllDeliveryStops();
    }

    public DeliveryStop getById(Long id) {
        return deliveryStopRepository.getDeliveryStopById(id);
    }

    public DeliveryStop create(DeliveryStop stop) {
        if (stop.getRoute() == null || stop.getRoute().getId() == null) {
            return new DeliveryStop();
        }
        if (stop.getShipment() == null || stop.getShipment().getId() == null) {
            return new DeliveryStop();
        }
        stop.setRoute(routeRepository.getRouteById(stop.getRoute().getId()));
        stop.setShipment(shipmentRepository.getShipmentById(stop.getShipment().getId()));
        return deliveryStopRepository.save(stop);
    }

    public DeliveryStop update(Long id, DeliveryStop updated) {
        DeliveryStop existing = getById(id);
        existing.setSequence(updated.getSequence());
        existing.setAddress(updated.getAddress());
        existing.setStatus(updated.getStatus());
        existing.setEta(updated.getEta());
        return deliveryStopRepository.save(existing);
    }

    public void softDelete(Long id) {
        DeliveryStop existing = getById(id);
        existing.setActive(false);
        deliveryStopRepository.save(existing);
    }
}
