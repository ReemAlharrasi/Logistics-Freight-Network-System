package Logistics_Freight_Network_System.repository;

import Logistics_Freight_Network_System.entity.InventoryItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface InventoryItemRepository extends JpaRepository<InventoryItem, Long> {

    @Query("SELECT i FROM InventoryItem i WHERE i.isActive=true")
    List<InventoryItem> getAllInventoryItems();

    @Query("SELECT i FROM InventoryItem i WHERE i.isActive=true AND i.id=:id")
    InventoryItem getInventoryItemById(@Param("id") Long id);
}
