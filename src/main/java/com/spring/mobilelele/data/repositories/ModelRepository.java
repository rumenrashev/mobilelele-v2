package com.spring.mobilelele.data.repositories;

import com.spring.mobilelele.data.entities.ModelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelRepository extends JpaRepository<ModelEntity,Long> {
}
