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

    // Constructor with only one arg
    Game(int population){
        this.population = population;
        this.hawkPop = 20;
        this.resource = 50;
        this.cost = 100;
    }

    public void start() {
    }
}
