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

public class CreateSyllableController implements Initializable {
    //LEGEND: BtnP : Button Pressed

    private Stage primaryStage;
    private Parent newScene;
    private Syllable newSyll;
    //SQL Constants
    static final String SYLLTBL = "conSyll";
    static final String ID = "_id";
    static final String SPELLED = "spelled";
    static final String PHONETIC = "phonetic";
    static final String POSITION = "position";
    static final String SYLLTYPE = "syllType";
    static final String MEANING = "meaning";
    static final String DATEADDED = "dateAdded";
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
    @FXML
    private Button cnlBtn;

    public void saveSyllable(ActionEvent saveSyllBtnP) throws SQLException, IOException {
        //DMLString
        if (syllSpell.getText().isEmpty() || syllPhone.getText().isEmpty()){
            showAlert();
        } else {
//            String dmlString = "INSERT INTO " + SYLLTBL + " (" + SPELLED + ", " + PHONETIC + ", " + POSITION + ", "
//                    + SYLLTYPE + ", " + MEANING + ", " + DATEADDED + ") " + "VALUES(?, ?, ?, ?, ?, ?)";
//            PreparedStatement prepStmt = DBConnection.dbConnector().prepareStatement(dmlString);
//            //SPELLED TEXTFIELD
//            prepStmt.setString(1, syllSpell.getText());
//            //PHONETIC TEXTFIELD
//            prepStmt.setString(2, syllPhone.getText());
//            //POSITION COMBO BOX
//            prepStmt.setString(3, position.getValue());
//            //SYLLTYPE COMBO BOX
//            prepStmt.setString(4, syllType.getValue());
//            //MEANING TEXTFIELD
//            prepStmt.setString(5, meaning.getText());
//            //DATEADDED SYSTEM DATETIME
//            prepStmt.setString(6, ZonedDateTime.now().toLocalDateTime().toString());
//            prepStmt.execute();
//            DBConnection.dbConnector().close();
            newSyll = new Syllable(-1, syllSpell.getText(), syllPhone.getText(), position.getValue(),
                    syllType.getValue(), meaning.getText(), ZonedDateTime.now().toLocalDateTime().toString());
            newSyll.createSyllable(newSyll);
            returnCreateWordMenu(saveSyllBtnP);
        }
    }

    public void returnCreateWordMenu(ActionEvent cnlBtnP) throws IOException {
        //Get current Stage
        primaryStage = (Stage)((Button)cnlBtnP.getSource()).getScene().getWindow();
        //Load Parent, FXMLLoader for createWord.fxml
        newScene = FXMLLoader.load(getClass().getClassLoader().getResource("ConLang/createWord.fxml"));
        primaryStage.setScene(new Scene(newScene));
        primaryStage.show();
    }

    public void showAlert(){
        Alert modAlert = new Alert(Alert.AlertType.WARNING);
        modAlert.setTitle("No Syllable create");
        modAlert.setContentText("Some elements are missing or incorrect - please review and try again.");
        modAlert.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        position.getItems().addAll("Any","First","First-Middle","Exact Middle",
                "Last-Middle", "Last");
        position.getSelectionModel().selectFirst();
        syllType.getItems().addAll("Regular", "Prefix", "Suffix",
                "Compound", "Separator");
        syllType.getSelectionModel().selectFirst();
    }
}
