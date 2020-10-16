import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Image;
import edu.macalester.graphics.CanvasWindow;

public class Potato implements Plant {

    GraphicsGroup graphics = new GraphicsGroup(0, 0);
    private int price;
    private Image potato;

    public Potato() {
        potato = new Image(0, 0, "potato.png");
        potato.setMaxHeight(100);
        potato.setMaxWidth(80);
        graphics.add(potato);
    }

    public void growLarger() {
        // makes the plant grow larger
    }

    public boolean maxSize() {
        // check if plant is at maximum size
        return true;
    }

    public int getPrice() {
        return price;
    }

    public void addToCanvas(CanvasWindow canvas) {
        canvas.add(potato);
    }

    public void removeFromCanavas(CanvasWindow canvas) {
        canvas.remove(potato);
    }
}

