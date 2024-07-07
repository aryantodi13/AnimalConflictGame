public class Dove {
    private int resource;
    private int id;
    private boolean alive;

    public Dove(int id) {
        this.id = id;
        resource = 0;
        alive = true;
    }

    public int getResource() {
        return resource;
    }

    public void addResource(int amount) {
        resource += amount;
    }

    public boolean isAlive() {
        return alive;
    }

    public void kill() {
        alive = false;
    }


}
