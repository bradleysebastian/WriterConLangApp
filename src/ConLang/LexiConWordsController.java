package ConLang;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
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

    public void searchWords(ActionEvent actionEvent) {
    }

    public void modifyWord(ActionEvent actionEvent) {
    }

    public void assignWord(ActionEvent actionEvent) {
    }

    public void deleteWord(ActionEvent actionEvent) {
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
