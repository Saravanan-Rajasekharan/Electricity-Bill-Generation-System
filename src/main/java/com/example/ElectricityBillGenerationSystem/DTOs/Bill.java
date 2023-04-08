package com.example.ElectricityBillGenerationSystem.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bill {

    private String Customer_Name;

    private int Customer_ID;

    private double Consumption_Units;

    private double Rate_per_Unit;

    private String Period;

    private double Bill_Amount;

}
