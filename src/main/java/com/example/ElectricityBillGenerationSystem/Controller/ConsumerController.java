package com.example.ElectricityBillGenerationSystem.Controller;

import com.example.ElectricityBillGenerationSystem.Model.Consumer;
import com.example.ElectricityBillGenerationSystem.Service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("consumer/")
public class ConsumerController {

    @Autowired
    ConsumerService consumerService;

    @PostMapping("addConsumer/")
    public String addConsumer(@RequestBody Consumer consumer){
        return consumerService.addConsumer(consumer);
    }


}
