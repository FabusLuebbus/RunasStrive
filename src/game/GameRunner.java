package game;

public class GameRunner {
    public static void main(String[] args) {
        if (args.length > 0) {
            System.out.println("please start program without any command line parameters");
        } else {
            Game game = new Game();
        }
    }
}
