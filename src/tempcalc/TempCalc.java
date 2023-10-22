package tempcalc;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.*;


public class TempCalc extends Application {

    @Override
    public void start(Stage primaryStage) {
        Text convertLabel = new Text("Select option Below");
        RadioButton fToD = new RadioButton("Fahrenheit to Degrees");
        RadioButton dToF = new RadioButton("Degrees to Fahrenheit");
        
        ToggleGroup group = new ToggleGroup();
        fToD.setToggleGroup(group);
        dToF.setToggleGroup(group);
        dToF.setSelected(true);
        
        Text inputLabel = new Text("Enter value below:");
        TextField input = new TextField();
        Text result_lbl= new Text("Result:");
        Text result= new Text();
        result.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR,15));
        Button calculate_btn = new Button ("Calculate");
        calculate_btn.setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent event){
                if(fToD.isSelected()){
                    double value = Double.parseDouble(input.getText());
                    double conversion = (((value-32)*5)/9);
                    result.setText(Double.toString(conversion));
                        
                }
                else{
                  double value = Double.parseDouble(input.getText());
                    double conversion = ((9*value)/5)+32;
                    result.setText(Double.toString(conversion));
                }
            }
        });
        
        
       

        GridPane gridPane = new GridPane();
        gridPane.setMinSize(400, 400);
        gridPane.setVgap(20);
        gridPane.setHgap(5);
        gridPane.setAlignment(Pos.CENTER_LEFT);
        
        gridPane.add(convertLabel, 3, 0);
        gridPane.add(fToD, 3, 1);
        gridPane.add(dToF, 3, 2);
        gridPane.add(inputLabel, 3, 3);
        gridPane.add(input, 3, 4);
        gridPane.add(calculate_btn,5,4);
        gridPane.add(result_lbl, 3, 5);
        gridPane.add(result,3, 6);
        
        
        primaryStage.setTitle("Temperature Converter");
       
        Scene my_scene=new Scene(gridPane); 
       
        primaryStage.setScene(my_scene);        
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}