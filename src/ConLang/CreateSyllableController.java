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
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.ZonedDateTime;
import java.util.ResourceBundle;

public class CreateSyllableController implements Initializable {
    //LEGEND: BtnP : Button Pressed

    private Stage primaryStage;
    private Parent newScene;
    //SQL Constants
    private static final String SYLLTBL = "conSyll";
    private static final String ID = "_id";
    private static final String SPELLED = "spelled";
    private static final String PHONETIC = "phonetic";
    private static final String POSITION = "position";
    private static final String SYLLTYPE = "syllType";
    private static final String MEANING = "meaning";
    private static final String DATEADDED = "dateAdded";
    //FORM Variables
    @FXML
    private TextField syllSpell;
    @FXML
    private TextField syllPhone;
    @FXML
    private TextField meaning;
    @FXML
    private ComboBox<String> position;
    @FXML
    private ComboBox<String> syllType;

    public void saveSyllable(ActionEvent saveSyllBtnP) throws SQLException {
        //TODO save new syllable into ConLang DB
//        PreparedStatement prepStmt = null;
        //DMLString
        String dmlString = "INSERT INTO " + SYLLTBL + " ("
                + SPELLED + ", "
                + PHONETIC + ", "
                + POSITION + ", "
                + SYLLTYPE + ", "
                + MEANING + ", "
                + DATEADDED + ") " +
                "VALUES(?, ?, ?, ?, ?, ?)";
        PreparedStatement prepStmt = DBConnection.dbConnector().prepareStatement(dmlString);
        //SPELLED TEXTFIELD
        System.out.println(syllSpell.getText());
        prepStmt.setString(1, syllSpell.getText());
        //PHONETIC TEXTFIELD
        System.out.println(syllPhone.getText());
        prepStmt.setString(2, syllPhone.getText());
        //POSITION TEXTFIELD??? OR COMBO BOX???
        System.out.println(position.getValue());
        prepStmt.setString(3, position.getValue());
        //SYLLTYPE TEXTFIELD??? OR COMBO BOX???
        System.out.println(syllType.getValue());
        prepStmt.setString(4, syllType.getValue());
        //MEANING TEXTFIELD
        System.out.println(meaning.getText());
        prepStmt.setString(5, meaning.getText());
        //DATEADDED SYSTEM DATETIME
        System.out.println(ZonedDateTime.now().toString());
        prepStmt.setString(6, ZonedDateTime.now().toString());
//        prepStmt.execute();
    }

    public void returnCreateWordMenu(ActionEvent cnlBtnP) throws IOException {
        //Get current Stage
        primaryStage = (Stage)((Button)cnlBtnP.getSource()).getScene().getWindow();
        //Load Parent, FXMLLoader for createWord.fxml
        newScene = FXMLLoader.load(getClass().getClassLoader().getResource("ConLang/createWord.fxml"));
        primaryStage.setScene(new Scene(newScene));
        primaryStage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        position.getItems().addAll("Any","First","First-Middle","Middle",
                "Last-Middle", "Last");
        syllType.getItems().addAll("Regular", "Prefix", "Suffix",
                "Compound", "Separator");
    }
}
