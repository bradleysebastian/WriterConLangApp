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



    public void addSyllMenu(ActionEvent addSyllBtnP) throws IOException {
        //Get current Stage
        primaryStage = (Stage)((Button)addSyllBtnP.getSource()).getScene().getWindow();
        //Load Parent, FXMLLoader for createWord.fxml
        newScene = FXMLLoader.load(getClass().getClassLoader().getResource("ConLang/createSyllable.fxml"));
        primaryStage.setScene(new Scene(newScene));
        primaryStage.show();
    }

    public void generateWord(ActionEvent genWordBtnP) throws SQLException {
        //TODO create word from ConLang DB w/ entered # syllables
        //# of Syllables from form
        int syllCount = 0;
        try {syllCount = Integer.parseInt(numSyll.getText());}
        catch (NumberFormatException nfe) {
            Alert apptAlert = new Alert(Alert.AlertType.WARNING);
            apptAlert.setTitle("There was a problem with number of syllables");
            apptAlert.setContentText("Please enter a whole number");
            apptAlert.show();
        }
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
        if (syllCount <= totalSyllables) {
        } else {
            System.out.println("Too large of number foir syllables");
            //TODO Hard stop
        }
        //First or 1 syllable selected should be Any, First, or First-Middle
        String genWord = "";
        for(int i = 1; i <=syllCount; i++){
            if (i == 1){
                //TODO First, First-Middle, Any
                System.out.println("First, First-Middle, Any");
                //Query for random syllable by position
                dmlString = "SELECT * FROM " + Main.SYLLTBL + " WHERE "
                        + Main.ID + " IN " + "(SELECT " + Main.ID + " FROM " + Main.SYLLTBL
                        + " WHERE " + Main.POSITION + " LIKE 'First' "
                        + " OR " + Main.POSITION + " LIKE 'First-Middle'"
                        + " OR " + Main.POSITION + " LIKE 'Any'"
                        + " ORDER BY RANDOM() LIMIT 1)";
                prepStmt = DBConnection.dbConnector().prepareStatement(dmlString);
                prepStmt.execute();
                sqlResults = prepStmt.getResultSet();
                while (sqlResults.next() ) {
                    genWord = genWord + sqlResults.getString(2);
                }
            }
            else if (i == syllCount && i > 1){
                //TODO Last, Last-Middle, Any
                System.out.println("Last, Last-Middle, Any");
                dmlString = "SELECT * FROM " + Main.SYLLTBL + " WHERE "
                        + Main.ID + " IN " + "(SELECT " + Main.ID + " FROM " + Main.SYLLTBL
                        + " WHERE " + Main.POSITION + " LIKE 'Last' "
                        + " OR " + Main.POSITION + " LIKE 'Last-Middle'"
                        + " OR " + Main.POSITION + " LIKE 'Any'"
                        + " ORDER BY RANDOM() LIMIT 1)";
                prepStmt = DBConnection.dbConnector().prepareStatement(dmlString);
                prepStmt.execute();
                sqlResults = prepStmt.getResultSet();
                while (sqlResults.next() ) {
                    genWord = genWord + sqlResults.getString(2);
                }
            }
            else if (i != 1 && i <= (syllCount / 2) ){
                //TODO First-Middle, Middle, Any
                System.out.println("First-Middle, Middle, Any");
                dmlString = "SELECT * FROM " + Main.SYLLTBL + " WHERE "
                        + Main.ID + " IN " + "(SELECT " + Main.ID + " FROM " + Main.SYLLTBL
                        + " WHERE " + Main.POSITION + " LIKE 'First-Middle' "
                        + " OR " + Main.POSITION + " LIKE 'Middle'"
                        + " OR " + Main.POSITION + " LIKE 'Any'"
                        + " ORDER BY RANDOM() LIMIT 1)";
                prepStmt = DBConnection.dbConnector().prepareStatement(dmlString);
                prepStmt.execute();
                sqlResults = prepStmt.getResultSet();
                while (sqlResults.next() ) {
                    genWord = genWord + sqlResults.getString(2);
                }
            }
            else if ( (Math.abs(1 - i)) == (syllCount - i) ){
                //TODO Middle
                System.out.println("Exact Middle");
                dmlString = "SELECT * FROM " + Main.SYLLTBL + " WHERE "
                        + Main.ID + " IN " + "(SELECT " + Main.ID + " FROM " + Main.SYLLTBL
                        + " WHERE " + Main.POSITION + " LIKE 'Exact Middle' "
//                        + " OR " + Main.POSITION + " LIKE 'Middle'"
//                        + " OR " + Main.POSITION + " LIKE 'Any'"
                        + " ORDER BY RANDOM() LIMIT 1)";
                prepStmt = DBConnection.dbConnector().prepareStatement(dmlString);
                prepStmt.execute();
                sqlResults = prepStmt.getResultSet();
                while (sqlResults.next() ) {
                    genWord = genWord + sqlResults.getString(2);
                }
            }
            else if (i != syllCount && i > (syllCount / 2)){
                //TODO Last-Middle, Middle, Any
                System.out.println("Last-Middle, Middle, Any");
                dmlString = "SELECT * FROM " + Main.SYLLTBL + " WHERE "
                        + Main.ID + " IN " + "(SELECT " + Main.ID + " FROM " + Main.SYLLTBL
                        + " WHERE " + Main.POSITION + " LIKE 'Last-Middle' "
                        + " OR " + Main.POSITION + " LIKE 'Middle'"
                        + " OR " + Main.POSITION + " LIKE 'Any'"
                        + " ORDER BY RANDOM() LIMIT 1)";
                prepStmt = DBConnection.dbConnector().prepareStatement(dmlString);
                prepStmt.execute();
                sqlResults = prepStmt.getResultSet();
                while (sqlResults.next() ) {
                    genWord = genWord + sqlResults.getString(2);
                }
            } else {
                //TODO Middle, Any
                System.out.println("Middle, Any");
                dmlString = "SELECT * FROM " + Main.SYLLTBL + " WHERE "
                        + Main.ID + " IN " + "(SELECT " + Main.ID + " FROM " + Main.SYLLTBL
                        + " WHERE " + Main.POSITION + " LIKE 'Middle' "
//                        + " OR " + Main.POSITION + " LIKE 'Middle'"
                        + " OR " + Main.POSITION + " LIKE 'Any'"
                        + " ORDER BY RANDOM() LIMIT 1)";
                prepStmt = DBConnection.dbConnector().prepareStatement(dmlString);
                prepStmt.execute();
                sqlResults = prepStmt.getResultSet();
                while (sqlResults.next() ) {
                    genWord = genWord + sqlResults.getString(2);
                }
            }
        }
        //Last syllable selected should be Any, Last, or Last-Middle
        //TODO shit, need a field for syllables
        spelledGenWord.setText(genWord);
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
