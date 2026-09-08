package Logistics_Freight_Network_System.repository;

import Logistics_Freight_Network_System.entity.DeliveryStop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DeliveryStopRepository extends JpaRepository<DeliveryStop, Long> {
    @Query("SELECT ds FROM DeliveryStop ds JOIN FETCH ds.route JOIN FETCH ds.shipment WHERE ds.isActive=true")
    List<DeliveryStop> getAllDeliveryStops();

    @Query("SELECT ds FROM DeliveryStop ds JOIN FETCH ds.route JOIN FETCH ds.shipment WHERE ds.isActive=true AND ds.id=:id")
    DeliveryStop getDeliveryStopById(@Param("id") Long id);
}
