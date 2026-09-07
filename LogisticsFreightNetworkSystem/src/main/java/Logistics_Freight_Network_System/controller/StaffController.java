package Logistics_Freight_Network_System.controller;

// ---------------- StaffController ----------------
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
    public Staff addStaff(@RequestBody Staff staff) {
        return staffService.create(staff);
    }

    @GetMapping("getAll")
    public List<Staff> getAllStaff() {
        return staffService.getAll();
    }

    @GetMapping("getById")
    public Staff getById(@RequestParam Long id) {
        return staffService.getById(id);
    }

    @PutMapping("update")
    public Staff updateStaff(@RequestBody Staff staff) {
        return staffService.update(staff.getId(), staff);
    }

    @DeleteMapping("deleteById")
    public Boolean deleteById(@RequestParam Long id) {
        staffService.softDelete(id);
        return true;
    }
}