package ru.kpfu.itis403.Utilities;


import java.sql.*;

public final class Database {

    private Connection conn;
    private static Database database;
    private static final String URL           = "jdbc:sqlserver://localhost:1434;databasename=MelomanGuide";
    private static final String USER_NAME     = "sa";
    private static final String PASSWORD      = "azatay12";


    private Database() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            this.conn = DriverManager.getConnection(URL,USER_NAME,PASSWORD);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Database getInstance() {

        if(database == null) {
            synchronized (Database.class) {
                if(database == null) {
                    database = new Database();
                }
            }
        }
        return database;
    }

    public static Connection getConnection(){

        return Database.getInstance().conn;
    }

}