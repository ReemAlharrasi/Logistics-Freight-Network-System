package Logistics_Freight_Network_System.service;


// ---------------- RouteService ----------------
import Logistics_Freight_Network_System.entity.Route;
import Logistics_Freight_Network_System.entity.Vehicle;
import Logistics_Freight_Network_System.entity.Driver;
import Logistics_Freight_Network_System.repository.RouteRepository;
import Logistics_Freight_Network_System.repository.VehicleRepository;
import Logistics_Freight_Network_System.repository.DriverRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RouteService {

    private final RouteRepository routeRepository;
    private final VehicleRepository vehicleRepository;
    private final DriverRepository driverRepository;

    public RouteService(RouteRepository routeRepository,
                        VehicleRepository vehicleRepository,
                        DriverRepository driverRepository) {
        this.routeRepository = routeRepository;
        this.vehicleRepository = vehicleRepository;
        this.driverRepository = driverRepository;
    }

    public List<Route> getAll() {
        return routeRepository.getAllRoutes();
    }

    public Route getById(Long id) {
        return routeRepository.getRouteById(id);
    }

    public Route create(Route route) {
        if (route.getVehicle() == null || route.getVehicle().getId() == null) {
            return new Route();
        }
        if (route.getDriver() == null || route.getDriver().getId() == null) {
            return new Route();
        }
        route.setVehicle(vehicleRepository.getVehicleById(route.getVehicle().getId()));
        route.setDriver(driverRepository.getDriverById(route.getDriver().getId()));
        return routeRepository.save(route);
    }

    public Route update(Long id, Route updated) {
        Route existing = getById(id);
        existing.setRouteDate(updated.getRouteDate());
        existing.setOrigin(updated.getOrigin());
        existing.setDestination(updated.getDestination());
        existing.setStatus(updated.getStatus());
        return routeRepository.save(existing);
    }

    public void softDelete(Long id) {
        Route existing = getById(id);
        existing.setActive(false);
        routeRepository.save(existing);
    }
}
