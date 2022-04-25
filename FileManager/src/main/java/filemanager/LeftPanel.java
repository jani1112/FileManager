/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package filemanager;

import java.awt.BorderLayout;
import java.io.File;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author 027950206
 */
public final class LeftPanel extends JPanel{
    private final JScrollPane lscrollpane = new JScrollPane();
    //private JTree dirtree = new JTree();
    RightPanel rpanel;
    TopPanel tpanel;
    
   public LeftPanel(JComboBox jbox){
     
    this.setLayout(new BorderLayout());
    lscrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    this.add(lscrollpane);
    GetTree(jbox);
   }
   
   public void setRPanel(RightPanel lp){
       rpanel = lp;
   }
   
   public void GetTree(JComboBox jbb){
       File GetCurrDir = (File) jbb.getSelectedItem();
       new CreateDirectoryTree(GetCurrDir,this);   
   }
}
