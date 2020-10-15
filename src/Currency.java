import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.FontStyle;
import edu.macalester.graphics.GraphicsText;
import edu.macalester.graphics.Rectangle;
import edu.macalester.graphics.events.Key;
import java.awt.Color;
import edu.macalester.graphics.events.KeyboardEvent;

public class Currency {
    private int money;
    private Rectangle button; 

    private GraphicsText label = new GraphicsText();



    public Currency(){
        money=0;

    }

    public int getMoney(){
        return money;
    }

    public void createButton(CanvasWindow canvas) {
        button = new Rectangle(0, 0, 80, 30);
        button.setCenter(815, 80);
        button.setFillColor(new Color(156, 195, 230));
        label.setText("Coins:"+money);       
        label.setFont(FontStyle.BOLD,10);
        label.setFillColor(Color.WHITE);
        label.setCenter(815,80);

        
        canvas.add(button);
        canvas.add(label);
        
    }


}
