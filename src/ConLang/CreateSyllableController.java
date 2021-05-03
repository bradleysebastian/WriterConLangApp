package ConLang;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
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
    private boolean sVowelFlag = false;
    private Syllable.FollowSyll fSyllType;
    private char[] vowelList = {'a', 'e', 'i', 'o', 'u', 'y'};
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
    private ComboBox<String> fSyll;
    @FXML
    private CheckBox selfFlagChkBx;

    public void saveSyllable(ActionEvent saveSyllBtnP) throws SQLException, IOException {
        //DMLString
        if (syllSpell.getText().isEmpty() || syllPhone.getText().isEmpty()){
            showAlert();
        } else {
            String spelling = syllSpell.getText();
            for (int i = 0; i < vowelList.length; i++){ //loop thru vowel char array, checking 1st char in entered syll
                if (spelling.charAt(0) == vowelList[i]) {
                    sVowelFlag = true; //sVowelFlag already set to false
                }
            } //Switch to set Syllable's ENUM
            switch (fSyll.getValue()) {
                case "Any":
                    fSyllType = Syllable.FollowSyll.Any;
                    break;
                case "Vowel":
                    fSyllType = Syllable.FollowSyll.Vowel;
                    break;
                case "Consonant":
                    fSyllType = Syllable.FollowSyll.Consonant;
                    break;
            }
            newSyll = new Syllable(-1, syllSpell.getText(), syllPhone.getText(), position.getValue(),
                    syllType.getValue(), meaning.getText(), ZonedDateTime.now().toLocalDateTime().toString(),
                    sVowelFlag, selfFlagChkBx.isSelected(), fSyllType);
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
        position.getItems().addAll("Any","First","First-Middle",
                "Last-Middle", "Last"); //REMOVED: "Exact Middle",
        position.getSelectionModel().selectFirst();
        syllType.getItems().addAll("Regular", "Prefix", "Suffix",
                "Compound", "Separator");
        syllType.getSelectionModel().selectFirst();
        fSyll.getItems().addAll( "Any", "Vowel", "Consonant");
        fSyll.getSelectionModel().selectFirst();
    }
}
