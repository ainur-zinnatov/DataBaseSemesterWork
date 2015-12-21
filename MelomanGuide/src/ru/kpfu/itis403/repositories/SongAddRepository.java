package ru.kpfu.itis403.repositories;

import ru.kpfu.itis403.Utilities.Database;
import ru.kpfu.itis403.entities.Song;
import ru.kpfu.itis403.exceptions.SQLExcept;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by hp on 14.12.2015.
 */
public class SongAddRepository {
    public static void addSong(Song song) throws SQLException, SQLExcept {

        if (song.getName().isEmpty()){
            throw new SQLExcept("Song is empty!");
        }else if (song.getGenre().isEmpty()){
            throw new SQLExcept("Genre is empty!");
        }else if(song.getDisk().isEmpty()){
            throw new SQLExcept("Disk is empty!");
        }else if(!GSIsValid(song.getDisk())){
            throw new SQLExcept("Disk is not valid!");
        }else if(!GSIsValid(song.getGenre())){
            throw new SQLExcept("Genre is not valid!");
        }else if(!GSIsValid(song.getName())){
            throw new SQLExcept("Song name is not valid!");
        }if (!GSIsValid(song.getGroup()) && !GSIsValid(song.getSinger())) {
            throw new SQLExcept("Group or Singer is not valid!");
        }

        try {


            String q = "INSERT INTO SONG(NAME) VALUES( ? ) ;";
            PreparedStatement p = Database.getConnection().prepareStatement(q);
            p.setNString(1, song.getName());
            p.executeUpdate();


            String d = "INSERT INTO GENRE(NAME) VALUES( ? ) ;";
            PreparedStatement p1 = Database.getConnection().prepareStatement(d);
            p1.setNString(1, song.getGenre());
            p1.executeUpdate();


            String d2 = "INSERT INTO NDISK(NAME) VALUES( ? ) ;";
            PreparedStatement p2 = Database.getConnection().prepareStatement(d2);
            p2.setNString(1, song.getDisk());
            p2.executeUpdate();
            if (song.getSinger() == "") {
                String d3 = "INSERT INTO NGROUP(NAME) VALUES( ? ) ;";
                System.out.println(1);
                PreparedStatement p3 = Database.getConnection().prepareStatement(d3);
                p3.setNString(1, song.getGroup());
                p3.executeUpdate();
            } else {
                System.out.println(2);
                String d4 = "INSERT INTO SINGER(NAME) VALUES( ? ) ;";
                PreparedStatement p4 = Database.getConnection().prepareStatement(d4);
                p4.setNString(1, song.getSinger());
                p4.executeUpdate();
            }
            String d5 = "INSERT INTO DISKANDSONG(DISK_ID, SONG_ID)  VALUES( (SELECT MIN(DISTINCT(d.ID)) FROM NDISK d WHERE d.NAME =?),(SELECT MIN(DISTINCT(s.ID)) FROM SONG s WHERE s.NAME =?) ) ;";
            PreparedStatement p5 = Database.getConnection().prepareStatement(d5);
            p5.setNString(1, song.getDisk());
            p5.setNString(2, song.getName());
            p5.executeUpdate();
            if (song.getGroup() != "") {
                String d6 = "INSERT INTO SONGANDGROUP(SONG_ID,  GROUP_ID)   VALUES( (SELECT MIN(DISTINCT(s.ID)) FROM SONG s WHERE s.NAME =?),(SELECT MIN(DISTINCT(g.ID)) FROM NGROUP g WHERE g.NAME =?) ) ;";
                System.out.println(1);
                PreparedStatement p6 = Database.getConnection().prepareStatement(d6);
                p6.setNString(1, song.getName());
                p6.setNString(2, song.getGroup());
                p6.executeUpdate();
            } else {
                String d6 = "INSERT INTO SONGANDGROUP(SONG_ID,  SINGER_ID)   VALUES( (SELECT MIN(DISTINCT(s.ID)) FROM SONG s WHERE s.NAME =?),(SELECT MIN(DISTINCT(s.ID)) FROM SINGER s WHERE s.NAME =?) ) ;";
                System.out.println(2);
                PreparedStatement p6 = Database.getConnection().prepareStatement(d6);
                p6.setNString(1, song.getName());
                p6.setNString(2, song.getSinger());
                p6.executeUpdate();
            }
            String d7 = "INSERT INTO SONGGENRE(SONG_ID,  GENRE_ID)   VALUES( (SELECT MIN(DISTINCT(s.ID)) FROM SONG s WHERE s.NAME =?),(SELECT MIN(DISTINCT(g.ID)) FROM GENRE g WHERE g.NAME =?) ) ;";
            PreparedStatement p7 = Database.getConnection().prepareStatement(d7);
            p7.setNString(1, song.getName());
            p7.setNString(2, song.getGenre());
            p7.executeUpdate();
            if (song.getGroup() == "") {
                String d8 = "INSERT INTO DISKANDSINGER(SINGER_ID,  DISK_ID)   VALUES( (SELECT MIN(DISTINCT(s.ID)) FROM SINGER s WHERE s.NAME =?),(SELECT MIN(DISTINCT(d.ID)) FROM NDISK d WHERE d.NAME =?) ) ;";
                PreparedStatement p8 = Database.getConnection().prepareStatement(d8);
                p8.setNString(1, song.getSinger());
                p8.setNString(2, song.getDisk());
                p8.executeUpdate();
            } else {
                String d9 = "INSERT INTO DISKANDGROUP(GROUP_ID,  DISK_ID)   VALUES( (SELECT MIN(DISTINCT(g.ID)) FROM NGROUP g WHERE g.NAME =?),(SELECT MIN(DISTINCT(d.ID)) FROM NDISK d WHERE d.NAME =?) ) ;";
                PreparedStatement p9 = Database.getConnection().prepareStatement(d9);
                p9.setNString(1, song.getGroup());
                p9.setNString(2, song.getDisk());
                p9.executeUpdate();
            }
            if (song.getGroup() == "") {
                String d10 = "INSERT INTO SINGERANDGENRE(SINGER_ID,  GENRE_ID)   VALUES( (SELECT MIN(DISTINCT(s.ID)) FROM SINGER s WHERE s.NAME =?),(SELECT MIN(DISTINCT(d.ID)) FROM GENRE d WHERE d.NAME =?) ) ;";
                PreparedStatement p10 = Database.getConnection().prepareStatement(d10);
                p10.setNString(1, song.getSinger());
                p10.setNString(2, song.getGenre());
                p10.executeUpdate();
            } else {
                String d11 = "INSERT INTO GROUPANDGENRE(GROUP_ID,  GENRE_ID)   VALUES( (SELECT MIN(DISTINCT(g.ID)) FROM NGROUP g WHERE g.NAME =?),(SELECT MIN(DISTINCT(d.ID)) FROM GENRE d WHERE d.NAME =?) ) ;";
                PreparedStatement p11 = Database.getConnection().prepareStatement(d11);
                p11.setNString(1, song.getGroup());
                p11.setNString(2, song.getGenre());
                p11.executeUpdate();
            }

        }
        catch (SQLException e){
            throw new SQLExcept(e.getMessage());
        }
    }
    public static boolean GSIsValid(String name) {
        Pattern pattern = Pattern.compile("^[A-Za-z0-9_-]{1,50}$");
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }

}

