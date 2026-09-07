package Logistics_Freight_Network_System.service;


// ---------------- DriverService ----------------
import Logistics_Freight_Network_System.entity.Driver;
import Logistics_Freight_Network_System.entity.Carrier;
import Logistics_Freight_Network_System.repository.DriverRepository;
import Logistics_Freight_Network_System.repository.CarrierRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DriverService {

    private final DriverRepository driverRepository;
    private final CarrierRepository carrierRepository;

    public DriverService(DriverRepository driverRepository, CarrierRepository carrierRepository) {
        this.driverRepository = driverRepository;
        this.carrierRepository = carrierRepository;
    }

    public List<Driver> getAll() {
        return driverRepository.getAllDrivers();
    }

    public Driver getById(Long id) {
        return driverRepository.getDriverById(id);
    }

    public Driver create(Driver driver) {
        if (driver.getCarrier() == null || driver.getCarrier().getId() == null) {
            return new Driver();
        }
        driver.setCarrier(carrierRepository.getCarrierById(driver.getCarrier().getId()));
        return driverRepository.save(driver);
    }

    public Driver update(Long id, Driver updated) {
        Driver existing = getById(id);
        existing.setName(updated.getName());
        existing.setLicenseNumber(updated.getLicenseNumber());
        existing.setPhoneNumber(updated.getPhoneNumber());
        existing.setStatus(updated.getStatus());
        return driverRepository.save(existing);
    }

    public void softDelete(Long id) {
        Driver existing = getById(id);
        existing.setActive(false);
        driverRepository.save(existing);
    }
}
