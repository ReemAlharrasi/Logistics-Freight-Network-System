package Logistics_Freight_Network_System.controller;

// ---------------- InvoiceController ----------------
import Logistics_Freight_Network_System.entity.Invoice;
import Logistics_Freight_Network_System.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("invoice")
public class InvoiceController {

    InvoiceService invoiceService;

    @Autowired
    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @PostMapping("add")
    public Invoice addInvoice(@RequestBody Invoice invoice) {
        return invoiceService.create(invoice);
    }

    @GetMapping("getAll")
    public List<Invoice> getAllInvoices() {
        return invoiceService.getAll();
    }

    @GetMapping("getById")
    public Invoice getById(@RequestParam Long id) {
        return invoiceService.getById(id);
    }

    @PutMapping("update")
    public Invoice updateInvoice(@RequestBody Invoice invoice) {
        return invoiceService.update(invoice.getId(), invoice);
    }

    @DeleteMapping("deleteById")
    public Boolean deleteById(@RequestParam Long id) {
        invoiceService.softDelete(id);
        return true;
    }
}