package com.dev.core.entity.dto.flight;

import java.util.Set;

public class FlightRequestDto {
    private String flightStatusId;
    private String airCompanyId;
    private Set<Long> airplaneIds;
    private String departureCountry;
    private String destinationCountry;
    private int distance;
    private int estimatedFlightTime;
    private String endedAt;
    private String delayStartedAt;
    private String createdAt;
    
    public String getFlightStatusId() {
        return flightStatusId;
    }
    
    public void setFlightStatusId(String flightStatusId) {
        this.flightStatusId = flightStatusId;
    }
    
    public String getAirCompanyId() {
        return airCompanyId;
    }
    
    public void setAirCompanyId(String airCompanyId) {
        this.airCompanyId = airCompanyId;
    }
    
    public Set<Long> getAirplaneIds() {
        return airplaneIds;
    }
    
    public void setAirplaneIds(Set<Long> airplaneIds) {
        this.airplaneIds = airplaneIds;
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
    
    public String getEndedAt() {
        return endedAt;
    }
    
    public void setEndedAt(String endedAt) {
        this.endedAt = endedAt;
    }
    
    public String getDelayStartedAt() {
        return delayStartedAt;
    }
    
    public void setDelayStartedAt(String delayStartedAt) {
        this.delayStartedAt = delayStartedAt;
    }
    
    public String getCreatedAt() {
        return createdAt;
    }
    
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
