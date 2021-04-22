package ConLang;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AssignSubjectController implements Initializable {
    //LEGEND: BtnP : Button Pressed

    private Stage primaryStage;
    private Parent newScene;

    @FXML
    private TableView<PPTSubject> pptSubjectTblVw;
    @FXML
    private TableColumn<String, PPTSubject> pptSubjName;
    @FXML
    private TableColumn<String, PPTSubject> archeType;

    public void createPPT(ActionEvent createBtnP) throws IOException {
        //Get current Stage
        primaryStage = (Stage)((Button)createBtnP.getSource()).getScene().getWindow();
        //Load Parent, FXMLLoader for createWord.fxml
        newScene = FXMLLoader.load(getClass().getClassLoader().getResource("ConLang/createSubject.fxml"));
        primaryStage.setScene(new Scene(newScene));
        primaryStage.show();
    }

    public void searchPPT(ActionEvent searchBtnP) {
        //TODO search PPT Subject
    }

    public void modifyPPT(ActionEvent modifyBtnP) {
        //TODO modify PPT Subject
    }

    public void assignPPT(ActionEvent assignBtnP) {
        //TODO assign ConWord to PPT Subject
    }

    public void deletePPT(ActionEvent deleteBtnP) {
        //TODO delete PPT Subject
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

    }
}
