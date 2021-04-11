package ConLang;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class ModifySubjectController {
    //LEGEND: xxxBtnP : Button Pressed

    private Stage primaryStage;
    private Parent newScene;

    public void selectPPTCombo(ActionEvent selectCombo) {
        //TODO Person, Place, or Thing selector
    }

    public void saveSubject(ActionEvent saveBtnP) {
        //TODO Save subject to DB
    }

    public void returnAssignSubjectMenu(ActionEvent cancelBtnP) throws IOException {
        //Get current Stage
        primaryStage = (Stage)((Button)cancelBtnP.getSource()).getScene().getWindow();
        //Load Parent, FXMLLoader for createWord.fxml
        newScene = FXMLLoader.load(getClass().getClassLoader().getResource("ConLang/assignSubject.fxml"));
        primaryStage.setScene(new Scene(newScene));
        primaryStage.show();
    }
}
