import edu.macalester.graphics.CanvasWindow;

public interface Plant {

    void growLarger();
    boolean maxSize();
    int getPrice();
    void addToCanvas(CanvasWindow canvas);
    void removeFromCanvas(CanvasWindow canvas);

    // Ellipse plant;
    // private int price;

    // public Plant(Color color, double x, double y, int price){
    //     plant = new Ellipse(x, y, 10, 10);
    //     this.price=price;
    // }
    
    // public void growLarger(){
    //     //makes the plant grow larger
    // }

    // public boolean maxSize(){
    //     //check if plant is at maximum size
    //     return true;
    // }

    // public int getPrice() {
    //     return price;
    // }

    // public void addToCanvas(CanvasWindow canvas){
    //     canvas.add(plant);
    // }

    // public void removeFromCanvas(CanvasWindow canvas){
    //     canvas.remove(plant);
    // }
}