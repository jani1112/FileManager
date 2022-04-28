/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package filemanager;

import java.io.File;
import java.text.SimpleDateFormat;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;

/**
 *
 * @author 027950206
 */
public class SimpleRPanel {

    public SimpleRPanel(File fileRoot, JPanel right) {
            right.removeAll();
            File[] files = fileRoot.listFiles();   
            DefaultListModel model = new DefaultListModel();
            if ( files != null )

        {  
            for( File child : files )
            {   
            	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            	model.addElement( new MusicFile( child ) );
//            	jmode.addElement(child.toPath());
//            	jmode.addElement(sdf.format(child.lastModified()));
//            	jmode.addElement(child.length()); //add bytes after it

            }
        }
          JList list = new JList(model);
          
          //JScrollPane scrollPane_1 = new JScrollPane(list);
          //right.setLayout(new BorderLayout());
//          list.addMouseListener( new MouseAdapter() {
//                  @Override
//       	   public void mouseClicked(MouseEvent e) {
//       	     if(e.getClickCount() == 2){
//
//       	       // now play the file
//       	       System.out.println(mf.getFile());
//       	      // mf.getFile() );
//       	     }
//       	   }
//       	});
          right.add(list);
          new PopupFeature(list,right);
          right.revalidate();
          right.repaint();
    }
    
    
}
