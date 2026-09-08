package Logistics_Freight_Network_System.controller;

// ---------------- ProductController ----------------
import Logistics_Freight_Network_System.dto.ProductDTO;
import Logistics_Freight_Network_System.entity.Product;
import Logistics_Freight_Network_System.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {

    ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("add")
    public ProductDTO addProduct(@RequestBody Product product) {
        return ProductDTO.convertToDTO(productService.create(product));
    }

    @GetMapping("getAll")
    public List<ProductDTO> getAllProducts() {
        return ProductDTO.convertToDTO(productService.getAll());
    }

    @GetMapping("getById")
    public ProductDTO getById(@RequestParam Long id) {
        return ProductDTO.convertToDTO(productService.getById(id));
    }

    @PutMapping("update")
    public ProductDTO updateProduct(@RequestBody Product product) {
        return ProductDTO.convertToDTO(productService.update(product.getId(), product));
    }

    @DeleteMapping("deleteById")
    public Boolean deleteById(@RequestParam Long id) {
        productService.softDelete(id);
        return true;
    }
}