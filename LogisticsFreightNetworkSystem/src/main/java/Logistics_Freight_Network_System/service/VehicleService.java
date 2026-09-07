package Logistics_Freight_Network_System.service;


// ---------------- VehicleService ----------------
import Logistics_Freight_Network_System.entity.Vehicle;
import Logistics_Freight_Network_System.entity.Carrier;
import Logistics_Freight_Network_System.repository.VehicleRepository;
import Logistics_Freight_Network_System.repository.CarrierRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VehicleService {

    private final VehicleRepository vehicleRepository;
    private final CarrierRepository carrierRepository;

    public VehicleService(VehicleRepository vehicleRepository, CarrierRepository carrierRepository) {
        this.vehicleRepository = vehicleRepository;
        this.carrierRepository = carrierRepository;
    }

    public List<Vehicle> getAll() {
        return vehicleRepository.getAllVehicles();
    }

    public Vehicle getById(Long id) {
        return vehicleRepository.getVehicleById(id);
    }

    public Vehicle create(Vehicle vehicle) {
        if (vehicle.getCarrier() == null || vehicle.getCarrier().getId() == null) {
            return new Vehicle();
        }
        vehicle.setCarrier(carrierRepository.getCarrierById(vehicle.getCarrier().getId()));
        return vehicleRepository.save(vehicle);
    }

    public Vehicle update(Long id, Vehicle updated) {
        Vehicle existing = getById(id);
        existing.setPlateNumber(updated.getPlateNumber());
        existing.setType(updated.getType());
        existing.setCapacityKg(updated.getCapacityKg());
        existing.setStatus(updated.getStatus());
        return vehicleRepository.save(existing);
    }

    public void softDelete(Long id) {
        Vehicle existing = getById(id);
        existing.setActive(false);
        vehicleRepository.save(existing);
    }
}