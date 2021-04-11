package ConLang;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class FinalizeWordController {
    //LEGEND: BtnP : Button Pressed

    private Stage primaryStage;
    private Parent newScene;

    public void assignSubject(ActionEvent assignBtnP) {
        //TODO Dropdown for all Subjects
    }

    public void saveLexiConWord(ActionEvent saveBtnP) {
        //TODO Save LexiConWord to DB
    }

    public void returnGenWordMenu(ActionEvent returnBtnP) throws IOException {
        //Get current Stage
        primaryStage = (Stage)((Button)returnBtnP.getSource()).getScene().getWindow();
        //Load Parent, FXMLLoader for createWord.fxml
        newScene = FXMLLoader.load(getClass().getClassLoader().getResource("ConLang/createWord.fxml"));
        primaryStage.setScene(new Scene(newScene));
        primaryStage.show();
    }
}
