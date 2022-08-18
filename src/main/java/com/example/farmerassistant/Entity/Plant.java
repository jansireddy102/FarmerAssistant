package com.example.farmerassistant.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="plantrecord")
public class Plant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long plantId;
    private Integer plantHeight;
    private String plantSpread;
    private String commonName;
    private String bloomTime;
    private String medicinalOrCulinaryUse;
    private String difficultyLevel;
    private String temperature;
    private String typeOfPlant;
    private String plantDescription;
    private Integer plantsStock;
    private double plantCost;

    public Plant(Integer plantHeight, String plantSpread, String commonName, String bloomTime, String medicinalOrCulinaryUse, String difficultyLevel, String temperature, String typeOfPlant, String plantDescription, Integer plantsStock, double plantCost) {
        this.plantHeight = plantHeight;
        this.plantSpread = plantSpread;
        this.commonName = commonName;
        this.bloomTime = bloomTime;
        this.medicinalOrCulinaryUse = medicinalOrCulinaryUse;
        this.difficultyLevel = difficultyLevel;
        this.temperature = temperature;
        this.typeOfPlant = typeOfPlant;
        this.plantDescription = plantDescription;
        this.plantsStock = plantsStock;
        this.plantCost = plantCost;
    }
}
