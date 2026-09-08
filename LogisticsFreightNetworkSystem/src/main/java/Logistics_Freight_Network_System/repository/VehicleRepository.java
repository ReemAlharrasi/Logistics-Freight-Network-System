package Logistics_Freight_Network_System.repository;

import Logistics_Freight_Network_System.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    @Query("SELECT v FROM Vehicle v JOIN FETCH v.carrier WHERE v.isActive=true")
    List<Vehicle> getAllVehicles();

    @Query("SELECT v FROM Vehicle v JOIN FETCH v.carrier WHERE v.isActive=true AND v.id=:id")
    Vehicle getVehicleById(@Param("id") Long id);
}
