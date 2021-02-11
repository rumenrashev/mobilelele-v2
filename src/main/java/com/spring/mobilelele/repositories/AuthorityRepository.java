package com.spring.mobilelele.repositories;

import com.spring.mobilelele.models.entities.AuthorityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorityRepository extends JpaRepository<AuthorityEntity,Long> {

    Optional<AuthorityEntity> findByAuthority(String authority);

}
