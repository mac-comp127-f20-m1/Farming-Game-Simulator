import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Image;

public class Plant {

    // GraphicsGroup graphics = new GraphicsGroup(0, 0);
    private final int price;
    private Image plant;

    public Plant(String image, int price) {
        plant = new Image(0, 0, image);
        this.price = price;
        plant.setMaxHeight(50);
        plant.setMaxWidth(40);
        // graphics.add(plant);
        plant.setRotation(Math.random()*30-15);
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
    plant.setCenter(x,y);
    }

    public void addToCanvas(CanvasWindow canvas) {
        canvas.add(plant);
    }

    public void removeFromCanvas(CanvasWindow canvas) {
        canvas.remove(plant);
    }
}