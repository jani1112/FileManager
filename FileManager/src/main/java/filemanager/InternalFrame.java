/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package filemanager;

import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JSplitPane;

/**
 *
 * @author 027950206
 */
public class InternalFrame extends JInternalFrame{
    JSplitPane splitpane;
    
    public InternalFrame(JComboBox jb){
    super("Internal Frame",true,true,true,true);
    
    LeftPanel LPanel = new LeftPanel(jb);
    RightPanel RPanel = new RightPanel();
    
    //LPanel.setRPanel(RPanel);
    splitpane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,true, LPanel, RPanel);
    splitpane.setResizeWeight(0.3);
    this.add(splitpane);
    this.setSize(800,400);
    this.setVisible(true);       
}
}
