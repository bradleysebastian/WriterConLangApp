package ConLang;

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
import java.util.ResourceBundle;

public class ModifySubjectController implements Initializable {
    //LEGEND: xxxBtnP : Button Pressed

    private Stage primaryStage;
    private Parent newScene;
    private PPTSubject selectedPPTSubject;

    @FXML
    private TextField descTxtF;
    @FXML
    private TextField nameTxtF;
    @FXML
    private ComboBox<String> selectCombo;

    public void selectPPTCombo(ActionEvent selectCombo) {
        //TODO Person, Place, or Thing selector
    }

    public void saveSubject(ActionEvent saveBtnP) throws IOException, SQLException {
        //TODO Save subject to DB
        selectedPPTSubject.setArcheType(selectCombo.getValue());
        selectedPPTSubject.setDescription(descTxtF.getText());
        PPTSubject.modifyPPTSubject(selectedPPTSubject);
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
        selectedPPTSubject = AssignSubjectController.getSelectedPPTSubject();
        selectCombo.getItems().addAll("Person", "Place", "Thing");
        nameTxtF.setText(selectedPPTSubject.getPptName());
        descTxtF.setText(selectedPPTSubject.getDescription());
        selectCombo.setValue(selectedPPTSubject.getArcheType());
    }
}
