package ConLang;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class CreateSubjectController {
    //LEGEND: BtnP : Button Pressed

    private Stage primaryStage;
    private Parent newScene;

    public void selectPPT(ActionEvent selectCombo) {
        //TODO Combo selector for Person, Place, or Thing
    }

    public void savePPT(ActionEvent saveBtnP) {
        //TODO Save Subject entry into DB
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
