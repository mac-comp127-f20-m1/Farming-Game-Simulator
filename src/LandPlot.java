import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Rectangle;
import java.awt.Color;

/**This class controls the appearance and lock status of the landplots in the game. */
public class LandPlot extends GraphicsGroup {
    private Rectangle rec;
    private boolean locked;
    private int maximumPlants = 9;
    private int cnt = 0;

    public LandPlot(double x, double y, double width, double height) {
        setPosition(x, y);
        rec = new Rectangle(0, 0, width, height);
        rec.setFillColor(new Color(139, 69, 19));
        rec.setStrokeWidth(5);
        lock();
        add(rec);
    }

    public int getMaximumPlants() {
        return maximumPlants;
    }

    public int getCnt() {
        return cnt;
    }

    public void plusOne() {
        cnt++;
    }

    public void minusOne() {
        cnt--;
    }

    /**
     * This method checks if a landplot is locked or not.
     * 
     * @return boolean, locked
     */
    public boolean isLocked() {
        return locked;
    }

    /**
     * This method changes the lock status of the landplot to locked, making the border red.
     */
    public void lock() {
        locked = true;
        rec.setStrokeColor(Color.red);
    }

    /**
     * This method changes the lock status of the landplot to unlocked, making the border white.
     */
    public void unlock() {
        locked = false;
        rec.setStrokeColor(Color.white);
    }
}
