package ConLang;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.time.ZonedDateTime;

public class Main extends Application {

    //SQL Constants
    static final String DBINFO = "jdbc:sqlite:ConLang.db";
    static final String SYLLTBL = "conSyll";
    static final String PREFIX = "conSyll.";
    static final String WORDTBL = "conWord";
    static final String PREFIXWORD = "conWord.";
    static final String PPTTBL = "conPPT";
    static final String PREFIXPPT = "conPPT.";
    static final String ID = "_id";
    static final String WID = "wordId";
    static final String SPELLED = "spelled";
    static final String PHONETIC = "phonetic";
    static final String WORDTYPE = "wordType";
    static final String POSITION = "position";
    static final String SYLLTYPE = "syllType";
    static final String MEANING = "meaning";
    static final String DATEADDED = "dateAdded";
    static final String DESC = "description";
    static final String ARCH = "archeType";
    static final String SVOW = "sVowelFlag";
    static final String SELF = "selfFlag";
    static final String FSYLL = "followSyll";


    @Override
    public void start(Stage primaryStage) throws Exception{
        //Ensure DB and tables created...TODO threading
        DBConnection.createTables();
        Parent root = FXMLLoader.load(getClass().getResource("mainMenu.fxml"));
        primaryStage.setTitle("LexiConLang");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    public static void addTestData() throws SQLException {
        Syllable newSyll;
        newSyll = new Syllable(-1,"a","ah","Any","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),true,false,Syllable.FollowSyll.Any);
        newSyll.createSyllable(newSyll);
        newSyll = new Syllable(-1,"e","eh","Any","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),true,true,Syllable.FollowSyll.Any);
        newSyll.createSyllable(newSyll);
        newSyll = new Syllable(-1,"i","ih","Any","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),true,false,Syllable.FollowSyll.Any);
        newSyll.createSyllable(newSyll);
        newSyll = new Syllable(-1,"o","oh","Any","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),true,true,Syllable.FollowSyll.Any);
        newSyll.createSyllable(newSyll);
        newSyll = new Syllable(-1,"u","uh","Any","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),true,false,Syllable.FollowSyll.Any);
        newSyll.createSyllable(newSyll);
        newSyll = new Syllable(-1,"a","ay","Any","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),true,false,Syllable.FollowSyll.Any);
        newSyll.createSyllable(newSyll);
        newSyll = new Syllable(-1,"e","ee","Any","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),true,true,Syllable.FollowSyll.Any);
        newSyll.createSyllable(newSyll);
        newSyll = new Syllable(-1,"i","eye","Any","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),true,false,Syllable.FollowSyll.Any);
        newSyll.createSyllable(newSyll);
        newSyll = new Syllable(-1,"o","oe","Any","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),true,true,Syllable.FollowSyll.Any);
        newSyll.createSyllable(newSyll);
        newSyll = new Syllable(-1,"u","you","Any","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),true,false,Syllable.FollowSyll.Any);
        newSyll.createSyllable(newSyll);
        newSyll = new Syllable(-1,"y","why","Any","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),true,false,Syllable.FollowSyll.Any);
        newSyll.createSyllable(newSyll);
        newSyll = new Syllable(-1,"ch","cheh","Any","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),false,false,Syllable.FollowSyll.Vowel);
        newSyll.createSyllable(newSyll);
        newSyll = new Syllable(-1,"mp","eh'mp","Last-Middle","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),false,false,Syllable.FollowSyll.Consonant);
        newSyll.createSyllable(newSyll);
        newSyll = new Syllable(-1,"t","tee","Any","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),false,true,Syllable.FollowSyll.Any);
        newSyll.createSyllable(newSyll);
        newSyll = new Syllable(-1,"c","see","First-Middle","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),false,false,Syllable.FollowSyll.Vowel);
        newSyll.createSyllable(newSyll);
        newSyll = new Syllable(-1,"c","k'eh","Any","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),false,false,Syllable.FollowSyll.Consonant);
        newSyll.createSyllable(newSyll);
        newSyll = new Syllable(-1,"gh","ff","Last-Middle","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),false,false,Syllable.FollowSyll.Consonant);
        newSyll.createSyllable(newSyll);
        newSyll = new Syllable(-1,"str","str","First-Middle","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),false,false,Syllable.FollowSyll.Vowel);
        newSyll.createSyllable(newSyll);
        newSyll = new Syllable(-1,"ck","kk","Last-Middle","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),false,false,Syllable.FollowSyll.Any);
        newSyll.createSyllable(newSyll);
    }
}
