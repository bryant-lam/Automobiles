import java.util.List;
import java.util.Scanner;

import jakarta.persistence.*;
import model.*;


public class App {
    private static void proj3Demo(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("project3Db");
        EntityManager em = factory.createEntityManager();

        Model newModel = new Model(1, "Pacifica", 2022);
        Trim newTrim = new Trim(1, newModel, "Limited", 30000);
        Feature newFeature = new Feature(1, "leather seats");
        PackageC newPackage = new PackageC(1, "Theater Package");
        Automobile newAutomobile = new Automobile(1, "12345abcde", newTrim);

        em.getTransaction().begin();
        em.persist(newModel);
        em.persist(newTrim);
        em.persist(newFeature);
        em.persist(newPackage);
        em.persist(newAutomobile);
        em.getTransaction().commit();
        System.out.println("Model " + newModel + " has been added.");
    }

    public static void main(String[] args) throws Exception {
        proj3Demo();
    }
}



