package ConLang;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class CreateWordController {
    //LEGEND: BtnP : Button Pressed

    private Stage primaryStage;
    private Parent newScene;


    public void addSyllMenu(ActionEvent addSyllBtnP) throws IOException {
        //Get current Stage
        primaryStage = (Stage)((Button)addSyllBtnP.getSource()).getScene().getWindow();
        //Load Parent, FXMLLoader for createWord.fxml
        newScene = FXMLLoader.load(getClass().getClassLoader().getResource("ConLang/createSyllable.fxml"));
        primaryStage.setScene(new Scene(newScene));
        primaryStage.show();
    }

    public void generateWord(ActionEvent genWordBtnP) {
        //TODO create word from ConLang DB w/ enetered # syllables
        //TODO shit, need a field for syllables
    }

    public void saveWord(ActionEvent saveWordBtnP) {
        //TODO add word to ConLang DB
    }

    public void returnToMain(ActionEvent cnlBtnP) throws IOException {
        //Get current Stage
        primaryStage = (Stage)((Button)cnlBtnP.getSource()).getScene().getWindow();
        //Load Parent, FXMLLoader for createWord.fxml
        newScene = FXMLLoader.load(getClass().getClassLoader().getResource("ConLang/mainMenu.fxml"));
        primaryStage.setScene(new Scene(newScene));
        primaryStage.show();
    }
}
