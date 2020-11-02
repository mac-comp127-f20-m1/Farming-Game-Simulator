import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Point;

import java.util.ArrayList;
import java.util.List;

/**
 * This class positions all of the landplots onto the screen, setting up the visual environment for
 * the game. It functions mainly as a landplot manager.
 */
public class Environment {
    private double landPlotSize = 200;
    private int row = 3, buffer = 20;
    private List<LandPlot> lands = new ArrayList<LandPlot>();

    /**
     * Positions all the landplots on the screen in even rows and columns, leaving the first three plots unlocked.
     */
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

    public LandPlot getLandPlotAtPosition(Point point) {
        for (LandPlot landPlot : lands) {
            if (landPlot.isInBounds(point)) {
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
