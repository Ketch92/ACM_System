package com.dev.core.entity;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
ACTIVE, COMPLETED, DELAYED, PENDING
 */
@Entity
@Table(name = "flight_statuses")
public class FlightStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String statusName;
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getStatusName() {
        return statusName;
    }
    
    public void setStatusName(String status) {
        this.statusName = status;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FlightStatus that = (FlightStatus) o;
        return Objects.equals(id, that.id) && Objects.equals(statusName, that.statusName);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id, statusName);
    }
    
    @Override
    public String toString() {
        return "FlightStatus{"
               + "id=" + id
               + ", status='" + statusName + '\''
               + '}';
    }
}
