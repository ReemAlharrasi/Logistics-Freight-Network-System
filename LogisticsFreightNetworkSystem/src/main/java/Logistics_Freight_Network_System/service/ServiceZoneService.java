package Logistics_Freight_Network_System.service;


// ---------------- ServiceZoneService ----------------
import Logistics_Freight_Network_System.entity.Route;
import Logistics_Freight_Network_System.entity.ServiceZone;
import Logistics_Freight_Network_System.repository.ServiceZoneRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ServiceZoneService {

    private final ServiceZoneRepository serviceZoneRepository;

    public ServiceZoneService(ServiceZoneRepository serviceZoneRepository) {
        this.serviceZoneRepository = serviceZoneRepository;
    }

    public List<ServiceZone> getAll() {
        return serviceZoneRepository.getAllServiceZones();
    }

    public ServiceZone getById(Long id) {
        return serviceZoneRepository.getServiceZoneById(id);
    }

    public ServiceZone create(ServiceZone serviceZone) {
        if (serviceZone.getName() == null || serviceZone.getName().isBlank()) {
            return new ServiceZone();
        }
        return serviceZoneRepository.save(serviceZone);
    }

    public ServiceZone update(Long id, ServiceZone updated) {
        ServiceZone existing = getById(id);
        existing.setName(updated.getName());
        existing.setRegion(updated.getRegion());
        existing.setBaseRate(updated.getBaseRate());
        return serviceZoneRepository.save(existing);
    }

    public void softDelete(Long id) {
        ServiceZone existing = getById(id);
        existing.setActive(false);
        serviceZoneRepository.save(existing);
    }
}