package ConLang;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MainMenuController {
    //LEGEND: BtnP : Button Pressed

    private Stage primaryStage;
    private Parent newScene;


    public void openCreateWordMenu(ActionEvent createWordBtnP) throws IOException {
        //Get current Stage
        primaryStage = (Stage)((Button)createWordBtnP.getSource()).getScene().getWindow();
        //Load Parent, FXMLLoader for createWord.fxml
        newScene = FXMLLoader.load(getClass().getClassLoader().getResource("ConLang/createWord.fxml"));
        primaryStage.setScene(new Scene(newScene));
        primaryStage.show();
    }


    public void openLexiconMenu(ActionEvent openLexBtnP) throws IOException {
        //Get current Stage
        primaryStage = (Stage)((Button)openLexBtnP.getSource()).getScene().getWindow();
        //Load Parent, FXMLLoader for createWord.fxml
        newScene = FXMLLoader.load(getClass().getClassLoader().getResource("ConLang/lexiConWords.fxml"));
        primaryStage.setScene(new Scene(newScene));
        primaryStage.show();
    }

    public void assignLexWordsMenu(ActionEvent assignLexWordsBtnP) throws IOException {
        //Get current Stage
        primaryStage = (Stage)((Button)assignLexWordsBtnP.getSource()).getScene().getWindow();
        //Load Parent, FXMLLoader for createWord.fxml
        newScene = FXMLLoader.load(getClass().getClassLoader().getResource("ConLang/assignSubject.fxml"));
        primaryStage.setScene(new Scene(newScene));
        primaryStage.show();
    }

    public void closeApp(ActionEvent closeAppBtnP) {
        System.exit(0);
    }

    public void onActionAddEnglish() throws SQLException {
        //TODO
        Main.addTestData();

    }

    public void onActionRemoveAllData() throws SQLException {
        //TODO
        String dmlString = "DELETE FROM " + Main.SYLLTBL;
        PreparedStatement prepStmt = DBConnection.dbConnector().prepareStatement(dmlString);
        prepStmt.execute();
        dmlString = "DELETE FROM " + Main.WORDTBL;
        prepStmt = DBConnection.dbConnector().prepareStatement(dmlString);
        prepStmt.execute();
        dmlString = "DELETE FROM " + Main.PPTTBL;
        prepStmt = DBConnection.dbConnector().prepareStatement(dmlString);
        prepStmt.execute();
    }
}
