import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.Pattern;

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
        formation.add("Sleeper");

        System.out.println("Final Train Formation:");
        System.out.println(formation + "\n");
        System.out.println("UC5 formation setup completed...");

        // === UC6 ===
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

        // === UC7 ===
        System.out.println("\n===============================================");
        System.out.println(" UC7 - Sort Bogies by Capacity (Comparator) ");
        System.out.println("===============================================\n");

        List<Bogie> passengerBogieList = new ArrayList<>();
        passengerBogieList.add(new Bogie("Sleeper", 72));
        passengerBogieList.add(new Bogie("AC Chair", 56));
        passengerBogieList.add(new Bogie("First Class", 24));

        System.out.println("Passenger Bogies Before Sorting:");
        for (Bogie b : passengerBogieList) {
            System.out.println(b.getName() + " - Capacity: " + b.getCapacity());
        }

        passengerBogieList.sort(java.util.Comparator.comparingInt(Bogie::getCapacity));

        System.out.println("\nPassenger Bogies After Sorting:");
        for (Bogie b : passengerBogieList) {
            System.out.println(b.getName() + " - Capacity: " + b.getCapacity());
        }

        System.out.println("\nUC7 bogie sorting completed...");

        // === UC8 ===
        System.out.println("\n===============================================");
        System.out.println(" UC8 - Filter Passenger Bogies Using Streams ");
        System.out.println("===============================================\n");

        List<Bogie> highCapacityBogies = passengerBogieList.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(java.util.stream.Collectors.toList());

        System.out.println("Filtered Bogies (Capacity > 60):");
        for (Bogie b : highCapacityBogies) {
            System.out.println(b.getName() + " - Capacity: " + b.getCapacity());
        }

        System.out.println("\nUC8 stream filtering completed successfully...");

        // === UC9 ===
        System.out.println("\n===============================================");
        System.out.println(" UC9 - Group Bogies by Type (Collectors.groupingBy) ");
        System.out.println("===============================================\n");

        java.util.Map<String, List<Bogie>> groupedBogies =
                passengerBogieList.stream()
                        .collect(java.util.stream.Collectors.groupingBy(Bogie::getName));

        System.out.println("Grouped Bogie Structure:");
        for (java.util.Map.Entry<String, List<Bogie>> entry : groupedBogies.entrySet()) {
            System.out.println("\nCategory: " + entry.getKey());
            for (Bogie b : entry.getValue()) {
                System.out.println(" - " + b.getName() + " | Capacity: " + b.getCapacity());
            }
        }

        System.out.println("\nUC9 bogie grouping completed successfully...");

        // === UC10 ===
        System.out.println("\n===============================================");
        System.out.println(" UC10 - Count Total Seats in Train (reduce) ");
        System.out.println("===============================================\n");

        int totalSeats = passengerBogieList.stream()
                .map(b -> b.getCapacity())
                .reduce(0, Integer::sum);

        System.out.println("Total Seating Capacity in Train: " + totalSeats);
        System.out.println("\nUC10 total seat aggregation completed...");

        // === UC11 ===
        System.out.println("\n===============================================");
        System.out.println(" UC11 - Validate Train ID and Cargo Code (Regex) ");
        System.out.println("===============================================\n");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Train ID (Format TRN-1234): ");
        String trainId = scanner.nextLine();

        System.out.print("Enter Cargo Code (Format: PET-AB): ");
        String cargoCode = scanner.nextLine();

        Pattern trainPattern = Pattern.compile("TRN-\\d{4}");
        Pattern cargoPattern = Pattern.compile("PET-[A-Z]{2}");

        boolean isTrainValid = trainPattern.matcher(trainId).matches();
        boolean isCargoValid = cargoPattern.matcher(cargoCode).matches();

        System.out.println("\nValidation Results");
        System.out.println("Train ID Valid: " + isTrainValid);
        System.out.println("Cargo Code Valid: " + isCargoValid);
        System.out.println("UC11 validation completed...");

        scanner.close();

        // === UC12 ===
        System.out.println("\n===============================================");
        System.out.println(" UC12 - Safety Compliance Check for Goods Bogies ");
        System.out.println("===============================================\n");

        class GoodsBogie {
            String type;
            String cargo;

            GoodsBogie(String type, String cargo) {
                this.type = type;
                this.cargo = cargo;
            }
        }

        List<GoodsBogie> goodsBogies = new ArrayList<>();
        goodsBogies.add(new GoodsBogie("Cylindrical", "Petroleum"));
        goodsBogies.add(new GoodsBogie("Open", "Coal"));
        goodsBogies.add(new GoodsBogie("Box", "Grain"));
        goodsBogies.add(new GoodsBogie("Cylindrical", "Coal"));

        System.out.println("Goods Bogies in Train:");
        for (GoodsBogie gb : goodsBogies) {
            System.out.println(gb.type + " -> " + gb.cargo);
        }

        boolean isSafe = goodsBogies.stream()
                .allMatch(gb -> !gb.type.equalsIgnoreCase("Cylindrical")
                        || gb.cargo.equalsIgnoreCase("Petroleum"));

        System.out.println("\nSafety Compliance Status: " + isSafe);
        System.out.println(isSafe ? "Train Formation is SAFE." : "Train Formation is NOT SAFE.");
        System.out.println("UC12 safety validation completed...");

        // === UC13 ===
        System.out.println("\n===============================================");
        System.out.println(" UC13 - Performance Comparison (Loops vs Streams) ");
        System.out.println("===============================================\n");

        List<Bogie> testBogies = new ArrayList<>();
        testBogies.add(new Bogie("Sleeper", 72));
        testBogies.add(new Bogie("AC Chair", 56));
        testBogies.add(new Bogie("First Class", 24));
        testBogies.add(new Bogie("Executive", 80));

        long startLoop = System.nanoTime();
        List<Bogie> loopFiltered = new ArrayList<>();
        for (Bogie b : testBogies) {
            if (b.getCapacity() > 60) {
                loopFiltered.add(b);
            }
        }
        long endLoop = System.nanoTime();

        long startStream = System.nanoTime();
        List<Bogie> streamFiltered = testBogies.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(java.util.stream.Collectors.toList());
        long endStream = System.nanoTime();

        System.out.println("Loop Execution Time:   " + (endLoop - startLoop) + " ns");
        System.out.println("Stream Execution Time: " + (endStream - startStream) + " ns");
        System.out.println("UC13 performance benchmarking completed...");

        // === UC14 ===
        System.out.println("\n===============================================");
        System.out.println(" UC14 - Handle Invalid Bogie Capacity (Custom Exception) ");
        System.out.println("===============================================\n");

        try {
            System.out.println("Attempting to create a Passenger Bogie with capacity -10...");
            PassengerBogieUC14 invalidBogie = new PassengerBogieUC14("Sleeper", -10);
        } catch (InvalidCapacityException e) {
            System.out.println("Exception Caught: " + e.getMessage());
        }

        try {
            System.out.println("\nCreating valid Passenger Bogie with capacity 50...");
            PassengerBogieUC14 validBogie = new PassengerBogieUC14("AC Chair", 50);
            System.out.println("Bogie Created Successfully → Type: " + validBogie.getType()
                    + ", Capacity: " + validBogie.getCapacity());
        } catch (InvalidCapacityException e) {
            System.out.println("ERROR: Should not happen for valid data.");
        }

        System.out.println("UC14 custom exception handling completed...");

        // ======================================================================
        // === UC15 =============================================================
        // ======================================================================
        System.out.println("\n===============================================");
        System.out.println(" UC15 - Safe Cargo Assignment Using try-catch-finally ");
        System.out.println("===============================================\n");

        GoodsBogieUC15 rectBogie = new GoodsBogieUC15("Rectangular");
        GoodsBogieUC15 cylBogie = new GoodsBogieUC15("Cylindrical");

        // Safe Assignment
        System.out.println("\n--- Test Case: Safe Cargo Assignment ---");
        rectBogie.assignCargo("Coal");

        // Unsafe Assignment (Petroleum in Rectangular)
        System.out.println("\n--- Test Case: Unsafe Cargo Assignment (Should Trigger Exception) ---");
        rectBogie.assignCargo("Petroleum");

        // Safe Petroleum assignment in Cylindrical
        System.out.println("\n--- Test Case: Valid Petroleum Assignment ---");
        cylBogie.assignCargo("Petroleum");

        System.out.println("\nUC15 safe runtime exception handling completed...");

        // ======================================================================
        // === UC16 =============================================================
        // ======================================================================
        System.out.println("\n===============================================");
        System.out.println(" UC16 - Sort Passenger Bogies by Capacity (Bubble Sort) ");
        System.out.println("===============================================\n");

        int[] capacities = {72, 56, 24, 70, 60};

        System.out.println("Before Sorting (Original Capacities):");
        printArray(capacities);

        bubbleSort(capacities);

        System.out.println("\nAfter Sorting (Bubble Sort Result):");
        printArray(capacities);

        System.out.println("\nUC16 bubble sort demonstration completed...");

        // ======================================================================
        // === UC17 =============================================================
        // ======================================================================
        System.out.println("\n===============================================");
        System.out.println(" UC17 - Sort Bogie Names Using Arrays.sort() ");
        System.out.println("===============================================\n");

        String[] bogieNames = {"Sleeper", "AC Chair", "First Class", "General", "Luxury"};

        System.out.println("Before Sorting (Original Bogie Names):");
        System.out.println(java.util.Arrays.toString(bogieNames));

        java.util.Arrays.sort(bogieNames);

        System.out.println("\nAfter Sorting Using Arrays.sort():");
        System.out.println(java.util.Arrays.toString(bogieNames));

        System.out.println("\nUC17 built-in Java sorting completed...");
    }

    // Bubble Sort Implementation for UC16
    public static void bubbleSort(int[] arr) {

        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {

            for (int j = 0; j < n - i - 1; j++) {

                if (arr[j] > arr[j + 1]) {

                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Helper Method to Print Array for UC16
    public static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}


// ======================================================================
// Custom Exception for UC14
// ======================================================================
class InvalidCapacityException extends Exception {
    public InvalidCapacityException(String message) {
        super(message);
    }
}

// ======================================================================
// Passenger Bogie Class for UC14
// ======================================================================
class PassengerBogieUC14 {
    private String type;
    private int capacity;

    public PassengerBogieUC14(String type, int capacity) throws InvalidCapacityException {
        if (capacity <= 0) {
            throw new InvalidCapacityException("Capacity must be greater than zero");
        }
        this.type = type;
        this.capacity = capacity;
    }

    public String getType() {
        return type;
    }

    public int getCapacity() {
        return capacity;
    }
}

// ======================================================================
// Existing Bogie Class (Used in UC7–UC13)
// ======================================================================
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

// ======================================================================
// UC15 - Custom Runtime Exception
// ======================================================================
class CargoSafetyException extends RuntimeException {
    public CargoSafetyException(String message) {
        super(message);
    }
}

// ======================================================================
// UC15 - Goods Bogie with Runtime Safety Check
// ======================================================================
class GoodsBogieUC15 {

    private String shape;
    private String cargo;

    public GoodsBogieUC15(String shape) {
        this.shape = shape;
    }

    public void assignCargo(String cargo) {

        System.out.println("Attempting cargo assignment → Shape: " + shape + ", Cargo: " + cargo);

        try {
            // Safety Rule
            if (shape.equalsIgnoreCase("Rectangular") &&
                    cargo.equalsIgnoreCase("Petroleum")) {

                throw new CargoSafetyException(
                        "UNSAFE ASSIGNMENT: Petroleum cannot be stored in Rectangular bogies!");
            }

            this.cargo = cargo;
            System.out.println("Cargo Assigned Successfully: " + cargo);

        } catch (CargoSafetyException e) {
            System.out.println("ERROR: " + e.getMessage());
            System.out.println("Cargo NOT assigned due to violation.");

        } finally {
            System.out.println("Cargo Validation Completed (finally block executed).");
        }
    }
}