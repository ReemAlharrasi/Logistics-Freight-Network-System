package Logistics_Freight_Network_System.controller;

// ---------------- InvoiceController ----------------
import Logistics_Freight_Network_System.entity.Invoice;
import Logistics_Freight_Network_System.service.InvoiceService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/invoices")
public class InvoiceController {

    private final InvoiceService invoiceService;

    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping
    public List<Invoice> getAll() {
        return invoiceService.getAll();
    }

    @GetMapping("/{id}")
    public Invoice getById(@PathVariable Long id) {
        return invoiceService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Invoice create(@RequestBody Invoice invoice) {
        return invoiceService.create(invoice);
    }

    @PutMapping("/{id}")
    public Invoice update(@PathVariable Long id, @RequestBody Invoice invoice) {
        return invoiceService.update(id, invoice);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void softDelete(@PathVariable Long id) {
        invoiceService.softDelete(id);
    }
}