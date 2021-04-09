import javafx.scene.paint.Color;

public abstract class Object implements Drawable{

    String name;
    Double xPosition;
    Double yPosition;
    Color color;

    public Object(String name, Double xPosition, Double yPosition, Color color) {
        this.name = name;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Object{" +
                "name='" + name + '\'' +
                '}';
    }
}
