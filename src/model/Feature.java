package model;

import java.util.*;
import jakarta.persistence.*;

@Entity(name = "features")
public class Feature {
    
    @Id
    @Column(name = "feature_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int featureId;

    @Column(length = 100, unique = true, nullable = false)
    private String name;

    @ManyToMany //no mappedBy because unidirectional
    private Set<Model> models;

    @ManyToMany
    private Set<Trim> trims;

    @ManyToMany
    private Set<Package> packages;

    public Feature() {
    }

    public Feature(int featureId, String name, Set<Model> models, Set<Trim> trims, Set<Package> packages) {
        this.featureId = featureId;
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public int getFeatureId() {
        return featureId;
    }

    public void setFeatureId(int featureId) {
        this.featureId = featureId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Model> getModels() {
        return models;
    }

    public void setModels(Set<Model> models) {
        this.models = models;
    }

    public Set<Trim> getTrims() {
        return trims;
    }

    public void setTrims(Set<Trim> trims) {
        this.trims = trims;
    }

    public Set<Package> getPackages() {
        return packages;
    }

    public void setPackages(Set<Package> packages) {
        this.packages = packages;
    }


}
