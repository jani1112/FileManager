/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package filemanager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.io.File;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

/**
 *
 * @author 027950206
 */
public class StatusBar extends JPanel{
    JLabel statuslabel;
    /**
     *
     * @param frame
     */
    public StatusBar(JFrame frame) {
        super((new FlowLayout(FlowLayout.LEFT)));
        this.setBorder(new CompoundBorder(new LineBorder(Color.DARK_GRAY),
        new EmptyBorder(4, 4, 4, 4)));
        frame.add(this, BorderLayout.SOUTH);
    }
    
    public void setMessage(File drive) {
        this.removeAll();
        statuslabel = new JLabel();
        statuslabel.setText("Current Drive: "+drive+" "+" Free Space: "+drive.getFreeSpace() / 1_000_000 / 1e3+" GB"
        +" Used Space: "+drive.getUsableSpace() / 1_000_000 / 1e3+" GB "+" Total Space: "+drive.getTotalSpace()
         / 1_000_000 / 1e3+" GB");   
        this.add(statuslabel);
    }
        }

