package Logistics_Freight_Network_System.service;


// ---------------- InvoiceService ----------------
import Logistics_Freight_Network_System.entity.InventoryItem;
import Logistics_Freight_Network_System.entity.Invoice;
import Logistics_Freight_Network_System.entity.Shipment;
import Logistics_Freight_Network_System.entity.Customer;
import Logistics_Freight_Network_System.repository.InvoiceRepository;
import Logistics_Freight_Network_System.repository.ShipmentRepository;
import Logistics_Freight_Network_System.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class InvoiceService {

    private final InvoiceRepository invoiceRepository;
    private final ShipmentRepository shipmentRepository;
    private final CustomerRepository customerRepository;

    public InvoiceService(InvoiceRepository invoiceRepository,
                          ShipmentRepository shipmentRepository,
                          CustomerRepository customerRepository) {
        this.invoiceRepository = invoiceRepository;
        this.shipmentRepository = shipmentRepository;
        this.customerRepository = customerRepository;
    }

    public List<Invoice> getAll() {
        return invoiceRepository.getAllInvoices();
    }

    public Invoice getById(Long id) {
        return invoiceRepository.getInvoiceById(id);
    }

    public Invoice create(Invoice invoice) {
        if (invoice.getShipment() == null || invoice.getShipment().getId() == null) {
            return new Invoice();
        }
        if (invoice.getCustomer() == null || invoice.getCustomer().getId() == null) {
            return new Invoice();
        }
        invoice.setShipment(shipmentRepository.getShipmentById(invoice.getShipment().getId()));
        invoice.setCustomer(customerRepository.getCustomerById(invoice.getCustomer().getId()));
        return invoiceRepository.save(invoice);
    }

    public Invoice update(Long id, Invoice updated) {
        Invoice existing = getById(id);
        existing.setAmount(updated.getAmount());
        existing.setStatus(updated.getStatus());
        existing.setIssuedDate(updated.getIssuedDate());
        return invoiceRepository.save(existing);
    }

    public void softDelete(Long id) {
        Invoice existing = getById(id);
        existing.setActive(false);
        invoiceRepository.save(existing);
    }
}