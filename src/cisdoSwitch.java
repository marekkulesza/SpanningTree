import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class cisdoSwitch extends Switches{

    public cisdoSwitch(String name, Double xPosition, Double yPosition, Color color) {
        super(name, xPosition, yPosition, color);
    }

    @Override
    public void draw(GraphicsContext gc) {
    }

    @Override
    public String toString() {
        return "cisdoSwitch{} " + super.toString();
    }
}
