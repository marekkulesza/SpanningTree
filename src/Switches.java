import javafx.scene.paint.Color;

public abstract class Switches extends ComputerObjects {

    public Switches(String name, Double xPosition, Double yPosition, Color color) {
        super(name, xPosition, yPosition, color);
    }

    @Override
    public String toString() {
        return "Switches{" +
                "name='" + name + '\'' +
                ", xPosition=" + xPosition +
                ", yPosition=" + yPosition +
                ", color=" + color +
                "} " + super.toString();
    }

}
