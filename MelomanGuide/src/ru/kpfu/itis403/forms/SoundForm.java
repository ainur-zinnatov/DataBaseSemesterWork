package ru.kpfu.itis403.forms;

import ru.kpfu.itis403.entities.Song;
import ru.kpfu.itis403.exceptions.SQLExcept;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import static ru.kpfu.itis403.repositories.SongAddRepository.addSong;


public class SoundForm {
    public static void AddSongGUI() {
        JFrame frame = new JFrame("Add Song");
        JPanel panel = new JPanel();


        panel.setLayout(null);
//Name
        final JTextField textName = new JTextField();
        textName.setBounds(80, 10, 200, 25);
        panel.add(textName);


        final JLabel labelName = new JLabel("Name:");
        labelName.setBounds(10, 10, 220, 25);
        panel.add(labelName);
//Genre
        final JTextField GenreName = new JTextField();
        GenreName.setBounds(80, 40, 200, 25);
        panel.add(GenreName);


        final JLabel GenreNameLabel = new JLabel("Genre:");
        GenreNameLabel.setBounds(10, 40, 220, 25);
        panel.add(GenreNameLabel);
//Disk
        final JTextField DiskName = new JTextField();
        DiskName.setBounds(80, 70, 200, 25);
        panel.add(DiskName);


        final JLabel DiskNameLabel = new JLabel("Disk:");
        DiskNameLabel.setBounds(10, 70, 220, 25);
        panel.add(DiskNameLabel);
//Group-Singer
        final JTextField GSName = new JTextField();
        GSName.setBounds(80, 100, 200, 25);
        panel.add(GSName);


        String items [] = {"Group","Singer"};
        JComboBox combo = new JComboBox(items);
        combo.setBounds(10, 100, 70, 25);
        panel.add(combo);

        final JLabel mes = new JLabel(":");
        mes.setBounds(100, 150, 200, 25);
        panel.add(mes);
        final JButton add = new JButton("ADD");
        add.setVerticalTextPosition(AbstractButton.CENTER);
        add.setHorizontalTextPosition(AbstractButton.LEADING);
        add.setBounds(10, 150, 70, 25);
        panel.add(add);

        add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                try {
                    String sing="";
                    String group="";
                    if(combo.getSelectedItem().toString().equals("Group")){
                        sing ="";
                         group = GSName.getText();
                    }else {
                         sing =GSName.getText();
                         group = "";
                    }

                    try {
                        addSong(new Song(textName.getText(),sing, group, GenreName.getText(), DiskName.getText()));
                        mes.setForeground(Color.green);
                        mes.setText("Song Added!");

                    } catch (SQLExcept sqlExcept) {
                        System.out.println(sqlExcept.getMessage());
                        mes.setForeground(Color.red);
                        mes.setText(sqlExcept.getMessage());

                    }

                }catch (SQLException e1){
                    e1.printStackTrace();
                }

            }});
                  frame.getContentPane().setLayout(new BorderLayout());
                  frame.getContentPane().add(panel);
                  frame.setPreferredSize(new Dimension(300, 250));
                  frame.pack();
                  frame.setLocationRelativeTo(null);
                  frame.setVisible(true);
              }
          }

