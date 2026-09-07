package Logistics_Freight_Network_System.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Getter
@Setter
@Entity
@Table(name = "inventory_items")
public class InventoryItem extends BaseClass {

    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false, length = 50)
    private String shelfLocation;

    @ManyToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "warehouse_id", nullable = false)
    private Warehouse warehouse;

    @ManyToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;
}
