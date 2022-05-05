package model;

import jakarta.persistence.*;
//Junction table without history
@Entity(name = "availablePackages")
public class AvailablePackage {
    //TODO add FK from Packages.java and Trim.java
    

    private float cost;
    
}
