package model;

import jakarta.persistence.*;

@Entity(name = "features")
public class Feature {
    
    @Id
    @Column(name = "feature_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int featureId;

    @Column(length = 100, unique = true, nullable = false)
    private String name;

    public Feature() {
    }

    public Feature(int featureId, String name) {
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

    

}
