package com.example.ElectricityBillGenerationSystem.Service;


import com.example.ElectricityBillGenerationSystem.DTOs.Bill;
import com.example.ElectricityBillGenerationSystem.Model.Admin;
import com.example.ElectricityBillGenerationSystem.Model.Consumer;
import com.example.ElectricityBillGenerationSystem.Model.Reading;
import com.example.ElectricityBillGenerationSystem.Model.Slab;
import com.example.ElectricityBillGenerationSystem.Repository.ConsumerRepository;
import com.example.ElectricityBillGenerationSystem.Repository.ReadingRepository;
import com.example.ElectricityBillGenerationSystem.Repository.SlabRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ConsumerService {
    @Autowired
    ConsumerRepository consumerRepository;

    @Autowired
    SlabRepository slabRepository;

    @Autowired
    ReadingRepository readingRepository;



    public String addConsumer(Consumer consumer) {
        Consumer consumer1 =new Consumer();
        consumer1.setName(consumer.getName());
        consumer1.setEmail(consumer.getEmail());
        consumer1.setPassword(consumer.getPassword());

        Reading reading = new Reading();
        Admin admin = consumer1.getAdmin();

        reading.setConsumer(consumer1);
        reading.setCurrentReading(0);
        reading.setAdmin(admin);

        List<Reading> readingList = consumer1.getReadingList();
        readingList.add(reading);
        consumer1.setReadingList(readingList);


        consumerRepository.save(consumer1);

        return "Registration Successful!";
    }


    public Bill getBill(int id) {
        Consumer consumer = consumerRepository.findById(id).get();
        Bill bill = new Bill();

        bill.setCustomer_ID(id);
        bill.setCustomer_Name(consumer.getName());

        //Units
        List<Reading> readingList = consumer.getReadingList();
        int n = readingList.size();

        Reading current = readingList.get(n-1);
        Reading previous = readingList.get(n-2);

        int units = current.getCurrentReading() - previous.getCurrentReading();

        //Slab rate
        Slab slab = consumer.getSlab();
        double slabRate = slab.getSlab_Rate();


        //bill amount
        double bill_amount = units*slabRate;

        bill.setConsumption_Units(units);
        bill.setRate_per_Unit(slabRate);
        bill.setBill_Amount(bill_amount);

        //period
        String period = previous.getReadingDate() +" to " + current.getReadingDate();
        bill.setPeriod(period);

        return bill;
    }



}
