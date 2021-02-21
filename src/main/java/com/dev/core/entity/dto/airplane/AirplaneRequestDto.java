package com.dev.core.entity.dto.airplane;

public class AirplaneRequestDto {
    private String name;
    private Long airplaneTypeId;
    private String factorySerialNumber;
    private Long airCompanyId;
    private int numberOfFlights;
    private int flightDistance;
    private int fuelCapacity;
    private int createdAt;
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Long getAirplaneTypeId() {
        return airplaneTypeId;
    }
    
    public void setAirplaneTypeId(Long airplaneTypeId) {
        this.airplaneTypeId = airplaneTypeId;
    }
    
    public String getFactorySerialNumber() {
        return factorySerialNumber;
    }
    
    public void setFactorySerialNumber(String factorySerialNumber) {
        this.factorySerialNumber = factorySerialNumber;
    }
    
    public Long getAirCompanyId() {
        return airCompanyId;
    }
    
    public void setAirCompanyId(Long airCompanyId) {
        this.airCompanyId = airCompanyId;
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
