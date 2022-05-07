package model;

import java.util.*;
import jakarta.persistence.*;

@Entity(name = "trims")
@Table(uniqueConstraints = {
    @UniqueConstraint(columnNames = {"name", "model_id"})
})
public class Trim {
    
    @Id
    @Column(name = "trim_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int trimId;

    @ManyToOne //bidirectional FK to parent model
    @JoinColumn(name = "model_id")
    private Model model;

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

    @OneToMany(mappedBy = "trim") //junction table with Package.java
    private Set<AvailablePackage> availablePackages;

    @OneToMany(mappedBy = "autoTrim")
    private Set<Automobile> automobiles;

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
