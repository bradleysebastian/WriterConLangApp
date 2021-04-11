package ConLang;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class LexiConWordsController {
    //LEGEND: BtnP : Button Pressed

    private Stage primaryStage;
    private Parent newScene;
    public void searchWords(ActionEvent actionEvent) {
    }

    public void modifyWord(ActionEvent actionEvent) {
    }

    public void assignWord(ActionEvent actionEvent) {
    }

    public void deleteWord(ActionEvent actionEvent) {
    }

    public void returnMainMenu(ActionEvent backBtnP) throws IOException {
        //Get current Stage
        primaryStage = (Stage)((Button)backBtnP.getSource()).getScene().getWindow();
        //Load Parent, FXMLLoader for createWord.fxml
        newScene = FXMLLoader.load(getClass().getClassLoader().getResource("ConLang/mainMenu.fxml"));
        primaryStage.setScene(new Scene(newScene));
        primaryStage.show();
    }
}
