package Logistics_Freight_Network_System.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "service_zones")
public class ServiceZone extends BaseClass {

    @Column(nullable = false, length = 80)
    private String name;

    @Column(nullable = false, length = 80)
    private String region;

    @Column(nullable = false)
    private Double baseRate;

    // Covers many delivery addresses/areas
    @OneToMany(mappedBy = "serviceZone")
    private List<Address> addresses = new ArrayList<>();
}
