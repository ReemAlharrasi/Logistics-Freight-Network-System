package Logistics_Freight_Network_System.service;

// ---------------- ProductService ----------------
import Logistics_Freight_Network_System.entity.Product;
import Logistics_Freight_Network_System.repository.ProductRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAll() {
        return productRepository.getAllProducts();
    }

    public Product getById(Long id) {
        return productRepository.getProductById(id);
    }

    public Product create(Product product) {
        if (product.getSku() == null || product.getSku().isBlank()) {
            return new Product();
        }
        return productRepository.save(product);
    }

    public Product update(Long id, Product updated) {
        Product existing = getById(id);
        existing.setName(updated.getName());
        existing.setSku(updated.getSku());
        existing.setWeightKg(updated.getWeightKg());
        existing.setCategory(updated.getCategory());
        return productRepository.save(existing);
    }

    public void softDelete(Long id) {
        Product existing = getById(id);
        existing.setActive(false);
        productRepository.save(existing);
    }
}