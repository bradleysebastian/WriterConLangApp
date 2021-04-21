package ConLang;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PPTSubject {

    private int pptSubjectID;
    private int wordID;
    private String archeType;
    private String description;
    private String dateAdded;
    //TODO Move this to ConWord
    private ObservableList<ConWord> lexiConWords;
    private static ObservableList<PPTSubject> pptSubjects = FXCollections.observableArrayList();

    public PPTSubject(int pptSubjectID, int wordID, String archeType, String description, String dateAdded) {
        this.pptSubjectID = pptSubjectID;
        this.wordID = wordID;
        this.archeType = archeType;
        this.description = description;
        this.dateAdded = dateAdded;
    }

    public PPTSubject() {
    }

    public int getPptSubjectID() {
        return pptSubjectID;
    }

    public void setPptSubjectID(int pptSubjectID) {
        this.pptSubjectID = pptSubjectID;
    }

    public int getWordID() {
        return wordID;
    }

    public void setWordID(int wordID) {
        this.wordID = wordID;
    }

    public String getArcheType() {
        return archeType;
    }

    public void setArcheType(String archeType) {
        this.archeType = archeType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(String dateAdded) {
        this.dateAdded = dateAdded;
    }

    public ObservableList<ConWord> getLexiConWords() {
        return lexiConWords;
    }

    public void setLexiConWords(ObservableList<ConWord> lexiConWords) {
        this.lexiConWords = lexiConWords;
    }

    public void storePPTSubject(PPTSubject newSubject) throws SQLException {
        String dmlString = "INSERT INTO " + Main.PPTTBL + " (" + Main.ARCH + ", " + Main.DESC + ", " + Main.DATEADDED + ")" +
                "VALUES (?, ?, ?)";
        PreparedStatement prepStmt = DBConnection.dbConnector().prepareStatement(dmlString);
        prepStmt.setString(1, newSubject.getArcheType());
        prepStmt.setString(2, newSubject.getDescription());
        prepStmt.setString(3, newSubject.getDateAdded());
        prepStmt.execute();
        DBConnection.dbConnector().close();
    }
    public static void populatePPTSubjects(String searchTxt) throws SQLException {
        String dmlString = "SELECT * FROM " + Main.PPTTBL + " WHERE " + Main.DESC + " LIKE ?";
        PreparedStatement prepStmt = DBConnection.dbConnector().prepareStatement(dmlString);
        prepStmt.setString(1, "%" + searchTxt + "%");
        prepStmt.execute();
        ResultSet quResults = prepStmt.getResultSet();
        while (quResults.next()){
            //Build PPTSubject object
            PPTSubject newSubject = new PPTSubject();
            newSubject.setPptSubjectID(quResults.getInt(1));
            newSubject.setWordID(quResults.getInt(2));
            newSubject.setArcheType(quResults.getString(3));
            newSubject.setDescription(quResults.getString(4));
            newSubject.setDateAdded(quResults.getString(5));
            pptSubjects.add(newSubject);
        }
        DBConnection.dbConnector().close();
    }
}
