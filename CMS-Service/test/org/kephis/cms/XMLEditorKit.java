package org.kephis.cms;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author bobby
 */
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import org.kephis.cms.file.controllers.ConfigMapper;


public class XMLEditorKit extends JFrame{

private JEditorPane editorpane;
JScrollPane editorScrollPane;
String filename="cms/config.xml";
Reader filereader;

public XMLEditorKit()
{       
        editorpane= new JEditorPane();
        editorpane.setEditable(false);

        if (filename != null) 
        {
            try 
            {
                filereader=new FileReader(filename);
                editorpane.setPage(filename);
            }

            catch (IOException e) 
            {
                System.err.println("Attempted to read a bad file " + filename);
            }
         }

        else
        {
            System.err.println("Couldn't find file");
        }

        //Put the editor pane in a scroll pane.
        editorScrollPane = new JScrollPane(editorpane);
            editorScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        editorScrollPane.setPreferredSize(new Dimension(250, 145));
        editorScrollPane.setMinimumSize(new Dimension(10, 10));

}
 
public static void main(String[] args) 
{
    ConfigMapper cm = new ConfigMapper();
    XMLEditorKit obj= new XMLEditorKit();
    obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    obj.setSize(600,600);
    obj.setLocation(100,100);
    obj.setVisible(true);
}
}