public class Game {
    int population;
    int hawkPop;
    int resource;
    int cost;

    // Constructor if all args defined
    Game(int population, int hawkPop, int resourceAmt, int cost){
        this.population = population;
        this.hawkPop = hawkPop;
        this.resource = resource;
        this.cost = cost;
    }

    public void start() {
        //write the simulation here
    }

    public void displayMenu() {
        //write the menu here
    }



    public static void main(String[] args) {
        if (args.length < 1 || args.length > 4) {
            System.err.println("Usage: ./project02 popSize [percentHawks] [resourceAmt] [costHawk-Hawk]");
            System.exit(1);
        }

        int population = Integer.parseInt(args[0]);
        int hawkPercent = (args.length > 1) ? Integer.parseInt(args[1]) : 20;
        int hawkPop = (int)(population * (hawkPercent / 100.0));
        int resourceAmt = (args.length > 2) ? Integer.parseInt(args[2]) : 50;
        int cost = (args.length > 3) ? Integer.parseInt(args[3]) : 100;

        Game game = new Game(population, hawkPop, resourceAmt, cost);
        game.start();
    }
}
