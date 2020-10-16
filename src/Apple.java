import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Image;
import edu.macalester.graphics.CanvasWindow;

public class Apple implements Plant {

    GraphicsGroup graphics = new GraphicsGroup(0, 0);
    private int price;
    private Image apple;

    public Apple() {
        apple = new Image(0, 0, "apple.png");
        apple.setMaxHeight(100);
        apple.setMaxWidth(80);
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

    public void setPostion(double x,double y){
        graphics.setCenter(x,y);
    }

    public void addToCanvas(CanvasWindow canvas) {
        canvas.add(apple);
    }



    @Override
    public void removeFromCanvas(CanvasWindow canvas) {
        canvas.remove(apple);
    }
}
