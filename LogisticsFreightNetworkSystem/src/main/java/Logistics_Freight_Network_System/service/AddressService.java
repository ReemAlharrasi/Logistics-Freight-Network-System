package Logistics_Freight_Network_System.service;


// ---------------- AddressService ----------------
import Logistics_Freight_Network_System.entity.Address;
import Logistics_Freight_Network_System.entity.Customer;
import Logistics_Freight_Network_System.repository.AddressRepository;
import Logistics_Freight_Network_System.repository.CustomerRepository;
import Logistics_Freight_Network_System.repository.ServiceZoneRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AddressService {

    private final AddressRepository addressRepository;
    private final CustomerRepository customerRepository;
    private final ServiceZoneRepository serviceZoneRepository;

    public AddressService(AddressRepository addressRepository, CustomerRepository customerRepository, ServiceZoneRepository serviceZoneRepository) {
        this.addressRepository = addressRepository;
        this.customerRepository = customerRepository;
        this.serviceZoneRepository = serviceZoneRepository;
    }

    public List<Address> getAll() {
        return addressRepository.getAllAddresses();
    }

    public Address getById(Long id) {
        return addressRepository.getAddressById(id);
    }

    public Address create(Address address) {
        if (address.getCustomer() == null || address.getCustomer().getId() == null) {
            return new Address();
        }
        Customer customer = customerRepository.getCustomerById(address.getCustomer().getId());
        address.setCustomer(customer);

        if (address.getServiceZone() != null && address.getServiceZone().getId() != null) {
            address.setServiceZone(serviceZoneRepository.getServiceZoneById(address.getServiceZone().getId()));
        }
        return addressRepository.save(address);
    }

    public Address update(Long id, Address updated) {
        Address existing = getById(id);
        existing.setStreet(updated.getStreet());
        existing.setCity(updated.getCity());
        existing.setPostalCode(updated.getPostalCode());
        existing.setCountry(updated.getCountry());
        if (updated.getServiceZone() != null && updated.getServiceZone().getId() != null) {
            existing.setServiceZone(serviceZoneRepository.getServiceZoneById(updated.getServiceZone().getId()));
        }
        return addressRepository.save(existing);
    }

    public void softDelete(Long id) {
        Address existing = getById(id);
        existing.setActive(false);
        addressRepository.save(existing);
    }
}