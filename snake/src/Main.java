import java.awt.event.KeyEvent;

public class Main {


    public static void main(String[] args) {

        Game game = new Game();
        while(true){
            game.update();
            if (game.gameover == true){
                break;
            }
        }
    }
}