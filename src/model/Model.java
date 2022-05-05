package model;

import jakarta.persistence.*;

@Entity(name = "models")
@Table(uniqueConstraints = {
    @UniqueConstraint(columnNames = {"name", "year"})
})
public class Model {
    
    @Id
    @Column(name = "model_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int modelId;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(nullable = false)
    private int year;

    public Model() {
    }

    public Model(int modelId, String name, int year) {
        this.modelId = modelId;
        this.name = name;
        this.year = year;
    }

    public int getModelId() {
        return modelId;
    }

    @Override
    public String toString(){
        return name + " " + year;
    }

    public void setModelId(int modelId) {
        this.modelId = modelId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
