package ConLang;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ModifySubjectController implements Initializable {
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }
}
