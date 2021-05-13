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
    private boolean sVowelFlag;
    private boolean selfFlag;
    private FollowSyll followSyll;

    enum FollowSyll {Any, Vowel, Consonant}

    //TODO Remove old constructor
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

    public Syllable(int id, String spelling, String phonetic, String position, String syllType, String meaning,
                    String dateAdded, boolean sVowelFlag, boolean selfFlag, FollowSyll followSyll) {
        this.id = id;
        this.spelling = spelling;
        this.phonetic = phonetic;
        this.position = position;
        this.syllType = syllType;
        this.meaning = meaning;
        this.dateAdded = dateAdded;
        this.sVowelFlag = sVowelFlag;
        this.selfFlag = selfFlag;
        this.followSyll = followSyll;
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

    public boolean issVowelFlag() {
        return sVowelFlag;
    }

    public void setsVowelFlag(int sVowelFlag) {
        if (sVowelFlag == 1) {
            this.sVowelFlag = true;
        } else {
            this.sVowelFlag = false;
        }
    }

    public boolean isSelfFlag() {
        return selfFlag;
    }

    public void setSelfFlag(boolean selfFlag) {
        this.selfFlag = selfFlag;
    }

    public FollowSyll getFollowSyll() {
        return followSyll;
    }

    public void setFollowSyll(FollowSyll followSyll) {
        this.followSyll = followSyll;
    }

    public void createSyllable(Syllable inputSyll) {
        String dmlString = "INSERT INTO " + Main.SYLLTBL + " (" +
                Main.SPELLED + ", " +
                Main.PHONETIC + ", " +
                Main.POSITION + ", " +
                Main.SYLLTYPE + ", " +
                Main.MEANING + ", " +
                Main.SVOW + ", " +
                Main.SELF + ", " +
                Main.FSYLL + ", " +
                Main.DATEADDED + ") " +
                "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement prepStmt = DBConnection.dbConnector().prepareStatement(dmlString)) {
//            PreparedStatement prepStmt = DBConnection.dbConnector().prepareStatement(dmlString);
            prepStmt.setString(1, inputSyll.getSpelling());
            prepStmt.setString(2, inputSyll.getPhonetic());
            prepStmt.setString(3, inputSyll.getPosition());
            prepStmt.setString(4, inputSyll.getSyllType());
            prepStmt.setString(5, inputSyll.getMeaning());
            prepStmt.setBoolean(6, inputSyll.issVowelFlag());
            prepStmt.setBoolean(7, inputSyll.isSelfFlag());
            prepStmt.setString(8, inputSyll.getFollowSyll().toString());
            prepStmt.setString(9, inputSyll.getDateAdded());
            prepStmt.execute();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
//        prepStmt.close();
    }
}
