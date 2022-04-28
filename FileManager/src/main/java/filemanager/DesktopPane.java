/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package filemanager;

import java.awt.Dimension;
import java.beans.PropertyVetoException;
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
    
    public void CascadeFrames()
        {
        JInternalFrame[] c = this.getAllFrames();
     
        int x = 5;
        int y = 10;
        int FRAME_OFFSET = 20;

        for (int i = c.length - 1; i >= 0; i--) {
            JInternalFrame frame = c[i];
            frame.setLocation(x, y);
            x = x + FRAME_OFFSET;
            y = y + FRAME_OFFSET;
        }
        }
        }
        