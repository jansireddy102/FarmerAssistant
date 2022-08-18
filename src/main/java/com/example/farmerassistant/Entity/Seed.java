package com.example.farmerassistant.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="seedrecord")
public class Seed {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long seedId;
        private String commonName;
        private String bloomTime;
        private String watering;
        private String difficultyLevel;
        private String temperature;
        private String typeOfSeed;
        private String seedDescription;
        private Integer seedsStock;
        private double seedCost;

        public Seed(String commonName, String bloomTime, String watering, String difficultyLevel, String temperature, String typeOfSeed, String seedDescription, Integer seedsStock, double seedCost) {
                this.commonName = commonName;
                this.bloomTime = bloomTime;
                this.watering = watering;
                this.difficultyLevel = difficultyLevel;
                this.temperature = temperature;
                this.typeOfSeed = typeOfSeed;
                this.seedDescription = seedDescription;
                this.seedsStock = seedsStock;
                this.seedCost = seedCost;
        }
}
