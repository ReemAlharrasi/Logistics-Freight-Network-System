package Logistics_Freight_Network_System.service;


// ---------------- TrackingEventService ----------------
import Logistics_Freight_Network_System.entity.TrackingEvent;
import Logistics_Freight_Network_System.entity.Shipment;
import Logistics_Freight_Network_System.repository.TrackingEventRepository;
import Logistics_Freight_Network_System.repository.ShipmentRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TrackingEventService {

    private final TrackingEventRepository trackingEventRepository;
    private final ShipmentRepository shipmentRepository;

    public TrackingEventService(TrackingEventRepository trackingEventRepository,
                                ShipmentRepository shipmentRepository) {
        this.trackingEventRepository = trackingEventRepository;
        this.shipmentRepository = shipmentRepository;
    }

    public List<TrackingEvent> getAll() {
        return trackingEventRepository.getAllTrackingEvents();
    }

    public TrackingEvent getById(Long id) {
        return trackingEventRepository.getTrackingEventById(id);
    }

    public TrackingEvent create(TrackingEvent event) {
        if (event.getShipment() == null || event.getShipment().getId() == null) {
            return new TrackingEvent();
        }
        event.setShipment(shipmentRepository.getShipmentById(event.getShipment().getId()));
        return trackingEventRepository.save(event);
    }

    public TrackingEvent update(Long id, TrackingEvent updated) {
        TrackingEvent existing = getById(id);
        existing.setEventTime(updated.getEventTime());
        existing.setLocation(updated.getLocation());
        existing.setStatus(updated.getStatus());
        existing.setNote(updated.getNote());
        return trackingEventRepository.save(existing);
    }

    public void softDelete(Long id) {
        TrackingEvent existing = getById(id);
        existing.setActive(false);
        trackingEventRepository.save(existing);
    }
}
