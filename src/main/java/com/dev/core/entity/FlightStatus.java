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
    private String status;
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
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
        return Objects.equals(id, that.id) && Objects.equals(status, that.status);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id, status);
    }
    
    @Override
    public String toString() {
        return "FlightStatus{"
               + "id=" + id
               + ", status='" + status + '\''
               + '}';
    }
}
