package Logistics_Freight_Network_System.repository;

import Logistics_Freight_Network_System.entity.TrackingEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TrackingEventRepository extends JpaRepository<TrackingEvent, Long> {
    @Query("SELECT t FROM TrackingEvent t WHERE t.isActive=true")
    List<TrackingEvent> getAllTrackingEvents();

    @Query("SELECT t FROM TrackingEvent t WHERE t.isActive=true AND t.id=:id")
    TrackingEvent getTrackingEventById(@Param("id") Long id);
}
