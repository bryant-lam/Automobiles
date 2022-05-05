package model;

import jakarta.persistence.*;

@Entity(name = "packages")
public class Package {
    
    @Id
    @Column(name = "package_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int packageId;

    @Column(length = 50, nullable = false)
    private String name;

    public Package() {
    }

    public Package(int packageId, String name) {
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

    
}