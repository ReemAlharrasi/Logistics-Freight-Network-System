package Logistics_Freight_Network_System.controller;

// ---------------- TrackingEventController ----------------
import Logistics_Freight_Network_System.dto.TrackingEventDTO;
import Logistics_Freight_Network_System.entity.TrackingEvent;
import Logistics_Freight_Network_System.service.TrackingEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("trackingEvent")
public class TrackingEventController {

    TrackingEventService trackingEventService;

    @Autowired
    public TrackingEventController(TrackingEventService trackingEventService) {
        this.trackingEventService = trackingEventService;
    }

    @PostMapping("add")
    public TrackingEventDTO addTrackingEvent(@RequestBody TrackingEvent trackingEvent) {
        return TrackingEventDTO.convertToDTO(trackingEventService.create(trackingEvent));
    }

    @GetMapping("getAll")
    public List<TrackingEventDTO> getAllTrackingEvents() {
        return TrackingEventDTO.convertToDTO(trackingEventService.getAll());
    }

    @GetMapping("getById")
    public TrackingEventDTO getById(@RequestParam Long id) {
        return TrackingEventDTO.convertToDTO(trackingEventService.getById(id));
    }

    @PutMapping("update")
    public TrackingEventDTO updateTrackingEvent(@RequestBody TrackingEvent trackingEvent) {
        return TrackingEventDTO.convertToDTO(trackingEventService.update(trackingEvent.getId(), trackingEvent));
    }

    @DeleteMapping("deleteById")
    public Boolean deleteById(@RequestParam Long id) {
        trackingEventService.softDelete(id);
        return true;
    }
}