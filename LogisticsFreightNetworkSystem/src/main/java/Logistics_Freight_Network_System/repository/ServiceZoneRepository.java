package Logistics_Freight_Network_System.repository;

import Logistics_Freight_Network_System.entity.ServiceZone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ServiceZoneRepository extends JpaRepository<ServiceZone, Long> {

    @Query("SELECT sz FROM ServiceZone sz WHERE sz.isActive=true")
    List<ServiceZone> getAllServiceZones();

    @Query("SELECT sz FROM ServiceZone sz WHERE sz.isActive=true AND sz.id=:id")
    ServiceZone getServiceZoneById(@Param("id") Long id);
}
