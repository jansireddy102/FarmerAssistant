package com.example.farmerassistant.Service;

import com.example.farmerassistant.Entity.Seed;
import com.example.farmerassistant.Repository.SeedRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
public class SeedServiceTest {
    @Mock
    private SeedRepository seedRepository;

    SeedService seedService;

    @BeforeEach
    void initUseCase(){
        seedService = new SeedServiceImpl(seedRepository);
    }
    @Test
    public void AddPlant(){
        Seed seed = new Seed("pavan", "spring", "medicinal", "hard", "cool", "small", "Hello plant", 100, 200);
        when(seedRepository.save(any(Seed.class))).thenReturn(seed);
        Seed savedPlant = seedRepository.save(seed);
        assertThat(savedPlant.getTypeOfSeed()).isNotNull();
    }
    @Test
    public void ViewAllTest(){
        Seed seed = new Seed("pavan", "spring", "medicinal", "hard", "cool", "small", "Hello plant", 100, 200);
        seedService.viewAllSeeds();
        verify(seedRepository).findAll();
    }
}
