package com.example.farmerassistant.Controller;
import com.example.farmerassistant.Entity.Seed;
import com.example.farmerassistant.Service.SeedServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/seed")
@CrossOrigin("http://localhost:3000")
public class SeedController {
    @Autowired
    private SeedServiceImpl seedServiceimpl;

    @PostMapping("/add")
    public ResponseEntity<Seed> addSeed(@RequestBody Seed seed){
        Seed seed1 = seedServiceimpl.addSeed(seed);
        log.info("Added a new Seed ");
        log.info(String.valueOf(seed1));
        return new ResponseEntity<>(seed1, HttpStatus.CREATED);
    }
    @GetMapping("/view")
    public ResponseEntity<Seed> viewPlant(@RequestParam Long seedId){
        Seed seed = seedServiceimpl.viewSeed(seedId);
        return new ResponseEntity<>(seed,HttpStatus.ACCEPTED);
    }
    @GetMapping("/viewall")
    public List<Seed> viewAllSeeds(){
        return seedServiceimpl.viewAllSeeds();
    }
    @PutMapping("/update")
    public void modifyplant(@RequestParam(value="id")Long id1, @RequestBody Seed seed) {
        seedServiceimpl.updateSeed(id1,seed);}
    @DeleteMapping("/delete/{seedId}")
    public void removeSeed(@PathVariable Long seedId){
        seedServiceimpl.deleteSeed(seedId);
    }
    @GetMapping("/viewByCommonName")
    public List<Seed> ViewByCommonName(@RequestParam String SeedCommonName){
        return seedServiceimpl.viewAllSeeds(SeedCommonName);
    }
    @GetMapping("/viewByTypeOfSeed")
    public List<Seed> ViewByTypeOfSeed(@RequestParam String typeOfSeed){
        return seedServiceimpl.viewAllSeeds(typeOfSeed);

    }
}
