package com.spring.mobilelele.models.entities;

import com.spring.mobilelele.constant.enums.EngineEnum;
import com.spring.mobilelele.constant.enums.TransmissionEnum;
import com.spring.mobilelele.models.entities.base.BaseEntityWithPicture;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "offers")
public class OfferEntity extends BaseEntityWithPicture {

    @Column(columnDefinition = "TEXT")
    private String description;

    @Enumerated(EnumType.STRING)
    private EngineEnum engine;

    @Column
    private Integer mileage;

    @Column(nullable = false)
    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    private TransmissionEnum transmission;

    @Column
    private Integer year;

    @ManyToOne
    private UserEntity seller;

    @ManyToOne
    private ModelEntity model;

    public OfferEntity() {
    }

    public String getDescription() {
        return description;
    }

    public OfferEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    public EngineEnum getEngine() {
        return engine;
    }

    public OfferEntity setEngine(EngineEnum engine) {
        this.engine = engine;
        return this;
    }

    public Integer getMileage() {
        return mileage;
    }

    public OfferEntity setMileage(Integer mileage) {
        this.mileage = mileage;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public OfferEntity setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public TransmissionEnum getTransmission() {
        return transmission;
    }

    public OfferEntity setTransmission(TransmissionEnum transmission) {
        this.transmission = transmission;
        return this;
    }

    public Integer getYear() {
        return year;
    }

    public OfferEntity setYear(Integer year) {
        this.year = year;
        return this;
    }

    public UserEntity getSeller() {
        return seller;
    }

    public OfferEntity setSeller(UserEntity seller) {
        this.seller = seller;
        return this;
    }

    public ModelEntity getModel() {
        return model;
    }

    public OfferEntity setModel(ModelEntity model) {
        this.model = model;
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
        final StringBuilder sb = new StringBuilder("OfferEntity{");
        sb.append(super.toString());
        sb.append("description='").append(description).append('\'');
        sb.append(", engine=").append(engine);
        sb.append(", mileage=").append(mileage);
        sb.append(", price=").append(price);
        sb.append(", transmission=").append(transmission);
        sb.append(", year=").append(year);
        sb.append('}');
        return sb.toString();
    }
}
