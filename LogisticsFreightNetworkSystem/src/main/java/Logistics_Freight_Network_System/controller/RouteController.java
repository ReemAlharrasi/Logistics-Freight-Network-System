package Logistics_Freight_Network_System.controller;

// ---------------- RouteController ----------------
import Logistics_Freight_Network_System.entity.Route;
import Logistics_Freight_Network_System.service.RouteService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/routes")
public class RouteController {

    private final RouteService routeService;

    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    @GetMapping
    public List<Route> getAll() {
        return routeService.getAll();
    }

    @GetMapping("/{id}")
    public Route getById(@PathVariable Long id) {
        return routeService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Route create(@RequestBody Route route) {
        return routeService.create(route);
    }

    @PutMapping("/{id}")
    public Route update(@PathVariable Long id, @RequestBody Route route) {
        return routeService.update(id, route);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void softDelete(@PathVariable Long id) {
        routeService.softDelete(id);
    }
}