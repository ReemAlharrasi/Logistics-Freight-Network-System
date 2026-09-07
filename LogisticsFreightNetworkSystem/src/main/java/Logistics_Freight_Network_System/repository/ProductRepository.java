package Logistics_Freight_Network_System.repository;

import Logistics_Freight_Network_System.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT p FROM Product p WHERE p.isActive=true")
    List<Product> getAllProducts();

    @Query("SELECT p FROM Product p WHERE p.isActive=true AND p.id=:id")
    Product getProductById(@Param("id") Long id);
}
