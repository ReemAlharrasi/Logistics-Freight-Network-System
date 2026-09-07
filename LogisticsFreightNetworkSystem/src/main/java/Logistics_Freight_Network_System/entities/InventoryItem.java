package Logistics_Freight_Network_System.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "inventory_items")
public class InventoryItem extends BaseClass {

    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false, length = 50)
    private String shelfLocation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "warehouse_id", nullable = false)
    private Warehouse warehouse;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;
}
