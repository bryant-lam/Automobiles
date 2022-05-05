import java.util.List;
import java.util.Scanner;

import jakarta.persistence.*;
import model.*;


public class App {
    private static void proj3Demo(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("project3Db");
        EntityManager em = factory.createEntityManager();
    }

    public static void main(String[] args) throws Exception {
        proj3Demo();
    }
}



