import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class CisdoSwitch extends Switches{

    public CisdoSwitch(String name, Double xPosition, Double yPosition, Color color) {
        super(name, xPosition, yPosition, color);
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(getColor());
        gc.fillRect(getxPosition() - 50, getyPosition() - 50, 50 * 2, 25 * 2);
        gc.setFill(Color.WHITE);
        gc.fillText(name,getxPosition()-40,getyPosition()-35);
    }

    @Override
    public String toString() {
        return "cisdoSwitch{} " + super.toString();
    }
}
