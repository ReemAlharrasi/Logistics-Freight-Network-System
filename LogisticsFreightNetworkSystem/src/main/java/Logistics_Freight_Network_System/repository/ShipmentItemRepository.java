package Logistics_Freight_Network_System.repository;

import Logistics_Freight_Network_System.entity.ShipmentItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ShipmentItemRepository extends JpaRepository<ShipmentItem, Long> {

    @Query("SELECT si FROM ShipmentItem si WHERE si.isActive=true")
    List<ShipmentItem> getAllShipmentItems();

    @Query("SELECT si FROM ShipmentItem si WHERE si.isActive=true AND si.id=:id")
    ShipmentItem getShipmentItemById(@Param("id") Long id);
}
