import java.util.*;

import jakarta.persistence.*;
import model.*;

//! integer ID does not matter because of serial values

public class App {
    private static void instantiateModel() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("project3Db");
        EntityManager em = factory.createEntityManager();

        //add Features
        Feature leatherSeats = new Feature(1, "leather seats");
        Feature hybridEngine = new Feature(2, "plug-in hybrid engine");
        Feature powerSlidingDoors = new Feature(3, "power sliding doors");
        Feature handsFreeSlidingDoors = new Feature(4, "hands-free sliding doors");
        Feature amazonFireTV = new Feature(5, "Amazon FireTV");
        Feature rearSeatScreens = new Feature(6, "rear-seat entertainment screens");
        Feature allWheelDrive = new Feature(7, "all-wheel drive");
        Feature adaptiveCruiseCtrl = new Feature(8, "adaptive cruise control"); 

        em.getTransaction().begin();
        em.persist(leatherSeats);
        em.persist(hybridEngine);
        em.persist(powerSlidingDoors);
        em.persist(handsFreeSlidingDoors);
        em.persist(amazonFireTV);
        em.persist(rearSeatScreens);
        em.persist(allWheelDrive);
        em.persist(adaptiveCruiseCtrl);
        em.getTransaction().commit();

        //add Packages
        //Theater Package
        PackageC theaterPkg = new PackageC(1, "Theater Package");
        Set<Feature> theaterFeatures = new HashSet<Feature>(Arrays.asList(rearSeatScreens));
        theaterPkg.setPackageFeatures(theaterFeatures);

        //Amazon Theater Package
        PackageC amzmTheaterPkg = new PackageC(2, "Amazon Theater Package");
        Set<Feature> amzmTheaterFeatures = new HashSet<Feature>(Arrays.asList(rearSeatScreens,amazonFireTV));
        amzmTheaterPkg.setPackageFeatures(amzmTheaterFeatures);
        
        //Safety Package
        PackageC safetyPkg = new PackageC(3, "Safety Package");
        Set<Feature> safetyFeatures = new HashSet<Feature>(Arrays.asList(adaptiveCruiseCtrl));
        safetyPkg.setPackageFeatures(safetyFeatures);

        em.getTransaction().begin();
        em.persist(theaterPkg);
        em.persist(amzmTheaterPkg);
        em.persist(safetyPkg);
        em.getTransaction().commit();


        //Pacifica 2022 Model
        Model pacifica2022 = new Model(1, "Pacifica", 2022);
        Set<Feature> pacifica2022Features = new HashSet<Feature>(Arrays.asList(powerSlidingDoors));
        pacifica2022.setModelFeatures(pacifica2022Features);

        //Pacifica 2022 Touring Trim
        Trim pacificaTouring = new Trim(1, pacifica2022, "Touring", 30000);
        AvailablePackage pacificaTouringAvailablePackage = new AvailablePackage(safetyPkg, pacificaTouring, 1, 3000);
        Set<AvailablePackage> pacificaTouringAvailablePackages = new HashSet<>(Arrays.asList(pacificaTouringAvailablePackage));
        pacificaTouring.setAvailablePackages(pacificaTouringAvailablePackages);
        
        //Pacifica 2022 Limited Trim
        Trim pacificaLimited = new Trim(2, pacifica2022, "Limited", 34000);
        Set<Feature> pacificaLimitedFeatures = new HashSet<Feature>(Arrays.asList(leatherSeats, handsFreeSlidingDoors));
        pacificaLimited.setTrimFeatures(pacificaLimitedFeatures);
        AvailablePackage pacificaLimitedAvailablePackage = new AvailablePackage(amzmTheaterPkg, pacificaLimited, 2, 2500);
        Set<AvailablePackage> pacificaLimitedAvailablePackages = new HashSet<>(Arrays.asList(pacificaLimitedAvailablePackage));
        pacificaLimited.setAvailablePackages(pacificaLimitedAvailablePackages);
        
        //Pacifica 2022 Pinnacle Trim
        Trim pacificaPinnacle = new Trim(3, pacifica2022, "Pinnacle",42000);
        Set<Feature> pacificaPinnacleFeatures = new HashSet<Feature>(Arrays.asList(leatherSeats, handsFreeSlidingDoors, rearSeatScreens, amazonFireTV, allWheelDrive));
        pacificaPinnacle.setTrimFeatures(pacificaPinnacleFeatures);
        
        List<Trim> pacificaTrimList = new ArrayList<Trim>(Arrays.asList(pacificaTouring, pacificaLimited, pacificaPinnacle));
        pacifica2022.setTrims(pacificaTrimList);

        //Inserts for Pacifica 2022 Model
        em.getTransaction().begin();
        em.persist(pacificaTouringAvailablePackage); //insert available packages before Trims and models
        em.persist(pacificaLimitedAvailablePackage);
        em.persist(pacificaTouring);
        em.persist(pacificaLimited);
        em.persist(pacificaPinnacle);
        em.persist(pacifica2022);            //insert all trims before inserting model
        em.getTransaction().commit();


        //Pacifica Hybrid 2022 Model
        Model pHybrid2022 = new Model(2, "Pacifica Hybrid", 2022);
        Set<Feature> pHybrid2022Features = new HashSet<Feature>(Arrays.asList(powerSlidingDoors, hybridEngine));
        pHybrid2022.setModelFeatures(pHybrid2022Features);

        //Pacifica Hybrid 2022 Touring Trim
        Trim pHybridTouring = new Trim(4, pHybrid2022, "Touring", 43000);
        
        //Pacifica Hybrid 2022 Limited Trim
        Trim pHybridLimited = new Trim(5, pHybrid2022, "Limited", 48000);
        Set<Feature> pHybridLimitedFeatures = new HashSet<Feature>(Arrays.asList(leatherSeats, handsFreeSlidingDoors));
        pHybridLimited.setTrimFeatures(pHybridLimitedFeatures);
        AvailablePackage pHybridAvailablePackage = new AvailablePackage(amzmTheaterPkg, pHybridLimited, 3, 2500);
        Set<AvailablePackage> pHybridAvailablePackages = new HashSet<>(Arrays.asList(pHybridAvailablePackage));
        pHybridLimited.setAvailablePackages(pHybridAvailablePackages);
        
        //Pacifica Hybrid 2022 Pinnacle Trim
        Trim pHybridPinnacle = new Trim(6, pHybrid2022, "Pinnacle",54000);
        Set<Feature> pHybridPinnacleFeatures = new HashSet<Feature>(Arrays.asList(leatherSeats, handsFreeSlidingDoors, rearSeatScreens, amazonFireTV));
        pHybridPinnacle.setTrimFeatures(pHybridPinnacleFeatures);
        
        List<Trim> pHybridTrimList = new ArrayList<Trim>(Arrays.asList(pHybridTouring, pHybridLimited, pHybridPinnacle));
        pHybrid2022.setTrims(pHybridTrimList);

        //Inserts for Pacifica Hybrid 2022 Model
        em.getTransaction().begin();
        em.persist(pHybridAvailablePackage); //insert Amazon package before Limited Trim
        em.persist(pHybridTouring);
        em.persist(pHybridLimited);
        em.persist(pHybridPinnacle);
        em.persist(pHybrid2022);            //insert all trims before inserting model
        em.getTransaction().commit();


        //Pacifica Hybrid 2021 Model
        Model pHybrid2021 = new Model(3, "Pacifica Hybrid", 2021);
        Set<Feature> pHybrid2021Features = new HashSet<Feature>(Arrays.asList(powerSlidingDoors, hybridEngine));
        pHybrid2021.setModelFeatures(pHybrid2021Features);

        //Pacifica Hybrid 2021 Touring Trim
        Trim pHybrid2021Touring = new Trim(7, pHybrid2021, "Touring", 41000);
        AvailablePackage pHybrid2021TouringAvailablePackage = new AvailablePackage(safetyPkg, pHybrid2021Touring, 4, 3000);
        Set<AvailablePackage> pHybrid2021TouringAvailablePackages = new HashSet<>(Arrays.asList(pHybrid2021TouringAvailablePackage));
        pacificaTouring.setAvailablePackages(pHybrid2021TouringAvailablePackages);

        //Pacifica Hybrid 2021 Limited Trim
        Trim pHybrid2021Limited = new Trim(8, pHybrid2021, "Limited", 46000);
        Set<Feature> pHybrid2021LimitedFeatures = new HashSet<Feature>(Arrays.asList(leatherSeats, handsFreeSlidingDoors));
        pHybrid2021Limited.setTrimFeatures(pHybrid2021LimitedFeatures);
        AvailablePackage pHybrid2021LimitedAvailablePackage1 = new AvailablePackage(theaterPkg, pHybrid2021Limited, 5, 2500);
        AvailablePackage pHybrid2021LimitedAvailablePackage2 = new AvailablePackage(safetyPkg, pHybrid2021Limited, 6, 2000);
        Set<AvailablePackage> pHybrid2021LimitedAvailablePackages = new HashSet<>(Arrays.asList(pHybrid2021LimitedAvailablePackage1, pHybrid2021LimitedAvailablePackage2));
        pacificaLimited.setAvailablePackages(pHybrid2021LimitedAvailablePackages);
        
        //Pacifica Hybrid 2021 Pinnacle Trim
        Trim pHybrid2021Pinnacle = new Trim(9, pHybrid2021, "Pinnacle",52000);
        Set<Feature> pHybrid2021PinnacleFeatures = new HashSet<Feature>(Arrays.asList(leatherSeats, handsFreeSlidingDoors, rearSeatScreens, adaptiveCruiseCtrl));
        pHybrid2021Pinnacle.setTrimFeatures(pHybrid2021PinnacleFeatures);

        List<Trim> pHybrid2021TrimList = new ArrayList<Trim>(Arrays.asList(pHybrid2021Touring, pHybrid2021Limited, pHybrid2021Pinnacle));
        pacifica2022.setTrims(pHybrid2021TrimList);

        //Inserts for Pacifica Hybrid 2021 Model
        em.getTransaction().begin();
        em.persist(pHybrid2021TouringAvailablePackage); //insert available packages before Trims and models
        em.persist(pHybrid2021LimitedAvailablePackage1);
        em.persist(pHybrid2021LimitedAvailablePackage2);
        em.persist(pHybrid2021Touring);
        em.persist(pHybrid2021Limited);
        em.persist(pHybrid2021Pinnacle);
        em.persist(pHybrid2021);            //insert all trims before inserting model
        em.getTransaction().commit();

        //Automobile 1
        Automobile a1 = new Automobile(1, "12345abcde", pacificaLimited);
        Set<AvailablePackage> a1AvailablePackages = new HashSet<AvailablePackage>(Arrays.asList(pHybridAvailablePackage)); // added Amazon Theater Package
        a1.setChosenPackage(a1AvailablePackages);

        //Automobile 2
        Automobile a2 = new Automobile(2, "67890abcde", pHybridPinnacle);
        
        //Automobile 3
        Automobile a3 = new Automobile(3, "99999aaaaa", pHybrid2021Pinnacle);

        //Automobile 4
        Automobile a4 = new Automobile(4, "aaaaa88888", pHybrid2021Touring);
        Set<AvailablePackage> a4AvailablePackages = new HashSet<AvailablePackage>(Arrays.asList(pHybrid2021TouringAvailablePackage)); //added safety package
        a4.setChosenPackage(a4AvailablePackages);
        
        //Automobile 5
        Automobile a5 = new Automobile(5, "bbbbb77777", pHybrid2021Limited);
        Set<AvailablePackage> a5AvailablePackages = new HashSet<AvailablePackage>(Arrays.asList(pHybrid2021LimitedAvailablePackage1, pHybrid2021LimitedAvailablePackage2)); //added safety and theater package
        a5.setChosenPackage(a5AvailablePackages);

        em.getTransaction().begin();
        em.persist(a1);  
        em.persist(a2);
        em.persist(a3);
        em.persist(a4);
        em.persist(a5);    
        em.getTransaction().commit();
    }

    private static void displayMenu() {
        System.out.println("1. Instantiate the model\n2. Automobile Lookup\n3. Feature Search\n4. Exit");
    }

    // displays automobile year, model, trim, and its features
    private static void automobileLookup(String s) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("project3Db");
        EntityManager em = factory.createEntityManager();

        var a = em.createQuery("SELECT a FROM automobiles a " + 
        "WHERE a.vin = ?1", Automobile.class);
        a.setParameter(1, s);
        try{
            Automobile requestedAutomobile = a.getSingleResult();
            if(requestedAutomobile.getVin().equals(s)) {
                String output = String.format("\n%d %s %s", 
                            requestedAutomobile.getAutoTrim().getModel().getYear(), //print year
                            requestedAutomobile.getAutoTrim().getModel().getName(), //print model name
                            requestedAutomobile.getAutoTrim().getName());           //print trim name
                Set<Feature> aFeatures = requestedAutomobile.getFeatures();

                List<Feature> listFeatures = new ArrayList<>(aFeatures);    //convert set to list
                Collections.sort(listFeatures, Comparator.comparing(Feature::getName)); //sort by feature name

                System.out.println(output);
                System.out.println(requestedAutomobile.stickerPrice());
                for (Feature f : listFeatures) {
                    System.out.println(f);
                }
            }
            System.out.println();
        }
        catch(NoResultException ex) {
            System.out.println("Error: Automobile with vin '" + s + "' does not exist.");
        }
    }

    // find automobile with feature s by querying through trim, package, and model
    private static void featureSearch(String s) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("project3Db");
        EntityManager em = factory.createEntityManager();
        
        Set<Automobile> totalAutomobiles = new LinkedHashSet<Automobile>(); 
        
        // query for trim features and add automobiles to set
        var autoTrimFeatures = em.createQuery("SELECT a FROM automobiles a " + 
        "JOIN a.autoTrim t " +
        "JOIN t.trimFeatures tf " +
        "WHERE tf.name = ?1", Automobile.class);
        autoTrimFeatures.setParameter(1, s);
        try{
            List<Automobile> requestedAutomobilebyTrimFeatures = autoTrimFeatures.getResultList();
            totalAutomobiles.addAll(requestedAutomobilebyTrimFeatures);
        }
        catch(NoResultException ex) {
            System.out.println("No trims with feature '" + s + "'.");
        }
        
        // query for package features and add automobiles to set
        var autoPackageFeatures = em.createQuery("SELECT a FROM automobiles a " + 
        "LEFT JOIN a.chosenPackage cP " +
        "LEFT JOIN cP.packageObj p " +
        "LEFT JOIN p.packageFeatures pf " +
        "WHERE pf.name = ?1", Automobile.class);
        autoPackageFeatures.setParameter(1, s);
        try{
            List<Automobile> requestedAutomobilebyPackageFeatures = autoPackageFeatures.getResultList();
            totalAutomobiles.addAll(requestedAutomobilebyPackageFeatures);
        }
        catch(NoResultException ex) {
            System.out.println("No packages with feature '" + s + "'.");
        }

        // query for model features and add automobiles to set
        var autoModelFeatures = em.createQuery("SELECT a FROM automobiles a " + 
        "JOIN a.autoTrim t " +
        "JOIN t.model m " +
        "JOIN m.modelFeatures mf " +
        "WHERE mf.name = ?1", Automobile.class);
        autoModelFeatures.setParameter(1, s);
        try{
            List<Automobile> requestedAutomobilebyModelFeatures = autoModelFeatures.getResultList();
            totalAutomobiles.addAll(requestedAutomobilebyModelFeatures);
        }
        catch(NoResultException ex) {
            System.out.println("No model with feature '" + s + "'.");
        }

        // display automobiles with desired feature
        System.out.println("vin(s):");
            for(Automobile automobile: totalAutomobiles) {
                System.out.println(automobile.getVin());
            }
        
    }

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        boolean isDataIn = false;
        System.out.println("Input integers to pick options.");
        displayMenu();
        int choice = Integer.parseInt(input.nextLine());

        while(choice != 4) {
            if(choice == 1 && isDataIn == false) {
                instantiateModel();
                isDataIn = true;            // prevent data from being inputted again
            }
            else if (choice == 1 && isDataIn == true) {
                System.out.println("The model is already instantiated.");
            }
            else if(choice == 2) {
                System.out.println("Enter vin of an automobile: ");
                String vin = input.nextLine();
                automobileLookup(vin);
            }
            else if(choice == 3) {
                System.out.println("Enter a feature name: ");
                String feature = input.nextLine();
                featureSearch(feature);
            }
            else if(choice == 4) {
                break;
            }
            else {
                System.out.println("Error: Invalid input.");
            }
            displayMenu();
            choice = Integer.parseInt(input.nextLine());
        }

        input.close();
    }
}



