package ru.kpfu.itis403.forms;

import ru.kpfu.itis403.entities.Song;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import static ru.kpfu.itis403.forms.SoundForm.AddSongGUI;
import static ru.kpfu.itis403.repositories.SongRepository.*;


/**
 * Created by hp on 12.12.2015.
 */
public class SoundSearchForn {
    public static String searchType ="Song";
    public static void createGUI() {

        JFrame.setDefaultLookAndFeelDecorated(true);
        final JFrame frame = new JFrame("Product");

        JPanel panel = new JPanel();


        panel.setLayout(null);

        String [] columns = new String[] {"Result"};
        // String[][] data = ProductRepository.getTable();

        String[][] data =  new String[10][1];
        JTable table = new JTable(data, columns);
        String[] items_sw = { "Song", "Disk", "Group", "Singer"};


        final JLabel message = new JLabel(":");
        message.setBounds(200, 10, 400, 25);
        panel.add(message);
//serach
        final JLabel searchWhat = new JLabel("Search what:");
        searchWhat.setBounds(10, 10, 220, 25);
        panel.add(searchWhat);

        JComboBox combo4 = new JComboBox(items_sw);
        combo4.setBounds(100, 10, 60, 25);
        panel.add(combo4);
//result
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setSize(590,170);
        scrollPane.setLocation(0,180);
       panel.add(scrollPane);

        frame.getContentPane().setLayout(new BorderLayout());
        frame.getContentPane().add(panel);

  //song
        final JTextField textSong = new JTextField();
        textSong.setBounds(100, 50, 200, 25);
        panel.add(textSong);


        final JLabel labelSong = new JLabel("Song:");
        labelSong.setBounds(10, 50, 220, 25);
        panel.add(labelSong);

        final JRadioButton rbSong = new JRadioButton("");
        rbSong.setBounds(300, 50, 30, 30);
        panel.add(rbSong);
        rbSong.setEnabled(false);
        textSong.setEnabled(false);
        labelSong.setEnabled(false);

        rbSong.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(rbSong.isSelected()){
                    textSong.setEnabled(true);
                    labelSong.setEnabled(true);
                }else {
                    textSong.setEnabled(false);
                    labelSong.setEnabled(false);
                }
            }});
//group
        final JTextField textName = new JTextField();
        textName.setBounds(100, 140, 200, 25);
        panel.add(textName);

        String[] items = {"Group", "Singer"};
        JComboBox comboGroupSinger = new JComboBox(items);
        comboGroupSinger.setBounds(8, 140, 70, 25);
        panel.add(comboGroupSinger);
        JComboBox combo= new JComboBox(items);

        final JRadioButton rbSGroup = new JRadioButton("");
        rbSGroup.setBounds(300, 140, 30, 30);
        panel.add(rbSGroup);

        textName.setEnabled(false);
        comboGroupSinger.setEnabled(false);

        rbSGroup.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(rbSGroup.isSelected()){
                    textName.setEnabled(true);
                    comboGroupSinger.setEnabled(true);
                }else {
                    textName.setEnabled(false);
                    comboGroupSinger.setEnabled(false);
                }
            }});
//genre
        final JTextField textGenre = new JTextField();
        textGenre.setBounds(100, 80, 200, 25);
        panel.add(textGenre);


        final JLabel label2 = new JLabel("Genre:");
        label2.setBounds(10, 80, 220, 25);
        panel.add(label2);

        final JRadioButton rbGenre = new JRadioButton("");
        rbGenre.setBounds(300, 80, 30, 30);
        panel.add(rbGenre);

        textGenre.setEnabled(false);
        label2.setEnabled(false);

        rbGenre.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(rbGenre.isSelected()){
                    textGenre.setEnabled(true);
                    label2.setEnabled(true);
                }else {
                    textGenre.setEnabled(false);
                    label2.setEnabled(false);
                }

                if(combo4.getSelectedItem()=="Group" || combo4.getSelectedItem()=="Singer"){
                    if(rbGenre.isSelected()){
                        textSong.setEnabled(false);
                        labelSong.setEnabled(false);
                        rbSong.setEnabled(false);
                        rbSong.setSelected(false);
                    }else {
                        rbSong.setEnabled(true);
                    }
                }
            }});
 //disk
        final JTextField textDisk = new JTextField();
        textDisk.setBounds(100, 110, 200, 25);
        panel.add(textDisk);


        final JLabel labelDisk = new JLabel("Disk:");
        labelDisk.setBounds(10, 110, 220, 25);
        panel.add(labelDisk);

        final JRadioButton rbDisk = new JRadioButton("");
        rbDisk.setBounds(300, 110, 30, 30);
        panel.add(rbDisk);

        textDisk.setEnabled(false);
        labelDisk.setEnabled(false);

        rbDisk.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(rbDisk.isSelected()){
                    textDisk.setEnabled(true);
                    labelDisk.setEnabled(true);
                }else {
                    textDisk.setEnabled(false);
                    labelDisk.setEnabled(false);
                }
                if(combo4.getSelectedItem()=="Group" || combo4.getSelectedItem()=="Singer"){
                    if(rbDisk.isSelected() && !rbGenre.isSelected()){
                        rbSong.setEnabled(true);
                    }
                }
            }});




        combo4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (combo4.getSelectedItem() == "Song") {
                    searchType="Song";
                    textSong.setEnabled(false);
                    labelSong.setEnabled(false);
                    textDisk.setEnabled(false);
                    labelDisk.setEnabled(false);
                    textGenre.setEnabled(false);
                    label2.setEnabled(false);
                    textName.setEnabled(false);
                    comboGroupSinger.setEnabled(false);
                    rbDisk.setSelected(false);
                    rbSGroup.setSelected(false);
                    rbSong.setSelected(false);
                    rbGenre.setSelected(false);
                    rbSong.setEnabled(false);

                    rbDisk.setEnabled(true);

                    rbGenre.setEnabled(true);

                    rbSGroup.setEnabled(true);
                }else if (combo4.getSelectedItem() == "Disk") {
                    searchType="Disk";
                    textSong.setEnabled(false);
                    labelSong.setEnabled(false);
                    textDisk.setEnabled(false);
                    labelDisk.setEnabled(false);
                    textGenre.setEnabled(false);
                    label2.setEnabled(false);
                    textName.setEnabled(false);
                    comboGroupSinger.setEnabled(false);
                    rbDisk.setSelected(false);
                    rbSGroup.setSelected(false);
                    rbSong.setSelected(false);
                    rbGenre.setSelected(false);
                    rbSong.setEnabled(true);


                    rbDisk.setEnabled(false);


                    rbGenre.setEnabled(false);

                    rbSGroup.setEnabled(true);
                }else if (combo4.getSelectedItem() == "Group" || combo4.getSelectedItem() == "Singer") {
                    if(combo4.getSelectedItem() == "Group"){
                        searchType="Group";
                    }else {
                        searchType="Singer";
                    }
                    textSong.setEnabled(false);
                    labelSong.setEnabled(false);
                    textDisk.setEnabled(false);
                    labelDisk.setEnabled(false);
                    textGenre.setEnabled(false);
                    label2.setEnabled(false);
                    textName.setEnabled(false);
                    comboGroupSinger.setEnabled(false);
                    rbDisk.setSelected(false);
                    rbSGroup.setSelected(false);
                    rbSong.setSelected(false);
                    rbGenre.setSelected(false);
                    rbSong.setEnabled(true);


                    rbDisk.setEnabled(true);


                    rbGenre.setEnabled(true);


                    rbSGroup.setEnabled(false);
                }

            }});

//button
        final JButton search = new JButton("Search");
        search.setVerticalTextPosition(AbstractButton.CENTER);
        search.setHorizontalTextPosition(AbstractButton.LEADING);
        search.setBounds(440, 150, 100, 25);
        panel.add(search);

      search.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                    try {



                        if(comboGroupSinger.isEnabled() && comboGroupSinger.getSelectedItem()=="Group" &&
                               !labelDisk.isEnabled()&& !label2.isEnabled() && combo4.getSelectedItem()=="Song") {

                            List<Song> songList = getSongByGroup(textName.getText());
                            String[][] data = new String[songList.size()][1];
                            int i = 0;
                            for (Song song : songList) {
                                data[i][0] = song.getName();

                                i++;
                            }
                            table.setModel(new DefaultTableModel(data, columns));
                            buttons(data,table, columns);
                        }
                        else if(!comboGroupSinger.isEnabled() && textSong.isEnabled() &&
                                !labelDisk.isEnabled()&& !label2.isEnabled() && combo4.getSelectedItem()=="Disk"){
                            List<Song> songList = getDiskFromSound(textSong.getText());
                            String[][] data = new String[songList.size()][1];
                            int i = 0;
                            for (Song song : songList) {
                                data[i][0] = song.getName();

                                i++;
                            }

                            table.setModel(new DefaultTableModel(data, columns));
                            buttons(data,table, columns);
                        }
                        else if(!comboGroupSinger.isEnabled() && !textSong.isEnabled() &&
                                !labelDisk.isEnabled()&& textGenre.isEnabled()  && combo4.getSelectedItem()=="Group"){
                            List<Song> songList = getGroupByGenre(textGenre.getText());
                            String[][] data = new String[songList.size()][1];
                            int i = 0;
                            for (Song song : songList) {
                                data[i][0] = song.getName();

                                i++;
                            }
                            table.setModel(new DefaultTableModel(data, columns));
                            buttons(data,table, columns);
                        }else if(!comboGroupSinger.isEnabled() && textSong.isEnabled() &&
                                !labelDisk.isEnabled()&& !label2.isEnabled()  && combo4.getSelectedItem()=="Group"){
                            List<Song> songList = getGroupBySong(textSong.getText());
                            String[][] data = new String[songList.size()][1];
                            int i = 0;
                            for (Song song : songList) {
                                data[i][0] = song.getName();

                                i++;
                            }
                            table.setModel(new DefaultTableModel(data, columns));
                            buttons(data,table, columns);
                        }else if(!comboGroupSinger.isEnabled() && !textSong.isEnabled() &&
                                labelDisk.isEnabled()&& !label2.isEnabled()  && combo4.getSelectedItem()=="Group"){
                            List<Song> songList = getGroupByDisk(textDisk.getText());
                            String[][] data = new String[songList.size()][1];
                            int i = 0;
                            for (Song song : songList) {
                                data[i][0] = song.getName();

                                i++;
                            }
                            table.setModel(new DefaultTableModel(data, columns));
                            buttons(data,table, columns);
                        }
                        else if(!comboGroupSinger.isEnabled() && !textSong.isEnabled() &&
                                !labelDisk.isEnabled()&& label2.isEnabled()  && combo4.getSelectedItem()=="Singer"){
                            List<Song> songList = getSingerByGenre(textGenre.getText());
                            String[][] data = new String[songList.size()][1];
                            int i = 0;
                            for (Song song : songList) {
                                data[i][0] = song.getName();

                                i++;
                            }
                            table.setModel(new DefaultTableModel(data, columns));
                            buttons(data,table, columns);
                        }else if(!comboGroupSinger.isEnabled() && textSong.isEnabled() &&
                                !labelDisk.isEnabled()&& !label2.isEnabled()  && combo4.getSelectedItem()=="Singer"){
                            List<Song> songList = getSingerBySong(textSong.getText());
                            String[][] data = new String[songList.size()][1];
                            int i = 0;
                          for (Song song : songList) {
                                data[i][0] = song.getName();

                                i++;
                            }
                            table.setModel(new DefaultTableModel(data, columns));
                            buttons(data,table, columns);
                        }
                        else if(!comboGroupSinger.isEnabled() && !textSong.isEnabled() &&
                                labelDisk.isEnabled()&& !label2.isEnabled()  && combo4.getSelectedItem()=="Singer"){
                            List<Song> songList = getSingerByDisk(textDisk.getText());
                            String[][] data = new String[songList.size()][1];
                            int i = 0;
                            for (Song song : songList) {
                                data[i][0] = song.getName();

                                i++;
                            }
                            table.setModel(new DefaultTableModel(data, columns));
                            buttons(data,table, columns);
                        }
                        else if(!comboGroupSinger.isEnabled()&& !textSong.isEnabled() && !labelDisk.isEnabled()&& label2.isEnabled()  && combo4.getSelectedItem()=="Song"){
                            List<Song> songList = getSoundByGenre(textGenre.getText());
                            String[][] data = new String[songList.size()][1];
                            int i = 0;
                            for (Song song : songList) {
                                data[i][0] = song.getName();

                                i++;
                            }
                            table.setModel(new DefaultTableModel(data, columns));
                            buttons(data,table, columns);
                        }
                        else if(comboGroupSinger.isEnabled() && !textSong.isEnabled() &&
                                !labelDisk.isEnabled()&& !label2.isEnabled() && comboGroupSinger.getSelectedItem()=="Singer"  && combo4.getSelectedItem()=="Song"){
                            List<Song> songList = getSoundFromSinger(textName.getText());
                            String[][] data = new String[songList.size()][1];
                            int i = 0;
                            for (Song song : songList) {
                                data[i][0] = song.getName();

                                i++;
                            }
                            table.setModel(new DefaultTableModel(data, columns));
                            buttons(data,table, columns);
                        }
                        else if(comboGroupSinger.isEnabled() && !textSong.isEnabled() &&
                                !labelDisk.isEnabled()&& !label2.isEnabled() && comboGroupSinger.getSelectedItem()=="Singer" && combo4.getSelectedItem()=="Disk"){
                            List<Song> songList = getDiskFromSinger(textName.getText());
                            String[][] data = new String[songList.size()][1];
                            int i = 0;
                            for (Song song : songList) {
                                data[i][0] = song.getName();

                                i++;
                            }
                            table.setModel(new DefaultTableModel(data, columns));
                            buttons(data,table, columns);
                        }
                        else if(!comboGroupSinger.isEnabled() && !textSong.isEnabled() &&
                                labelDisk.isEnabled()&& !label2.isEnabled()  && combo4.getSelectedItem()=="Song"){
                            List<Song> songList = getSoundFromDisk(textDisk.getText());
                            String[][] data = new String[songList.size()][1];
                            int i = 0;
                            for (Song song : songList) {
                                data[i][0] = song.getName();

                                i++;
                            }
                            table.setModel(new DefaultTableModel(data, columns));
                            buttons(data,table, columns);
                        }
                        else if(comboGroupSinger.isEnabled() && !textSong.isEnabled() &&
                                !labelDisk.isEnabled()&& !label2.isEnabled() && comboGroupSinger.getSelectedItem()=="Group" && combo4.getSelectedItem()=="Disk"){
                            List<Song> songList = getDiskFromGroup(textName.getText());
                            String[][] data = new String[songList.size()][1];
                            int i = 0;
                            for (Song song : songList) {
                                data[i][0] = song.getName();

                                i++;
                            }

                            table.setModel(new DefaultTableModel(data, columns));
                            buttons(data,table, columns);
                        }
                        else if(!comboGroupSinger.isEnabled() && !textSong.isEnabled() &&
                                labelDisk.isEnabled()&& label2.isEnabled() && combo4.getSelectedItem()=="Song"){
                            List<Song> songList = getSongFromGenreAndDisk(textGenre.getText(),textDisk.getText());
                            String[][] data = new String[songList.size()][1];
                            int i = 0;
                            for (Song song : songList) {
                                data[i][0] = song.getName();

                                i++;
                            }

                            table.setModel(new DefaultTableModel(data, columns));
                            buttons(data,table, columns);
                        }else if(comboGroupSinger.isEnabled() && !textSong.isEnabled() &&
                                !labelDisk.isEnabled()&& label2.isEnabled() && comboGroupSinger.getSelectedItem()=="Group" && combo4.getSelectedItem()=="Song"){
                            List<Song> songList = getSongFromGenreAndGroup(textGenre.getText(),textName.getText());
                            String[][] data = new String[songList.size()][1];
                            int i = 0;
                            for (Song song : songList) {
                                data[i][0] = song.getName();

                                i++;
                            }

                            table.setModel(new DefaultTableModel(data, columns));
                            buttons(data,table, columns);
                        }else if(comboGroupSinger.isEnabled() && !textSong.isEnabled() &&
                                labelDisk.isEnabled()&& !label2.isEnabled() && comboGroupSinger.getSelectedItem()=="Group" && combo4.getSelectedItem()=="Song"){
                            List<Song> songList = getSongFromGroupAndDisk(textName.getText(),textDisk.getText());
                            String[][] data = new String[songList.size()][1];
                            int i = 0;
                            for (Song song : songList) {
                                data[i][0] = song.getName();

                                i++;
                            }

                            table.setModel(new DefaultTableModel(data, columns));
                            buttons(data,table, columns);
                        }else if(comboGroupSinger.isEnabled() && !textSong.isEnabled() &&
                                !labelDisk.isEnabled()&& label2.isEnabled() && comboGroupSinger.getSelectedItem()=="Singer" && combo4.getSelectedItem()=="Song"){
                            List<Song> songList = getSongFromSingerAndGenre(textName.getText(),textGenre.getText());
                            String[][] data = new String[songList.size()][1];
                            int i = 0;
                            for (Song song : songList) {
                                data[i][0] = song.getName();

                                i++;
                            }

                            table.setModel(new DefaultTableModel(data, columns));
                            buttons(data,table, columns);
                        }else if(comboGroupSinger.isEnabled() && !textSong.isEnabled() &&
                                labelDisk.isEnabled()&& !label2.isEnabled() && comboGroupSinger.getSelectedItem()=="Singer" && combo4.getSelectedItem()=="Song"){
                            List<Song> songList = getSongFromSingerAndDisk(textName.getText(),textDisk.getText());
                            String[][] data = new String[songList.size()][1];
                            int i = 0;
                            for (Song song : songList) {
                                data[i][0] = song.getName();

                                i++;
                            }

                            table.setModel(new DefaultTableModel(data, columns));
                            buttons(data,table, columns);
                        }
                        else if(comboGroupSinger.isEnabled() && !textSong.isEnabled() &&
                                labelDisk.isEnabled()&& label2.isEnabled() && comboGroupSinger.getSelectedItem()=="Group" && combo4.getSelectedItem()=="Song"){
                            List<Song> songList = getSongFromGroupGenreDisk(textName.getText(),textGenre.getText(),textDisk.getText());
                            String[][] data = new String[songList.size()][1];
                            int i = 0;
                            for (Song song : songList) {
                                data[i][0] = song.getName();

                                i++;
                            }

                            table.setModel(new DefaultTableModel(data, columns));
                            buttons(data,table, columns);
                        }else if(comboGroupSinger.isEnabled() && !textSong.isEnabled() &&
                                labelDisk.isEnabled()&& label2.isEnabled() && comboGroupSinger.getSelectedItem()=="Singer" && combo4.getSelectedItem()=="Song"){
                            List<Song> songList = getSongFromSingerGenreDisk(textName.getText(),textGenre.getText(),textDisk.getText());
                            String[][] data = new String[songList.size()][1];
                            int i = 0;
                            for (Song song : songList) {
                                data[i][0] = song.getName();

                                i++;
                            }

                            table.setModel(new DefaultTableModel(data, columns));
                            buttons(data,table, columns);
                        }else if(comboGroupSinger.isEnabled() && textSong.isEnabled() &&
                                !labelDisk.isEnabled()&& !label2.isEnabled() && comboGroupSinger.getSelectedItem()=="Group" && combo4.getSelectedItem()=="Disk"){
                            List<Song> songList = getDiskFromSongAndGroup(textSong.getText(),textName.getText());
                            String[][] data = new String[songList.size()][1];
                            int i = 0;
                            for (Song song : songList) {
                                data[i][0] = song.getName();

                                i++;
                            }

                            table.setModel(new DefaultTableModel(data, columns));
                            buttons(data,table, columns);
                        }else if(comboGroupSinger.isEnabled() && textSong.isEnabled() &&
                                !labelDisk.isEnabled()&& !label2.isEnabled() && comboGroupSinger.getSelectedItem()=="Singer" && combo4.getSelectedItem()=="Disk"){
                            List<Song> songList = getDiskFromSongAndSinger(textSong.getText(),textName.getText());
                            String[][] data = new String[songList.size()][1];
                            int i = 0;
                            for (Song song : songList) {
                                data[i][0] = song.getName();

                                i++;
                            }

                            table.setModel(new DefaultTableModel(data, columns));
                            buttons(data,table, columns);
                        }else if(!comboGroupSinger.isEnabled() && !textSong.isEnabled() &&
                                labelDisk.isEnabled()&& label2.isEnabled()  && combo4.getSelectedItem()=="Group"){
                            List<Song> songList = getGroupFromDiskAndGenre(textDisk.getText(),textGenre.getText());
                            String[][] data = new String[songList.size()][1];
                            int i = 0;
                            for (Song song : songList) {
                                data[i][0] = song.getName();

                                i++;
                            }

                            table.setModel(new DefaultTableModel(data, columns));
                            buttons(data,table, columns);
                        }else if(!comboGroupSinger.isEnabled() && textSong.isEnabled() &&
                                labelDisk.isEnabled()&& !label2.isEnabled()  && combo4.getSelectedItem()=="Group"){
                            List<Song> songList = getGroupFromDiskAndSong(textDisk.getText(),textSong.getText());
                            String[][] data = new String[songList.size()][1];
                            int i = 0;
                            for (Song song : songList) {
                                data[i][0] = song.getName();

                                i++;
                            }

                            table.setModel(new DefaultTableModel(data, columns));
                            buttons(data,table, columns);
                        }else if(!comboGroupSinger.isEnabled() && !textSong.isEnabled() &&
                                labelDisk.isEnabled()&& label2.isEnabled()  && combo4.getSelectedItem()=="Singer"){
                            List<Song> songList = getSingerFromDiskAndGenre(textDisk.getText(),textGenre.getText());
                            String[][] data = new String[songList.size()][1];
                            int i = 0;
                            for (Song song : songList) {
                                data[i][0] = song.getName();

                                i++;
                            }

                            table.setModel(new DefaultTableModel(data, columns));
                            buttons(data,table, columns);
                        }else if(!comboGroupSinger.isEnabled() && textSong.isEnabled() &&
                                labelDisk.isEnabled()&& !label2.isEnabled()  && combo4.getSelectedItem()=="Singer"){
                            List<Song> songList = getSingerFromDiskAndSong(textDisk.getText(),textSong.getText());
                            String[][] data = new String[songList.size()][1];
                            int i = 0;
                            for (Song song : songList) {
                                data[i][0] = song.getName();

                                i++;
                            }

                            table.setModel(new DefaultTableModel(data, columns));
                            buttons(data,table, columns);
                        }


                    } catch (SQLException e1) {
                        e1.printStackTrace();
                        message.setText(e1.getMessage());
                        System.out.println(e1.getMessage());
                    }

            }});


        final JButton add = new JButton("Add Song");
        add.setVerticalTextPosition(AbstractButton.CENTER);
        add.setHorizontalTextPosition(AbstractButton.LEADING);
        add.setBounds(440, 360, 100, 25);
        panel.add(add);
        add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                AddSongGUI();
            }});



                // frame.getContentPane().add(content);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setPreferredSize(new Dimension(600, 430));
                frame.setResizable(false);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

            }

public static Object[] dat = new Object[1];
    public static void buttons(String data[][], JTable table, String columns[]){
        dat[0] = data;
        JButton delete[] = new JButton[data.length];
        int h =0;
        for (int i = 0; i <data.length ; i++) {
            delete[i]=new JButton("Delete");
            delete[i].setBounds(500, h, 70, 15);
            table.add(delete[i]);
            h+=16;
        }
        for (int i = 0; i < delete.length; i++) {
            final int finalI = i;

            delete[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String [][]finalData = (String[][]) dat[0];

                    try {
                        if(searchType=="Song") {
                            deleteFromSong(finalData[finalI][0]);
                        }else if(searchType=="Group"){
                            deleteFromGroup(finalData[finalI][0]);
                        }else if(searchType=="Disk"){
                            deleteFromDisk(finalData[finalI][0]);
                        }else if(searchType=="Singer"){
                            deleteFromSinger(finalData[finalI][0]);
                        }

                        String data2[][] =new String[finalData.length-1][finalData[0].length];
                        int k=0;
                        for (int j = 0; j <finalData.length ; j++) {
                            if(j!= finalI) {

                                data2[k][0] = finalData[j][0];
                                k++;
                            }
                        }
                      dat[0]=data2;

                        table.setModel(new DefaultTableModel((Object[][]) dat[0],columns));
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }});
        }

    }
            public static void main(String[] args) {
                javax.swing.SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        createGUI();
                    }
                });
            }

        }
