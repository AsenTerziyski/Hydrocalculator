package com.example.hydrocalc.repositrory;

import com.example.hydrocalc.model.entities.PePipeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PePipeRepository extends JpaRepository<PePipeEntity, Long> {
}
