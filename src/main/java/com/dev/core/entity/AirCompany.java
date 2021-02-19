package com.dev.core.entity;

import com.dev.core.entity.type.CompanyType;
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
@Table(name = "air_companies")
public class AirCompany {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "company_type")
    private CompanyType companyType;
    @Column(name = "founded_at")
    private int foundedAt;
    
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
    
    public CompanyType getCompanyType() {
        return companyType;
    }
    
    public void setCompanyType(CompanyType companyType) {
        this.companyType = companyType;
    }
    
    public int getFoundedAt() {
        return foundedAt;
    }
    
    public void setFoundedAt(int foundedAt) {
        this.foundedAt = foundedAt;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AirCompany that = (AirCompany) o;
        return foundedAt == that.foundedAt
               && Objects.equals(id, that.id)
               && Objects.equals(name, that.name)
               && Objects.equals(companyType, that.companyType);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id, name, companyType, foundedAt);
    }
    
    @Override
    public String toString() {
        return "AirCompany{"
               + "id=" + id
               + ", name='" + name + '\''
               + ", companyType=" + companyType
               + ", foundedAt=" + foundedAt
               + '}';
    }
}
