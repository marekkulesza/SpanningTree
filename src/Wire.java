import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Wire extends ComputerObjects{

    Switches switches1;
    Switches switches2;
    Double endxPosition;
    Double endyPosition;

    public Wire(String name, Double xPosition, Double yPosition, Double endxPosition, Double endyPosition, Color color, Switches switches1, Switches switches2) {
        super(name, xPosition, yPosition, color);
        this.switches1 = switches1;
        this.switches2 = switches2;
        this.endxPosition = endxPosition;
        this.endyPosition = endyPosition;
    }

    @Override
    public void draw(GraphicsContext gc) {

    }
}
