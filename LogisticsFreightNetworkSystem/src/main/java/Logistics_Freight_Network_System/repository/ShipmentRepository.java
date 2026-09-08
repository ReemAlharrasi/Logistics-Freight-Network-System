package Logistics_Freight_Network_System.repository;

import Logistics_Freight_Network_System.entity.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ShipmentRepository extends JpaRepository<Shipment, Long> {

    @Query("SELECT s FROM Shipment s JOIN FETCH s.warehouse JOIN FETCH s.customer LEFT JOIN FETCH s.carrier WHERE s.isActive=true")
    List<Shipment> getAllShipments();

    @Query("SELECT s FROM Shipment s JOIN FETCH s.warehouse JOIN FETCH s.customer LEFT JOIN FETCH s.carrier WHERE s.isActive=true AND s.id=:id")
    Shipment getShipmentById(@Param("id") Long id);
}
