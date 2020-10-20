import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Rectangle;
import java.awt.Color;

public class LandPlot extends GraphicsGroup {
    private Rectangle rec;
    private boolean locked;
    private int maximumPlants = 9;
    private int cnt=0;

    public LandPlot(double x, double y, double width, double height) {
        setPosition(x, y);
        rec = new Rectangle(0, 0, width, height);
        rec.setFillColor(new Color(139, 69, 19));
        rec.setStrokeWidth(5);
        lock();
        add(rec);
    }

    public int getMaximumPlants(){
        return maximumPlants;
    }

    public int getCnt(){
        return cnt;
    }

    public void plusOne(){
       cnt++;
    }

    public void minusOne(){
        cnt--;
    }

    public boolean isLocked() {
        return locked;
    }

    public void lock() {
        locked = true;
        rec.setStrokeColor(Color.red);
    }

    public void unlock() {
        locked = false;
        rec.setStrokeColor(Color.white);
    }
}
