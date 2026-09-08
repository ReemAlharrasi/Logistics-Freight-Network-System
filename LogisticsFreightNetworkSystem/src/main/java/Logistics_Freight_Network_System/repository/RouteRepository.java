package Logistics_Freight_Network_System.repository;

import Logistics_Freight_Network_System.entity.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RouteRepository extends JpaRepository<Route, Long> {
    @Query("SELECT r FROM Route r JOIN FETCH r.vehicle JOIN FETCH r.driver WHERE r.isActive=true")
    List<Route> getAllRoutes();

    @Query("SELECT r FROM Route r JOIN FETCH r.vehicle JOIN FETCH r.driver WHERE r.isActive=true AND r.id=:id")
    Route getRouteById(@Param("id") Long id);
}
