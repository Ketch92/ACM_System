package com.dev.core.entity;

import com.dev.core.entity.type.AirplaneType;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "airplanes")
@Data
@NoArgsConstructor
public class Airplane {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name = "factory_serial_number")
    private String factorySerialNumber;
    @ManyToOne
    @JoinColumn(name = "air_company")
    private AirCompany airCompany;
    @Column(name = "number_of_flights")
    private int numberOfFlights;
    @Column(name = "flight_distance")
    private int flightDistance;
    @Column(name = "fuel_capacity")
    private int fuelCapacity;
    @ManyToOne
    @JoinColumn(name = "airplane_type")
    private AirplaneType airplaneType;
    @Column(name = "created_at")
    private LocalDate createdAt;
}
