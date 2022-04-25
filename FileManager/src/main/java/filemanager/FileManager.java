package filemanager;


import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;


/**
 *
 * @author 027950206
 */
public class FileManager{
       
      
    public static void main(String[] args) { 

        JFrame frame = new JFrame();
        DesktopPane desk = new DesktopPane(frame);
        AddMenu addMenu = new AddMenu(frame);  
        new PopupFeature(frame);
        
        frame.setSize(1000,650);
        frame.setTitle("CECS 544 File Manager");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
      
        JPanel toppanel = new JPanel();
        JToolBar toolbar = new JToolBar();
        File[] drives = File.listRoots();
        JComboBox cb = new JComboBox(drives);
        cb.setBounds(50, 50,90,20);          
        toppanel.add(cb);        
        toppanel.add(new JButton("Simple"));
        toppanel.add(new JButton("Details"));
        toolbar.add(toppanel);
        frame.add(toppanel,BorderLayout.NORTH);
        
       InternalFrame intframe = new InternalFrame(cb);
        desk.NewIntFrame(intframe);
        
        
                cb.addActionListener(new ActionListener() {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                InternalFrame newframe = new InternalFrame(cb);
                desk.NewIntFrame(newframe);
            }
        });
        
        addMenu.menuitem31.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
              InternalFrame newframe2 = new InternalFrame(cb);
              desk.NewIntFrame(newframe2);
            }
            
        });
        //End Top Panel
          
        //Status Bar
       // new StatusBar(frame,drives);
       //End Status Bar
                     
                      
        frame.setVisible(true);
    
        
    }   
}