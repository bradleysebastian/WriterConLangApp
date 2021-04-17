package ConLang;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.ZonedDateTime;
import java.util.ResourceBundle;

public class ModifyWordController implements Initializable {
    //LEGEND: BtnP : Button Pressed

    private Stage primaryStage;
    private Parent newScene;

    @FXML
    private TextField spelledTxtF;
    @FXML
    private TextField phoneticTxtF;
    @FXML
    private TextField meaningTxtF;
    @FXML
    private ComboBox<String> assignCombo;


    public void assignLexiConWord(ActionEvent assignBtnP) {
        //TODO REMOVE?
    }

    public void saveLexiConWord(ActionEvent saveBtnP) throws SQLException, IOException {
        //Set meaning to blank instead of null
        if (meaningTxtF.getText().isEmpty()) {
            meaningTxtF.setText("");
        }
        //Check that word details are set/haven't been removed
        if(spelledTxtF.getText().isEmpty() || phoneticTxtF.getText().isEmpty() || assignCombo.getValue() == null){
            Alert finalWordAlert = new Alert(Alert.AlertType.WARNING);
            finalWordAlert.setTitle("No Word Saved");
            finalWordAlert.setContentText("Please make sure Spelled, Phonetic and Type are populated");
            finalWordAlert.show();
        } else {
            //TODO get Word's ID
            ConWord selectedWord = LexiConWordsController.getSelectedWord();
            ConWord finalConWord = new ConWord(selectedWord.getId(), spelledTxtF.getText(), phoneticTxtF.getText(), assignCombo.getValue(), meaningTxtF.getText(), ZonedDateTime.now().toString());
            finalConWord.changeLexiConWord(finalConWord);
            //Get current Stage
            primaryStage = (Stage)((Button)saveBtnP.getSource()).getScene().getWindow();
            //Load Parent, FXMLLoader for createWord.fxml
            newScene = FXMLLoader.load(getClass().getClassLoader().getResource("ConLang/lexiConWords.fxml"));
            primaryStage.setScene(new Scene(newScene));
            primaryStage.show();
        }
    }

    public void returnGenWordMenu(ActionEvent returnBtnP) throws IOException {
        //Get current Stage
        primaryStage = (Stage)((Button)returnBtnP.getSource()).getScene().getWindow();
        //Load Parent, FXMLLoader for createWord.fxml
        newScene = FXMLLoader.load(getClass().getClassLoader().getResource("ConLang/lexiConWords.fxml"));
        primaryStage.setScene(new Scene(newScene));
        primaryStage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ConWord selectedWord = LexiConWordsController.getSelectedWord();
        spelledTxtF.setText(selectedWord.getSpelling());
        phoneticTxtF.setText(selectedWord.getPhonetic());
        meaningTxtF.setText(selectedWord.getMeaning());

        assignCombo.getItems().addAll("Noun", "Verb", "Adjective", "Pronoun", "Adverb");
        assignCombo.setValue(selectedWord.getWordType());
    }
}
