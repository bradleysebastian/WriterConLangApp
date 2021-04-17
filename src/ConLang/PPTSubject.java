package ConLang;

import javafx.collections.ObservableList;

public class PPTSubject {

    private int pptSubjectID;
    private int wordID;
    private String archeType;
    private String description;
    private String dateAdded;
    //TODO Move this to ConWord
    private ObservableList<ConWord> lexiConWords;

    public PPTSubject(int pptSubjectID, int wordID, String archeType, String description, String dateAdded,
                      ObservableList<ConWord> lexiConWords) {
        this.pptSubjectID = pptSubjectID;
        this.wordID = wordID;
        this.archeType = archeType;
        this.description = description;
        this.dateAdded = dateAdded;
        this.lexiConWords = lexiConWords;
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
}
