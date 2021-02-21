package com.dev.core.entity.type;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "company_types")
public class CompanyType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String typeName;
    
    public CompanyType() {
    }
    
    public CompanyType(String typeName) {
        this.typeName = typeName;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getTypeName() {
        return typeName;
    }
    
    public void setTypeName(String type) {
        this.typeName = type;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CompanyType that = (CompanyType) o;
        return Objects.equals(id, that.id)
               && Objects.equals(typeName, that.typeName);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id, typeName);
    }
}
