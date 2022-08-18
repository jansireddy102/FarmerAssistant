package com.example.farmerassistant.Repository;

import com.example.farmerassistant.Entity.Seed;
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

public class SeedRepositoryTest {

    @Autowired
    private SeedRepository seedRepository;

    @BeforeEach
    void initUseCase(){
        Seed seed = new Seed("pavan", "spring", "daily", "hard", "cool", "small", "Hello plant", 100, 200);
        seedRepository.save(seed);
    }

    @AfterEach
    public void destroyAll(){
        seedRepository.deleteAll();
    }
    @Test
    void findByCommonName() {
        Optional<Seed> seed1 = seedRepository.findByCommonName("pavan");
        assertThat(seed1.isPresent()).isNotNull();
    }
    @Test
    void findByTypeOfSeed(){
        List<Seed> seed1 = seedRepository.findByTypeOfSeed("small");
        assertThat(seed1.size()).isGreaterThanOrEqualTo(1);
    }
    @Test
    void AddSeedTest(){
        Seed seed = new Seed("Ram", "spring", "medicinal", "hard", "cool", "small", "Hello plant", 1000, 2000);
        seedRepository.save(seed);
        assertThat(seed).isNotNull();
        assertThat(seed.getSeedId()).isGreaterThan(1);
    }
    @Test
    void UpdateSeed(){
        Seed seed = new Seed("Ram", "spring", "medicinal", "hard", "cool", "small", "Hello plant", 1000, 2000);
        seedRepository.save(seed);
        Seed savedSeed = seedRepository.findById(seed.getSeedId()).get();
        savedSeed.setTypeOfSeed("FlowerPlants");
        savedSeed.setCommonName("Govind");
        Seed updatedSeed = seedRepository.save(savedSeed);
        assertThat(updatedSeed.getTypeOfSeed()).isEqualTo("FlowerPlants");
        assertThat(updatedSeed.getCommonName()).isEqualTo("Govind");
    }
    @Test
    void DeleteSeed(){
        Seed seed = new Seed("Ram", "spring", "medicinal", "hard", "cool", "small", "Hello plant", 1000, 2000);
        seedRepository.save(seed);
        seedRepository.deleteById(seed.getSeedId());
        Optional<Seed> seedOptional = seedRepository.findById(seed.getSeedId());
        assertThat(seedOptional).isEmpty();
    }
    @Test
    void ViewAll(){
        assertThat(seedRepository.findAll()).isNotNull();
    }

    @Test
    void ViewById(){
        Seed seed = new Seed("pavan", "spring", "medicinal", "hard", "cool", "small", "Hello plant", 100, 200);
        seedRepository.save(seed);
        Seed seedViewAll = seedRepository.findById(seed.getSeedId()).get();
        assertThat(seedViewAll).isNotNull();
    }
}
