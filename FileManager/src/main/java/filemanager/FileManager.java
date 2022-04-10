package filemanager;


import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 *
 * @author 027950206
 */
public class FileManager {

    private final JFrame frame;
    private final JPanel panel;
    private JMenuBar jmenubar;
    private JMenu menu1,menu2,menu3,menu4;  
    private JMenuItem menuitem11, menuitem12, menuitem13, menuitem14,menuitem15,menuitem21, menuitem22,menuitem31, menuitem32,menuitem41, menuitem42;
    private static JDialog jdbox;
    private JButton btn;
    private JLabel jlabel;
    
    private FileManager(){
           
    frame = new JFrame();
    panel = new JPanel();
    AddMenu();
    frame.add(panel);
    frame.setSize(500, 700);
    frame.setTitle("CECS 544 File Manager");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
    }
    
    
    public final void AddMenu(){
    
    jmenubar  = new JMenuBar(); 
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
          menu1.add(menuitem14);
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
          
          
          menuitem41.addActionListener((var e) -> {
          jdbox = new JDialog(frame,"About Product",true);
          jdbox.setLayout( new FlowLayout() );  
          btn = new JButton("Ok");
          btn.addActionListener((ActionEvent e1) -> {
                FileManager.jdbox.setVisible(false);
          });
          jdbox.add(new JLabel("CECS 544 File Manager.",JLabel.CENTER));
          jdbox.add(new JLabel("All Rights Reserved.",JLabel.CENTER));
          jdbox.setSize(500,200);
          jdbox.add(btn);
          jdbox.setVisible(true);
    });
          
    jmenubar.add(menu1);
    jmenubar.add(menu2);
    jmenubar.add(menu3);
    jmenubar.add(menu4);
    frame.setJMenuBar(jmenubar); 
    
        }
    
    public static void main(String[] args) { 
        
        FileManager fileManager = new FileManager();
    }
}