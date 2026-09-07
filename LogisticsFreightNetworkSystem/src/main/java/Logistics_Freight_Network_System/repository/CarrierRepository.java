package Logistics_Freight_Network_System.repository;

import Logistics_Freight_Network_System.entity.Carrier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CarrierRepository extends JpaRepository<Carrier, Long> {
    @Query("SELECT c FROM Carrier c WHERE c.isActive=true")
    List<Carrier> getAllCarriers();

    @Query("SELECT c FROM Carrier c WHERE c.isActive=true AND c.id=:id")
    Carrier getCarrierById(@Param("id") Long id);
}
