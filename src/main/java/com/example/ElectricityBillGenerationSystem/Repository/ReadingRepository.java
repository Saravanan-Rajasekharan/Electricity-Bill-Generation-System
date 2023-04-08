package com.example.ElectricityBillGenerationSystem.Repository;

import com.example.ElectricityBillGenerationSystem.Model.Reading;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReadingRepository extends JpaRepository<Reading, Integer> {
}
