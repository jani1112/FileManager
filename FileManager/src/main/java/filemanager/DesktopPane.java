/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package filemanager;

import java.awt.CardLayout;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;

/**
 *
 * @author 027950206
 */
public class DesktopPane extends JDesktopPane{
    
  
    public DesktopPane(JFrame frame){
    frame.add(this);
    }
    
    public void NewIntFrame(JInternalFrame jif){
       this.add(jif);
    }
}
