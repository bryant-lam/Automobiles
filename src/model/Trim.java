package model;

import java.util.*;
import jakarta.persistence.*;

@Entity(name = "trims")
//TODO add table constraint from relational scheme UK
//TODO add OneToMany with Model.java and Package.java (Bidirectional)
public class Trim {
    
    @Id
    @Column(name = "trim_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int trimId;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(nullable = false)
    private float cost;

    @JoinTable(
        name = "trimFeatures", 
        joinColumns = @JoinColumn(name = "trim_id"), 
        inverseJoinColumns = @JoinColumn(name = "feature_id")
    )
    @ManyToMany
    private Set<Feature> trimFeatures;

    public Trim() {
    }

    public Trim(int trimId, String name, float cost) {
        this.trimId = trimId;
        this.name = name;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return name;
    }

    public int getTrimId() {
        return trimId;
    }

    public void setTrimId(int trimId) {
        this.trimId = trimId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    
}
