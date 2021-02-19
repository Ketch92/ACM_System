package com.dev.core.entity;

import java.time.Duration;
import java.time.LocalDateTime;
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

@Entity
@Table(name = "flights")
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
    private Airplane airplane;
    @Column(name = "departure_country")
    private String departureCountry;
    @Column(name = "destination_country")
    private String destinationCountry;
    private int distance;
    @Column(name = "estimated_flight_time")
    private int estimatedFlightTime;
    @Column(name = "ended_at")
    private LocalDateTime endedAt;
    @Column(name = "delay_started_at")
    private LocalDateTime delayStartedAt;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public FlightStatus getFlightStatus() {
        return flightStatus;
    }
    
    public void setFlightStatus(FlightStatus flightStatus) {
        this.flightStatus = flightStatus;
    }
    
    public AirCompany getAirCompany() {
        return airCompany;
    }
    
    public void setAirCompany(AirCompany airCompany) {
        this.airCompany = airCompany;
    }
    
    public Airplane getAirplane() {
        return airplane;
    }
    
    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }
    
    public String getDepartureCountry() {
        return departureCountry;
    }
    
    public void setDepartureCountry(String departureCountry) {
        this.departureCountry = departureCountry;
    }
    
    public String getDestinationCountry() {
        return destinationCountry;
    }
    
    public void setDestinationCountry(String destinationCountry) {
        this.destinationCountry = destinationCountry;
    }
    
    public int getDistance() {
        return distance;
    }
    
    public void setDistance(int distance) {
        this.distance = distance;
    }
    
    public int getEstimatedFlightTime() {
        return estimatedFlightTime;
    }
    
    public void setEstimatedFlightTime(int estimatedFlightTime) {
        this.estimatedFlightTime = estimatedFlightTime;
    }
    
    public LocalDateTime getEndedAt() {
        return endedAt;
    }
    
    public void setEndedAt(LocalDateTime endedAt) {
        this.endedAt = endedAt;
    }
    
    public LocalDateTime getDelayStartedAt() {
        return delayStartedAt;
    }
    
    public void setDelayStartedAt(LocalDateTime delayStartedAt) {
        this.delayStartedAt = delayStartedAt;
    }
    
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Flight flight = (Flight) o;
        return distance == flight.distance
               && Objects.equals(id, flight.id)
               && Objects.equals(flightStatus, flight.flightStatus)
               && Objects.equals(airCompany, flight.airCompany)
               && Objects.equals(airplane, flight.airplane)
               && Objects.equals(departureCountry, flight.departureCountry)
               && Objects.equals(destinationCountry, flight.destinationCountry)
               && Objects.equals(estimatedFlightTime, flight.estimatedFlightTime)
               && Objects.equals(endedAt, flight.endedAt)
               && Objects.equals(delayStartedAt, flight.delayStartedAt)
               && Objects.equals(createdAt, flight.createdAt);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id, flightStatus, airCompany,
                airplane, departureCountry, destinationCountry,
                distance, estimatedFlightTime, endedAt,
                delayStartedAt, createdAt);
    }
}
