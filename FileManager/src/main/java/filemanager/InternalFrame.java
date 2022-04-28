/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package filemanager;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;

/**
 *
 * @author 027950206
 */
public class InternalFrame extends JInternalFrame implements InternalFrameListener, ActionListener {
    JSplitPane splitpane;
    JPanel mainstatus;
    
    
    public InternalFrame(JComboBox jb,JPanel toppanel,JFrame frame,JButton j, JButton j1,JPanel mainstatus){
    super(jb.getSelectedItem().toString(),true,true,true,true); 
    
    this.mainstatus = mainstatus;
    
    //Setting Rpanel
    RightPanel RPanel = new RightPanel();
    JScrollPane rscrollpane = new JScrollPane(RPanel);
    rscrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    //Seting Left Panel
    LeftPanel LPanel = new LeftPanel(jb,RPanel,toppanel,frame,j,j1);
    JScrollPane lscrollpane = new JScrollPane(LPanel);
    lscrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    
    this.addInternalFrameListener(this);

    
    splitpane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,true, lscrollpane, rscrollpane);
    splitpane.setResizeWeight(0.3);
    this.add(splitpane);
    this.setSize(700,350);
    this.setVisible(true);  
}
    @Override
    public void internalFrameOpened(InternalFrameEvent e) {
             String drivename = this.title;
       File drive = new File(drivename);
        mainstatus.removeAll();
        JLabel statuslabel = new JLabel();
        statuslabel.setText("Current Drive: "+drive+" "+" Free Space: "+drive.getFreeSpace() / 1_000_000 / 1e3+" GB"
        +" Used Space: "+drive.getUsableSpace() / 1_000_000 / 1e3+" GB "+" Total Space: "+drive.getTotalSpace()
         / 1_000_000 / 1e3+" GB");   
        mainstatus.add(statuslabel);
    }

    @Override
    public void internalFrameClosing(InternalFrameEvent e) {
    }

    @Override
    public void internalFrameClosed(InternalFrameEvent e) {
    }

    @Override
    public void internalFrameIconified(InternalFrameEvent e) {
    }

    @Override
    public void internalFrameDeiconified(InternalFrameEvent e) {
    }

    @Override
    public void internalFrameActivated(InternalFrameEvent e) {
       String drivename = this.title;
       File drive = new File(drivename);
        mainstatus.removeAll();
        JLabel statuslabel = new JLabel();
        statuslabel.setText("Current Drive: "+drive+" "+" Free Space: "+drive.getFreeSpace() / 1_000_000 / 1e3+" GB"
        +" Used Space: "+drive.getUsableSpace() / 1_000_000 / 1e3+" GB "+" Total Space: "+drive.getTotalSpace()
         / 1_000_000 / 1e3+" GB");   
        mainstatus.add(statuslabel);
        //st.setMessage();
    }

    @Override
    public void internalFrameDeactivated(InternalFrameEvent e) {
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
   
    }
     
}
