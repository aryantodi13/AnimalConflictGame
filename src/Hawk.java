/*
 * Author: Gnandeep Gottipati
 * File: Hawk.java
 */

/**
 * The Hawk class represents a hawk in the simulation. Hawks will always fight
 * as hard as they can, retreating only when seriously injured.
 */
public class Hawk {
    private int resource;  // Resource value for the Hawk
    private int id;        // Unique identifier for the Hawk
    private boolean alive; // Status of the Hawk, true if alive

    /**
     * Constructor to initialize a Hawk object with a unique identifier.
     *
     * @param i Unique identifier for the Hawk.
     */
    public Hawk(int i) {
        this.id = i;
        resource = 0;    // Initial resource value is 0
        alive = true;    // Hawk is initially alive
    }

    /**
     * Get the resource value of the Hawk.
     *
     * @return The current resource value of the Hawk.
     */
    public int getResource() {
        return resource;
    }

    /**
     * Add a specified amount to the Hawk's resource.
     *
     * @param amount The amount to add to the resource.
     */
    public void addResource(int amount) {
        resource += amount;
    }

    /**
     * Check if the Hawk is alive.
     *
     * @return True if the Hawk is alive, false otherwise.
     */
    public boolean isAlive() {
        return alive;
    }

    /**
     * Kill the Hawk by setting its alive status to false.
     */
    public void kill() {
        alive = false;
    }

    /**
     * Get the unique identifier of the Hawk.
     *
     * @return The unique identifier of the Hawk.
     */
    public int getId() {
        return id;
    }

    /**
     * Interaction method when the Hawk interacts with a Dove.
     * The Hawk gains the entire resource amount.
     *
     * @param d           The Dove the Hawk interacts with.
     * @param resourcAmt  The resource amount involved in the interaction.
     */
    public void interactWithDove(Dove d, int resourcAmt) {
        this.resource += resourcAmt;
    }

    /**
     * Interaction method when the Hawk interacts with another Hawk.
     * The resource amount is divided, and the cost of the fight is subtracted
     * from both Hawks. If a Hawk's resource falls below zero, it is killed.
     *
     * @param h           The other Hawk involved in the interaction.
     * @param resourcAmt  The resource amount involved in the interaction.
     * @param cost        The cost of the fight between Hawks.
     */
    public void interactWithHawk(Hawk h, int resourcAmt, int cost) {
        this.resource += resourcAmt - cost; // Add resource amount minus cost to this Hawk's resource
        h.addResource(-cost);               // Subtract cost from the other Hawk's resource
        if (this.getResource() < 0) {       // Check if this Hawk's resource is below zero
            this.kill();                    // Kill this Hawk if its resource is below zero
            System.out.println("Hawk one has died!");
        }
        if (h.getResource() < 0) {          // Check if the other Hawk's resource is below zero
            h.kill();                       // Kill the other Hawk if its resource is below zero
            System.out.println("Hawk two has died!");
        }
    }
}
