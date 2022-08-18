package com.example.farmerassistant.Controller;


import com.example.farmerassistant.Entity.Farmer;
import com.example.farmerassistant.Service.FarmerService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/customer")
@CrossOrigin("http://localhost:3000")
public class FarmerController {
    @Autowired
    private FarmerService farmerService;

    @GetMapping("/welcome")
    public String customer() {
        return("<h1>Welcome to Farmer Assistant</h1>");
    }

    @ApiOperation("Add New Customer")
    @PostMapping("/register")
    public ResponseEntity<Farmer> registerCustomer(@RequestBody Farmer farmer) {
        Farmer farmerNew = farmerService.addCustomer(farmer);
        log.info("Added new Customer");
        return new ResponseEntity<>(farmerNew, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<Farmer> validateCustomer(@RequestParam Integer customerId, String username, String password, String customerName, String customerEmail) {
        Farmer farmer = farmerService.validateCustomer(customerId,username,password, customerName,customerEmail);
        if(farmer !=null) {
            return new ResponseEntity<>(farmer, HttpStatus.ACCEPTED);
        }
        else {
            return new ResponseEntity<>(farmer, HttpStatus.FORBIDDEN);
        }
    }

    @DeleteMapping("/remove")
    public ResponseEntity<Farmer> removeCustomer(@RequestBody Integer customerId) {
        Farmer farmerRemoved = farmerService.removeCustomer(customerId);
        if(farmerRemoved !=null)
            return new ResponseEntity<>(farmerRemoved, HttpStatus.ACCEPTED);
        else
            return new ResponseEntity<>(farmerRemoved, HttpStatus.FORBIDDEN);
    }

    @GetMapping("/viewall")
    public List<Farmer> viewAllCustomers(){
        return farmerService.viewAllCustomers();
    }

    @GetMapping("/view")
    public ResponseEntity<Farmer> viewPlant(@RequestParam Integer customerId){
        Farmer farmer = farmerService.viewCustomer(customerId);
        return new ResponseEntity<>(farmer,HttpStatus.ACCEPTED);
    }
}
