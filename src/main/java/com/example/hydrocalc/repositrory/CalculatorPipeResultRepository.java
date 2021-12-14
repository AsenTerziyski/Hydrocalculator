package com.example.hydrocalc.repositrory;

import com.example.hydrocalc.model.CalculatorPipeResults;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalculatorPipeResultRepository extends JpaRepository<CalculatorPipeResults, Long> {
}
