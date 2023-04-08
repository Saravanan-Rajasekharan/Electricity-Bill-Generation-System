package com.example.ElectricityBillGenerationSystem.Repository;

import com.example.ElectricityBillGenerationSystem.Model.Slab;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SlabRepository extends JpaRepository<Slab,Integer> {
}
