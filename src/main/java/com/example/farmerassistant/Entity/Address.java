package com.example.farmerassistant.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer addressId;
    private String houseNo;
    private String colony;
    private String city;
    private String state;
    private int pincode;
}
