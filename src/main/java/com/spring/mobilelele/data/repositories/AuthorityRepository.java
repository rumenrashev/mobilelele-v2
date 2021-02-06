package com.spring.mobilelele.data.repositories;

import com.spring.mobilelele.data.entities.AuthorityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorityRepository extends JpaRepository<AuthorityEntity,Long> {
}