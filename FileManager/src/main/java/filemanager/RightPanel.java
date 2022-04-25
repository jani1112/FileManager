/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package filemanager;

import java.awt.Dimension;
import java.awt.dnd.DropTarget;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author 027950206
 */
public class RightPanel extends JPanel
{
 JList list = new JList();
 DefaultListModel model = new DefaultListModel();
 private final JScrollPane rscrollpane = new JScrollPane();
 
 public RightPanel(){
     
    rscrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    this.add(rscrollpane);
//     list.setPreferredSize(new Dimension(500,500));
     this.setDropTarget(new DropTarget());
     list.setDragEnabled(true);
     
     list.setModel(model);
     this.add(list);
    
 }
}
