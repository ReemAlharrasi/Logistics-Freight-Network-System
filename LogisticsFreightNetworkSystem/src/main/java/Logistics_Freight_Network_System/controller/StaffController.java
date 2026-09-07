package Logistics_Freight_Network_System.controller;

// ---------------- StaffController ----------------
import Logistics_Freight_Network_System.entity.Staff;
import Logistics_Freight_Network_System.service.StaffService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/staff")
public class StaffController {

    private final StaffService staffService;

    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }

    @GetMapping
    public List<Staff> getAll() {
        return staffService.getAll();
    }

    @GetMapping("/{id}")
    public Staff getById(@PathVariable Long id) {
        return staffService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Staff create(@RequestBody Staff staff) {
        return staffService.create(staff);
    }

    @PutMapping("/{id}")
    public Staff update(@PathVariable Long id, @RequestBody Staff staff) {
        return staffService.update(id, staff);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void softDelete(@PathVariable Long id) {
        staffService.softDelete(id);
    }
}
