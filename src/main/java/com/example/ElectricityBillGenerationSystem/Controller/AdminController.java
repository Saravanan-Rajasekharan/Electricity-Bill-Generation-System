package com.example.ElectricityBillGenerationSystem.Controller;

import com.example.ElectricityBillGenerationSystem.Model.Admin;
import com.example.ElectricityBillGenerationSystem.Service.AdminService;
import com.example.ElectricityBillGenerationSystem.Service.SlabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    @Autowired
    SlabService slabService;


    @PostMapping("/register")
    public String registerAdmin(@RequestBody Admin admin){
        return adminService.registerAdmin(admin);
    }

    @PostMapping("/SetSlabRate/{startDate}/{endDate}/{slabRate}/{AdminId}")
    public String setSlabRate(@PathVariable String startDate,@PathVariable String endDate,@PathVariable double slabRate, @PathVariable int AdminId){
        return slabService.setSlabRate(startDate,endDate,slabRate,AdminId);
    }

   @PostMapping("/setReading/{currentReading}/{date}/{customerId}/{adminId}")
    public  String setReading(@PathVariable int currentReading, @PathVariable String date, @PathVariable int customerId, @PathVariable int adminId){
        return adminService.setReading(currentReading,date,customerId,adminId);
   }


}
