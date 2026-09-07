package Logistics_Freight_Network_System.controller;

// ---------------- RouteController ----------------
import Logistics_Freight_Network_System.entity.Route;
import Logistics_Freight_Network_System.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("route")
public class RouteController {

    RouteService routeService;

    @Autowired
    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    @PostMapping("add")
    public Route addRoute(@RequestBody Route route) {
        return routeService.create(route);
    }

    @GetMapping("getAll")
    public List<Route> getAllRoutes() {
        return routeService.getAll();
    }

    @GetMapping("getById")
    public Route getById(@RequestParam Long id) {
        return routeService.getById(id);
    }

    @PutMapping("update")
    public Route updateRoute(@RequestBody Route route) {
        return routeService.update(route.getId(), route);
    }

    @DeleteMapping("deleteById")
    public Boolean deleteById(@RequestParam Long id) {
        routeService.softDelete(id);
        return true;
    }
}
