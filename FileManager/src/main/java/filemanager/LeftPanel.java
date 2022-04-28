/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package filemanager;

import java.awt.BorderLayout;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author 027950206
 */
public final class LeftPanel extends JPanel{
	RightPanel rpanel;
        JPanel toppanel;
        JFrame frame;
        JButton j;
        JButton j1;


    
   public LeftPanel(JComboBox jbox, RightPanel rp,JPanel toppanel,JFrame frame,JButton j, JButton j1){
    
    this.toppanel=toppanel;
	   this.frame=frame;
	   this.j=j;
	   this.j1 =j1;
       
    this.setLayout(new BorderLayout());
    this.rpanel = rp;
    GetTree(jbox);
   }
   
//   public void setRPanel(RightPanel lp){
//       rpanel = lp;
//   }
   
   public void GetTree(JComboBox jbb){
       File GetCurrDir = (File) jbb.getSelectedItem();
       new CreateDirectoryTree(GetCurrDir,this,rpanel,toppanel,frame,j,j1);   
   }
}
