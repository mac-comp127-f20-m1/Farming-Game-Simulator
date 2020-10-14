import edu.macalester.graphics.CanvasWindow;

public class Game {

    private CanvasWindow canvas;

    public Game(){
        canvas=new CanvasWindow("JRL Farm", 900, 1000);

    }
    


    public static void main(String[] args) {
        new Game();
    }
    
}
