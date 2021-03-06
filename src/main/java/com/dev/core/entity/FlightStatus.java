package com.dev.core.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
ACTIVE, COMPLETED, DELAYED, PENDING
 */
@Entity
@Table(name = "flight_statuses")
@Data
@NoArgsConstructor
public class FlightStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String statusName;
}
