package com.example.farmerassistant.Repository;

import com.example.farmerassistant.Entity.Plant;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
@Rollback(value = true)
public class PlantRepositoryTest {
    @Autowired
    private PlantRepository plantRepository;

    @BeforeEach
    void initUseCase(){
        Plant plant = new Plant(10, "Hello", "pavan", "spring", "medicinal", "hard", "cool", "small", "Hello plant", 100, 200);
        plantRepository.save(plant);
    }

    @AfterEach
    public void destroyAll(){
        plantRepository.deleteAll();
    }
    @Test
    void findByCommonName() {
        Optional<Plant> plant1 = plantRepository.findByCommonName("pavan");
        assertThat(plant1.isPresent()).isNotNull();
    }
    @Test
    void findByTypeOfPlant(){
        List<Plant> plant1 = plantRepository.findByTypeOfPlant("small");
        assertThat(plant1.size()).isGreaterThanOrEqualTo(1);
    }
    @Test
    void AddPlantTest(){
        Plant plant = new Plant(10, "Byte", "Ram", "spring", "medicinal", "hard", "cool", "small", "Hello plant", 1000, 2000);
        plantRepository.save(plant);
        assertThat(plant).isNotNull();
        assertThat(plant.getPlantId()).isGreaterThan(1);
    }
    @Test
    void UpdatePlant(){
        Plant plant = new Plant(10, "Byte", "Ram", "spring", "medicinal", "hard", "cool", "small", "Hello plant", 1000, 2000);
        plantRepository.save(plant);
        Plant savedPlant = plantRepository.findById(plant.getPlantId()).get();
        savedPlant.setTypeOfPlant("FlowerPlants");
        savedPlant.setCommonName("Deepak");
        Plant updatedPlant = plantRepository.save(savedPlant);
        assertThat(updatedPlant.getTypeOfPlant()).isEqualTo("FlowerPlants");
        assertThat(updatedPlant.getCommonName()).isEqualTo("Deepak");
    }
    @Test
    void DeletePlant(){
        Plant plant = new Plant(10, "Byte", "Ram", "spring", "medicinal", "hard", "cool", "small", "Hello plant", 1000, 2000);
        plantRepository.save(plant);
        plantRepository.deleteById(plant.getPlantId());
        Optional<Plant> plantOptional = plantRepository.findById(plant.getPlantId());
        assertThat(plantOptional).isEmpty();
    }
    @Test
    void ViewAll(){
        assertThat(plantRepository.findAll()).isNotNull();
    }

    @Test
    void ViewById(){
        Plant plant = new Plant(10, "Hello", "pavan", "spring", "medicinal", "hard", "cool", "small", "Hello plant", 100, 200);
        plantRepository.save(plant);
        Plant plantViewAll = plantRepository.findById(plant.getPlantId()).get();
        assertThat(plantViewAll).isNotNull();
    }
}
