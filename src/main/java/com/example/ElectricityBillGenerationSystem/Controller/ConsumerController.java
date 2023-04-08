package com.example.ElectricityBillGenerationSystem.Controller;

import com.example.ElectricityBillGenerationSystem.DTOs.Bill;
import com.example.ElectricityBillGenerationSystem.Model.Consumer;
import com.example.ElectricityBillGenerationSystem.Service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/consumer")
public class ConsumerController {

    @Autowired
    ConsumerService consumerService;

    @PostMapping("/addConsumer")
    public String addConsumer(@RequestBody Consumer consumer){
        return consumerService.addConsumer(consumer);
    }

    @GetMapping("/getBill/{id}")
    public Bill getBill(@PathVariable int id){
        return consumerService.getBill(id);
    }


}
