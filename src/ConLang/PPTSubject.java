package ConLang;

import com.sun.xml.internal.bind.v2.model.core.ID;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PPTSubject {

    private int pptSubjectID;
    private int wordID;
    private String pptName;
    private String archeType;
    private String description;
    private String dateAdded;
    //TODO Move this to ConWord
    private ObservableList<ConWord> lexiConWords;
    private static ObservableList<PPTSubject> pptSubjects = FXCollections.observableArrayList();

    public PPTSubject(int pptSubjectID, int wordID, String pptName, String archeType, String description, String dateAdded) {
        this.pptSubjectID = pptSubjectID;
        this.wordID = wordID;
        this.pptName = pptName;
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

    public String getPptName() {
        return pptName;
    }

    public void setPptName(String pptName) {
        this.pptName = pptName;
    }

    public ObservableList<ConWord> getLexiConWords() {
        return lexiConWords;
    }

    public void setLexiConWords(ObservableList<ConWord> lexiConWords) {
        this.lexiConWords = lexiConWords;
    }

    public static ObservableList<PPTSubject> getPptSubjects() {
        return pptSubjects;
    }

    public static void setPptSubjects(ObservableList<PPTSubject> pptSubjects) {
        PPTSubject.pptSubjects = pptSubjects;
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
        pptSubjects.clear();
        String dmlString = "SELECT " + Main.PREFIXPPT+Main.ID +
                ", " + Main.PREFIXWORD+Main.SPELLED +
                ", " + Main.PREFIXPPT+Main.ARCH +
                ", " + Main.PREFIXPPT+Main.DESC +
                ", " + Main.PREFIXPPT+Main.DATEADDED +
                " FROM " + Main.PPTTBL + " LEFT JOIN " + Main.WORDTBL +
                " ON " + Main.PREFIXPPT+Main.WID + " = " + Main.PREFIXWORD+Main.ID +
                " WHERE " + Main.PREFIXPPT+Main.DESC + " LIKE ?";
        PreparedStatement prepStmt = DBConnection.dbConnector().prepareStatement(dmlString);
        prepStmt.setString(1, "%" + searchTxt + "%");
        prepStmt.execute();
        ResultSet quResults = prepStmt.getResultSet();
        while (quResults.next()){
            PPTSubject newSubject = new PPTSubject();
            newSubject.setPptSubjectID(quResults.getInt(1));
            if (quResults.getString(2) == null){
                newSubject.setPptName("Not Assigned");
            } else {
                newSubject.setPptName(quResults.getString(2));
            }
            newSubject.setArcheType(quResults.getString(3));
            newSubject.setDescription(quResults.getString(4));
            newSubject.setDateAdded(quResults.getString(5));
            pptSubjects.add(newSubject);
        }
        DBConnection.dbConnector().close();
    }

    public static void deletePPTSubject(PPTSubject delSubject) throws SQLException {
        String dmlString = "DELETE FROM " + Main.PPTTBL + " WHERE " + Main.ID + " = ?";
        PreparedStatement prepStmt = DBConnection.dbConnector().prepareStatement(dmlString);
        prepStmt.setInt(1, delSubject.getPptSubjectID());
        prepStmt.execute();
        DBConnection.dbConnector().close();
    }

//    public static void modifyPPTSubject(PPTSubject modSubject) throws SQLException {
//        String dmlString = "UPDATE " + Main.PPTTBL +
//                " SET " + Main.ARCH + " = ?, " + Main.DESC + " = ? " +
//                "WHERE " + Main.ID + " = ?";
//        PreparedStatement prepStmt = DBConnection.dbConnector().prepareStatement(dmlString);
//        prepStmt.setString(1, modSubject.getArcheType());
//        prepStmt.setString(2, modSubject.getDescription());
//        prepStmt.setInt(3, modSubject.getPptSubjectID());
//        prepStmt.execute();
//        DBConnection.dbConnector().close();
//    }

    public static void modifyPPTSubject(PPTSubject modSubject) throws SQLException {
        String dmlString = "UPDATE " + Main.PPTTBL +
                " SET wordId = ?, " + Main.ARCH + " = ?, " + Main.DESC + " = ? " +
                "WHERE " + Main.ID + " = ?";
        PreparedStatement prepStmt = DBConnection.dbConnector().prepareStatement(dmlString);
        prepStmt.setInt(1, modSubject.getWordID());
        prepStmt.setString(2, modSubject.getArcheType());
        prepStmt.setString(3, modSubject.getDescription());
        prepStmt.setInt(4, modSubject.getPptSubjectID());
        prepStmt.execute();
        DBConnection.dbConnector().close();
    }
}
