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
public class StatusBar {
    
    /**
     *
     * @param frame
     * @param drives
     */
    public StatusBar(JFrame frame,File[] drives){
           //Status Bar
        JPanel statusBar = new JPanel(new FlowLayout(FlowLayout.LEFT));
        statusBar.setBorder(new CompoundBorder(new LineBorder(Color.DARK_GRAY),
        new EmptyBorder(4, 4, 4, 4)));
        final JLabel status = new JLabel();
        status.setText("Current Drive: "+drives[0]+" "+" Free Space: "+drives[0].getFreeSpace() / 1_000_000 / 1e3+" GB"
        +" Used Space: "+drives[0].getUsableSpace() / 1_000_000 / 1e3+" GB "+" Total Space: "+drives[0].getTotalSpace()
         / 1_000_000 / 1e3+" GB");
        statusBar.add(status);
        JLabel content = new JLabel("Content in the middle");
        content.setHorizontalAlignment(JLabel.CENTER);
        frame.add(statusBar, BorderLayout.SOUTH);
 
    }
}
