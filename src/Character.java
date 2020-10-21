import java.util.ArrayList;
import java.util.List;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Image;
import edu.macalester.graphics.Point;
import edu.macalester.graphics.GraphicsGroup;


/**
 * Lien, Jaylynn, and Russell Paul helped us. This class created the character and include the
 * method for currency and character' actions
 */
public class Character {
    GraphicsGroup graphics = new GraphicsGroup(0, 0);
    private Image pig;
    List<Plant> plants = new ArrayList<>();
    private int money = 100;

    /**
     * Create the character of the class using the pig image
     */
    public Character() {
        pig = new Image(0, 0, "pig.png");
        pig.setMaxHeight(100);
        pig.setMaxWidth(80);
        graphics.add(pig);
    }

    public int getMoney() {
        return money;
    }

    public List<Plant> getList() {
        return plants;
    }

    public void subtractMoney(int subtractAmount) {
        money = money - subtractAmount;
    }

    /**
     * This method harvests a plant by removing it from the canvas and adding the profit to the
     * character's money.
     * 
     * @param canvas
     * @param plant
     */
    public void harvest(CanvasWindow canvas, Plant plant) {
        plant.removeFromCanvas(canvas);
        money += plant.getPrice() * 2;
        plants.remove(plant);
    }

    /**
     * @return the position(point) of each plant.
     * @param point
     */
    public Plant getPlantAtPosition(Point point) {
        for (Plant plant : plants) {
            if (plant.getImage().isInBounds(point)) {
                return plant;
            }
        }
        return null;
    }

    /**
     * Creates a new aplle object and adds it to the canvas when it's called. After planting, it
     * subtracts the price of the orange from the character's money.
     * 
     * @param canvas
     * @param x
     * @param y
     */
    public void plantApple(CanvasWindow canvas, double x, double y) {
        Plant apple = new Plant("apple.png", 10);
        apple.setPosition(x, y);
        plants.add(apple);
        apple.addToCanvas(canvas);
        money = money - apple.getPrice();
    }

    /**
     * Creates a new orange object and adds it to the canvas when it's called. After planting, it
     * subtracts the price of the orange from the character's money.
     * 
     * @param canvas
     * @param x
     * @param y
     */
    public void plantOrange(CanvasWindow canvas, double x, double y) {
        Plant orange = new Plant("orange.png", 15);
        orange.setPosition(x, y);
        plants.add(orange);
        orange.addToCanvas(canvas);
        money = money - orange.getPrice();
    }

    /**
     * Creates a new potato object and adds it to the canvas when it's called. After planting, it
     * subtracts the price of the orange from the character's money.
     * 
     * @param canvas
     * @param x
     * @param y
     */
    public void plantPotato(CanvasWindow canvas, double x, double y) {
        Plant potato = new Plant("potato.png", 5);
        potato.getImage().setAnchor(potato.getWidth()/2,potato.getHeight());
        potato.setPosition(x, y);
        plants.add(potato);
        potato.addToCanvas(canvas);
        money = money - potato.getPrice();

    }

    /**
     * Creates a new cabbage object and adds it to the canvas when it's called. After planting, it
     * subtracts the price of the orange from the character's money.
     * 
     * @param canvas
     * @param x
     * @param y
     */
    public void plantCabbage(CanvasWindow canvas, double x, double y) {
        Plant cabbage = new Plant("cabbage.png", 20);
        cabbage.setPosition(x, y);
        plants.add(cabbage);
        cabbage.addToCanvas(canvas);
        money = money - cabbage.getPrice();
    }

    public void addToCanvas(CanvasWindow canvas) {
        canvas.add(this.pig);
    }

    public void removeFromCanvas(CanvasWindow canvas) {
        canvas.remove(this.pig);
    }

    public void moveX(double dx) {
        pig.setX(pig.getX() + dx);
    }

    public void moveY(double dy) {
        pig.setY(pig.getY() + dy);
    }

    public void setCenter(double x, double y) {
        pig.setCenter(x, y);
    }

    public double getX() {
        return pig.getX();
    }

    public double getY() {
        return pig.getY();
    }

    public Point getPosition() {
        return pig.getPosition();
    }

    /**
     *Make the character stay within the bounds. If the pig go out of the bounds, reset it to the edge of the bounds. 
     * @param canvas
     */
    public void canvasBounds(CanvasWindow canvas) {
        double height = canvas.getHeight();

        if (pig.getX() + pig.getWidth() > 750) {
            pig.setX(750 - pig.getWidth());
        }
        if (pig.getX() < 0) {
            pig.setX(0);
        }
        if (pig.getY() + pig.getHeight() > height) {
            pig.setY(height - pig.getHeight());
        }
        if (pig.getY() < 0) {
            pig.setY(0);
        }
    }
}
