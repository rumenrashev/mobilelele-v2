package com.spring.mobilelele.data.entities.base;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.util.Objects;

@MappedSuperclass
public class BaseEntityWithPicture extends BaseEntity{

    @Column(nullable = false,length = 512)
    private String imageUrl;

    public BaseEntityWithPicture() {
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public BaseEntityWithPicture setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
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
        StringBuilder sb = new StringBuilder();
        sb.append("imageUrl='").append(imageUrl).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
