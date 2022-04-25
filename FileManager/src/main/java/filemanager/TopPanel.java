/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package filemanager;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.plaf.basic.BasicComboBoxUI;

/**
 *
 * @author 027950206
 */
public class TopPanel{
   
    JComboBox cb;
    JPanel toppanel = new JPanel();
    public TopPanel(JFrame f){
        JToolBar toolbar = new JToolBar();
        File[] drives = File.listRoots();
        JComboBox cb = new JComboBox(drives);
        cb.setBounds(50, 50,90,20);          
        toppanel.add(cb);        
        toppanel.add(new JButton("Simple"));
        toppanel.add(new JButton("Details"));
        toolbar.add(toppanel);
        f.add(toppanel,BorderLayout.NORTH);
        
    }
}
                     
