package Logistics_Freight_Network_System.service;



// ---------------- CarrierService ----------------
import Logistics_Freight_Network_System.entity.Carrier;
import Logistics_Freight_Network_System.repository.CarrierRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CarrierService {

    private final CarrierRepository carrierRepository;

    public CarrierService(CarrierRepository carrierRepository) {
        this.carrierRepository = carrierRepository;
    }

    public List<Carrier> getAll() {
        return carrierRepository.getAllCarriers();
    }

    public Carrier getById(Long id) {
        return carrierRepository.getCarrierById(id);
    }

    public Carrier create(Carrier carrier) {
        if (carrier.getName() == null || carrier.getName().isBlank()) {
            return new Carrier();
        }
        return carrierRepository.save(carrier);
    }

    public Carrier update(Long id, Carrier updated) {
        Carrier existing = getById(id);
        existing.setName(updated.getName());
        existing.setContactEmail(updated.getContactEmail());
        existing.setPhoneNumber(updated.getPhoneNumber());
        existing.setCountry(updated.getCountry());
        return carrierRepository.save(existing);
    }

    public void softDelete(Long id) {
        Carrier existing = getById(id);
        existing.setActive(false);
        carrierRepository.save(existing);
    }
}

