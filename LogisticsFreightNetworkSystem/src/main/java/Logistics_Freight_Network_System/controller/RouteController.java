package Logistics_Freight_Network_System.controller;

// ---------------- RouteController ----------------
import Logistics_Freight_Network_System.dto.RouteDTO;
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
    public RouteDTO addRoute(@RequestBody Route route) {
        return RouteDTO.convertToDTO(routeService.create(route));
    }

    @GetMapping("getAll")
    public List<RouteDTO> getAllRoutes() {
        return RouteDTO.convertToDTO(routeService.getAll());
    }

    @GetMapping("getById")
    public RouteDTO getById(@RequestParam Long id) {
        return RouteDTO.convertToDTO(routeService.getById(id));
    }

    @PutMapping("update")
    public RouteDTO updateRoute(@RequestBody Route route) {
        return RouteDTO.convertToDTO(routeService.update(route.getId(), route));
    }

    @DeleteMapping("deleteById")
    public Boolean deleteById(@RequestParam Long id) {
        routeService.softDelete(id);
        return true;
    }
}

