package com.example.farmerassistant.Service;

import com.example.farmerassistant.Entity.Seed;

import java.util.List;
import java.util.Optional;

public interface SeedService {
    Seed addSeed(Seed seed);

    void updateSeed(Long id, Seed seed);

    void deleteSeed(Long seedId);

    Seed viewSeed(Long seedId);

    Optional<Seed> viewSeed(String commonName);

    List<Seed> viewAllSeeds();

    List<Seed> viewAllSeeds(String typeOfSeed);
}