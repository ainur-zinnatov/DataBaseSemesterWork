package ru.kpfu.itis403.entities;

/**
 * Created by hp on 12.12.2015.
 */
public class Song {
    private String Name;
    private String Singer;
    private String Group;
    private String Genre;
    private String Disk;

    public Song(String name, String singer, String group, String genre, String disk) {
        Name = name;
        Singer = singer;
        Group = group;
        Genre = genre;
        Disk = disk;
    }

    public Song(String name) {
        Name = name;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSinger() {
        return Singer;
    }

    public void setSinger(String singer) {
        Singer = singer;
    }

    public String getGroup() {
        return Group;
    }

    public void setGroup(String group) {
        Group = group;
    }

    public String getGenre() {
        return Genre;
    }

    public void setGenre(String genre) {
        Genre = genre;
    }

    public String getDisk() {
        return Disk;
    }

    public void setDisk(String disk) {
        Disk = disk;
    }
}
