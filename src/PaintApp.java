import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
    private ArrayList<ComputerObjects> objectsArrayList = new ArrayList<>();
    Canvas canvas = new Canvas(800,390);

    //Labels
    Label topLabel;
    Label locationLabel;
    Label colourLabel;
    Label sizeLabel;
    Label errorLabel;

    //TextFields

    //Buttons


    Button cisdoSwitchButton = new Button("Circle");
    Button nvtSwitchButton = new Button("Square");
    Button drawButton = new Button("Draw");
    Button undoButton = new Button("Undo");

    ObservableList<Button> switchButtonsSelection = FXCollections.observableArrayList();


    private void switchSelection(ActionEvent event) {
        Object pressed = event.getSource();
        for (Button button: switchButtonsSelection) {
            button.setDisable(false);
        }

        for (Button button : switchButtonsSelection) {
            if (pressed == button){
                button.setDisable(true);
            }
        }
    }

    private void pressHandler(javafx.scene.input.MouseEvent me){

        if (cisdoSwitchButton.isDisable()) {
            CisdoSwitch ciscdoSwitch = new CisdoSwitch("CisdoSwitch",me.getX(),me.getY()+20,Color.BLACK);
            ciscdoSwitch.draw(gc);
            objectsArrayList.add(ciscdoSwitch);
            undoButton.setDisable(objectsArrayList.isEmpty());
        }

        if (nvtSwitchButton.isDisable()) {
            NvtPhybridgeSwitch nvtSwitch = new NvtPhybridgeSwitch("PoLRE",me.getX(),me.getY()+20,Color.BLACK);
            nvtSwitch.draw(gc);
            objectsArrayList.add(nvtSwitch);
            undoButton.setDisable(objectsArrayList.isEmpty());
        }

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

        for (ComputerObjects geo : objectsArrayList) {
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
        errorLabel = new Label("No Errors ");

        //Button
        cisdoSwitchButton = new Button("CisdoSwitch");
        nvtSwitchButton = new Button("NvtSwitch");
        undoButton = new Button("Undo");

        //Text


        //ArrayStuff
        switchButtonsSelection.add(cisdoSwitchButton);
        switchButtonsSelection.add(nvtSwitchButton);

        // 3. Add components to the root
        root.getChildren().addAll(canvas,topLabel,
                cisdoSwitchButton, nvtSwitchButton,
                drawButton,undoButton,errorLabel);

        // 4. Configure the components (colors, fonts, size, location)
        gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.LIGHTBLUE);
        gc.fillRect(0,0,800,450);

        //Labels
        topLabel.relocate(300,0);
        topLabel.setTextAlignment(TextAlignment.CENTER);
        errorLabel.relocate(400, 430);
        errorLabel.setTextAlignment(TextAlignment.CENTER);

        //Buttons
        cisdoSwitchButton.relocate(10,400);
        nvtSwitchButton.relocate(100,400);
        drawButton.relocate(640,400);
        undoButton.relocate(690,400);
        undoButton.setDisable(objectsArrayList.isEmpty());

        //TextFields


        // 5. Add Event Handlers and do final setup
        canvas.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_PRESSED, this::pressHandler);

        for (Button button: switchButtonsSelection) {
            button.setOnAction(this::switchSelection);
        }


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
