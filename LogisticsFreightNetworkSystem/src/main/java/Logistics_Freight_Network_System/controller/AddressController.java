package Logistics_Freight_Network_System.controller;

// ---------------- AddressController ----------------
import Logistics_Freight_Network_System.entity.Address;
import Logistics_Freight_Network_System.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("address")
public class AddressController {

    AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping("add")
    public Address addAddress(@RequestBody Address address) {
        return addressService.create(address);
    }

    @GetMapping("getAll")
    public List<Address> getAllAddresses() {
        return addressService.getAll();
    }

    @GetMapping("getById")
    public Address getById(@RequestParam Long id) {
        return addressService.getById(id);
    }

    @PutMapping("update")
    public Address updateAddress(@RequestBody Address address) {
        return addressService.update(address.getId(), address);
    }

    @DeleteMapping("deleteById")
    public Boolean deleteById(@RequestParam Long id) {
        addressService.softDelete(id);
        return true;
    }
}
