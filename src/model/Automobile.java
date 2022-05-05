package model;

import jakarta.persistence.*;

@Entity(name = "automobiles")
public class Automobile {
    //TODO FK trim_id


    @Id
    @Column(name = "auto_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int autoId;

    @Column(unique = true, nullable = false)
    private String vin;
    
}
