package ConLang;

import javafx.css.PseudoClass;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.ZonedDateTime;
import java.util.ResourceBundle;

public class CreateSubjectController implements Initializable {
    //LEGEND: BtnP : Button Pressed

    private Stage primaryStage;
    private Parent newScene;

    @FXML
    private TextField pptDescTxtF;
    @FXML
    private ComboBox<String> pptCombo;
    @FXML
    private TextField tbdTextF;


    public void selectPPT(ActionEvent selectCombo) {
        //TODO Combo selector for Person, Place, or Thing
    }

    public void savePPT(ActionEvent saveBtnP) throws IOException {
        //TODO Save Subject entry into DB
        PPTSubject newSubject = new PPTSubject();
        newSubject.setArcheType(pptCombo.getValue());
        newSubject.setDescription(pptDescTxtF.getText());
        newSubject.setDateAdded(ZonedDateTime.now().toString());
        //TODO tie in PPTSubject storeSubject method
        newSubject.storePPTSubject(newSubject);
        //Get current Stage
        primaryStage = (Stage)((Button)saveBtnP.getSource()).getScene().getWindow();
        //Load Parent, FXMLLoader for createWord.fxml
        newScene = FXMLLoader.load(getClass().getClassLoader().getResource("ConLang/assignSubject.fxml"));
        primaryStage.setScene(new Scene(newScene));
        primaryStage.show();
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
        pptCombo.getItems().addAll("Person", "Place", "Thing");
        pptCombo.getSelectionModel().selectFirst();
//        pptDescTxtF.requestFocus();
    }
}
