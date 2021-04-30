package ConLang;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CreateWordController {
    //LEGEND: BtnP : Button Pressed

    private Stage primaryStage;
    private Parent newScene;

    @FXML
    private TextField numSyll;
    @FXML
    private TextField spelledGenWord;
    @FXML
    private TextField phoneticGenWord;

    public static ConWord newGenWord;

    public static ConWord getNewGenWord() {
        return newGenWord;
    }

    public void addSyllMenu(ActionEvent addSyllBtnP) throws IOException {
        //Get current Stage
        primaryStage = (Stage) ((Button) addSyllBtnP.getSource()).getScene().getWindow();
        //Load Parent, FXMLLoader for createWord.fxml
        newScene = FXMLLoader.load(getClass().getClassLoader().getResource("ConLang/createSyllable.fxml"));
        primaryStage.setScene(new Scene(newScene));
        primaryStage.show();
    }

    public void saveWord(ActionEvent saveWordBtnP) throws IOException {
        //TODO take word into Finalize Word screen
        if (!spelledGenWord.getText().isEmpty()) {
            //Get current Stage
            primaryStage = (Stage) ((Button) saveWordBtnP.getSource()).getScene().getWindow();
            //Load Parent, FXMLLoader for createWord.fxml
            newScene = FXMLLoader.load(getClass().getClassLoader().getResource("ConLang/finalizeWord.fxml"));
            primaryStage.setScene(new Scene(newScene));
            primaryStage.show();
        } else {
            Alert genWordAlert = new Alert(Alert.AlertType.WARNING);
            genWordAlert.setTitle("No Word Generated Yet");
            genWordAlert.setContentText("Please enter number of desired syllables and click Generate Word");
            genWordAlert.show();
        }
    }

    public void returnToMain(ActionEvent cnlBtnP) throws IOException {
        //Get current Stage
        primaryStage = (Stage) ((Button) cnlBtnP.getSource()).getScene().getWindow();
        //Load Parent, FXMLLoader for createWord.fxml
        newScene = FXMLLoader.load(getClass().getClassLoader().getResource("ConLang/mainMenu.fxml"));
        primaryStage.setScene(new Scene(newScene));
        primaryStage.show();
    }

    public void constructWord(ActionEvent menuBtnP) throws SQLException {
        String currSyll = "";
        String followSyll = "";
        boolean selfFlag = false;
        //# of Syllables from form (ENSURE INT ENTERED!!!)
        int syllCount = 0;
        try {
            syllCount = Integer.parseInt(numSyll.getText());
        } catch (NumberFormatException nfe) {
            Alert genWordAlert = new Alert(Alert.AlertType.WARNING);
            genWordAlert.setTitle("There was a problem with number of syllables");
            genWordAlert.setContentText("Please enter a whole number");
            genWordAlert.show();
        }
        //ConWord object has Syllable List object and method to load it
        newGenWord = new ConWord();
        //Syllables counted - logic looped thru for each syllable, added to ConWord's Syllable List
        for (int i = 1; i <= syllCount; i++) {
            if (i == 1) {//First, First-Middle, Any
                newGenWord.getSyllable("First", "First-Middle", "Any", followSyll, currSyll); //TODO Add currSyll as argument to getSyllable
            } else if (i == syllCount && i > 1) {//Last, Last-Middle, Any
                newGenWord.getSyllable("Last", "Last-Middle", "Any", followSyll, currSyll);
            } else if (i != 1 && i <= (syllCount / 2)) {//First-Middle, Middle, Any
                newGenWord.getSyllable("Middle", "First-Middle", "Any", followSyll, currSyll);
            } else if ((Math.abs(1 - i)) == (syllCount - i)) {//Exact Middle
                newGenWord.getSyllable("", "Exact-Middle", "", followSyll, currSyll);
            } else if (i != syllCount && i > (syllCount / 2)) {//Last-Middle, Middle, Any
                newGenWord.getSyllable("Middle", "Last-Middle", "Any", followSyll, currSyll);
            } else {//Middle, Any
                newGenWord.getSyllable("", "Middle", "Any", followSyll, currSyll);
            }
            //TODO - Set currentSyllable
            currSyll = "";
            if (newGenWord.getSyllList().get(i - 1).isSelfFlag() == true) {
                currSyll = newGenWord.getSyllList().get(i - 1).getSpelling();
            }
            //TODO - Check selfFlag
            //TODO - If selfFlag: False, feeds currentSyllable into method (populates WHERE spelling NOT LIKE "")
            //TODO - Set followSyll value
            //TODO - followSyll value feeds [something] into method (populates WHERE followSyll LIKE "")
        }
        //ConWord set from its Syllable list - getters display to form
        newGenWord.setSpelling(newGenWord.getSyllList());
        newGenWord.setPhonetic(newGenWord.getSyllList());
        DBConnection.dbConnector().close();
        spelledGenWord.setText(newGenWord.getSpelling());
        phoneticGenWord.setText(newGenWord.getPhonetic());
    }

    public int totalSyllCount() throws SQLException {
        //Ensure # of syllables entered doesn't exceed # of syllables in DB
        int totalSyllables = 0;
        String dmlString = "SELECT COUNT(_id) FROM " + Main.SYLLTBL + ";";
        PreparedStatement prepStmt = DBConnection.dbConnector().prepareStatement(dmlString);
        prepStmt.execute();
        ResultSet sqlResults = prepStmt.getResultSet();
        while (sqlResults.next()) {
            totalSyllables = sqlResults.getInt(1);
            System.out.println(totalSyllables);
        }
//        if (syllCount <= totalSyllables) {
//        } else {
//            System.out.println("Too large of number foir syllables");
//            //TODO Hard stop
//        }
        return totalSyllables;
    }
}
