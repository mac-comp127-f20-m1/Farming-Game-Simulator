
import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsObject;
import edu.macalester.graphics.Rectangle;

import java.util.ArrayList;
import java.util.List;
import java.awt.Color;


public class Environment {
    private double landPlotSize = 200;
    private int row = 3, buffer = 20;
    private List<LandPlot> lands = new ArrayList<LandPlot>();

    public Environment() {
        for (int j = 0; j < row; j++) {

            for (int i = 0; i < row; i++) {
                lands.add(
                    new LandPlot(
                        i * landPlotSize + 70 * i + buffer,
                        j * landPlotSize + 70 * j + buffer,
                        landPlotSize,
                        landPlotSize));
            }
        }
        lands.get(0).unlock();
        lands.get(1).unlock();
        lands.get(2).unlock();
    }


    public List<LandPlot> getLands() {
        return lands;
    }


    public void addToCanvas(CanvasWindow canvas) {
        for (LandPlot b : lands) {
            canvas.add(b);
        }
    }

    public void setColor(LandPlot rec) {

    }

    // You might do something like this:

    // public boolean canCharacterMoveTo(Point pos) {
    //     if (pos is out of bounds) {
    //         return false;
    //     }
    //     LandPlot land = getLandAt(pos);
    //     return land == null || !land.isLocked();
    // }
}
