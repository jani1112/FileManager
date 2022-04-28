/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package filemanager;

import java.awt.event.ActionEvent;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author 027950206
 */
public class AddMenu {

    private final JMenuBar menubar;
    private final JMenu menu1,menu2,menu3,menu4;
    private final JMenuItem menuitem11,menuitem12,menuitem13,menuitem14,menuitem15,menuitem21,menuitem22
            ,menuitem41,menuitem42;
    public JMenuItem menuitem31,menuitem32;
    //private final JDialog jdbox;
    //private final JButton btn;
            
    public AddMenu(JFrame frame){

    menubar = new JMenuBar();
    
    menu1 = new JMenu("File");
    menu2 = new JMenu("Tree");
    menu3 = new JMenu("Window");
    menu4 = new JMenu("Help");  
    
    
    //Menu 1 - Menuitem
    menuitem11=new JMenuItem("Rename");  
    menuitem12=new JMenuItem("Copy");  
    menuitem13=new JMenuItem("Delete");  
    menuitem14=new JMenuItem("Run");  
    menuitem15=new JMenuItem("Exit");
         
    menu1.add(menuitem11);
    menu1.add(menuitem12); 
    menu1.add(menuitem13);  
  //  menu1.add(menuitem14);
    menu1.add(menuitem15);
    
    
    //Menu2 menuitem
    menuitem21=new JMenuItem("Expand Branch");  
    menuitem22=new JMenuItem("Collapse Branch");  
    menu2.add(menuitem21);
    menu2.add(menuitem22); 
          
    //Menu3 menuitem
    menuitem31=new JMenuItem("New");  
    menuitem32=new JMenuItem("Cascade");  
    menu3.add(menuitem31);
    menu3.add(menuitem32); 
          
    //Menu4 menuitem
    menuitem41=new JMenuItem("Help");  
    menuitem42=new JMenuItem("About");  
    menu4.add(menuitem41);
    menu4.add(menuitem42);   
    
    //property for menuitems
    
    
    
     menuitem15.addActionListener((var e3)->{
    frame.dispose();

    });
     
     //Cascade Frames
     menuitem32.addActionListener((e) -> {
        DesktopPane cascade = new DesktopPane(frame);
        cascade.CascadeFrames();
     });
     
       
          menuitem42.addActionListener((ActionEvent e) -> {
          Box box = new Box(BoxLayout.Y_AXIS);
          JDialog jdbox = new JDialog(frame,"About Product",true);
          JButton btn = new JButton("Ok");
          //btn.setAlignmentX(btn.CENTER_ALIGNMENT);
          btn.addActionListener((ActionEvent e1) -> {
                jdbox.setVisible(false);
          });
          box.add(new JLabel("CECS 544 File Manager."));
          box.add(new JLabel("All Rights Reserved."));
          box.add(btn);
          jdbox.add(box);
          jdbox.setSize(300,200);
          jdbox.setVisible(true);
          });
          
          menuitem41.addActionListener((ActionEvent e) -> {
          Box box = new Box(BoxLayout.Y_AXIS);
          JDialog jdbox = new JDialog(frame,"Help DIalog",true);
          JButton btn = new JButton("Ok");
          //btn.setAlignmentX(btn.CENTER_ALIGNMENT);
          btn.addActionListener((ActionEvent e1) -> {
                jdbox.setVisible(false);
          });
          box.add(new JLabel("File Manager Help."));
          box.add(new JLabel("All Rights Reserved."));
          box.add(btn);
          jdbox.add(box);
          jdbox.setSize(300,200);
          jdbox.setVisible(true);
          });
          
          
          
    menubar.add(menu1);
    menubar.add(menu2);
    menubar.add(menu3);
    menubar.add(menu4);
    frame.setJMenuBar(menubar);
    }
}