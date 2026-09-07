package Logistics_Freight_Network_System.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "carriers")
public class Carrier extends BaseClass {

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 100)
    private String contactEmail;

    @Column(nullable = false, length = 20)
    private String phoneNumber;

    @Column(nullable = false, length = 60)
    private String country;

    @OneToMany(mappedBy = "carrier")
    private List<Shipment> shipments = new ArrayList<>();

    @OneToMany(mappedBy = "carrier", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Vehicle> vehicles = new ArrayList<>();

    @OneToMany(mappedBy = "carrier", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Driver> drivers = new ArrayList<>();
}
