package Logistics_Freight_Network_System.controller;

// ---------------- TrackingEventController ----------------
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
    public TrackingEvent addTrackingEvent(@RequestBody TrackingEvent trackingEvent) {
        return trackingEventService.create(trackingEvent);
    }

    @GetMapping("getAll")
    public List<TrackingEvent> getAllTrackingEvents() {
        return trackingEventService.getAll();
    }

    @GetMapping("getById")
    public TrackingEvent getById(@RequestParam Long id) {
        return trackingEventService.getById(id);
    }

    @PutMapping("update")
    public TrackingEvent updateTrackingEvent(@RequestBody TrackingEvent trackingEvent) {
        return trackingEventService.update(trackingEvent.getId(), trackingEvent);
    }

    @DeleteMapping("deleteById")
    public Boolean deleteById(@RequestParam Long id) {
        trackingEventService.softDelete(id);
        return true;
    }
}