package com.example.farmerassistant.Service;

import com.example.farmerassistant.Entity.Plant;

import java.util.List;

import java.util.Optional;
public interface PlantService {
    Plant addPlant(Plant plant);
    void updatePlant(Long id, Plant plant);
    void deletePlant(Long plantId);
    Plant viewPlant(Long plantId);
    Optional<Plant> viewPlant(String commonName);
    List<Plant> viewAllPlants();
    List<Plant> viewAllPlants(String typeOfPlant);
//    public List<Plant> viewPlantDetails(Integer plantId,String plantName);
}
