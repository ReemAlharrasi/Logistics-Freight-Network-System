package Logistics_Freight_Network_System.service;

// ---------------- CustomerService ----------------
import Logistics_Freight_Network_System.entity.Customer;
import Logistics_Freight_Network_System.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAll() {
        return customerRepository.getAllCustomers();
    }

    public Customer getById(Long id) {
        return customerRepository.getCustomerById(id);
    }

    public Customer create(Customer customer) {
        if (customer.getEmail() == null || customer.getEmail().isBlank()) {
            return new Customer();
        }
        return customerRepository.save(customer);
    }

    public Customer update(Long id, Customer updated) {
        Customer existing = getById(id);
        existing.setName(updated.getName());
        existing.setEmail(updated.getEmail());
        existing.setPhoneNumber(updated.getPhoneNumber());
        existing.setType(updated.getType());
        return customerRepository.save(existing);
    }

    public void softDelete(Long id) {
        Customer existing = getById(id);
        existing.setActive(false);
        customerRepository.save(existing);
    }
}
