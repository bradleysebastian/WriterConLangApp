package ConLang;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class AssignSubjectActualController {
    //LEGEND: BtnP : Button Pressed

    private Stage primaryStage;
    private Parent newScene;

    public void searchLexiConWords(ActionEvent searchBtnP) {
        //TODO search LexiConWords
    }

    public void assignLexiConWord(ActionEvent assignBtnP) {
        //TODO Assign LexiConWord to PPT Subject
    }

    public void returnAssignFirst(ActionEvent returnBtnP) throws IOException {
        //Get current Stage
        primaryStage = (Stage)((Button)returnBtnP.getSource()).getScene().getWindow();
        //Load Parent, FXMLLoader for createWord.fxml
        newScene = FXMLLoader.load(getClass().getClassLoader().getResource("ConLang/assignSubject.fxml"));
        primaryStage.setScene(new Scene(newScene));
        primaryStage.show();
    }
}
