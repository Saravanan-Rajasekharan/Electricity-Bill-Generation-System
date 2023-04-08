package com.example.ElectricityBillGenerationSystem.Service;


import com.example.ElectricityBillGenerationSystem.Model.Consumer;
import com.example.ElectricityBillGenerationSystem.Repository.ConsumerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {
    @Autowired
    ConsumerRepository consumerRepository;

    public String addConsumer(Consumer consumer) {
        Consumer consumer1 =new Consumer();
        consumer1.setCustomerName(consumer.getCustomerName());
        consumer1.setEmail(consumer.getEmail());
        consumer1.setPassword(consumer.getPassword());

        consumerRepository.save(consumer1);

        return "Registration Successful!";
    }


}
