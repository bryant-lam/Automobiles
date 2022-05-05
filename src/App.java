import java.util.List;
import java.util.Scanner;

import jakarta.persistence.*;
import model.*;


public class App {
    private static void proj3Demo(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("project3Db");
        EntityManager em = factory.createEntityManager();

        Model newModel = new Model(1, "Pacifica", 2022);
        em.getTransaction().begin();
        em.persist(newModel);
        em.getTransaction().commit();
        System.out.println("Model " + newModel + " has been added.");
    }

    public static void main(String[] args) throws Exception {
        proj3Demo();
    }
}



