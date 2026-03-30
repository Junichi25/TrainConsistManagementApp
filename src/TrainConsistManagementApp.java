import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;

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

        // Create an ArrayList for passenger bogies
        List<String> passengerBogies = new ArrayList<>();

        // Add bogies
        passengerBogies.add("Sleeper");
        passengerBogies.add("AC Chair");
        passengerBogies.add("First Class");

        // Display after addition
        System.out.println("After Adding Bogies: Passenger Bogies " + passengerBogies);

        // Remove one bogie (AC Chair)
        passengerBogies.remove("AC Chair");
        System.out.println("After Removing \"AC Chair\": Passenger Bogies " + passengerBogies);

        // Check existence of Sleeper
        boolean containsSleeper = passengerBogies.contains("Sleeper");
        System.out.println("Checking if \"Sleeper\" exists → Contains Sleeper? " + containsSleeper);

        // Final state of passenger consist
        System.out.println("Final Train Passenger Consist: " + passengerBogies);

        System.out.println("UC2 operations completed successfully...");



        // === UC3: Track Unique Bogie IDs using HashSet ===
        System.out.println("\n=== UC3: Track Unique Bogie IDs ===");

        // Create a Set to store unique bogie IDs
        Set<String> bogieIds = new HashSet<>();

        // Add IDs (including duplicates)
        bogieIds.add("BG101");
        bogieIds.add("BG102");
        bogieIds.add("BG103");
        bogieIds.add("BG104");

        // Intentional duplicates
        bogieIds.add("BG101"); // duplicate
        bogieIds.add("BG102"); // duplicate

        // Display final unique bogie IDs
        System.out.println("Bogie IDs After Insertion:");
        System.out.println(bogieIds);

        System.out.println("Note: Duplicates are automatically ignored by HashSet.");
        System.out.println("UC3 uniqueness validation completed....");
    }
}