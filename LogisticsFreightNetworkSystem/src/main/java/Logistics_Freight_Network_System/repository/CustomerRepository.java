package Logistics_Freight_Network_System.repository;

import Logistics_Freight_Network_System.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query("SELECT c FROM Customer c WHERE c.isActive=true")
    List<Customer> getAllCustomers();

    @Query("SELECT c FROM Customer c WHERE c.isActive=true AND c.id=:id")
    Customer getCustomerById(@Param("id") Long id);
}
