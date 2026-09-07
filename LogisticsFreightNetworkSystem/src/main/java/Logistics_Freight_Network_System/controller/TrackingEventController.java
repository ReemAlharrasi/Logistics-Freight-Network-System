package Logistics_Freight_Network_System.controller;

// ---------------- TrackingEventController ----------------
import Logistics_Freight_Network_System.entity.TrackingEvent;
import Logistics_Freight_Network_System.service.TrackingEventService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/tracking-events")
public class TrackingEventController {

    private final TrackingEventService trackingEventService;

    public TrackingEventController(TrackingEventService trackingEventService) {
        this.trackingEventService = trackingEventService;
    }

    @GetMapping
    public List<TrackingEvent> getAll() {
        return trackingEventService.getAll();
    }

    @GetMapping("/{id}")
    public TrackingEvent getById(@PathVariable Long id) {
        return trackingEventService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TrackingEvent create(@RequestBody TrackingEvent trackingEvent) {
        return trackingEventService.create(trackingEvent);
    }

    @PutMapping("/{id}")
    public TrackingEvent update(@PathVariable Long id, @RequestBody TrackingEvent trackingEvent) {
        return trackingEventService.update(id, trackingEvent);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void softDelete(@PathVariable Long id) {
        trackingEventService.softDelete(id);
    }
}