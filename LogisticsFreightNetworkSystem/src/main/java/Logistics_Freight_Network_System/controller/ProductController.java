package Logistics_Freight_Network_System.controller;

// ---------------- ProductController ----------------
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
    public Product addProduct(@RequestBody Product product) {
        return productService.create(product);
    }

    @GetMapping("getAll")
    public List<Product> getAllProducts() {
        return productService.getAll();
    }

    @GetMapping("getById")
    public Product getById(@RequestParam Long id) {
        return productService.getById(id);
    }

    @PutMapping("update")
    public Product updateProduct(@RequestBody Product product) {
        return productService.update(product.getId(), product);
    }

    @DeleteMapping("deleteById")
    public Boolean deleteById(@RequestParam Long id) {
        productService.softDelete(id);
        return true;
    }
}