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
//        newSyll = new Syllable(-1,"a","ah","Any","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),true,false,Syllable.FollowSyll.Any);
//        newSyll.createSyllable(newSyll);
//        newSyll = new Syllable(-1,"e","eh","Any","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),true,true,Syllable.FollowSyll.Any);
//        newSyll.createSyllable(newSyll);
//        newSyll = new Syllable(-1,"i","ih","Any","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),true,false,Syllable.FollowSyll.Any);
//        newSyll.createSyllable(newSyll);
//        newSyll = new Syllable(-1,"o","oh","Any","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),true,true,Syllable.FollowSyll.Any);
//        newSyll.createSyllable(newSyll);
//        newSyll = new Syllable(-1,"u","uh","Any","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),true,false,Syllable.FollowSyll.Any);
//        newSyll.createSyllable(newSyll);
//        newSyll = new Syllable(-1,"a","ay","Any","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),true,false,Syllable.FollowSyll.Any);
//        newSyll.createSyllable(newSyll);
//        newSyll = new Syllable(-1,"e","ee","Any","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),true,true,Syllable.FollowSyll.Any);
//        newSyll.createSyllable(newSyll);
//        newSyll = new Syllable(-1,"i","eye","Any","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),true,false,Syllable.FollowSyll.Any);
//        newSyll.createSyllable(newSyll);
//        newSyll = new Syllable(-1,"o","oe","Any","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),true,true,Syllable.FollowSyll.Any);
//        newSyll.createSyllable(newSyll);
//        newSyll = new Syllable(-1,"u","you","Any","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),true,false,Syllable.FollowSyll.Any);
//        newSyll.createSyllable(newSyll);
//        newSyll = new Syllable(-1,"y","why","Any","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),true,false,Syllable.FollowSyll.Any);
//        newSyll.createSyllable(newSyll);
//        newSyll = new Syllable(-1,"ch","cheh","Any","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),false,false,Syllable.FollowSyll.Vowel);
//        newSyll.createSyllable(newSyll);
//        newSyll = new Syllable(-1,"mp","eh'mp","Last-Middle","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),false,false,Syllable.FollowSyll.Consonant);
//        newSyll.createSyllable(newSyll);
//        newSyll = new Syllable(-1,"t","tee","Any","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),false,true,Syllable.FollowSyll.Any);
//        newSyll.createSyllable(newSyll);
//        newSyll = new Syllable(-1,"c","see","First-Middle","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),false,false,Syllable.FollowSyll.Vowel);
//        newSyll.createSyllable(newSyll);
//        newSyll = new Syllable(-1,"c","k'eh","Any","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),false,false,Syllable.FollowSyll.Consonant);
//        newSyll.createSyllable(newSyll);
//        newSyll = new Syllable(-1,"gh","ff","Last-Middle","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),false,false,Syllable.FollowSyll.Consonant);
//        newSyll.createSyllable(newSyll);
//        newSyll = new Syllable(-1,"str","str","First-Middle","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),false,false,Syllable.FollowSyll.Vowel);
//        newSyll.createSyllable(newSyll);
//        newSyll = new Syllable(-1,"ck","kk","Last-Middle","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),false,false,Syllable.FollowSyll.Any);
//        newSyll.createSyllable(newSyll);
        newSyll = new Syllable(-1,"a","ah","Any","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),true,false,Syllable.FollowSyll.Any);
        newSyll.createSyllable(newSyll);
        newSyll = new Syllable(-1,"i","ee","Any","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),true,false,Syllable.FollowSyll.Any);
        newSyll.createSyllable(newSyll);
        newSyll = new Syllable(-1,"u","oo","Any","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),true,false,Syllable.FollowSyll.Any);
        newSyll.createSyllable(newSyll);
        newSyll = new Syllable(-1,"e","eh","Any","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),true,false,Syllable.FollowSyll.Any);
        newSyll.createSyllable(newSyll);
        newSyll = new Syllable(-1,"o","oe","Any","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),true,false,Syllable.FollowSyll.Any);
        newSyll.createSyllable(newSyll);
        newSyll = new Syllable(-1,"ka","kah","Any","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),false,false,Syllable.FollowSyll.Any);
        newSyll.createSyllable(newSyll);
        newSyll = new Syllable(-1,"ki","kee","Any","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),false,false,Syllable.FollowSyll.Any);
        newSyll.createSyllable(newSyll);
        newSyll = new Syllable(-1,"ku","koo","Any","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),false,false,Syllable.FollowSyll.Any);
        newSyll.createSyllable(newSyll);
        newSyll = new Syllable(-1,"ke","keh","Any","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),false,false,Syllable.FollowSyll.Any);
        newSyll.createSyllable(newSyll);
        newSyll = new Syllable(-1,"ko","koe","Any","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),false,false,Syllable.FollowSyll.Any);
        newSyll.createSyllable(newSyll);
        newSyll = new Syllable(-1,"ga","gah","Any","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),false,false,Syllable.FollowSyll.Any);
        newSyll.createSyllable(newSyll);
        newSyll = new Syllable(-1,"gi","gee","Any","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),false,false,Syllable.FollowSyll.Any);
        newSyll.createSyllable(newSyll);
        newSyll = new Syllable(-1,"gu","goo","Any","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),false,false,Syllable.FollowSyll.Any);
        newSyll.createSyllable(newSyll);
        newSyll = new Syllable(-1,"ge","geh","Any","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),false,false,Syllable.FollowSyll.Any);
        newSyll.createSyllable(newSyll);
        newSyll = new Syllable(-1,"go","goe","Any","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),false,false,Syllable.FollowSyll.Any);
        newSyll.createSyllable(newSyll);
        newSyll = new Syllable(-1,"sa","sah","Any","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),false,false,Syllable.FollowSyll.Any);
        newSyll.createSyllable(newSyll);
        newSyll = new Syllable(-1,"si","shi","Any","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),false,false,Syllable.FollowSyll.Any);
        newSyll.createSyllable(newSyll);
        newSyll = new Syllable(-1,"su","soo","Any","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),false,false,Syllable.FollowSyll.Any);
        newSyll.createSyllable(newSyll);
        newSyll = new Syllable(-1,"se","seh","Any","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),false,false,Syllable.FollowSyll.Any);
        newSyll.createSyllable(newSyll);
        newSyll = new Syllable(-1,"so","soe","Any","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),false,false,Syllable.FollowSyll.Any);
        newSyll.createSyllable(newSyll);
        newSyll = new Syllable(-1,"za","zah","Any","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),false,false,Syllable.FollowSyll.Any);
        newSyll.createSyllable(newSyll);
        newSyll = new Syllable(-1,"ji","jee","Any","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),false,false,Syllable.FollowSyll.Any);
        newSyll.createSyllable(newSyll);
        newSyll = new Syllable(-1,"zu","zoo","Any","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),false,false,Syllable.FollowSyll.Any);
        newSyll.createSyllable(newSyll);
        newSyll = new Syllable(-1,"ze","zeh","Any","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),false,false,Syllable.FollowSyll.Any);
        newSyll.createSyllable(newSyll);
        newSyll = new Syllable(-1,"zo","zoe","Any","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),false,false,Syllable.FollowSyll.Any);
        newSyll.createSyllable(newSyll);
        newSyll = new Syllable(-1,"ta","tah","Any","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),false,false,Syllable.FollowSyll.Any);
        newSyll.createSyllable(newSyll);
        newSyll = new Syllable(-1,"chi","chee","Any","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),false,false,Syllable.FollowSyll.Any);
        newSyll.createSyllable(newSyll);
        newSyll = new Syllable(-1,"tsu","tsoo","Any","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),false,false,Syllable.FollowSyll.Any);
        newSyll.createSyllable(newSyll);
        newSyll = new Syllable(-1,"te","teh","Any","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),false,false,Syllable.FollowSyll.Any);
        newSyll.createSyllable(newSyll);
        newSyll = new Syllable(-1,"to","toe","Any","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),false,false,Syllable.FollowSyll.Any);
        newSyll.createSyllable(newSyll);
        newSyll = new Syllable(-1,"na","nah","Any","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),false,false,Syllable.FollowSyll.Any);
        newSyll.createSyllable(newSyll);
        newSyll = new Syllable(-1,"ni","nee","Any","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),false,false,Syllable.FollowSyll.Any);
        newSyll.createSyllable(newSyll);
        newSyll = new Syllable(-1,"nu","noo","Any","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),false,false,Syllable.FollowSyll.Any);
        newSyll.createSyllable(newSyll);
        newSyll = new Syllable(-1,"ne","neh","Any","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),false,false,Syllable.FollowSyll.Any);
        newSyll.createSyllable(newSyll);
        newSyll = new Syllable(-1,"no","noe","Any","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),false,false,Syllable.FollowSyll.Any);
        newSyll.createSyllable(newSyll);
        newSyll = new Syllable(-1,"da","dah","Any","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),false,false,Syllable.FollowSyll.Any);
        newSyll.createSyllable(newSyll);
        newSyll = new Syllable(-1,"de","deh","Any","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),false,false,Syllable.FollowSyll.Any);
        newSyll.createSyllable(newSyll);
        newSyll = new Syllable(-1,"do","doe","Any","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),false,false,Syllable.FollowSyll.Any);
        newSyll.createSyllable(newSyll);
        newSyll = new Syllable(-1,"ha","hah","Any","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),false,false,Syllable.FollowSyll.Any);
        newSyll.createSyllable(newSyll);
        newSyll = new Syllable(-1,"hi","hee","Any","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),false,false,Syllable.FollowSyll.Any);
        newSyll.createSyllable(newSyll);
        newSyll = new Syllable(-1,"hu","hoo","Any","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),false,false,Syllable.FollowSyll.Any);
        newSyll.createSyllable(newSyll);
        newSyll = new Syllable(-1,"he","heh","Any","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),false,false,Syllable.FollowSyll.Any);
        newSyll.createSyllable(newSyll);
        newSyll = new Syllable(-1,"ho","hoe","Any","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),false,false,Syllable.FollowSyll.Any);
        newSyll.createSyllable(newSyll);
        newSyll = new Syllable(-1,"ba","bah","Any","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),false,false,Syllable.FollowSyll.Any);
        newSyll.createSyllable(newSyll);
        newSyll = new Syllable(-1,"bi","bee","Any","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),false,false,Syllable.FollowSyll.Any);
        newSyll.createSyllable(newSyll);
        newSyll = new Syllable(-1,"bu","boo","Any","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),false,false,Syllable.FollowSyll.Any);
        newSyll.createSyllable(newSyll);
        newSyll = new Syllable(-1,"be","beh","Any","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),false,false,Syllable.FollowSyll.Any);
        newSyll.createSyllable(newSyll);
        newSyll = new Syllable(-1,"bo","boe","Any","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),false,false,Syllable.FollowSyll.Any);
        newSyll.createSyllable(newSyll);
        newSyll = new Syllable(-1,"pa","pah","Any","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),false,false,Syllable.FollowSyll.Any);
        newSyll.createSyllable(newSyll);
        newSyll = new Syllable(-1,"pi","pee","Any","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),false,false,Syllable.FollowSyll.Any);
        newSyll.createSyllable(newSyll);
        newSyll = new Syllable(-1,"pu","poo","Any","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),false,false,Syllable.FollowSyll.Any);
        newSyll.createSyllable(newSyll);
        newSyll = new Syllable(-1,"pe","peh","Any","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),false,false,Syllable.FollowSyll.Any);
        newSyll.createSyllable(newSyll);
        newSyll = new Syllable(-1,"po","poe","Any","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),false,false,Syllable.FollowSyll.Any);
        newSyll.createSyllable(newSyll);
        newSyll = new Syllable(-1,"ma","mah","Any","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),false,false,Syllable.FollowSyll.Any);
        newSyll.createSyllable(newSyll);
        newSyll = new Syllable(-1,"mi","mee","Any","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),false,false,Syllable.FollowSyll.Any);
        newSyll.createSyllable(newSyll);
        newSyll = new Syllable(-1,"mu","moo","Any","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),false,false,Syllable.FollowSyll.Any);
        newSyll.createSyllable(newSyll);
        newSyll = new Syllable(-1,"me","meh","Any","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),false,false,Syllable.FollowSyll.Any);
        newSyll.createSyllable(newSyll);
        newSyll = new Syllable(-1,"mo","moe","Any","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),false,false,Syllable.FollowSyll.Any);
        newSyll.createSyllable(newSyll);
        newSyll = new Syllable(-1,"ra","rah","Any","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),false,false,Syllable.FollowSyll.Any);
        newSyll.createSyllable(newSyll);
        newSyll = new Syllable(-1,"ri","ree","Any","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),false,false,Syllable.FollowSyll.Any);
        newSyll.createSyllable(newSyll);
        newSyll = new Syllable(-1,"ru","roo","Any","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),false,false,Syllable.FollowSyll.Any);
        newSyll.createSyllable(newSyll);
        newSyll = new Syllable(-1,"re","reh","Any","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),false,false,Syllable.FollowSyll.Any);
        newSyll.createSyllable(newSyll);
        newSyll = new Syllable(-1,"ro","roe","Any","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),false,false,Syllable.FollowSyll.Any);
        newSyll.createSyllable(newSyll);
        newSyll = new Syllable(-1,"wa","wah","Any","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),false,false,Syllable.FollowSyll.Any);
        newSyll.createSyllable(newSyll);
        newSyll = new Syllable(-1,"wo","woe","Any","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),false,false,Syllable.FollowSyll.Any);
        newSyll.createSyllable(newSyll);
        newSyll = new Syllable(-1,"n","n","Any","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),false,false,Syllable.FollowSyll.Any);
        newSyll.createSyllable(newSyll);
        newSyll = new Syllable(-1,"kya","kyah","Any","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),false,false,Syllable.FollowSyll.Any);
        newSyll.createSyllable(newSyll);
        newSyll = new Syllable(-1,"kyu","kyoo","Any","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),false,false,Syllable.FollowSyll.Any);
        newSyll.createSyllable(newSyll);
        newSyll = new Syllable(-1,"kyo","kyoe","Any","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),false,false,Syllable.FollowSyll.Any);
        newSyll.createSyllable(newSyll);
        newSyll = new Syllable(-1,"gya","kyah","Any","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),false,false,Syllable.FollowSyll.Any);
        newSyll.createSyllable(newSyll);
        newSyll = new Syllable(-1,"gyu","kyoo","Any","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),false,false,Syllable.FollowSyll.Any);
        newSyll.createSyllable(newSyll);
        newSyll = new Syllable(-1,"gyo","kyoe","Any","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),false,false,Syllable.FollowSyll.Any);
        newSyll.createSyllable(newSyll);
        newSyll = new Syllable(-1,"chya","kyah","Any","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),false,false,Syllable.FollowSyll.Any);
        newSyll.createSyllable(newSyll);
        newSyll = new Syllable(-1,"chyu","kyoo","Any","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),false,false,Syllable.FollowSyll.Any);
        newSyll.createSyllable(newSyll);
        newSyll = new Syllable(-1,"chyo","kyoe","Any","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),false,false,Syllable.FollowSyll.Any);
        newSyll.createSyllable(newSyll);
        newSyll = new Syllable(-1,"nya","kyah","Any","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),false,false,Syllable.FollowSyll.Any);
        newSyll.createSyllable(newSyll);
        newSyll = new Syllable(-1,"nyu","kyoo","Any","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),false,false,Syllable.FollowSyll.Any);
        newSyll.createSyllable(newSyll);
        newSyll = new Syllable(-1,"nyo","kyoe","Any","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),false,false,Syllable.FollowSyll.Any);
        newSyll.createSyllable(newSyll);
        newSyll = new Syllable(-1,"hya","kyah","Any","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),false,false,Syllable.FollowSyll.Any);
        newSyll.createSyllable(newSyll);
        newSyll = new Syllable(-1,"hyu","kyoo","Any","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),false,false,Syllable.FollowSyll.Any);
        newSyll.createSyllable(newSyll);
        newSyll = new Syllable(-1,"hyo","kyoe","Any","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),false,false,Syllable.FollowSyll.Any);
        newSyll.createSyllable(newSyll);
        newSyll = new Syllable(-1,"bya","kyah","Any","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),false,false,Syllable.FollowSyll.Any);
        newSyll.createSyllable(newSyll);
        newSyll = new Syllable(-1,"byu","kyoo","Any","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),false,false,Syllable.FollowSyll.Any);
        newSyll.createSyllable(newSyll);
        newSyll = new Syllable(-1,"byo","kyoe","Any","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),false,false,Syllable.FollowSyll.Any);
        newSyll.createSyllable(newSyll);
        newSyll = new Syllable(-1,"pya","kyah","Any","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),false,false,Syllable.FollowSyll.Any);
        newSyll.createSyllable(newSyll);
        newSyll = new Syllable(-1,"pyu","kyoo","Any","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),false,false,Syllable.FollowSyll.Any);
        newSyll.createSyllable(newSyll);
        newSyll = new Syllable(-1,"pyo","kyoe","Any","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),false,false,Syllable.FollowSyll.Any);
        newSyll.createSyllable(newSyll);
        newSyll = new Syllable(-1,"mya","kyah","Any","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),false,false,Syllable.FollowSyll.Any);
        newSyll.createSyllable(newSyll);
        newSyll = new Syllable(-1,"myu","kyoo","Any","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),false,false,Syllable.FollowSyll.Any);
        newSyll.createSyllable(newSyll);
        newSyll = new Syllable(-1,"myo","kyoe","Any","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),false,false,Syllable.FollowSyll.Any);
        newSyll.createSyllable(newSyll);
        newSyll = new Syllable(-1,"rya","kyah","Any","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),false,false,Syllable.FollowSyll.Any);
        newSyll.createSyllable(newSyll);
        newSyll = new Syllable(-1,"ryu","kyoo","Any","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),false,false,Syllable.FollowSyll.Any);
        newSyll.createSyllable(newSyll);
        newSyll = new Syllable(-1,"ryo","kyoe","Any","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),false,false,Syllable.FollowSyll.Any);
        newSyll.createSyllable(newSyll);
        newSyll = new Syllable(-1,"sha","kyah","Any","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),false,false,Syllable.FollowSyll.Any);
        newSyll.createSyllable(newSyll);
        newSyll = new Syllable(-1,"shu","kyoo","Any","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),false,false,Syllable.FollowSyll.Any);
        newSyll.createSyllable(newSyll);
        newSyll = new Syllable(-1,"sho","kyoe","Any","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),false,false,Syllable.FollowSyll.Any);
        newSyll.createSyllable(newSyll);
        newSyll = new Syllable(-1,"ja","kyah","Any","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),false,false,Syllable.FollowSyll.Any);
        newSyll.createSyllable(newSyll);
        newSyll = new Syllable(-1,"ju","kyoo","Any","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),false,false,Syllable.FollowSyll.Any);
        newSyll.createSyllable(newSyll);
        newSyll = new Syllable(-1,"jo","kyoe","Any","Regular","none",ZonedDateTime.now().toLocalDateTime().toString(),false,false,Syllable.FollowSyll.Any);
        newSyll.createSyllable(newSyll);
    }
}
