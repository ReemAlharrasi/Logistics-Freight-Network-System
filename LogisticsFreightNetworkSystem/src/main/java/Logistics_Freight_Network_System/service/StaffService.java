package Logistics_Freight_Network_System.service;


// ---------------- StaffService ----------------
import Logistics_Freight_Network_System.entity.Shipment;
import Logistics_Freight_Network_System.entity.Staff;
import Logistics_Freight_Network_System.entity.Warehouse;
import Logistics_Freight_Network_System.repository.StaffRepository;
import Logistics_Freight_Network_System.repository.WarehouseRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StaffService {

    private final StaffRepository staffRepository;
    private final WarehouseRepository warehouseRepository;

    public StaffService(StaffRepository staffRepository, WarehouseRepository warehouseRepository) {
        this.staffRepository = staffRepository;
        this.warehouseRepository = warehouseRepository;
    }

    public List<Staff> getAll() {
        return staffRepository.getAllStaff();
    }

    public Staff getById(Long id) {
        return staffRepository.getStaffById(id);
    }

    public Staff create(Staff staff) {
        if (staff.getWarehouse() == null || staff.getWarehouse().getId() == null) {
            return new Staff();
        }
        staff.setWarehouse(warehouseRepository.getWarehouseById(staff.getWarehouse().getId()));
        return staffRepository.save(staff);
    }

    public Staff update(Long id, Staff updated) {
        Staff existing = getById(id);
        existing.setName(updated.getName());
        existing.setRole(updated.getRole());
        existing.setPhoneNumber(updated.getPhoneNumber());
        if (updated.getWarehouse() != null && updated.getWarehouse().getId() != null) {
            existing.setWarehouse(warehouseRepository.getWarehouseById(updated.getWarehouse().getId()));
        }
        return staffRepository.save(existing);
    }

    public void softDelete(Long id) {
        Staff existing = getById(id);
        existing.setActive(false);
        staffRepository.save(existing);
    }
}
