package model;

import java.util.*;
import jakarta.persistence.*;
//Junction table without history
@Entity(name = "availablePackages")
public class AvailablePackage {

    @JoinColumn(name = "package_id")
    @ManyToOne
    private PackageC packageObj;

    @JoinColumn(name = "trim_id")
    @ManyToOne
    private Trim trim;

    @Id
    @Column(name = "available_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int availableId;

    private float cost;

    @ManyToMany(mappedBy = "chosenPackage") //Bidirectional
    private Set<Automobile> automobiles;

    public AvailablePackage() {
    }

    public AvailablePackage(PackageC packageObj, Trim trim, int availableId, float cost) {
        this.packageObj = packageObj;
        this.trim = trim;
        this.availableId = availableId;
        this.cost = cost;
    }

    @Override
    public String toString(){
        return "Trim: " + trim.getName() + "\nPackage: " + packageObj.getName() + "\nCost: " + cost;
    }

    public int getAvailableId() {
        return availableId;
    }

    public void setAvailableId(int availableId) {
        this.availableId = availableId;
    }

    public PackageC getPackageObj() {
        return packageObj;
    }

    public void setPackageObj(PackageC packageObj) {
        this.packageObj = packageObj;
    }

    public Trim getTrim() {
        return trim;
    }

    public void setTrim(Trim trim) {
        this.trim = trim;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public Set<Automobile> getAutomobiles() {
        return automobiles;
    }

    public void setAutomobiles(Set<Automobile> automobiles) {
        this.automobiles = automobiles;
    }

}
