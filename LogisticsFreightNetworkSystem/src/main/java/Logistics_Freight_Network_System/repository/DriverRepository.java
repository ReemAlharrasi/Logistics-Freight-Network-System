package Logistics_Freight_Network_System.repository;

import Logistics_Freight_Network_System.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DriverRepository extends JpaRepository<Driver, Long> {
    @Query("SELECT d FROM Driver d WHERE d.isActive=true")
    List<Driver> getAllDrivers();

    @Query("SELECT d FROM Driver d WHERE d.isActive=true AND d.id=:id")
    Driver getDriverById(@Param("id") Long id);
}
