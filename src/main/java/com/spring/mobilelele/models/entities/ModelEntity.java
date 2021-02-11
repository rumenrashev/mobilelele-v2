package com.spring.mobilelele.models.entities;

import com.spring.mobilelele.constant.enums.CategoryEnum;
import com.spring.mobilelele.models.entities.base.BaseEntityWithPicture;

import javax.persistence.*;

@Entity
@Table(name = "models")
public class ModelEntity extends BaseEntityWithPicture {

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    private CategoryEnum category;

    @Column(nullable = false)
    private Integer startYear;

    @Column
    private Integer endYear;

    @ManyToOne
    private BrandEntity brand;

    public ModelEntity() {
    }

    public String getName() {
        return name;
    }

    public ModelEntity setName(String name) {
        this.name = name;
        return this;
    }

    public CategoryEnum getCategory() {
        return category;
    }

    public ModelEntity setCategory(CategoryEnum category) {
        this.category = category;
        return this;
    }

    public Integer getStartYear() {
        return startYear;
    }

    public ModelEntity setStartYear(Integer startYear) {
        this.startYear = startYear;
        return this;
    }

    public Integer getEndYear() {
        return endYear;
    }

    public ModelEntity setEndYear(Integer endYear) {
        this.endYear = endYear;
        return this;
    }

    public BrandEntity getBrand() {
        return brand;
    }

    public ModelEntity setBrand(BrandEntity brand) {
        this.brand = brand;
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
        final StringBuilder sb = new StringBuilder("ModelEntity{");
        sb.append(super.toString());
        sb.append("name='").append(name).append('\'');
        sb.append(", category=").append(category);
        sb.append(", startYear=").append(startYear);
        sb.append(", endYear=").append(endYear);
        sb.append(", brand=").append(brand);
        sb.append('}');
        return sb.toString();
    }
}
