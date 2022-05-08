package model;

import java.util.*;
import jakarta.persistence.*;

@Entity(name = "automobiles")
public class Automobile {

    @Id
    @Column(name = "auto_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int autoId;

    @Column(unique = true, nullable = false)
    private String vin;
    
    @ManyToOne
    @JoinColumn(name = "trim_id")
    private Trim autoTrim;

    @JoinTable(
        name = "chosenPackages", 
        joinColumns = @JoinColumn(name = "auto_id"), 
        inverseJoinColumns = @JoinColumn(name = "available_id")
    )
    @ManyToMany
    private Set<AvailablePackage> chosenPackage;
    
    public Automobile() {
    }

    public Automobile(int autoId, String vin, Trim autoTrim) {
        this.autoId = autoId;
        this.vin = vin;
        this.autoTrim = autoTrim;
    }

    @Override
    public String toString() {
        return "Automobile [vin=" + vin + "]";
    }

    public int getAutoId() {
        return autoId;
    }

    public void setAutoId(int autoId) {
        this.autoId = autoId;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public Trim getAutoTrim() {
        return autoTrim;
    }

    public void setAutoTrim(Trim autoTrim) {
        this.autoTrim = autoTrim;
    }

    public Set<AvailablePackage> getChosenPackage() {
        return chosenPackage;
    }

    public void setChosenPackage(Set<AvailablePackage> chosenPackage) {
        this.chosenPackage = chosenPackage;
    }
    
    public Set<Feature> getFeatures() {
        Set<Feature> totalFeatures = new HashSet<Feature>();
        Set<Feature> temp = new HashSet<Feature>();

        for(AvailablePackage aP : chosenPackage){           //get all packages from automobile
            temp = aP.getPackageObj().getPackageFeatures(); 
            for(Feature f : temp) {             // in each package, add features to new Set
                totalFeatures.add(f);
            }
        }
        temp.clear();

        temp = autoTrim.getTrimFeatures(); // set of features from trims
        for(Feature f : temp) {
            totalFeatures.add(f);
        }
        temp.clear();

        temp = autoTrim.getModel().getModelFeatures(); //set of features from model
        for(Feature f : temp) {
            totalFeatures.add(f);
        }
        temp.clear();

        return totalFeatures;
    }

    public double stickerPrice() {
        double total = 0;
        total += autoTrim.getCost();

        for(AvailablePackage aP : chosenPackage){           //get all packages from automobile
            total += aP.getCost();                  // in each package, get cost and add to total
        }

        return total;
    }
}
