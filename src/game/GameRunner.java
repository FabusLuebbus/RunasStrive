package game;

public class GameRunner {
    public static void main(String[] args) {
        if (args.length > 0) {
            System.out.println("Error, start without command line arguments");
        } else {
            Game game = new Game();
        }
    }
}
