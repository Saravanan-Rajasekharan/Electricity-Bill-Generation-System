package com.example.ElectricityBillGenerationSystem.Service;

import com.example.ElectricityBillGenerationSystem.Model.Admin;
import com.example.ElectricityBillGenerationSystem.Model.Consumer;
import com.example.ElectricityBillGenerationSystem.Model.Reading;
import com.example.ElectricityBillGenerationSystem.Repository.AdminRepository;
import com.example.ElectricityBillGenerationSystem.Repository.ConsumerRepository;
import com.example.ElectricityBillGenerationSystem.Repository.ReadingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    AdminRepository adminRepository;

    @Autowired
    ReadingRepository readingRepository;

    @Autowired
    ConsumerRepository consumerRepository;

    public String registerAdmin(Admin admin){
        Admin admin1 = new Admin();

        admin1.setUsername(admin.getUsername());
        admin1.setPassword(admin.getPassword());

        adminRepository.save(admin1);

        return "Registration Successful!";
    }


    public String setReading(int currentReading, String date, int customerId, int AdminId) {
        Consumer consumer =  consumerRepository.findById(customerId).get();
        Admin admin = adminRepository.findById(AdminId).get();

        List<Reading> readingList = consumer.getReadingList();

        Reading reading = new Reading();
        reading.setCurrentReading(currentReading);
        reading.setAdmin(admin);
        reading.setConsumer(consumer);

        readingList.add(reading);

        return "Reading Set for customer!";
    }


}
