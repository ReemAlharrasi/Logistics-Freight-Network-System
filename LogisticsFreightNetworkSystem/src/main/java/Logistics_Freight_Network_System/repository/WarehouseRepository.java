package Logistics_Freight_Network_System.repository;

import Logistics_Freight_Network_System.entity.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {

    @Query("SELECT w FROM Warehouse w WHERE w.isActive=true")
    List<Warehouse> getAllWarehouses();

    @Query("SELECT w FROM Warehouse w WHERE w.isActive=true AND w.id=:id")
    Warehouse getWarehouseById(@Param("id") Long id);
}
