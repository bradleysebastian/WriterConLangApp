package ConLang;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZonedDateTime;

public class ConWord {
    //TODO fields
    private int id;
    private String spelling;
    private String phonetic;
    private String wordType;
    private String meaning;
    private String dateAdded;

    private ObservableList<Syllable> syllList;
    //TODO Constructor

    public ConWord(int id, String spelling, String phonetic, String wordType, String meaning, String dateAdded) {
        this.id = id;
        this.spelling = spelling;
        this.phonetic = phonetic;
        this.wordType = wordType;
        this.meaning = meaning;
        this.dateAdded = dateAdded;
        this.syllList =  FXCollections.observableArrayList();
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

    public void setPhonetic(ObservableList<Syllable> syllList) {
        String syllPhoneChain = "";
        for(int i = 0; i < syllList.size(); i++){
            syllPhoneChain = syllPhoneChain + syllList.get(i).getPhonetic();
        }
        this.phonetic = syllPhoneChain;
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

    //TODO SQL Retrieval
    //Returns 1 Syllable
    public void getSyllable(String syllType1, String syllType2, String syllType3) throws SQLException {
//        Syllable newSyll = new Syllable();
        String dmlString = "SELECT * FROM " + Main.SYLLTBL + " WHERE "
                + Main.ID + " IN " + "(SELECT " + Main.ID + " FROM " + Main.SYLLTBL
                + " WHERE " + Main.POSITION + " LIKE 'First' "
                + " OR " + Main.POSITION + " LIKE 'First-Middle'"
                + " OR " + Main.POSITION + " LIKE 'Any'"
                + " ORDER BY RANDOM() LIMIT 1)";
        PreparedStatement prepStmt = DBConnection.dbConnector().prepareStatement(dmlString);
        prepStmt.execute();
        ResultSet sqlResults = prepStmt.getResultSet();
        while (sqlResults.next() ) {
            Syllable newSyll = new Syllable(sqlResults.getInt(1), sqlResults.getString(2),
                    sqlResults.getString(3), sqlResults.getString(4),
                    sqlResults.getString(5),sqlResults.getString(6),
                    sqlResults.getString(7));
            syllList.add(newSyll);
        }
    }
    //TODO SQL Storage

}
