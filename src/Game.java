import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Game {
    private int population;
    private int hawkPop;
    private int resource;
    private int cost;
    private ArrayList<Object> popList = new ArrayList<>();
    


    // Constructor if all args defined
    Game(int population, int hawkPop, int resourceAmt, int cost){
        this.population = population;
        this.hawkPop = hawkPop;
        this.resource = resourceAmt;
        this.cost = cost;
    }

    public void start() {
        initpopulation();
        Scanner scanner = new Scanner(System.in);
       while (true) {
           displayMenu();
           // TODO
           //ask the user for input a number between 1-8 and call the necessary method
           System.out.print("Enter a number between 1-8: ");
           int option = scanner.nextInt();

           switch (option) {
               case 1:
                   displayStats();
                   break;
               case 2:
                   displayIndividuals();
                   break;
               case 3:
                   displaySorted();
                   break;
               case 4:
                   have1000Interactions();
                   break;
               case 5:
                   have1000Interactions();
                   break;
               case 6:
                   have1000Interactions();
                   break;
               case 7:
                   stepThroughInteractions();
                   break;
               case 8:
                   scanner.close();
                   return;
           }
       }
       
    }

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

    private void stepThroughInteractions() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'stepThroughInteractions'");
    }

    private void have1000Interactions() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'have1000Interactions'");
    }

    private void displaySorted() {
        List<Dove> doves = new ArrayList<>();
        List<Hawk> hawks = new ArrayList<>();

        // Populate the doves and hawks lists
        for (Object o : popList) {
            if (o instanceof Dove) {
                doves.add((Dove) o);
            }
            if (o instanceof Hawk) {
                hawks.add((Hawk) o);
            }
        }

        // Sort the doves and hawks lists based on resource value in descending order
        Collections.sort(doves, Comparator.comparingInt(Dove::getResource).reversed());
        Collections.sort(hawks, Comparator.comparingInt(Hawk::getResource).reversed());

        // Display the sorted list of individuals
        int i =0;
        int j=0;
        while(i<doves.size() || j<hawks.size()) {
            if (j>=hawks.size()) {
                System.out.println((doves.get(i).isAlive() ? "Dove: " : "Dead: ") + doves.get(i).getResource());
                i++;
                continue;
            }
            if(i>=doves.size()) {
                System.out.println((hawks.get(j).isAlive() ? "Hawk: " : "Dead: ") + hawks.get(j).getResource());
                j++;
                continue;
            }
            if(doves.get(i).getResource() > hawks.get(j).getResource()) {
                System.out.println(doves.get(i).isAlive() ? "Dove: " : "Dead: " + doves.get(i).getResource());
                i++;
            } else {
                System.out.println((hawks.get(j).isAlive() ? "Hawk: " : "Dead: ") + hawks.get(j).getResource());
                j++;
            }
        }
    }
        
    

    private void displayIndividuals() {
        int alivecount = 0;
        for(Object o : popList) {
            if(o instanceof Dove) {
                if(((Dove)o).isAlive()) {
                    alivecount++; 
                }
                System.out.println("Individual[" + ((Dove)o).getId() + "]=" + (((Dove)o).isAlive() ? "Dove" : "Dead" ) + ":" + ((Dove)o).getResource());
            }
            if(o instanceof Hawk) {
                if(((Hawk)o).isAlive()) {
                    alivecount++;
                }
                System.out.println("Individual[" + ((Hawk)o).getId() + "]=" + (((Hawk)o).isAlive() ? "Hawk" : "Dead")+ ":" + ((Hawk)o).getResource());
            }
        }
        System.out.println("Living: " + alivecount);
    }

    public void displayMenu() {
        System.out.println("===============MENU=============");
        System.out.println("1 ) Starting Stats");
        System.out.println("2 ) Display Individuals and Points");
        System.out.println("3 ) Display Sorted");
        System.out.println("4 ) Have 1000 interactions");
        System.out.println("5 ) Have 10000 interactions");  
        System.out.println("6 ) Have n interactions"); 
        System.out.println("7 )Step through interactions \"Stop\" to return to menu");
        System.out.println("8 ) Quit");
        System.out.println("================================");
        System.out.println();
    }

    public void initpopulation(){
        for (int i = 0; i < hawkPop; i++) {
            popList.add(new Hawk(i));
        }  

        for (int i = hawkPop; i < population; i++) {
            popList.add(new Dove(i));
        }

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
