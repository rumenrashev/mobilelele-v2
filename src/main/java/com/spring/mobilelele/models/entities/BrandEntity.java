package com.spring.mobilelele.models.entities;

import com.spring.mobilelele.models.entities.base.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "brands")
public class BrandEntity extends BaseEntity {

    private String name;

    public BrandEntity() {
    }

    public String getName() {
        return name;
    }

    public BrandEntity setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
       return super.hashCode();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Brand{");
        sb.append(super.toString());
        sb.append("name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
