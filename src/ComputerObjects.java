import javafx.scene.paint.Color;

public abstract class ComputerObjects implements Drawable{

    String name;
    Double xPosition;
    Double yPosition;
    Color color;

    public ComputerObjects(String name, Double xPosition, Double yPosition, Color color) {
        this.name = name;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.color = color;
    }

    public Double getxPosition() {
        return xPosition;
    }

    public Double getyPosition() {
        return yPosition;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Object{" +
                "name='" + name + '\'' +
                '}';
    }
}
