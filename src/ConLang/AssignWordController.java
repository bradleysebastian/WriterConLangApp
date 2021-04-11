package ConLang;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class AssignWordController {
    //LEGEND: BtnP : Button Pressed

    private Stage primaryStage;
    private Parent newScene;

    public void searchPPTSubjects(ActionEvent searchBtnP) {
        //TODO search PPT Subjects
        //TODO Show ListView
    }

    public void assignWord(ActionEvent assignBtnP) {
        //TODO Assign Word to PPT Subject
    }

    public void returnLexiConWords(ActionEvent returnBtnP) throws IOException {
        //Get current Stage
        primaryStage = (Stage)((Button)returnBtnP.getSource()).getScene().getWindow();
        //Load Parent, FXMLLoader for createWord.fxml
        newScene = FXMLLoader.load(getClass().getClassLoader().getResource("ConLang/lexiConWords.fxml"));
        primaryStage.setScene(new Scene(newScene));
        primaryStage.show();
    }
}
