package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{
    @FXML
    private Polygon upButton, downButton;

    @FXML
    private Text clockText;

    @FXML
    private Label monthLabel;
    @FXML
    private Label dayLabel;
    @FXML
    private Label yearLabel;
    @FXML
    private Label hourLabel;
    @FXML
    private Label minuteLabel;

    Clock mainClock = new Clock();
    int selection = 0;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        /*clockText.setText(mainClock.toString());*/
        updateScreen();
        upButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                increaseSelection();
            }
        });

        downButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                decreaseSelection();
            }
        });
    }

    public void increaseSelection(){
        if (selection == 1){// increase months
            mainClock.updateClockObject(mainClock.getYear(), mainClock.getMonthCounter() +1
                    , mainClock.getDay(), mainClock.getHours(), mainClock.getMinutes());
        }else if(selection == 2){// increase day
            mainClock.updateClockObject(mainClock.getYear(), mainClock.getMonthCounter()
                    , mainClock.getDay()+1, mainClock.getHours(), mainClock.getMinutes());
        }else if(selection == 3){ // increase year
            mainClock.updateClockObject(mainClock.getYear()+ 1, mainClock.getMonthCounter()
                    , mainClock.getDay(), mainClock.getHours(), mainClock.getMinutes());
        }else if(selection == 4){// increase hour
            mainClock.updateClockObject(mainClock.getYear(), mainClock.getMonthCounter()
                    , mainClock.getDay(), mainClock.getHours()+1, mainClock.getMinutes());
        }else if(selection == 5){// increase minutes
            mainClock.updateClockObject(mainClock.getYear(), mainClock.getMonthCounter()
                    , mainClock.getDay(), mainClock.getHours(), mainClock.getMinutes()+1);
        }
        showSelection();
        updateScreen();
    }

    public void decreaseSelection(){
        if (selection == 1){// decrease months
            mainClock.updateClockObject(mainClock.getYear(), mainClock.getMonthCounter()- 1
                    , mainClock.getDay(), mainClock.getHours(), mainClock.getMinutes());
        }else if(selection == 2){// decrease day
            mainClock.updateClockObject(mainClock.getYear(), mainClock.getMonthCounter()
                    , mainClock.getDay()-1, mainClock.getHours(), mainClock.getMinutes());
        }else if(selection == 3){ // decrease year
            mainClock.updateClockObject(mainClock.getYear()- 1, mainClock.getMonthCounter()
                    , mainClock.getDay(), mainClock.getHours(), mainClock.getMinutes());
        }else if(selection == 4){// decrease hour
            mainClock.updateClockObject(mainClock.getYear(), mainClock.getMonthCounter()
                    , mainClock.getDay(), mainClock.getHours()- 1, mainClock.getMinutes());
        }else if(selection == 5){// decrease minutes
            mainClock.updateClockObject(mainClock.getYear(), mainClock.getMonthCounter()
                    , mainClock.getDay(), mainClock.getHours(), mainClock.getMinutes()+1);
        }
        showSelection();
        updateScreen();
    }

    public void selectEdit(){

        if(selection >= 1 && selection <= 5){
            selection++;

        }else{
            selection = 1;
        }
        showSelection();
    }

    public void doneEditing(){
        selection = 0;
        showSelection();
    }

    public void updateScreen(){
        monthLabel.setText(mainClock.getMonth());
        dayLabel.setText(String.format("%02d", mainClock.getDay()));
        yearLabel.setText(String.format("%02d", mainClock.getYear()));
        hourLabel.setText(String.format("%02d", mainClock.getHours()));
        minuteLabel.setText(String.format("%02d", mainClock.getMinutes()));
        showSelection();
    }

    public void showSelection(){
        monthLabel.setTextFill(Color.web("#000"));
        dayLabel.setTextFill(Color.web("#000"));
        yearLabel.setTextFill(Color.web("#000"));
        hourLabel.setTextFill(Color.web("#000"));
        minuteLabel.setTextFill(Color.web("#000"));

        if(selection == 1) {
            monthLabel.setTextFill(Color.RED);
        }else if(selection == 2){
            dayLabel.setTextFill(Color.RED);
        }else if(selection == 3){
            yearLabel.setTextFill(Color.RED);
        }else if(selection == 4){
            hourLabel.setTextFill(Color.RED);
        }else if(selection == 5){
            minuteLabel.setTextFill(Color.RED);
        }
    }
}
