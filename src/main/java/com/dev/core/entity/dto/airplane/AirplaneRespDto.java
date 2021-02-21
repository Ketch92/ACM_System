package com.dev.core.entity.dto.airplane;

public class AirplaneRespDto {
    private Long id;
    private String name;
    private String airplaneType;
    private String factorySerialNumber;
    private String airCompanyName;
    private int numberOfFlights;
    private int flightDistance;
    private int fuelCapacity;
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
    
    public String getAirplaneType() {
        return airplaneType;
    }
    
    public void setAirplaneType(String airplaneType) {
        this.airplaneType = airplaneType;
    }
    
    public String getFactorySerialNumber() {
        return factorySerialNumber;
    }
    
    public void setFactorySerialNumber(String factorySerialNumber) {
        this.factorySerialNumber = factorySerialNumber;
    }
    
    public String getAirCompanyName() {
        return airCompanyName;
    }
    
    public void setAirCompanyName(String airCompanyName) {
        this.airCompanyName = airCompanyName;
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
    
    public int getCreatedAt() {
        return createdAt;
    }
    
    public void setCreatedAt(int createdAt) {
        this.createdAt = createdAt;
    }
}
