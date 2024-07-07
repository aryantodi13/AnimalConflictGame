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

    public int getId() {
        return id;
    }

    public void interactWithDove(Dove d, int resourcAmt) {
        int bounty = resourcAmt / 2;
        this.resource += bounty;
        d.addResource(bounty);

    }

    public void interactWithHawk(Hawk h, int resourcAmt) {
        h.addResource(resourcAmt);
    }


}
