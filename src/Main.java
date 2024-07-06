public class Main {
    public static void main(String[] args) {
        System.out.println(args.length);
        if(args.length < 1 || args.length > 4){
            // Error message
            System.err.println();
            System.exit(0);
        }
        if(args.length == 1) {
            Game game = new Game(Integer.parseInt(args[0]));
            game.start();

        }
    }
}