package com.example.farmerassistant.Service;

import com.example.farmerassistant.Entity.Plant;
import com.example.farmerassistant.Repository.PlantRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;
import static org.assertj.core.api.Java6Assertions.assertThat;
@ExtendWith(MockitoExtension.class)
public class PlantServiceTest {
    @Mock
    private PlantRepository plantRepository;

    PlantService plantService;

    @BeforeEach
    void initUseCase(){
        plantService = new PlantServiceImpl(plantRepository);
    }
    @Test
    public void AddPlant(){
        Plant plant = new Plant(10, "Hello", "pavan", "spring", "medicinal", "hard", "cool", "small", "Hello plant", 100, 200);
        when(plantRepository.save(any(Plant.class))).thenReturn(plant);
        Plant savedPlant = plantRepository.save(plant);
        assertThat(savedPlant.getTypeOfPlant()).isNotNull();
    }
    @Test
    public void ViewAllTest(){
        Plant plant = new Plant(10, "Hello", "pavan", "spring", "medicinal", "hard", "cool", "small", "Hello plant", 100, 200);
        plantService.viewAllPlants();
        verify(plantRepository).findAll();
    }

}
