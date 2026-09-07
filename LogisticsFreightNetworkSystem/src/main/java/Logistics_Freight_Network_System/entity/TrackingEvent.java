package Logistics_Freight_Network_System.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "tracking_events")
public class TrackingEvent extends BaseClass {

    @Column(nullable = false)
    private LocalDateTime eventTime;

    @Column(nullable = false, length = 100)
    private String location;

    @Column(nullable = false, length = 30)
    private String status;

    @Column(length = 255)
    private String note;

    @ManyToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "shipment_id", nullable = false)
    private Shipment shipment;
}