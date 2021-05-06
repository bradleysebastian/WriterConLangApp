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

public class AssignWordController implements Initializable {
    //LEGEND: BtnP : Button Pressed

    private Stage primaryStage;
    private Parent newScene;
    private ConWord selectedWord;

    @FXML
    private TextField selConWordTxtF;
    @FXML
    private TextField searchTxtF;


    @FXML
    private TableView<PPTSubject> pptSubjectTableView;
    @FXML
    private TableColumn<PPTSubject, String> pptNameTblCol;
    @FXML
    private TableColumn<PPTSubject, String> pptArchTblCol;
    @FXML
    private TableColumn<PPTSubject, String> pptDescTblCol;

    public void searchPPTSubjects(ActionEvent searchBtnP) throws SQLException {
        //TODO search PPT Subjects
        PPTSubject.populatePPTSubjects(searchTxtF.getText());
    }

    public void assignWord(ActionEvent assignBtnP) throws IOException, SQLException {
        //TODO Assign Word to PPT Subject
        PPTSubject modSubject = pptSubjectTableView.getSelectionModel().getSelectedItem();
        if (modSubject != null) {
            modSubject.setWordID(selectedWord.getId());
            PPTSubject.modifyPPTSubject(modSubject);
            returnLexiConWords(assignBtnP);
        } else {
            showAlert();
        }
    }

    public void returnLexiConWords(ActionEvent returnBtnP) throws IOException {
        //Get current Stage
        primaryStage = (Stage)((Button)returnBtnP.getSource()).getScene().getWindow();
        //Load Parent, FXMLLoader for createWord.fxml
        newScene = FXMLLoader.load(getClass().getClassLoader().getResource("ConLang/lexiConWords.fxml"));
        primaryStage.setScene(new Scene(newScene));
        primaryStage.show();
    }

    public void showAlert(){
        Alert modAlert = new Alert(Alert.AlertType.WARNING);
        modAlert.setTitle("No Subject selected");
        modAlert.setContentText("Please select a Subject and try again.  If there are no Subjects showing, reset search terms" +
                " or add Subjects in the other menu");
        modAlert.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        selectedWord = LexiConWordsController.getSelectedWord();
        selConWordTxtF.setText(selectedWord.getSpelling());
        try {
            PPTSubject.populatePPTSubjects("");
            pptSubjectTableView.setItems(PPTSubject.getPptSubjects());
            pptNameTblCol.setCellValueFactory(new PropertyValueFactory<>("pptName"));
            pptArchTblCol.setCellValueFactory(new PropertyValueFactory<>("archeType"));
            pptDescTblCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
