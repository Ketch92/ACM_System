package com.dev.core.entity.dto.flight;

import com.dev.core.entity.dto.airplane.AirplaneRespDto;
import java.util.List;

public class FlightRespDto {
    private Long id;
    private String flightStatus;
    private String airCompanyName;
    private List<AirplaneRespDto> airplanes;
    private String departureCountry;
    private String destinationCountry;
    private int distance;
    private int estimatedFlightTime;
    private String endedAt;
    private String delayStartedAt;
    private String createdAt;
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getFlightStatus() {
        return flightStatus;
    }
    
    public void setFlightStatus(String flightStatus) {
        this.flightStatus = flightStatus;
    }
    
    public String getAirCompanyName() {
        return airCompanyName;
    }
    
    public void setAirCompanyName(String airCompanyName) {
        this.airCompanyName = airCompanyName;
    }
    
    public List<AirplaneRespDto> getAirplanes() {
        return airplanes;
    }
    
    public void setAirplanes(List<AirplaneRespDto> airplanes) {
        this.airplanes = airplanes;
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
