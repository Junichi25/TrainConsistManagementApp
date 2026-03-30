import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;
import java.util.LinkedList;

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        // === UC1 ===
        System.out.println("\n=== Train Consist Management App ===");

        List<String> trainConsist = new ArrayList<>();

        System.out.println("Train initialized successfully...");
        System.out.println("Initial Bogie Count: " + trainConsist.size());
        System.out.println("Current Train Consist: " + trainConsist);
        System.out.println("System ready for operations....");

        // === UC2: Add Passenger Bogies ===
        System.out.println("\n=== UC2: Add Passenger Bogies to Train ===");

        List<String> passengerBogies = new ArrayList<>();

        passengerBogies.add("Sleeper");
        passengerBogies.add("AC Chair");
        passengerBogies.add("First Class");

        System.out.println("After Adding Bogies: Passenger Bogies " + passengerBogies);

        passengerBogies.remove("AC Chair");
        System.out.println("After Removing \"AC Chair\": Passenger Bogies " + passengerBogies);

        boolean containsSleeper = passengerBogies.contains("Sleeper");
        System.out.println("Checking if \"Sleeper\" exists → Contains Sleeper? " + containsSleeper);

        System.out.println("Final Train Passenger Consist: " + passengerBogies);
        System.out.println("UC2 operations completed successfully...");



        // === UC3: Track Unique Bogie IDs using HashSet ===
        System.out.println("\n=== UC3: Track Unique Bogie IDs ===");

        Set<String> bogieIds = new HashSet<>();

        bogieIds.add("BG101");
        bogieIds.add("BG102");
        bogieIds.add("BG103");
        bogieIds.add("BG104");

        bogieIds.add("BG101"); // duplicate
        bogieIds.add("BG102"); // duplicate

        System.out.println("Bogie IDs After Insertion:");
        System.out.println(bogieIds);

        System.out.println("Note: Duplicates are automatically ignored by HashSet.");
        System.out.println("UC3 uniqueness validation completed....");



        // === UC4: Maintain Ordered Bogie Consist using LinkedList ===
        System.out.println("\n===============================================");
        System.out.println(" UC4 - Maintain Ordered Bogie Consist ");
        System.out.println("===============================================\n");

        // Create a LinkedList for ordered consist
        LinkedList<String> orderedConsist = new LinkedList<>();

        // Add bogies in physical sequence
        orderedConsist.add("Engine");
        orderedConsist.add("Sleeper");
        orderedConsist.add("AC");
        orderedConsist.add("Cargo");
        orderedConsist.add("Guard");

        System.out.println("Initial Train Consist:");
        System.out.println(orderedConsist + "\n");

        // Insert Pantry Car at position 2
        orderedConsist.add(2, "Pantry Car");
        System.out.println("After Inserting 'Pantry Car' at position 2:");
        System.out.println(orderedConsist + "\n");

        // Remove first and last bogie
        orderedConsist.removeFirst();
        orderedConsist.removeLast();

        System.out.println("After Removing First and Last Bogie:");
        System.out.println(orderedConsist + "\n");

        System.out.println("UC4 ordered consist operations completed...");
    }
}