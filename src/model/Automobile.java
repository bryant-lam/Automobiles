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
    
}
