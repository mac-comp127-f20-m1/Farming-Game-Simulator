import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Image;

public class Plant {

    double width=5;
    double height=10;


    // GraphicsGroup graphics = new GraphicsGroup(0, 0);
    private final int price;
    private Image plant;

    public Plant(String image, int price) {
        plant = new Image(0, 0, image);
        this.price = price;
        plant.setMaxHeight(width);
        plant.setMaxWidth(height);
        // graphics.add(plant);
        plant.setRotation(Math.random()*30-15);
    }

 

  public Image getImage() {
    return plant;
  }

    /**
     * Makes the plant grow larger
     */
    public void growLarger() {
        height = height*3;
        width = width *3;
        plant.setMaxHeight(height);
        plant.setMaxWidth(width);
    }


    public boolean maxSize() {
        if (width == 45 && height == 90){
            return true;
        }else{
            return false;
        }
        
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