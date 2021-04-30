package ConLang;

import java.sql.*;

public class DBConnection {

    public static void execSQL(String sqlCode){
        try {
            Connection dbConnect = DriverManager.getConnection(Main.DBINFO);
            Statement varStatement = dbConnect.createStatement();
            varStatement.execute(sqlCode);
            varStatement.close();
            dbConnect.close();
        } catch (SQLException sqlE) {
            System.out.println("SQL Problem " + sqlE.getMessage());
        }
    }

    public static Connection dbConnector(){
        try {
            Connection dbConnect = DriverManager.getConnection(Main.DBINFO);
            return dbConnect;
        } catch (SQLException sqlE) {
            System.out.println("SQL Problem " + sqlE.getMessage());
            return null;
        }
    }

    public static void  createTables(){
        execSQL("CREATE TABLE IF NOT EXISTS conSyll " +
                "(" + Main.ID + " INTEGER, " +
                Main.SPELLED + " TEXT NOT NULL, " +
                Main.PHONETIC + " TEXT NOT NULL, " +
                Main.POSITION + " TEXT NOT NULL, " +
                Main.SYLLTYPE + " TEXT NOT NULL, " +
                Main.MEANING + " TEXT, " +
                Main.SVOW + " TEXT NOT NULL, " +
                Main.SELF + " TEXT NOT NULL, " +
                Main.FSYLL + " TEXT NOT NULL, " +
                Main.DATEADDED + " TEXT NOT NULL, " +
                "PRIMARY KEY(" + Main.ID + " AUTOINCREMENT))");
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
