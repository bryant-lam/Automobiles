package model;

import java.util.*;
import jakarta.persistence.*;

@Entity(name = "automobiles")
public class Automobile {
    //TODO FK trim_id
    //TODO bidirectional with available packages


    @Id
    @Column(name = "auto_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int autoId;

    @Column(unique = true, nullable = false)
    private String vin;
    
    @JoinTable(
        name = "chosenPackages", 
        joinColumns = @JoinColumn(name = "available_id"), 
        inverseJoinColumns = @JoinColumn(name = "auto_id")
    )
    @ManyToMany
    private Set<AvailablePackage> chosenPackage;

}
