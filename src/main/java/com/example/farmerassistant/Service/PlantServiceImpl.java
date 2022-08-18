package com.example.farmerassistant.Service;

import com.example.farmerassistant.Entity.Plant;
import com.example.farmerassistant.Exception.NoSuchPlantExistsException;
import com.example.farmerassistant.Exception.PlantAlreadyExistsException;
import com.example.farmerassistant.Repository.PlantRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class PlantServiceImpl implements PlantService{

    @Autowired
    PlantRepository plantRepository;

    public PlantServiceImpl(PlantRepository plantRepository) {
        this.plantRepository=plantRepository;
    }

    @Override
    public Plant addPlant(Plant plant) {
        Optional<Plant> plant1 = plantRepository.findByCommonName(plant.getCommonName());
        if(plant1.isPresent()) {
            throw new PlantAlreadyExistsException("Customer already exists!!");
        }
        return plantRepository.save(plant);
    }



    @Override
    public void deletePlant(Long plantId) {
        Optional<Plant> plant1 = plantRepository.findById(plantId);
        if (plant1.isPresent()) {
            plantRepository.deleteById(plantId);
        }
        else{
            throw new NoSuchPlantExistsException("PlantId "+plantId+" Not found in the Records to Delete");
        }
    }

    @Override
    public Plant viewPlant(Long plantId) {
        Optional<Plant> plant1 = plantRepository.findById(plantId);
        if (!plant1.isPresent()) {
            throw new NoSuchPlantExistsException("No details found with this"+plantId+"Id");
        }
        return plantRepository.findById(plantId).get();
    }

    @Override
    public Optional<Plant> viewPlant(String commonName) {
        return Optional.ofNullable(plantRepository.findByCommonName(commonName).orElseThrow(
                () -> new NoSuchPlantExistsException("No Items to show")));
    }

    @Override
    public List<Plant> viewAllPlants() {
        return plantRepository.findAll();
    }

    @Override
    public List<Plant> viewAllPlants(String typeOfPlant) {
        return plantRepository.findByTypeOfPlant(typeOfPlant);
    }

//    @Override
//    public List<Plant> viewPlantDetails(Long plantId, String plantName) {
//        return null;
//    }


    @Transactional
    public void updatePlant(Long id,Plant plant) {
        Optional<Plant> plant1=plantRepository.findById(id);
        if(plant1.isPresent()) {
            plant1.get().setPlantHeight(plant.getPlantHeight());
            plant1.get().setPlantSpread(plant.getPlantSpread());
            plant1.get().setCommonName(plant.getCommonName());
            plant1.get().setBloomTime(plant.getBloomTime());
            plant1.get().setMedicinalOrCulinaryUse(plant.getMedicinalOrCulinaryUse());
            plant1.get().setDifficultyLevel(plant.getDifficultyLevel());
            plant1.get().setTemperature(plant.getTemperature());
            plant1.get().setTypeOfPlant(plant.getTypeOfPlant());
            plant1.get().setPlantDescription(plant.getPlantDescription());
            plant1.get().setPlantsStock(plant.getPlantsStock());
            plant1.get().setPlantCost(plant.getPlantCost());
        }
        else throw new IllegalStateException("Plant: "+id+ " doesnt exists!");
    }

}