package com.example.farmerassistant.Service;
import com.example.farmerassistant.Entity.Seed;
import com.example.farmerassistant.Exception.NoSuchSeedExistsException;
import com.example.farmerassistant.Exception.SeedAlreadyExistsException;
import com.example.farmerassistant.Repository.SeedRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class SeedServiceImpl implements SeedService {

    @Autowired
    SeedRepository seedRepository;

    public SeedServiceImpl(SeedRepository seedRepository) {
        this.seedRepository=seedRepository;
    }
    @Override
    public Seed addSeed(Seed seed) {
        Optional<Seed> seed1 = seedRepository.findByCommonName(seed.getCommonName());
        if(seed1.isPresent()) {
            throw new SeedAlreadyExistsException("Customer already exists!!");
        }
        return seedRepository.save(seed);
    }

    @Override
    public void deleteSeed(Long seedId) {
        Optional<Seed> seed1 = seedRepository.findById(seedId);
        if (seed1.isPresent()) {
            seedRepository.deleteById(seedId);
        }
        else{
            throw new NoSuchSeedExistsException("PlantId "+seedId+" Not found in the Records to Delete");
        }
    }

    @Override
    public Seed viewSeed(Long seedId) {
        Optional<Seed> seed1 = seedRepository.findById(seedId);
        if (!seed1.isPresent()) {
            throw new NoSuchSeedExistsException("No details found with this"+seedId+"Id");
        }
        return seedRepository.findById(seedId).get();
    }

    @Override
    public Optional<Seed> viewSeed(String commonName) {
        return Optional.ofNullable(seedRepository.findByCommonName(commonName).orElseThrow(
                () -> new NoSuchSeedExistsException("No Items to show")));
    }

    @Override
    public List<Seed> viewAllSeeds() {
        return seedRepository.findAll();
    }

    @Override
    public List<Seed> viewAllSeeds(String typeOfSeed) {
        return seedRepository.findByTypeOfSeed(typeOfSeed);
    }

    @Transactional
    public void updateSeed(Long id, Seed seed) {
        Optional<Seed> seed1=seedRepository.findById(id);
        if(seed1.isPresent()) {
            seed1.get().setCommonName(seed.getCommonName());
            seed1.get().setBloomTime(seed.getBloomTime());
            seed1.get().setDifficultyLevel(seed.getDifficultyLevel());
            seed1.get().setTemperature(seed.getTemperature());
            seed1.get().setTypeOfSeed(seed.getTypeOfSeed());
            seed1.get().setSeedDescription(seed.getSeedDescription());
            seed1.get().setSeedsStock(seed.getSeedsStock());
            seed1.get().setSeedCost(seed.getSeedCost());
        }
        else throw new IllegalStateException("Seed: "+id+ " doesnt exists!");
    }
}