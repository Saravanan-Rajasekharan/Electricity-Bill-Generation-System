package com.example.ElectricityBillGenerationSystem.Service;

import com.example.ElectricityBillGenerationSystem.Model.Admin;
import com.example.ElectricityBillGenerationSystem.Model.Slab;
import com.example.ElectricityBillGenerationSystem.Repository.AdminRepository;
import com.example.ElectricityBillGenerationSystem.Repository.SlabRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SlabService {
    @Autowired
    SlabRepository slabRepository;

    @Autowired
    AdminRepository adminRepository;

    public String setSlabRate(String startDate, String endDate, double slabRate, int AdminId){
        Slab slab = new Slab();

        slab.setStart_Date(startDate);
        slab.setEnd_Date(endDate);
        slab.setSlab_Rate(slabRate);

        Admin admin = adminRepository.findById(AdminId).get();

        slab.setAdmin(admin);

        slabRepository.save(slab);

        return "Slab rate set Successfully!";
    }
}




























