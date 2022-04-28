package filemanager;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.SwingUtilities;



     public class PopupFeature{
          
         public PopupFeature(JList list,JPanel panel){
          JPopupMenu menu = new JPopupMenu("Menu");
          JMenuItem rename = new JMenuItem("Rename");
          JMenuItem copy = new JMenuItem("Copy");
          JMenuItem delete = new JMenuItem("Delete");
          
          menu.add(rename);
          menu.add(copy);
          menu.add(delete);
          menu.setVisible(false);
          
                copy.addActionListener((e) -> {
                MusicFile mf = (MusicFile)list.getModel().getElementAt( list.getSelectedIndex());
                File currfilename = mf.getFile();
                String currfilestr = currfilename.toString();
                JTextField textField1 = new JTextField(currfilestr);
                Object[] inputFields = {"From", textField1,"To",};
                String option = JOptionPane.showInputDialog(list, inputFields);
                
                if(option != null){
                         File inputfile = new File(option);
              try {
                  copyFiles(currfilename,inputfile);
                  
              } catch (IOException ex) {
                  Logger.getLogger(PopupFeature.class.getName()).log(Level.SEVERE, null, ex);
              }
                }
                });
                
                
                rename.addActionListener((e) -> {
                MusicFile mf = (MusicFile)list.getModel().getElementAt( list.getSelectedIndex());
                File currfilename = mf.getFile();
                String currfilestr = currfilename.toString();
                String currfilestrname = currfilename.getName();
                String currfileparent = currfilename.getParent();
                      JTextField textField1 = new JTextField(currfilestrname);
                      Object[] inputFields = {"From", textField1,"To",};
                      String option = JOptionPane.showInputDialog(list, inputFields);
                    if (option != null) {
                      File newname = new File(currfileparent+"\\"+option);
                     boolean check = currfilename.renameTo(newname);
                    DefaultListModel listmodel = (DefaultListModel) list.getModel();
                    int index = list.getSelectedIndex();
                    if (index > -1){
                    listmodel.setElementAt(option, index);
                    }
}
                     
                });
                
  delete.addActionListener((e)->{
      MusicFile mf = (MusicFile)list.getModel().getElementAt( list.getSelectedIndex());
                File currfilename = mf.getFile();
          
                           int result =
                JOptionPane.showConfirmDialog(
                        list,
                        "Are you sure you want to delete this file? "+currfilename,
                        "Delete File",
                        JOptionPane.ERROR_MESSAGE);
                 if (result == JOptionPane.OK_OPTION) {
                 currfilename.delete();
                    DefaultListModel listmodel = (DefaultListModel) list.getModel();
                    int index = list.getSelectedIndex();
                    if (index > -1){
                    listmodel.removeElementAt(index);
                    }
                 }
              });
            
  
              
        list.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
     //right mouse click event
     if (SwingUtilities.isRightMouseButton(e) && e.getClickCount() == 1  && !list.isSelectionEmpty()
           && list.locationToIndex(e.getPoint())
              == list.getSelectedIndex()){
           menu.show(list , e.getX(), e.getY());
     }        
    }               
   });
    }
         
         
  public static void copyFiles(File src, File dest) throws IOException{
    
      if(src.isDirectory()){
        //if the directory does not exist, create it
        if(!dest.exists()){
           dest.mkdir();
           System.out.println("Directory "+ src + "  > " + dest);
        }
        //list the contents of the directory
        String files[] = src.list();
        
        for (String f : files) {
           //build the structure of the src and dest files
           File srcF = new File(src, f);
           File destF = new File(dest, f);
           //recursive copy
           copyFiles(srcF, destF);
        }
      }else{
          //if src is a file, copy it.
          InputStream in = new FileInputStream(src);
          OutputStream out = new FileOutputStream(dest); 
                           
          byte[] buffer = new byte[1024];
          int length;
          //copy the contents of the file
          while ((length = in.read(buffer)) > 0){
            out.write(buffer, 0, length);
          }
 
          in.close();
          out.close();
      }
  }
     }