package ConLang;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class AssignSubjectController {
    //LEGEND: BtnP : Button Pressed

    private Stage primaryStage;
    private Parent newScene;

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
}
