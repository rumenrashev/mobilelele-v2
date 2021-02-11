package com.spring.mobilelele.models.entities.base;

import javax.persistence.*;
import java.time.Instant;
import java.util.Objects;

@MappedSuperclass
public class BaseEntity {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Instant created;

    @Column(nullable = false)
    private Instant modified;

    public BaseEntity() {
    }

    public Long getId() {
        return id;
    }

    public BaseEntity setId(Long id) {
        this.id = id;
        return this;
    }

    @PrePersist
    public void prePersist(){
        setCreated(Instant.now());
        setModified(Instant.now());
    }

    @PreUpdate
    public void preUpdate(){
        setModified(Instant.now());
    }

    public Instant getCreated() {
        return created;
    }

    public BaseEntity setCreated(Instant created) {
        this.created = created;
        return this;
    }

    public Instant getModified() {
        return modified;
    }

    public BaseEntity setModified(Instant modified) {
        this.modified = modified;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseEntity that = (BaseEntity) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("id=").append(id);
        sb.append(", created=").append(created);
        sb.append(", modified=").append(modified);
        sb.append('}');
        return sb.toString();
    }
}
