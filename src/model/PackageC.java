package model;

import java.util.*;
import jakarta.persistence.*;

@Entity(name = "packages")
public class PackageC {
    
    @Id
    @Column(name = "package_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int packageId;

    @Column(length = 50, nullable = false)
    private String name;

    @JoinTable(
        name = "packageFeatures", 
        joinColumns = @JoinColumn(name = "package_id"), 
        inverseJoinColumns = @JoinColumn(name = "feature_id")
    )
    @ManyToMany
    private Set<Feature> packageFeatures;

    @OneToMany(mappedBy = "packageObj") //junction table
    private Set<AvailablePackage> availablePackages;

    public PackageC() {
    }

    public PackageC(int packageId, String name) {
        this.packageId = packageId;
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
    public int getPackageId() {
        return packageId;
    }

    public void setPackageId(int packageId) {
        this.packageId = packageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Feature> getPackageFeatures() {
        return packageFeatures;
    }

    public void setPackageFeatures(Set<Feature> packageFeatures) {
        this.packageFeatures = packageFeatures;
    }

    public Set<AvailablePackage> getAvailablePackages() {
        return availablePackages;
    }

    public void setAvailablePackages(Set<AvailablePackage> availablePackages) {
        this.availablePackages = availablePackages;
    }

    
    
}
