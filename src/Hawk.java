// Will always fight as hard as they can, retreating only when seriously injured
public class Hawk {
    private int resource;
    private int id;
    private boolean alive;

    public Hawk(int i) {
        this.id = i;
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
