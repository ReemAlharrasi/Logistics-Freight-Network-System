package Logistics_Freight_Network_System.controller;

// ---------------- CustomerController ----------------
import Logistics_Freight_Network_System.entity.Customer;
import Logistics_Freight_Network_System.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("customer")
public class CustomerController {

    CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("add")
    public Customer addCustomer(@RequestBody Customer customer) {
        return customerService.create(customer);
    }

    @GetMapping("getAll")
    public List<Customer> getAllCustomers() {
        return customerService.getAll();
    }

    @GetMapping("getById")
    public Customer getById(@RequestParam Long id) {
        return customerService.getById(id);
    }

    @PutMapping("update")
    public Customer updateCustomer(@RequestBody Customer customer) {
        return customerService.update(customer.getId(), customer);
    }

    @DeleteMapping("deleteById")
    public Boolean deleteById(@RequestParam Long id) {
        customerService.softDelete(id);
        return true;
    }
}
