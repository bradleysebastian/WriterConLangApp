package ConLang;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.ZonedDateTime;

public class Syllable {

    private int id;
    private String spelling;
    private String phonetic;
    private String position;
    private String syllType;
    private String meaning;
    private String dateAdded;

    public Syllable(int id, String spelling, String phonetic, String position,
                    String syllType, String meaning, String dateAdded) {
        this.id = id;
        this.spelling = spelling;
        this.phonetic = phonetic;
        this.position = position;
        this.syllType = syllType;
        this.meaning = meaning;
        this.dateAdded = dateAdded;
    }

    public Syllable() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSpelling() {
        return spelling;
    }

    public void setSpelling(String spelling) {
        this.spelling = spelling;
    }

    public String getPhonetic() {
        return phonetic;
    }

    public void setPhonetic(String phonetic) {
        this.phonetic = phonetic;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getSyllType() {
        return syllType;
    }

    public void setSyllType(String syllType) {
        this.syllType = syllType;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    public String getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(String dateAdded) {
        this.dateAdded = dateAdded;
    }

    public void createSyllable(Syllable inputSyll) throws SQLException {
        String dmlString = "INSERT INTO " + Main.SYLLTBL + " (" + Main.SPELLED + ", " + Main.PHONETIC + ", " + Main.POSITION + ", "
                + Main.SYLLTYPE + ", " + Main.MEANING + ", " + Main.DATEADDED + ") " + "VALUES(?, ?, ?, ?, ?, ?)";
        PreparedStatement prepStmt = DBConnection.dbConnector().prepareStatement(dmlString);
        //SPELLED TEXTFIELD
        prepStmt.setString(1, inputSyll.getSpelling());
        //PHONETIC TEXTFIELD
        prepStmt.setString(2, inputSyll.getPhonetic());
        //POSITION COMBO BOX
        prepStmt.setString(3, inputSyll.getPosition());
        //SYLLTYPE COMBO BOX
        prepStmt.setString(4, inputSyll.getSyllType());
        //MEANING TEXTFIELD
        prepStmt.setString(5, inputSyll.getMeaning());
        //DATEADDED SYSTEM DATETIME
        prepStmt.setString(6, inputSyll.getDateAdded());
        prepStmt.execute();
        DBConnection.dbConnector().close();
    }
}
