package Logistics_Freight_Network_System.controller;

// ---------------- CustomerController ----------------
import Logistics_Freight_Network_System.dto.CustomerDTO;
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
    public CustomerDTO addCustomer(@RequestBody Customer customer) {
        return CustomerDTO.convertToDTO(customerService.create(customer));
    }

    @GetMapping("getAll")
    public List<CustomerDTO> getAllCustomers() {
        return CustomerDTO.convertToDTO(customerService.getAll());
    }

    @GetMapping("getById")
    public CustomerDTO getById(@RequestParam Long id) {
        return CustomerDTO.convertToDTO(customerService.getById(id));
    }

    @PutMapping("update")
    public CustomerDTO updateCustomer(@RequestBody Customer customer) {
        return CustomerDTO.convertToDTO(customerService.update(customer.getId(), customer));
    }

    @DeleteMapping("deleteById")
    public Boolean deleteById(@RequestParam Long id) {
        customerService.softDelete(id);
        return true;
    }
}
