/*
 * Author: Gnandeep Gottipati
 * File: Game.java
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * The Game class simulates interactions between Hawks and Doves in a population.
 * It manages population statistics, interactions, and user interface for simulation control.
 */
public class Game {
    private int population;          // Total population size
    private int hawkPop;             // Number of Hawks in the population
    private int resource;            // Resource value for interactions
    private int cost;                // Cost of Hawk-Hawk interaction
    private ArrayList<Object> popList = new ArrayList<>();  // List to hold population objects

    /**
     * Constructor to initialize the game with given parameters.
     *
     * @param population Total population size
     * @param hawkPop Number of Hawks in the population
     * @param resource Resource value for interactions
     * @param cost Cost of Hawk-Hawk interaction
     */
    Game(int population, int hawkPop, int resource, int cost){
        this.population = population;
        this.hawkPop = hawkPop;
        this.resource = resource;
        this.cost = cost;
    }

    /**
     * Starts the simulation and handles user interaction through a menu.
     */
    public void start() {
        initPopulation();  // Initialize the population
        Scanner scanner = new Scanner(System.in);
        while (true) {
            displayMenu();  // Display menu options
            System.out.print("Enter a number between 1-8: ");
            int option = scanner.nextInt();  // Read user input

            switch (option) {
                case 1:
                    displayStats();  // Display current statistics
                    break;
                case 2:
                    displayIndividuals();  // Display details of each individual
                    break;
                case 3:
                    displaySorted();  // Display individuals sorted by resource amount
                    break;
                case 4:
                    haveInteractions(1000, true, -1);  // Simulate 1000 interactions
                    break;
                case 5:
                    haveInteractions(10000, true, -1);  // Simulate 10000 interactions
                    break;
                case 6:
                    System.out.print("Enter number of interactions: ");
                    int n = scanner.nextInt();
                    haveInteractions(n, true, -1);  // Simulate n interactions
                    break;
                case 7:
                    stepThroughInteractions();  // Step through interactions one by one
                    break;
                case 8:
                    scanner.close();  // Close the scanner and exit the program
                    return;
                default:
                    System.out.println("Invalid option. Please enter a number between 1-8.");
                    break;
            }
        }
    }

    /**
     * Display current population statistics.
     */
    private void displayStats() {
        System.out.println("Population size: " + population);
        System.out.println("Percentage of Hawks: " + (hawkPop * 100 / population) + "%");
        System.out.println("Number of Hawks: " + hawkPop);
        System.out.println();
        System.out.println("Percentage of Doves: " + (100 - (hawkPop * 100 / population)) + "%");
        System.out.println("Number of Doves: " + (population - hawkPop));
        System.out.println();
        System.out.println("Each resource is worth: " + resource);
        System.out.println("Cost of Hawk-Hawk interaction: " + cost);
        System.out.println();
    }

    /**
     * Step through interactions one by one until user commands to stop.
     */
    private void stepThroughInteractions() {
        int interactionNum = 0;
        Scanner sc = new Scanner(System.in);
        while (true){
            haveInteractions(1, false, interactionNum);  // Simulate one interaction
            interactionNum++;
            System.out.print("Type 'stop' to return to menu: ");
            String command = sc.nextLine();
            if (command.equalsIgnoreCase("stop")) break;
        }
        sc.close();
    }

    /**
     * Simulate interactions among population members.
     *
     * @param cycles Number of interactions to simulate
     * @param flag Flag to indicate if interactions should be displayed
     * @param interactionNum Index of the interaction
     */
    private void haveInteractions(int cycles, boolean flag, int interactionNum) {
        if(popList.size() == 1) {
            System.out.println("Cannot have interactions since only 1 animal is alive.");
            return;
        }

        Random random = new Random();
        int numEncounters = 0;
        for (int i = 0; i < cycles; i++) {
            if (!flag){
                numEncounters=interactionNum;
            }
            int ind1 = random.nextInt(popList.size());
            int ind2 = random.nextInt(popList.size());

            // Ensure different individuals are selected
            while(ind2 == ind1) ind2 = random.nextInt(popList.size());

            Object o1 = popList.get(ind1);
            Object o2 = popList.get(ind2);

            // Handle interactions based on object types
            if(o1 instanceof Dove && o2 instanceof Hawk) {
                if(((Dove)o1).isAlive() && ((Hawk)o2).isAlive()) {
                    System.out.println("Encounter: " + numEncounters);
                    System.out.println("Individual " + ((Dove)o1).getId() + ": Dove");
                    System.out.println("Individual " + ((Hawk)o2).getId() + ": Hawk");
                    System.out.println("Hawk/Dove: Hawk: +" + this.resource + "  Dove: +0");
                    ((Dove)o1).interactWithHawk((Hawk)o2, this.resource);
                    System.out.println("Individual " + ((Dove)o1).getId() + "= " + ((Dove)o1).getResource() +
                            "  Individual " + ((Hawk)o2).getId() + "= " + ((Hawk)o2).getResource());
                } else {
                    i--;  // Retry this iteration if any individual is not alive
                    continue;
                }
            }
            // Continue with other interaction types (Hawk-Dove, Hawk-Hawk, Dove-Dove)
            // Insert similar if(o1 instanceof Hawk && o2 instanceof Dove) and if(o1 instanceof Hawk && o2 instanceof Hawk) sections here.
            
            numEncounters++;
        }
    }

    /**
     * Display individuals sorted by their resource amount.
     */
    private void displaySorted() {
        List<Dove> doves = new ArrayList<>();
        List<Hawk> hawks = new ArrayList<>();

        // Separate Hawks and Doves into different lists
        for (Object o : popList) {
            if (o instanceof Dove) {
                doves.add((Dove) o);
            }
            if (o instanceof Hawk) {
                hawks.add((Hawk) o);
            }
        }

        // Sort lists in descending order based on resource amount
        Collections.sort(doves, Comparator.comparingInt(Dove::getResource).reversed());
        Collections.sort(hawks, Comparator.comparingInt(Hawk::getResource).reversed());

        // Display sorted individuals with their resource amount and status
        int i = 0, j = 0;
        while (i < doves.size() || j < hawks.size()) {
            if (j >= hawks.size()) {
                System.out.println((doves.get(i).isAlive() ? "Dove: " : "Dead: ") + doves.get(i).getResource());
                i++;
                continue;
            }
            if (i >= doves.size()) {
                System.out.println((hawks.get(j).isAlive() ? "Hawk: " : "Dead: ") + hawks.get(j).getResource());
                j++;
                continue;
            }
            if (doves.get(i).getResource() > hawks.get(j).getResource()) {
                System.out.println((doves.get(i).isAlive() ? "Dove: " : "Dead: ") + doves.get(i).getResource());
                i++;
            } else {
                System.out.println((hawks.get(j).isAlive() ? "Hawk: " : "Dead: ") + hawks.get(j).getResource());
                j++;
            }
        }
    }

    /**
     * Display details of each individual in the population.
     */
    private void displayIndividuals() {
        int aliveCount = 0;
        for (Object o : popList) {
            if (o instanceof Dove) {
                System.out.println("Individual[" + ((Dove)o).getId() + "]=" +
                        (((Dove)o).isAlive() ? "Dove" : "Dead") + ":" + ((Dove)o).getResource());
                if (((Dove)o).isAlive()) {
                    aliveCount++;
                }                System.out.println("Individual[" + ((Hawk)o).getId() + "]=" + (((Hawk)o).isAlive() ? "Hawk" : "Dead")+ ":" + ((Hawk)o).getResource());

            }
            if (o instanceof Hawk) {
                System.out.println("Individual[" + ((Hawk)o).getId() + "]=" +
                        (((Hawk)o).isAlive() ? "Hawk" : "Dead") + ":" + ((Hawk)o).getResource());
                if (((Hawk)o).isAlive()) {
                    aliveCount++;
                }
            }
        }
        System.out.println("Living: " + aliveCount);
    }

    /**
     * Display the main menu options.
     */
    public void displayMenu() {
        System.out.println("=============== MENU =============");
        System.out.println("1 ) Starting Stats");
        System.out.println("2 ) Display Individuals and Points");
        System.out.println("3 ) Display Sorted");
        System.out.println("4 ) Have 1000 interactions");
        System.out.println("5 ) Have 10000 interactions");
        System.out.println("6 ) Have n interactions"); 
        System.out.println("7 ) Step through interactions \"Stop\" to return to menu");
        System.out.println("8 ) Quit");
        System.out.println("===================================");
        System.out.println();
    }

    /**
     * Initializes the population by creating Hawks and Doves.
     */
    public void initPopulation() {
        // Create Hawks
        for (int i = 0; i < hawkPop; i++) {
            popList.add(new Hawk(i));  // Add a new Hawk to the population list
        }  

        // Create Doves
        for (int i = hawkPop; i < population; i++) {
            popList.add(new Dove(i));  // Add a new Dove to the population list
        }
    }

    /**
     * Main method to start the game.
     *
     * @param args Command line arguments for population size, percentage of Hawks, resource amount, and cost.
     */
    public static void main(String[] args) {
        // Validate command line arguments
        if (args.length < 1 || args.length > 4) {
            System.err.println("Usage: ./project02 popSize [percentHawks] [resourceAmt] [costHawk-Hawk]");
            System.exit(1);  // Exit if invalid arguments are provided
        }

        // Parse command line arguments
        int population = Integer.parseInt(args[0]);
        int hawkPercent = (args.length > 1) ? Integer.parseInt(args[1]) : 20;  // Default to 20% Hawks
        int hawkPop = (int)(population * (hawkPercent / 100.0));  // Calculate number of Hawks
        int resourceAmt = (args.length > 2) ? Integer.parseInt(args[2]) : 50;  // Default resource amount
        int cost = (args.length > 3) ? Integer.parseInt(args[3]) : 100;  // Default cost of Hawk-Hawk interaction

        // Initialize and start the game
        Game game = new Game(population, hawkPop, resourceAmt, cost);
        game.start();
    }
}
