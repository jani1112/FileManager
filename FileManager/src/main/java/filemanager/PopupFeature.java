/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package filemanager;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 *
 * @author 027950206
 */
public class PopupFeature {
    
    public PopupFeature(JFrame frame){
    
          JPopupMenu menu = new JPopupMenu("Menu");
          JMenuItem rename = new JMenuItem("Rename");
          JMenuItem copy = new JMenuItem("Copy");
          JMenuItem paste = new JMenuItem("Paste");
          JMenuItem delete = new JMenuItem("Delete");
          
          menu.add(rename);
          menu.add(copy);
          menu.add(paste);
          menu.add(delete);
          menu.setVisible(false);
          
                 
                delete.addActionListener((e)->{
                       String name = "Boom";
                      int a =JOptionPane.showConfirmDialog(null, "Delete "+name, "Deleting!!", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                      if(a== 0)
                      {
                          System.out.println("clicked yes");
                      }else{
                      
}  
              });
            
        frame.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
     //right mouse click event
     if (SwingUtilities.isRightMouseButton(e) && e.getClickCount() == 1){
           menu.show(frame , e.getX(), e.getY());
     }        
    }               
   });
    }
}