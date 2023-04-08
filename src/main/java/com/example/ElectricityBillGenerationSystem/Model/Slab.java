package com.example.ElectricityBillGenerationSystem.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="slab")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Slab {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String Start_Date;

    private String End_Date;

    private double Slab_Rate;

    @OneToOne
    @JoinColumn
    private Admin admin;

}
