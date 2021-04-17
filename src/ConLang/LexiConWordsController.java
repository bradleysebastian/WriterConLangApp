package ConLang;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class LexiConWordsController implements Initializable {
    //LEGEND: BtnP : Button Pressed

    private Stage primaryStage;
    private Parent newScene;

    private static ConWord selectedWord;

    @FXML
    private TextField searchTextF;
    @FXML
    private TableView<ConWord> lexiConWordsTblVw;
    @FXML
    private TableColumn<ConWord, String> spelledTblCol;
    @FXML
    private TableColumn<ConWord, String> phoneticTblCol;
    @FXML
    private TableColumn<ConWord, String> wordTypeTblCol;
    @FXML
    private TableColumn<ConWord, String> meaningTblCol;

    public static ConWord getSelectedWord() {
        return selectedWord;
    }

    public void searchWords(ActionEvent actionEvent) throws SQLException {
        ConWord.populateLexiConWords(searchTextF.getText());
    }

    public void modifyWord(ActionEvent modifyBtnP) throws IOException {
        selectedWord = lexiConWordsTblVw.getSelectionModel().getSelectedItem();
        if(selectedWord != null) {
            //Get current Stage
            primaryStage = (Stage)((Button)modifyBtnP.getSource()).getScene().getWindow();
            //Load Parent, FXMLLoader for createWord.fxml
            newScene = FXMLLoader.load(getClass().getClassLoader().getResource("ConLang/modifyWord.fxml"));
            primaryStage.setScene(new Scene(newScene));
            primaryStage.show();
        } else {
            showAlert();
        }

    }

    public void assignWord(ActionEvent assignBtnP) throws IOException {
        selectedWord = lexiConWordsTblVw.getSelectionModel().getSelectedItem();
        if(selectedWord != null) {
            //Get current Stage
            primaryStage = (Stage)((Button)assignBtnP.getSource()).getScene().getWindow();
            //Load Parent, FXMLLoader for createWord.fxml
            newScene = FXMLLoader.load(getClass().getClassLoader().getResource("ConLang/assignWord.fxml"));
            primaryStage.setScene(new Scene(newScene));
            primaryStage.show();
        } else {
            showAlert();
        }
    }

    public void showAlert(){
        Alert modAlert = new Alert(Alert.AlertType.WARNING);
        modAlert.setTitle("No word selected");
        modAlert.setContentText("Please select a word and try again.  If there are no words showing, reset search terms" +
                " or add words in the other menu");
        modAlert.show();
    }

    public void deleteWord(ActionEvent actionEvent) {
        selectedWord = lexiConWordsTblVw.getSelectionModel().getSelectedItem();
        if(selectedWord != null) {

        } else {
            showAlert();
        }
    }

    public void returnMainMenu(ActionEvent backBtnP) throws IOException {
        //Get current Stage
        primaryStage = (Stage)((Button)backBtnP.getSource()).getScene().getWindow();
        //Load Parent, FXMLLoader for createWord.fxml
        newScene = FXMLLoader.load(getClass().getClassLoader().getResource("ConLang/mainMenu.fxml"));
        primaryStage.setScene(new Scene(newScene));
        primaryStage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        System.out.println(searchTextF.getText());
        try {
            ConWord.populateLexiConWords(searchTextF.getText());
            lexiConWordsTblVw.setItems(ConWord.getLexiConWords());
            spelledTblCol.setCellValueFactory(new PropertyValueFactory<>("spelling"));
            phoneticTblCol.setCellValueFactory(new PropertyValueFactory<>("phonetic"));
            wordTypeTblCol.setCellValueFactory(new PropertyValueFactory<>("wordType"));
            meaningTblCol.setCellValueFactory(new PropertyValueFactory<>("meaning"));
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
}
