package com.example.hydrocalc.repositrory;

import com.example.hydrocalc.model.entities.PvcOPipeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PvcOPipeRepository extends JpaRepository<PvcOPipeEntity, Long> {
}
