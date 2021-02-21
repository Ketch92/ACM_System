package com.dev.core.entity.dto.flight;

import com.sun.istack.NotNull;
import java.util.Set;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

public class FlightRequestDto {
    @NotNull
    private Long flightStatusId;
    @NotNull
    private Long airCompanyId;
    private Set<Long> airplaneIds;
    @NotNull
    @NotBlank
    private String departureCountry;
    @NotNull
    @NotBlank
    private String destinationCountry;
    @Positive
    private int distance;
    @Positive
    private int estimatedFlightTime;
    private String startedAt;
    private String endedAt;
    private String delayStartedAt;
    @NotNull
    @NotBlank
    private String createdAt;
    
    public String getStartedAt() {
        return startedAt;
    }
    
    public void setStartedAt(String startedAt) {
        this.startedAt = startedAt;
    }
    
    public Long getFlightStatusId() {
        return flightStatusId;
    }
    
    public void setFlightStatusId(Long flightStatusId) {
        this.flightStatusId = flightStatusId;
    }
    
    public Long getAirCompanyId() {
        return airCompanyId;
    }
    
    public void setAirCompanyId(Long airCompanyId) {
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
