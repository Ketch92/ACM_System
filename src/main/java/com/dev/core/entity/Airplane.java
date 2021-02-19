package com.dev.core.entity;

import com.dev.core.entity.type.AirplaneType;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "airplanes")
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
    private int createdAt;
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getFactorySerialNumber() {
        return factorySerialNumber;
    }
    
    public void setFactorySerialNumber(String factorySerialNumber) {
        this.factorySerialNumber = factorySerialNumber;
    }
    
    public AirCompany getAirCompany() {
        return airCompany;
    }
    
    public void setAirCompany(AirCompany airCompany) {
        this.airCompany = airCompany;
    }
    
    public int getNumberOfFlights() {
        return numberOfFlights;
    }
    
    public void setNumberOfFlights(int numberOfFlights) {
        this.numberOfFlights = numberOfFlights;
    }
    
    public int getFlightDistance() {
        return flightDistance;
    }
    
    public void setFlightDistance(int flightDistance) {
        this.flightDistance = flightDistance;
    }
    
    public int getFuelCapacity() {
        return fuelCapacity;
    }
    
    public void setFuelCapacity(int fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }
    
    public AirplaneType getType() {
        return airplaneType;
    }
    
    public void setType(AirplaneType airplaneType) {
        this.airplaneType = airplaneType;
    }
    
    public int getCreatedAt() {
        return createdAt;
    }
    
    public void setCreatedAt(int createdAt) {
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
        Airplane airplane = (Airplane) o;
        return numberOfFlights == airplane.numberOfFlights
               && flightDistance == airplane.flightDistance
               && fuelCapacity == airplane.fuelCapacity
               && createdAt == airplane.createdAt
               && Objects.equals(id, airplane.id)
               && Objects.equals(name, airplane.name)
               && Objects.equals(factorySerialNumber, airplane.factorySerialNumber)
               && Objects.equals(airCompany, airplane.airCompany)
               && Objects.equals(airplaneType, airplane.airplaneType);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id, name, factorySerialNumber,
                airCompany, numberOfFlights, flightDistance,
                fuelCapacity, airplaneType, createdAt);
    }
    
    @Override
    public String toString() {
        return "Airplane{"
               + "id=" + id
               + ", name='" + name + '\''
               + ", factorySerialNumber='" + factorySerialNumber + '\''
               + ", airCompany=" + airCompany
               + ", numberOfFlights=" + numberOfFlights
               + ", flightDistance=" + flightDistance
               + ", fuelCapacity=" + fuelCapacity
               + ", type=" + airplaneType
               + ", createdAt=" + createdAt
               + '}';
    }
}
