package ConLang;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    //SQL Constants
    static final String SYLLTBL = "conSyll";
    static final String WORDTBL = "conWord";
    static final String PPTTBL = "conPPT";
    static final String ID = "_id";
    static final String SPELLED = "spelled";
    static final String PHONETIC = "phonetic";
    static final String WORDTYPE = "wordType";
    static final String POSITION = "position";
    static final String SYLLTYPE = "syllType";
    static final String MEANING = "meaning";
    static final String DATEADDED = "dateAdded";
    static final String DESC = "description";
    static final String ARCH = "archeType";

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Ensure DB and tables created...TODO threading
        DBConnection.createTables();
        Parent root = FXMLLoader.load(getClass().getResource("mainMenu.fxml"));
        primaryStage.setTitle("LexiConLang");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
