package ConLang;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZonedDateTime;

import static ConLang.Main.*;

public class ConWord {
    //TODO fields
    private int id;
    private String spelling;
    private String phonetic;
    private String wordType;
    private String meaning;
    private String dateAdded;

    private ObservableList<Syllable> syllList;
    private static ObservableList<ConWord> lexiConWords = FXCollections.observableArrayList();
    //TODO Constructor

    public ConWord(int id, String spelling, String phonetic, String wordType, String meaning, String dateAdded) {
        this.id = id;
        this.spelling = spelling;
        this.phonetic = phonetic;
        this.wordType = wordType;
        this.meaning = meaning;
        this.dateAdded = dateAdded;
        this.syllList = FXCollections.observableArrayList();
    }

    public ConWord() {
        this.id = -1;
        this.dateAdded = ZonedDateTime.now().toLocalDateTime().toString();
        this.syllList =  FXCollections.observableArrayList();
    }

    //TODO Getter

    public int getId() {
        return id;
    }

    public String getSpelling() {
        return spelling;
    }

    public String getPhonetic() {
        return phonetic;
    }

    public String getWordType() {
        return wordType;
    }

    public String getMeaning() {
        return meaning;
    }

    public String getDateAdded() {
        return dateAdded;
    }

    public ObservableList<Syllable> getSyllList() {
        return syllList;
    }

    public static ObservableList<ConWord> getLexiConWords() {
        return lexiConWords;
    }

    //TODO Setter

    public void setId(int id) {
        this.id = id;
    }

    public void setSpelling(ObservableList<Syllable> syllList) {
        String syllSpellChain = "";
        for(int i = 0; i < syllList.size(); i++){
            syllSpellChain = syllSpellChain + syllList.get(i).getSpelling();
        }
        this.spelling = syllSpellChain;
    }

    public void setSpelling(String spelled){
        this.spelling = spelled;
    }

    public void setPhonetic(ObservableList<Syllable> syllList) {
        String syllPhoneChain = "";
        for(int i = 0; i < syllList.size(); i++){
            syllPhoneChain = syllPhoneChain + syllList.get(i).getPhonetic();
        }
        this.phonetic = syllPhoneChain;
    }

    public void setPhonetic(String phone){
        this.phonetic = phone;
    }

    public void setWordType(String wordType) {
        this.wordType = wordType;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    public void setDateAdded(String dateAdded) {
        this.dateAdded = dateAdded;
    }
    //Returns 1 Syllable
    public void getSyllable(String syllType1, String syllType2, String syllType3,
                            int followSyll, String selfSyll) {
        String dmlString = "SELECT * FROM " + SYLLTBL + " WHERE "
                + ID + " IN " + "(SELECT " + ID + " FROM " + SYLLTBL
                + " WHERE (" + SVOW + " = ? AND " + SPELLED + " NOT LIKE ?)"
                + " AND (" + POSITION + " LIKE ? OR " + POSITION + " LIKE ? OR " + POSITION + " LIKE ?)"
                + " ORDER BY RANDOM() LIMIT 1)";
        //TODO try /w resources (TOP):
        try (PreparedStatement prepStmt = DBConnection.dbConnector().prepareStatement(dmlString)){
//            PreparedStatement prepStmt = DBConnection.dbConnector().prepareStatement(dmlString); //TODO move to try
            prepStmt.setInt(1, followSyll);
            prepStmt.setString(2, selfSyll);
            prepStmt.setString(3, syllType1);
            prepStmt.setString(4, syllType2);
            prepStmt.setString(5, syllType3);
            prepStmt.execute();
            try (ResultSet sqlResults = prepStmt.getResultSet()) { //NESTED TRY FOR RESULTSET USAGES
//            ResultSet sqlResults = prepStmt.getResultSet(); //TODO move to NESTED try
                while (sqlResults.next()) {
                    //Translate 1/0 to T/F for sVowelFlag
                    boolean sVowFlgVal;
                    if (sqlResults.getInt(7) == 1) {
                        sVowFlgVal = true;
                    } else {
                        sVowFlgVal = false;
                    }
                    //Translate 1/0 to T/F for selfFlag
                    boolean selfFlgVal;
                    if (sqlResults.getInt(8) == 1) {
                        selfFlgVal = true;
                    } else {
                        selfFlgVal = false;
                    }
                    //Translate Any,Vowel,Cons to FollowSyll Enum
                    Syllable.FollowSyll follSyllEnum;
                    switch (sqlResults.getString(9)) {
                        case "Any":
                            follSyllEnum = Syllable.FollowSyll.Any;
                            break;
                        case "Vowel":
                            follSyllEnum = Syllable.FollowSyll.Vowel;
                            break;
                        default:
                            follSyllEnum = Syllable.FollowSyll.Consonant;
                    }
                    Syllable newSyll = new Syllable(
                            sqlResults.getInt(1), //ID#
                            sqlResults.getString(2), //spelled
                            sqlResults.getString(3), //phonetic
                            sqlResults.getString(4), //position
                            sqlResults.getString(5), //syllType
                            sqlResults.getString(6), //meaning
                            sqlResults.getString(10), //dateAdded (SQL table re-ordered)
                            sVowFlgVal,
                            selfFlgVal,
                            follSyllEnum);
                    syllList.add(newSyll);
                }
            }
        } catch (SQLException sqlE) { //BOTH OUTER AND INNER TRYS SPIT SQLEXCEPTIONS
            sqlE.printStackTrace();
        }
        //TODO try /w resources (TOP):
        //TODO Remove any close statements
//        sqlResults.close();
//        prepStmt.close();
    }

    //TODO Maybe move this method???
    //Populate List of All (or specified search) Words
    public static void populateLexiConWords(String searchText) {
        lexiConWords.clear();
        String dmlString = "SELECT * FROM " + Main.WORDTBL + " WHERE spelled LIKE ?";
        //TODO TRY W/ RESOURCES PREPAREDSTATEMENT
        try (PreparedStatement prepStmt = DBConnection.dbConnector().prepareStatement(dmlString)) {
//        PreparedStatement prepStmt = DBConnection.dbConnector().prepareStatement(dmlString);
            prepStmt.setString(1, "%" + searchText + "%");
            prepStmt.execute();
            //TODO TRY W/ RESOURCES RESULTSET
            try (ResultSet sqlResults = prepStmt.getResultSet()) {
//            ResultSet sqlResults = prepStmt.getResultSet();
            while (sqlResults.next()) {
                ConWord addWord = new ConWord();
                addWord.setId(sqlResults.getInt(1));
                addWord.setSpelling(sqlResults.getString(2));
                addWord.setPhonetic(sqlResults.getString(3));
                addWord.setWordType(sqlResults.getString(4));
                addWord.setMeaning(sqlResults.getString(5));
                addWord.setDateAdded(sqlResults.getString(6));
                //Observable List in class declarations above
                lexiConWords.add(addWord);
                }
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
//        sqlResults.close();
//        prepStmt.close();
    }
    //TODO SQL Storage
    public void storeLexiConWord(ConWord newConWord) {
        String dmlString = "INSERT INTO " + WORDTBL + " ("
                + SPELLED + "," + PHONETIC + "," + WORDTYPE + "," + MEANING + "," + DATEADDED + ")" +
                "VALUES (?, ?, ?, ?, ?)";
        try(PreparedStatement prepStmt = DBConnection.dbConnector().prepareStatement(dmlString)) {
//            PreparedStatement prepStmt = DBConnection.dbConnector().prepareStatement(dmlString);
            prepStmt.setString(1, newConWord.getSpelling());
            prepStmt.setString(2, newConWord.getPhonetic());
            prepStmt.setString(3, newConWord.getWordType());
            prepStmt.setString(4, newConWord.getMeaning());
            prepStmt.setString(5, newConWord.getDateAdded());
            prepStmt.execute();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
//        prepStmt.close();
    }
    //TODO Modify Word Record in SQL
    public void changeLexiConWord(ConWord modConWord) {
        String dmlString = "UPDATE " + WORDTBL
                + " SET " + SPELLED + " = ?, " + PHONETIC + " = ?, "
                + WORDTYPE + " = ?, " + MEANING + " = ?"
                + "WHERE " + ID + " = ?";
        try(PreparedStatement prepStmt = DBConnection.dbConnector().prepareStatement(dmlString)) {
//            PreparedStatement prepStmt = DBConnection.dbConnector().prepareStatement(dmlString);
            prepStmt.setString(1, modConWord.getSpelling());
            prepStmt.setString(2, modConWord.getPhonetic());
            prepStmt.setString(3, modConWord.getWordType());
            prepStmt.setString(4, modConWord.getMeaning());
            prepStmt.setInt(5, modConWord.getId());
            prepStmt.execute();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
//        prepStmt.close();
    }

    public void deleteLexiConWord(ConWord delConWord) {
        String dmlString = "DELETE FROM " + WORDTBL + " WHERE " + ID + " = ?";
        try (PreparedStatement prepStmt = DBConnection.dbConnector().prepareStatement(dmlString)) {
//            PreparedStatement prepStmt = DBConnection.dbConnector().prepareStatement(dmlString);
            prepStmt.setInt(1, delConWord.getId());
            prepStmt.execute();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
//        prepStmt.close();
    }
}
