package com.example.hydrocalc.repositrory;

import com.example.hydrocalc.model.entities.PpPipeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PpPipeRepository extends JpaRepository<PpPipeEntity, Long> {
    PpPipeEntity findByDn(String dn);
}
