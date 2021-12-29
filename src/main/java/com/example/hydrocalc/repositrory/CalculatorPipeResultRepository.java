package com.example.hydrocalc.repositrory;

import com.example.hydrocalc.model.entities.CalculatorPipeResults;
import com.example.hydrocalc.model.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CalculatorPipeResultRepository extends JpaRepository<CalculatorPipeResults, Long> {
    List<CalculatorPipeResults> findAllByUser(UserEntity user);
    CalculatorPipeResults findByUser(UserEntity user);
}
