import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Image;

/**
 * Lien, Jaylynn, and Russell Paul helped us. This class created the plants and include the method
 * for plants
 */
public class Plant {
    double width = 5;
    double height = 10;

    private final int price;
    private Image plant;

    public Plant(String image, int price) {
        plant = new Image(0, 0, image);
        this.price = price;
        plant.setMaxHeight(width);
        plant.setMaxWidth(height);
        plant.setRotation(Math.random() * 30 - 15);
    }

    /**
     * @return the plants' image
     */
    public Image getImage() {
        return plant;
    }


    public double getWidth(){
        return width;
    }

    public double getHeight(){
        return height;
    }
    /**
     * Makes the plant grow larger
     */
    public void growLarger() {
        // plant.setScale(5);
        height = height * 3;
        width = width * 3;
        plant.setMaxHeight(height);
        plant.setMaxWidth(width);
    }

    /**
     * test whether the plant reach the largest size.
     */
    public boolean maxSize() {
        if (width == 45 && height == 90) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * @return the price of the plant
     */
    public int getPrice() {
        return price;
    }

    /**
     * set plant position to x,y
     */
    public void setPosition(double x, double y) {
        plant.setCenter(x, y);
    }

    /**
     * add plant to the canvas
     */
    public void addToCanvas(CanvasWindow canvas) {
        canvas.add(plant);
    }

    /**
     * remove plant from canvas
     */
    public void removeFromCanvas(CanvasWindow canvas) {
        canvas.remove(plant);
    }
}