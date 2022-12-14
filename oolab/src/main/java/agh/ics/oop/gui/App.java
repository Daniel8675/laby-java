package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;



public class App extends javafx.application.Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        String[] args = getParameters().getRaw().toArray(new String[0]);
        AbstractWorldMap map = new GrassField(20);
        MoveDirection[] direction = OptionsParser.parse(args);
        Vector2d[] position = { new Vector2d(0,0), new Vector2d(4,4) };
        SimulationEngine engine = new SimulationEngine(direction, map, position);
        engine.run();

        GridPane gridPane = new GridPane();
        gridPane.setGridLinesVisible(true);
        gridPane.setPadding(new Insets(20, 20, 20, 20));

        drawMap(map, gridPane);
        drawObjects(map, gridPane);

        System.out.println(map);

        Scene scene = new Scene(gridPane, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    void drawMap(AbstractWorldMap map, GridPane gridPane){
        final int sideOfSquare = 40;

        Label label = new Label("y/x");
        gridPane.add(label, 0, 0);
        gridPane.getColumnConstraints().add(new ColumnConstraints(sideOfSquare));
        gridPane.getRowConstraints().add(new RowConstraints(sideOfSquare));
        GridPane.setHalignment(label, HPos.CENTER);

        for(int i = map.calculateLowerBound().x; i <= map.calculateUpperBound().x; i++ ){
            label = new Label(String.format("%d", i));
            gridPane.add(label, i - map.calculateLowerBound().x + 1, 0);
            gridPane.getColumnConstraints().add(new ColumnConstraints(sideOfSquare));
            GridPane.setHalignment(label, HPos.CENTER);
        }

        for(int i = map.calculateLowerBound().y; i <= map.calculateUpperBound().y; i++ ){
            label = new Label(String.format("%d", i));
            gridPane.add(label, 0,  map.calculateUpperBound().y - i + 1);
            gridPane.getRowConstraints().add(new RowConstraints(sideOfSquare));
            GridPane.setHalignment(label, HPos.CENTER);
        }
    }

    void drawObjects(AbstractWorldMap map, GridPane gridPane) {
        for (int i = map.calculateLowerBound().x; i <= map.calculateUpperBound().x; i++) {
            for (int j = map.calculateUpperBound().y; j >= map.calculateLowerBound().y; j--) {
                Object toAdd = map.objectAt(new Vector2d(i, j));
                if (toAdd == null) {
                    continue;
                }
                Label label = new Label(toAdd.toString());
                gridPane.add(label, i + 1, map.calculateUpperBound().y - j + 1);
                GridPane.setHalignment(label, HPos.CENTER);
            }
        }
    }
}
