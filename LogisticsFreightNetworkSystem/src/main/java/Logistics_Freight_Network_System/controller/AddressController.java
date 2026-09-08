package Logistics_Freight_Network_System.controller;

// ---------------- AddressController ----------------
import Logistics_Freight_Network_System.dto.AddressDTO;
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
    public AddressDTO addAddress(@RequestBody Address address) {
        return AddressDTO.convertToDTO(addressService.create(address));
    }

    @GetMapping("getAll")
    public List<AddressDTO> getAllAddresses() {
        return AddressDTO.convertToDTO(addressService.getAll());
    }

    @GetMapping("getById")
    public AddressDTO getById(@RequestParam Long id) {
        return AddressDTO.convertToDTO(addressService.getById(id));
    }

    @PutMapping("update")
    public AddressDTO updateAddress(@RequestBody Address address) {
        return AddressDTO.convertToDTO(addressService.update(address.getId(), address));
    }

    @DeleteMapping("deleteById")
    public Boolean deleteById(@RequestParam Long id) {
        addressService.softDelete(id);
        return true;
    }
}