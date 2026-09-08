package Logistics_Freight_Network_System.repository;

import Logistics_Freight_Network_System.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Long> {
    @Query("SELECT a FROM Address a JOIN FETCH a.customer LEFT JOIN FETCH a.serviceZone WHERE a.isActive=true")
    List<Address> getAllAddresses();

    @Query("SELECT a FROM Address a JOIN FETCH a.customer LEFT JOIN FETCH a.serviceZone WHERE a.isActive=true AND a.id=:id")
    Address getAddressById(@Param("id") Long id);
}
