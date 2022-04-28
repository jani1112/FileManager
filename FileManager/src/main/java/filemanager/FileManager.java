package filemanager;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;


/**
 *
 * @author 027950206
 */
public class FileManager{
       
      public FileManager(){
      }
    public static void main(String[] args) { 

        JFrame frame = new JFrame();
        DesktopPane desk = new DesktopPane(frame);
       
        AddMenu addMenu = new AddMenu(frame); 
        frame.setSize(1200,700);
        frame.setTitle("CECS 544 File Manager");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
        //Status bar
        StatusBar status = new StatusBar(frame);
        
        JPanel toppanel = new JPanel();
        JToolBar toolbar = new JToolBar();
        File[] drives = File.listRoots();
        JComboBox cb = new JComboBox(drives);
        cb.setBounds(50, 50,90,20);          
        toppanel.add(cb);
        JButton j = new JButton("Simple");
        JButton j1 = new JButton("Details");
        toppanel.add(j);
        toppanel.add(j1);
        toolbar.add(toppanel);
        frame.add(toppanel,BorderLayout.NORTH);
        
//       InternalFrame intframe = new InternalFrame(cb,toppanel,frame,j,j1);
//       desk.NewIntFrame(intframe);

        
      
//                cb.addActionListener(new ActionListener() {
//                  @Override
//                  public void actionPerformed(ActionEvent e) {
//                InternalFrame newframe = new InternalFrame(cb,toppanel,frame,j,j1);
//                desk.NewIntFrame(newframe);
//                int getcurrdrive = cb.getSelectedIndex();
//            }
//        });
        
        addMenu.menuitem31.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
              InternalFrame newframe2 = new InternalFrame(cb,toppanel,frame,j,j1,status);
              desk.NewIntFrame(newframe2);
            }
           
        });
        
        addMenu.menuitem32.addActionListener((e) -> {
            desk.CascadeFrames();
        });
        //End Top Panel
        
        
        frame.setVisible(true);
    }
   
}