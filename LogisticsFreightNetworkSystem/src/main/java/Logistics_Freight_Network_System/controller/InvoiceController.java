package Logistics_Freight_Network_System.controller;

/// ---------------- InvoiceController ----------------
import Logistics_Freight_Network_System.dto.InvoiceDTO;
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
    public InvoiceDTO addInvoice(@RequestBody Invoice invoice) {
        return InvoiceDTO.convertToDTO(invoiceService.create(invoice));
    }

    @GetMapping("getAll")
    public List<InvoiceDTO> getAllInvoices() {
        return InvoiceDTO.convertToDTO(invoiceService.getAll());
    }

    @GetMapping("getById")
    public InvoiceDTO getById(@RequestParam Long id) {
        return InvoiceDTO.convertToDTO(invoiceService.getById(id));
    }

    @PutMapping("update")
    public InvoiceDTO updateInvoice(@RequestBody Invoice invoice) {
        return InvoiceDTO.convertToDTO(invoiceService.update(invoice.getId(), invoice));
    }

    @DeleteMapping("deleteById")
    public Boolean deleteById(@RequestParam Long id) {
        invoiceService.softDelete(id);
        return true;
    }
}