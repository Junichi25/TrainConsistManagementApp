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

        // === UC2 ===
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

        // === UC3 ===
        System.out.println("\n=== UC3: Track Unique Bogie IDs ===");

        Set<String> bogieIds = new HashSet<>();

        bogieIds.add("BG101");
        bogieIds.add("BG102");
        bogieIds.add("BG103");
        bogieIds.add("BG104");
        bogieIds.add("BG101");
        bogieIds.add("BG102");

        System.out.println("Bogie IDs After Insertion:");
        System.out.println(bogieIds);

        System.out.println("Note: Duplicates are automatically ignored by HashSet.");
        System.out.println("UC3 uniqueness validation completed....");

        // === UC4 ===
        System.out.println("\n===============================================");
        System.out.println(" UC4 - Maintain Ordered Bogie Consist ");
        System.out.println("===============================================\n");

        LinkedList<String> orderedConsist = new LinkedList<>();

        orderedConsist.add("Engine");
        orderedConsist.add("Sleeper");
        orderedConsist.add("AC");
        orderedConsist.add("Cargo");
        orderedConsist.add("Guard");

        System.out.println("Initial Train Consist:");
        System.out.println(orderedConsist + "\n");

        orderedConsist.add(2, "Pantry Car");
        System.out.println("After Inserting 'Pantry Car' at position 2:");
        System.out.println(orderedConsist + "\n");

        orderedConsist.removeFirst();
        orderedConsist.removeLast();

        System.out.println("After Removing First and Last Bogie:");
        System.out.println(orderedConsist + "\n");

        System.out.println("UC4 ordered consist operations completed...");

        // === UC5 ===
        System.out.println("\n===============================================");
        System.out.println(" UC5 - Preserve Insertion Order of Bogies ");
        System.out.println("===============================================\n");

        Set<String> formation = new java.util.LinkedHashSet<>();

        formation.add("Engine");
        formation.add("Sleeper");
        formation.add("Cargo");
        formation.add("Guard");

        formation.add("Sleeper"); // Duplicate ignored

        System.out.println("Final Train Formation:");
        System.out.println(formation + "\n");

        System.out.println("Note:");
        System.out.println("LinkedHashSet preserves insertion order and removes duplicates automatically.\n");

        System.out.println("UC5 formation setup completed...");

        // === UC6: Map Bogie to Capacity using HashMap ===
        System.out.println("\n===============================================");
        System.out.println(" UC6 - Map Bogie to Capacity (HashMap) ");
        System.out.println("===============================================\n");

        java.util.HashMap<String, Integer> bogieCapacity = new java.util.HashMap<>();

        bogieCapacity.put("Sleeper", 72);
        bogieCapacity.put("AC Chair", 56);
        bogieCapacity.put("First Class", 24);
        bogieCapacity.put("Goods - Rectangular", 5000);
        bogieCapacity.put("Goods - Cylindrical", 7000);

        System.out.println("Bogie Capacity Mapping:");
        for (java.util.Map.Entry<String, Integer> entry : bogieCapacity.entrySet()) {
            System.out.println(entry.getKey() + " → Capacity: " + entry.getValue());
        }

        System.out.println("\nUC6 bogie-capacity mapping completed successfully...");

        // === UC7: Sort Bogies by Capacity (Comparator) ===
        System.out.println("\n===============================================");
        System.out.println(" UC7 - Sort Bogies by Capacity (Comparator) ");
        System.out.println("===============================================\n");

        // Create a list of Bogie objects
        List<Bogie> passengerBogieList = new ArrayList<>();

        // Add bogies with capacity
        passengerBogieList.add(new Bogie("Sleeper", 72));
        passengerBogieList.add(new Bogie("AC Chair", 56));
        passengerBogieList.add(new Bogie("First Class", 24));

        System.out.println("Passenger Bogies Before Sorting:");
        for (Bogie b : passengerBogieList) {
            System.out.println(b.getName() + " - Capacity: " + b.getCapacity());
        }

        // Sort by capacity (ascending)
        passengerBogieList.sort(java.util.Comparator.comparingInt(Bogie::getCapacity));

        System.out.println("\nPassenger Bogies After Sorting by Capacity:");
        for (Bogie b : passengerBogieList) {
            System.out.println(b.getName() + " - Capacity: " + b.getCapacity());
        }

        System.out.println("\nUC7 bogie sorting completed...");

        // === UC8: Filter Passenger Bogies Using Streams ===
        System.out.println("\n===============================================");
        System.out.println(" UC8 - Filter Passenger Bogies Using Streams ");
        System.out.println("===============================================\n");

        // UC8 Goal: Select bogies with capacity > 60 using Stream API
        System.out.println("Filtering bogies with capacity > 60...");

        List<Bogie> highCapacityBogies = passengerBogieList.stream()
                .filter(b -> b.getCapacity() > 60)   // Condition
                .collect(java.util.stream.Collectors.toList());  // Collect results

        System.out.println("\nFiltered Bogies (Capacity > 60):");

        if (highCapacityBogies.isEmpty()) {
            System.out.println("No bogies match the filtering criteria.");
        } else {
            for (Bogie b : highCapacityBogies) {
                System.out.println(b.getName() + " - Capacity: " + b.getCapacity());
            }
        }

        System.out.println("\nUC8 stream filtering completed successfully...");
    }
}
class Bogie {
    private String name;
    private int capacity;

    public Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }
}