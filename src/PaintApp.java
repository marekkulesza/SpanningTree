import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * Expand this FXGUITemplate into your own Paint app. Don't forget to
 * comment according to course commenting standards.
 *
 * @author YOUR NAME
 */
public class PaintApp extends Application {

    // TODO: Instance Variables for View Components and Model
    GraphicsContext gc;
    private ArrayList<Object> objectsArrayList = new ArrayList<>();
    Canvas canvas = new Canvas(800,390);

    //Labels
    Label topLabel;
    Label locationLabel;
    Label colourLabel;
    Label sizeLabel;
    Label errorLabel;

    //TextFields

    //Buttons


    Button cisdoSwitch = new Button("Circle");
    Button nvtSwitch = new Button("Square");
    Button drawButton = new Button("Draw");
    Button undoButton = new Button("Undo");

    ArrayList<Button> switchButtonsSelection = new ArrayList<>();


    /**
     * the set circle method, this is basically to show
     * that the circle draw is on.
     *
     * @param event sets the circle to disabled and square to enable
     */
    private void switchSelection(ActionEvent event) {
        cisdoSwitch.setDisable(true);
        nvtSwitch.setDisable(false);
    }

    /**
     * the set circle method, this is basically to show
     * that the square draw is on.
     *
     * @param event sets the circle to enable and square to disabled
     */
    private void setSquare(ActionEvent event) {
        cisdoSwitch.setDisable(false);
        nvtSwitch.setDisable(true);
    }

    /**
     * undos the last object drawn then redraws the whole canvas-1
     *
     * @param event press the button
     */
    private void undoButtonAction(ActionEvent event) {

        objectsArrayList.remove(objectsArrayList.size()-1);
        gc.setFill(Color.LIGHTBLUE);
        gc.fillRect(0,0,800,450);

        for (Object geo : objectsArrayList) {
            geo.draw(gc);
        }
        undoButton.setDisable(objectsArrayList.isEmpty());
    }
    /**
     * This is where you create your components and the model and add event
     * handlers.
     *
     * @param stage The main stage
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {
        Pane root = new Pane();
        Scene scene = new Scene(root, 800, 450); // set the size here
        stage.setTitle("Painter"); // set the window title here
        stage.setScene(scene);
        // 1. Create the model
        // 2. Create the GUI components
        canvas = new Canvas(800,390);

        //Labels
        topLabel = new Label("Press Draw or Click Canvas for a Circle");
        locationLabel = new Label ("Location: ");
        colourLabel = new Label("Colour: ");
        sizeLabel = new Label("Size: ");
        errorLabel = new Label("No Errors ");

        //Button
        cisdoSwitch = new Button("CisdoSwitch");
        nvtSwitch = new Button("NvtSwitch");
        undoButton = new Button("Undo");
        cisdoSwitch.setDisable(true); //Default to a circle

        //Text


        //ArrayStuff
        switchButtonsSelection.add(cisdoSwitch);
        switchButtonsSelection.add(nvtSwitch);

        // 3. Add components to the root
        root.getChildren().addAll(canvas,topLabel,locationLabel,colourLabel,sizeLabel, cisdoSwitch,
                nvtSwitch,drawButton,undoButton,errorLabel);

        // 4. Configure the components (colors, fonts, size, location)
        gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.LIGHTBLUE);
        gc.fillRect(0,0,800,450);

        //Labels
        topLabel.relocate(300,0);
        topLabel.setTextAlignment(TextAlignment.CENTER);
        locationLabel.relocate(120,400);
        colourLabel.relocate(340,400);

        errorLabel.relocate(400, 430);
        errorLabel.setTextAlignment(TextAlignment.CENTER);

        //Buttons
        cisdoSwitch.relocate(10,400);
        nvtSwitch.relocate(60,400);
        drawButton.relocate(640,400);
        undoButton.relocate(690,400);
        undoButton.setDisable(objectsArrayList.isEmpty());

        //TextFields


        // 5. Add Event Handlers and do final setup
        canvas.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_PRESSED, this::pressHandler);
        cisdoSwitch.setOnAction(this::switchSelection);
        nvtSwitch.setOnAction(this::setSquare);
        undoButton.setOnAction(this::undoButtonAction);

        // 6. Show the stage
        stage.show();
    }

    /**
     * Make no changes here.
     *
     * @param args unused
     */
    public static void main(String[] args) {
        launch(args);
    }
}
