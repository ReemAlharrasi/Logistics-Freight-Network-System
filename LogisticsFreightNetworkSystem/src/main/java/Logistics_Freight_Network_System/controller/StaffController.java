package Logistics_Freight_Network_System.controller;

// ---------------- StaffController ----------------
import Logistics_Freight_Network_System.dto.StaffDTO;
import Logistics_Freight_Network_System.entity.Staff;
import Logistics_Freight_Network_System.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("staff")
public class StaffController {

    StaffService staffService;

    @Autowired
    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }

    @PostMapping("add")
    public StaffDTO addStaff(@RequestBody Staff staff) {
        return StaffDTO.convertToDTO(staffService.create(staff));
    }

    @GetMapping("getAll")
    public List<StaffDTO> getAllStaff() {
        return StaffDTO.convertToDTO(staffService.getAll());
    }

    @GetMapping("getById")
    public StaffDTO getById(@RequestParam Long id) {
        return StaffDTO.convertToDTO(staffService.getById(id));
    }

    @PutMapping("update")
    public StaffDTO updateStaff(@RequestBody Staff staff) {
        return StaffDTO.convertToDTO(staffService.update(staff.getId(), staff));
    }

    @DeleteMapping("deleteById")
    public Boolean deleteById(@RequestParam Long id) {
        staffService.softDelete(id);
        return true;
    }
}
