/**
 * The Dove class represents a dove with an id, resource amount, and alive status.
 */
public class Dove {
    private int resource; // Amount of resource the dove has
    private int id; // Unique identifier for the dove
    private boolean alive; // Status indicating if the dove is alive

    /**
     * Constructor to initialize a Dove object with a given id.
     * 
     * @param id the unique identifier for the dove
     */
    public Dove(int id) {
        this.id = id;
        resource = 0; // Initial resource amount is set to 0
        alive = true; // Dove is initially alive
    }

    /**
     * Getter method to return the amount of resource the dove has.
     * 
     * @return the resource amount
     */
    public int getResource() {
        return resource;
    }

    /**
     * Method to add a specified amount of resource to the dove's resource.
     * 
     * @param amount the amount of resource to be added
     */
    public void addResource(int amount) {
        resource += amount;
    }

    /**
     * Method to check if the dove is alive.
     * 
     * @return true if the dove is alive, false otherwise
     */
    public boolean isAlive() {
        return alive;
    }

    /**
     * Method to kill the dove, setting its alive status to false.
     */
    public void kill() {
        alive = false;
    }

    /**
     * Getter method to return the unique identifier of the dove.
     * 
     * @return the id of the dove
     */
    public int getId() {
        return id;
    }

    /**
     * Method to interact with another dove, sharing a specified amount of resource.
     * The resource amount is split equally between the two doves.
     * 
     * @param d the other dove to interact with
     * @param resourcAmt the amount of resource to be shared
     */
    public void interactWithDove(Dove d, int resourcAmt) {
        int bounty = resourcAmt / 2;
        this.resource += bounty;
        d.addResource(bounty);
    }

    /**
     * Method to interact with a hawk, transferring a specified amount of resource to the hawk.
     * 
     * @param h the hawk to interact with
     * @param resourcAmt the amount of resource to be transferred
     */
    public void interactWithHawk(Hawk h, int resourcAmt) {
        h.addResource(resourcAmt);
    }
}
