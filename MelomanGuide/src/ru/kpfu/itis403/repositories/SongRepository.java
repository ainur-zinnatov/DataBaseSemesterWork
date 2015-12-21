package ru.kpfu.itis403.repositories;

import ru.kpfu.itis403.Utilities.Database;
import ru.kpfu.itis403.entities.Song;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hp on 13.12.2015.
 */
public class SongRepository {
    //delete
    public static void deleteFromSong(String name) throws SQLException {

        String q = "EXECUTE deleteFromSong '"+name+"';";

        Database.getConnection().createStatement().execute(q);

    }
    public static void deleteFromGroup(String name) throws SQLException {

        String q = "EXECUTE deleteFromGroup '"+name+"';";

        Database.getConnection().createStatement().execute(q);

    }
    public static void deleteFromDisk(String name) throws SQLException {

        String q = "EXECUTE deleteFromDisk '"+name+"';";

        Database.getConnection().createStatement().execute(q);

    }

    public static void deleteFromSinger(String name) throws SQLException {

        String q = "EXECUTE deleteFromSinger '"+name+"';";

        Database.getConnection().createStatement().execute(q);

    }

    //get
    public static List<Song> getSongByGroup(String group) throws SQLException {
        List<Song> songs = new ArrayList<>();
        String q = "EXECUTE getSoundFromGroup '"+group+"';";

        ResultSet set = Database.getConnection().createStatement().executeQuery(q);

        while (set.next()){
            songs.add(new Song(
                            set.getNString(1)
                    )
            );
        }
        return songs;
    }
    public static List<Song> getSoundByGenre(String genre) throws SQLException {
        List<Song> songs = new ArrayList<>();
        String q = "EXECUTE getSoundFromGenre '"+genre+"';";

        ResultSet set = Database.getConnection().createStatement().executeQuery(q);

        while (set.next()){
            songs.add(new Song(
                            set.getNString(1)
                    )
            );
        }
        return songs;
    }

    public static List<Song>  getSoundFromSinger(String singer) throws SQLException {
        List<Song> songs = new ArrayList<>();
        String q = "EXECUTE getSoundFromSinger '"+singer+"';";

        ResultSet set = Database.getConnection().createStatement().executeQuery(q);

        while (set.next()){
            songs.add(new Song(
                            set.getNString(1)
                    )
            );
        }
        return songs;
    }
    public static List<Song>  getSoundFromDisk(String disk) throws SQLException {
        List<Song> songs = new ArrayList<>();
        String q = "EXECUTE getSoundFromDisk '"+disk+"';";

        ResultSet set = Database.getConnection().createStatement().executeQuery(q);

        while (set.next()){
            songs.add(new Song(
                            set.getNString(1)
                    )
            );
        }
        return songs;
    }
    public static List<Song> getGroupByGenre(String genre) throws SQLException {
        List<Song> songs = new ArrayList<>();
        String q = "EXECUTE getGroupByGenre '"+genre+"';";

        ResultSet set = Database.getConnection().createStatement().executeQuery(q);

        while (set.next()){
            songs.add(new Song(
                            set.getNString(1)
                    )
            );
        }
        return songs;
    }
    public static List<Song> getGroupBySong(String song) throws SQLException {
        List<Song> songs = new ArrayList<>();
        String q = "EXECUTE getGroupBySong '"+song+"';";

        ResultSet set = Database.getConnection().createStatement().executeQuery(q);

        while (set.next()){
            songs.add(new Song(
                            set.getNString(1)
                    )
            );
        }
        return songs;
    }
    public static List<Song> getGroupByDisk(String song) throws SQLException {
        List<Song> songs = new ArrayList<>();
        String q = "EXECUTE getGroupByDisk '"+song+"';";

        ResultSet set = Database.getConnection().createStatement().executeQuery(q);

        while (set.next()){
            songs.add(new Song(
                            set.getNString(1)
                    )
            );
        }
        return songs;
    }
    public static List<Song> getSingerByGenre(String genre) throws SQLException {
        List<Song> songs = new ArrayList<>();
        String q = "EXECUTE getSingerByGenre '"+genre+"';";

        ResultSet set = Database.getConnection().createStatement().executeQuery(q);

        while (set.next()){
            songs.add(new Song(
                            set.getNString(1)
                    )
            );
        }
        return songs;
    }
    public static List<Song> getSingerByDisk(String disk) throws SQLException {
        List<Song> songs = new ArrayList<>();
        String q = "EXECUTE getSingerByDisk '"+disk+"';";

        ResultSet set = Database.getConnection().createStatement().executeQuery(q);

        while (set.next()){
            songs.add(new Song(
                            set.getNString(1)
                    )
            );
        }
        return songs;
    }
    public static List<Song> getSingerBySong(String song) throws SQLException {
        List<Song> songs = new ArrayList<>();
        String q = "EXECUTE getSingerBySong '"+song+"';";

        ResultSet set = Database.getConnection().createStatement().executeQuery(q);

        while (set.next()){
            songs.add(new Song(
                            set.getNString(1)
                    )
            );
        }
        return songs;
    }
    public static List<Song> getDiskFromSound(String sound) throws SQLException {
        List<Song> songs = new ArrayList<>();
        String q = "EXECUTE getDiskFromSound '"+sound+"';";

        ResultSet set = Database.getConnection().createStatement().executeQuery(q);

        while (set.next()){
            songs.add(new Song(
                            set.getNString(1)
                    )
            );
        }
        return songs;
    }
    public static List<Song> getDiskFromGroup(String group) throws SQLException {
        List<Song> songs = new ArrayList<>();
        String q = "EXECUTE getDiskFromGroup '"+group+"';";

        ResultSet set = Database.getConnection().createStatement().executeQuery(q);

        while (set.next()){
            songs.add(new Song(
                            set.getNString(1)
                    )
            );
        }
        return songs;
    }public static List<Song> getDiskFromSinger(String singer) throws SQLException {
        List<Song> songs = new ArrayList<>();
        String q = "EXECUTE getDiskFromSinger '"+singer+"';";

        ResultSet set = Database.getConnection().createStatement().executeQuery(q);

        while (set.next()){
            songs.add(new Song(
                            set.getNString(1)
                    )
            );
        }
        return songs;
    }
    public static List<Song> getSongFromGenreAndDisk(String genre, String disk) throws SQLException {
        List<Song> songs = new ArrayList<>();
        String q = "EXECUTE getSongFromGenreAndDisk '"+genre+"', '"+disk+"'";

        ResultSet set = Database.getConnection().createStatement().executeQuery(q);

        while (set.next()){
            songs.add(new Song(
                            set.getNString(1)
                    )
            );
        }
        return songs;
    }
    public static List<Song> getSongFromGenreAndGroup(String genre, String group) throws SQLException {
        List<Song> songs = new ArrayList<>();
        String q = "EXECUTE getSongFromGenreAndGroup '"+genre+"', '"+group+"'";

        ResultSet set = Database.getConnection().createStatement().executeQuery(q);

        while (set.next()){
            songs.add(new Song(
                            set.getNString(1)
                    )
            );
        }
        return songs;
    }
    public static List<Song> getSongFromGroupAndDisk(String group, String disk) throws SQLException {
        List<Song> songs = new ArrayList<>();
        String q = "EXECUTE getSongFromGroupAndDisk '"+group+"', '"+disk+"'";

        ResultSet set = Database.getConnection().createStatement().executeQuery(q);

        while (set.next()){
            songs.add(new Song(
                            set.getNString(1)
                    )
            );
        }
        return songs;
    }
    public static List<Song> getSongFromSingerAndGenre(String singer, String genre) throws SQLException {
        List<Song> songs = new ArrayList<>();
        String q = "EXECUTE getSongFromSingerAndGenre '"+singer+"', '"+genre+"'";

        ResultSet set = Database.getConnection().createStatement().executeQuery(q);

        while (set.next()){
            songs.add(new Song(
                            set.getNString(1)
                    )
            );
        }
        return songs;
    }
    public static List<Song> getSongFromSingerAndDisk(String singer, String disk) throws SQLException {
        List<Song> songs = new ArrayList<>();
        String q = "EXECUTE getSongFromSingerAndDisk '"+singer+"', '"+disk+"'";

        ResultSet set = Database.getConnection().createStatement().executeQuery(q);

        while (set.next()){
            songs.add(new Song(
                            set.getNString(1)
                    )
            );
        }
        return songs;
    }
    public static List<Song> getSongFromGroupGenreDisk(String group, String genre, String disk) throws SQLException {
        List<Song> songs = new ArrayList<>();
        String q = "EXECUTE getSongFromGroupGenreDisk '"+group+"', '"+genre+"', '"+disk+"'";

        ResultSet set = Database.getConnection().createStatement().executeQuery(q);

        while (set.next()){
            songs.add(new Song(
                            set.getNString(1)
                    )
            );
        }
        return songs;
    }
    public static List<Song> getSongFromSingerGenreDisk(String singer, String genre, String disk) throws SQLException {
        List<Song> songs = new ArrayList<>();
        String q = "EXECUTE getSongFromSingerGenreDisk '"+singer+"', '"+genre+"', '"+disk+"'";

        ResultSet set = Database.getConnection().createStatement().executeQuery(q);

        while (set.next()){
            songs.add(new Song(
                            set.getNString(1)
                    )
            );
        }
        return songs;
    }
    public static List<Song> getDiskFromSongAndGroup(String song, String group) throws SQLException {
        List<Song> songs = new ArrayList<>();
        String q = "EXECUTE getDiskFromSongAndGroup '"+song+"', '"+group+"'";

        ResultSet set = Database.getConnection().createStatement().executeQuery(q);

        while (set.next()){
            songs.add(new Song(
                            set.getNString(1)
                    )
            );
        }
        return songs;
    }
    public static List<Song> getDiskFromSongAndSinger(String song, String singer) throws SQLException {
        List<Song> songs = new ArrayList<>();
        String q = "EXECUTE getDiskFromSongAndSinger '"+song+"', '"+singer+"'";

        ResultSet set = Database.getConnection().createStatement().executeQuery(q);

        while (set.next()){
            songs.add(new Song(
                            set.getNString(1)
                    )
            );
        }
        return songs;
    }

    public static List<Song> getGroupFromDiskAndGenre(String disk, String genre) throws SQLException {
        List<Song> songs = new ArrayList<>();
        String q = "EXECUTE getGroupFromDiskAndGenre '"+disk+"', '"+genre+"'";

        ResultSet set = Database.getConnection().createStatement().executeQuery(q);

        while (set.next()){
            songs.add(new Song(
                            set.getNString(1)
                    )
            );
        }
        return songs;
    }
    public static List<Song> getGroupFromDiskAndSong(String disk, String song) throws SQLException {
        List<Song> songs = new ArrayList<>();
        String q = "EXECUTE getGroupFromDiskAndSong '"+disk+"', '"+song+"'";

        ResultSet set = Database.getConnection().createStatement().executeQuery(q);

        while (set.next()){
            songs.add(new Song(
                            set.getNString(1)
                    )
            );
        }
        return songs;
    }

    public static List<Song> getSingerFromDiskAndGenre(String disk, String genre) throws SQLException {
        List<Song> songs = new ArrayList<>();
        String q = "EXECUTE getSingerFromDiskAndGenre '"+disk+"', '"+genre+"'";

        ResultSet set = Database.getConnection().createStatement().executeQuery(q);

        while (set.next()){
            songs.add(new Song(
                            set.getNString(1)
                    )
            );
        }
        return songs;
    }
    public static List<Song> getSingerFromDiskAndSong(String disk, String song) throws SQLException {
        List<Song> songs = new ArrayList<>();
        String q = "EXECUTE getSingerFromDiskAndSong '"+disk+"', '"+song+"'";

        ResultSet set = Database.getConnection().createStatement().executeQuery(q);

        while (set.next()){
            songs.add(new Song(
                            set.getNString(1)
                    )
            );
        }
        return songs;
    }
}
