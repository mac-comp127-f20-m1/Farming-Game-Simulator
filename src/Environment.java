
import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsObject;
import edu.macalester.graphics.Point;
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

    public LandPlot getLandPlotAtPosition(Point point){
        for (LandPlot landPlot : lands) {
            if (landPlot.isInBounds(point)){
                return landPlot;
            }
        }
        return null;
    }

    public List<LandPlot> getLands() {
        return lands;
    }

    public void addToCanvas(CanvasWindow canvas) {
        for (LandPlot b : lands) {
            canvas.add(b);
        }
    }
}
