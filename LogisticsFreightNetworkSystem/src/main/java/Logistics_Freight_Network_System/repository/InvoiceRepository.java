package Logistics_Freight_Network_System.repository;

import Logistics_Freight_Network_System.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
    @Query("SELECT inv FROM Invoice inv WHERE inv.isActive=true")
    List<Invoice> getAllInvoices();

    @Query("SELECT inv FROM Invoice inv WHERE inv.isActive=true AND inv.id=:id")
    Invoice getInvoiceById(@Param("id") Long id);
}
