package ConLang;

import java.sql.*;

public class DBConnection {

    public static void execSQL(String sqlCode){
        try {
            Connection dbConnect = DriverManager.getConnection("jdbc:sqlite:ConLang.db");
            Statement varStatement = dbConnect.createStatement();
            varStatement.execute(sqlCode);
            varStatement.close();
            dbConnect.close();
        } catch (SQLException sqlE) {
            System.out.println("SQL Problem " + sqlE.getMessage());
        }
    }

    public static void  createTables(){
        execSQL("CREATE TABLE IF NOT EXISTS conSyll " +
                "(_id INTEGER, " +
                "spelled TEXT NOT NULL, " +
                "phonetic TEXT NOT NULL, " +
                "position TEXT NOT NULL, " +
                "syllType TEXT NOT NULL, " +
                "meaning TEXT, " +
                "dateAdded TEXT NOT NULL, " +
                "PRIMARY KEY(_id AUTOINCREMENT))");
        execSQL("CREATE TABLE IF NOT EXISTS conWord " +
                "(_id INTEGER, " +
                "spelled TEXT NOT NULL, " +
                "phonetic TEXT NOT NULL, " +
                "wordType TEXT NOT NULL, " +
                "meaning TEXT, " +
                "dateAdded TEXT NOT NULL, " +
                "PRIMARY KEY(_id AUTOINCREMENT))");
        execSQL("CREATE TABLE IF NOT EXISTS conPPT " +
                "(_id	INTEGER," +
                "wordId	INTEGER, " +
                "archeType TEXT NOT NULL, " +
                "description TEXT NOT NULL, " +
                "dateAdded TEXT NOT NULL, " +
                "PRIMARY KEY(_id AUTOINCREMENT), " +
                "FOREIGN KEY(wordId) REFERENCES conWord(_id) " +
                "ON UPDATE CASCADE)");
    }

}
