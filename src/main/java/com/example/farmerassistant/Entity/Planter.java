package com.example.farmerassistant.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Planter {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long planterId;
        private Float planterHeight;
        private Integer planterCapacity;
        private Integer drainageHoles;
        private Integer planterColor;
        private String planterShaper;
        private Integer planterStock;
        private Integer planterCost;
        @OneToMany(cascade = CascadeType.ALL)
        @JoinColumn(
                name = "",
                referencedColumnName = "planterId"
        )
        @JsonIgnore
        private List<Plant> plants;
        @OneToMany(cascade = CascadeType.ALL)
        @JoinColumn(
                name = "",
                referencedColumnName = "planterId"
        )
        @JsonIgnore
        private List<Seed> seeds;
}
