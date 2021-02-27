package com.dev.core.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "flights")
@Data
@NoArgsConstructor
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "flight_status")
    private FlightStatus flightStatus;
    @ManyToOne
    @JoinColumn(name = "air_company")
    private AirCompany airCompany;
    @OneToMany
    private List<Airplane> airplanes;
    @Column(name = "departure_country")
    private String departureCountry;
    @Column(name = "destination_country")
    private String destinationCountry;
    private int distance;
    @Column(name = "estimated_flight_time")
    private int estimatedFlightTime;
    @Column(name = "started_at")
    private LocalDateTime startedAt;
    @Column(name = "ended_at")
    private LocalDateTime endedAt;
    @Column(name = "delay_started_at")
    private LocalDateTime delayStartedAt;
    @Column(name = "created_at")
    private LocalDate createdAt;
}
