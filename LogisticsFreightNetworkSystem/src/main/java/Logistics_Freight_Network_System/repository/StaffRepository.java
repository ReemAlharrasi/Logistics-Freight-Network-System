package Logistics_Freight_Network_System.repository;

import Logistics_Freight_Network_System.entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StaffRepository extends JpaRepository<Staff, Long> {
    @Query("SELECT st FROM Staff st WHERE st.isActive=true")
    List<Staff> getAllStaff();

    @Query("SELECT st FROM Staff st WHERE st.isActive=true AND st.id=:id")
    Staff getStaffById(@Param("id") Long id);
}
