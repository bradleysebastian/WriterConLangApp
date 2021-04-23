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

public class AssignSubjectController implements Initializable {
    //LEGEND: BtnP : Button Pressed

    private Stage primaryStage;
    private Parent newScene;
    private PPTSubject selectedPPTSubject;

    @FXML
    private TextField searchTxtF;

    @FXML
    private TableView<PPTSubject> pptSubjectTblVw;
    @FXML
    private TableColumn<PPTSubject, String> pptNameTblCol;
    @FXML
    private TableColumn<PPTSubject, String> archeTypeTblCol;
    @FXML
    private TableColumn<PPTSubject, String> descTblCol;

    public PPTSubject getSelectedPPTSubject() {
        return selectedPPTSubject;
    }

    public void createPPT(ActionEvent createBtnP) throws IOException {
        //Get current Stage
        primaryStage = (Stage)((Button)createBtnP.getSource()).getScene().getWindow();
        //Load Parent, FXMLLoader for createWord.fxml
        newScene = FXMLLoader.load(getClass().getClassLoader().getResource("ConLang/createSubject.fxml"));
        primaryStage.setScene(new Scene(newScene));
        primaryStage.show();
    }

    public void searchPPT() throws SQLException {
        PPTSubject.populatePPTSubjects(searchTxtF.getText());
    }

    public void modifyPPT(ActionEvent modifyBtnP) throws IOException {
        //TODO modify PPT Subject
        selectedPPTSubject = pptSubjectTblVw.getSelectionModel().getSelectedItem();
        if (selectedPPTSubject != null){
            //Get current Stage
            primaryStage = (Stage)((Button)modifyBtnP.getSource()).getScene().getWindow();
            //Load Parent, FXMLLoader for createWord.fxml
            newScene = FXMLLoader.load(getClass().getClassLoader().getResource("ConLang/modifySubject.fxml"));
            primaryStage.setScene(new Scene(newScene));
            primaryStage.show();
        } else {
            showAlert();
        }
    }

    public void assignPPT(ActionEvent assignBtnP) throws IOException {
        //TODO assign ConWord to PPT Subject
        selectedPPTSubject = pptSubjectTblVw.getSelectionModel().getSelectedItem();
        if (selectedPPTSubject != null){
            //Get current Stage
            primaryStage = (Stage)((Button)assignBtnP.getSource()).getScene().getWindow();
            //Load Parent, FXMLLoader for createWord.fxml
            newScene = FXMLLoader.load(getClass().getClassLoader().getResource("ConLang/assignSubjectActual.fxml"));
            primaryStage.setScene(new Scene(newScene));
            primaryStage.show();
        } else {
            showAlert();
        }
    }

    public void deletePPT(ActionEvent deleteBtnP) throws SQLException {
        //TODO delete PPT Subject
        selectedPPTSubject = pptSubjectTblVw.getSelectionModel().getSelectedItem();
        if (selectedPPTSubject != null){
            PPTSubject.deletePPTSubject(selectedPPTSubject);
            searchPPT();
        } else {
            showAlert();
        }
    }

    public void showAlert(){
        Alert modAlert = new Alert(Alert.AlertType.WARNING);
        modAlert.setTitle("No subject selected");
        modAlert.setContentText("Please select a subject and try again.  If there are no subjects showing, reset search terms" +
                " or add subjects in the other menu");
        modAlert.show();
    }

    public void returnMainMenu(ActionEvent returnBtnP) throws IOException {
        //Get current Stage
        primaryStage = (Stage)((Button)returnBtnP.getSource()).getScene().getWindow();
        //Load Parent, FXMLLoader for createWord.fxml
        newScene = FXMLLoader.load(getClass().getClassLoader().getResource("ConLang/mainMenu.fxml"));
        primaryStage.setScene(new Scene(newScene));
        primaryStage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            PPTSubject.populatePPTSubjects("");
            pptSubjectTblVw.setItems(PPTSubject.getPptSubjects());
            pptNameTblCol.setCellValueFactory(new PropertyValueFactory<>("pptName"));
            archeTypeTblCol.setCellValueFactory(new PropertyValueFactory<>("archeType"));
            descTblCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }


    }
}
