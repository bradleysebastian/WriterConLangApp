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
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.ZonedDateTime;
import java.util.ResourceBundle;

import static ConLang.Main.*;

public class FinalizeWordController implements Initializable {
    //LEGEND: BtnP : Button Pressed

    private Stage primaryStage;
    private Parent newScene;

    @FXML
    private TextField spelledGenWord;
    @FXML
    private TextField phoneticGenWord;
    @FXML
    private TextField meaningGenWord;
    @FXML
    private ComboBox<String> assignCombo;

    //TODO Pluralize
    //TODO Conjugate (verb)
    //TODO TBD Word Transformations

    public void assignWordType(ActionEvent assignBtnP) {
        //TODO REMOVE
    }

    public void saveLexiConWord(ActionEvent saveBtnP) throws SQLException, IOException {
        //Set meaning to blank instead of null
        if (meaningGenWord.getText().isEmpty()) {
            meaningGenWord.setText("");
        }
        //Check that word details are set/haven't been removed
        if(spelledGenWord.getText().isEmpty() || phoneticGenWord.getText().isEmpty() || assignCombo.getValue() == null){
            Alert finalWordAlert = new Alert(Alert.AlertType.WARNING);
            finalWordAlert.setTitle("No Word Saved");
            finalWordAlert.setContentText("Please make sure Spelled, Phonetic and Type are populated");
            finalWordAlert.show();
        } else {
            System.out.println("Add Word");
            //DML statement:
            String dmlString = "INSERT INTO " + WORDTBL + " ("
            + SPELLED + "," + PHONETIC + "," + WORDTYPE + "," + MEANING + "," + DATEADDED + ")" +
            "VALUES (?, ?, ?, ?, ?)";
            PreparedStatement prepStmt = DBConnection.dbConnector().prepareStatement(dmlString);
            prepStmt.setString(1, spelledGenWord.getText());
            prepStmt.setString(2, phoneticGenWord.getText());
            prepStmt.setString(3, assignCombo.getValue());
            prepStmt.setString(4, meaningGenWord.getText());
            prepStmt.setString(5, ZonedDateTime.now().toLocalDateTime().toString());
            prepStmt.execute();
            DBConnection.dbConnector().close();
            //Get current Stage
            primaryStage = (Stage)((Button)saveBtnP.getSource()).getScene().getWindow();
            //Load Parent, FXMLLoader for createWord.fxml
            newScene = FXMLLoader.load(getClass().getClassLoader().getResource("ConLang/createWord.fxml"));
            primaryStage.setScene(new Scene(newScene));
            primaryStage.show();
        }
    }

    public void returnGenWordMenu(ActionEvent returnBtnP) throws IOException {
        //Get current Stage
        primaryStage = (Stage)((Button)returnBtnP.getSource()).getScene().getWindow();
        //Load Parent, FXMLLoader for createWord.fxml
        newScene = FXMLLoader.load(getClass().getClassLoader().getResource("ConLang/createWord.fxml"));
        primaryStage.setScene(new Scene(newScene));
        primaryStage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        spelledGenWord.setText(CreateWordController.newGenWord.getSpelling());
        phoneticGenWord.setText(CreateWordController.newGenWord.getPhonetic());
        assignCombo.getItems().addAll("Noun", "Verb", "Adjective", "Pronoun", "Adverb");
    }
}
