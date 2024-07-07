// Will always fight as hard as they can, retreating only when seriously injured

import java.util.ArrayList;

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

    public int getId() {
        return id;
    }

    public void interactWithDove(Dove d, int resourcAmt) {
        this.resource += resourcAmt;
    }

    public void interactWithHawk(Hawk h, int resourcAmt, int cost) {
        this.resource += resourcAmt - cost;
        h.addResource(-cost);
        if (this.getResource() < 0) {
            this.kill();
            System.out.println("Hawk one has died!");
        }
        if(h.getResource() < 0) {
            h.kill();
            System.out.println("Hawk two has died!");
        }
        
    }

}
