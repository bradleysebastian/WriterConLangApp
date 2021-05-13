package ConLang;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AssignSubjectActualController implements Initializable {
    //LEGEND: BtnP : Button Pressed

    private Stage primaryStage;
    private Parent newScene;
    private PPTSubject selectedPPTSubject;

    @FXML
    private TextField pptDescTxtF;
    @FXML
    private TextField pptArchTxtF;
    @FXML
    private TextField searchTxtF;
    @FXML
    private TableView<ConWord> conWordTblVw;
    @FXML
    private TableColumn<ConWord, String> spellTblCol;
    @FXML
    private TableColumn<ConWord, String> phoneTblCol;
    @FXML
    private TableColumn<ConWord, String> typeTblCol;
    @FXML
    private TableColumn<ConWord, String> defTblCol;

    public void searchLexiConWords() {
        //TODO search LexiConWords
        ConWord.populateLexiConWords(searchTxtF.getText());
    }

    public void assignLexiConWord(ActionEvent assignBtnP) throws IOException {
        //TODO Assign LexiConWord to PPT Subject
        if (conWordTblVw.getSelectionModel().getSelectedItem() != null){
            selectedPPTSubject.setWordID(conWordTblVw.getSelectionModel().getSelectedItem().getId());
            PPTSubject.modifyPPTSubject(selectedPPTSubject);
            returnAssignFirst(assignBtnP);
        }
        else {
            showAlert();
        }

    }

    public void returnAssignFirst(ActionEvent returnBtnP) throws IOException {
        //Get current Stage
        primaryStage = (Stage)((Button)returnBtnP.getSource()).getScene().getWindow();
        //Load Parent, FXMLLoader for createWord.fxml
        newScene = FXMLLoader.load(getClass().getClassLoader().getResource("ConLang/assignSubject.fxml"));
        primaryStage.setScene(new Scene(newScene));
        primaryStage.show();
    }

    public void showAlert(){
        Alert modAlert = new Alert(Alert.AlertType.WARNING);
        modAlert.setTitle("No LexiConWord selected");
        modAlert.setContentText("Please select a LexiConWord and try again.  If there are no LexiConWords showing, reset search terms" +
                " or add LexiConWords in the other menu");
        modAlert.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        selectedPPTSubject = AssignSubjectController.getSelectedPPTSubject();
        pptDescTxtF.setText(selectedPPTSubject.getDescription());
        pptArchTxtF.setText(selectedPPTSubject.getArcheType());
            ConWord.populateLexiConWords("");
            conWordTblVw.setItems(ConWord.getLexiConWords());
            spellTblCol.setCellValueFactory(new PropertyValueFactory<>("spelling"));
            phoneTblCol.setCellValueFactory(new PropertyValueFactory<>("phonetic"));
            typeTblCol.setCellValueFactory(new PropertyValueFactory<>("wordType"));
            defTblCol.setCellValueFactory(new PropertyValueFactory<>("meaning"));
    }
}
