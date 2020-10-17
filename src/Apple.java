import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Image;
import edu.macalester.graphics.CanvasWindow;

public class Apple implements Plant {

    GraphicsGroup graphics = new GraphicsGroup(0, 0);
    private final int price = 10;
    private Image apple;

    public Apple() {
        apple = new Image(0, 0, "apple.png");
        apple.setMaxHeight(50);
        apple.setMaxWidth(40);
        graphics.add(apple);
    }

    /**
     * Makes the plant grow larger
     */
    public void growLarger() {

    }

    public boolean maxSize() {
        // check if plant is at maximum size
        return true;
    }

    public int getPrice() {
        return price;
    }

    public void setPosition(double x,double y){
        apple.setCenter(x,y);
    }

    public void addToCanvas(CanvasWindow canvas) {
        canvas.add(apple);
    }

    @Override
    public void removeFromCanvas(CanvasWindow canvas) {
        canvas.remove(apple);
    }
}
