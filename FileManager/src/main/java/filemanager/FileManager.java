package filemanager;


import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.Iterator;
import java.util.Vector;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JToolBar;
import javax.swing.JTree;
import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;


/**
 *
 * @author 027950206
 */
public class FileManager {
    
    private JMenuBar jmenubar;
    private JMenu menu1,menu2,menu3,menu4;  
    private JMenuItem menuitem11, menuitem12, menuitem13, menuitem14,menuitem15,menuitem21, menuitem22,menuitem31, menuitem32,menuitem41, menuitem42;
    private static JDialog jdbox;
    private JButton btn;

  
    
    public void FileManager() {
        
        
         }
    
    
    public final void AddMenu(JFrame mainframe){
    
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
              mainframe.dispose();
    });
          
          
          menuitem42.addActionListener((ActionEvent e) -> {
          Box box = new Box(BoxLayout.Y_AXIS);
          jdbox = new JDialog(mainframe,"About Product",true);
          btn = new JButton("Ok");
          //btn.setAlignmentX(btn.CENTER_ALIGNMENT);
          btn.addActionListener((ActionEvent e1) -> {
                FileManager.jdbox.setVisible(false);
          });
          box.add(new JLabel("CECS 544 File Manager."));
          box.add(new JLabel("All Rights Reserved."));
          box.add(btn);
          jdbox.add(box);
          jdbox.setSize(300,200);
          jdbox.setVisible(true);
    });
          
    jmenubar.add(menu1);
    jmenubar.add(menu2);
    jmenubar.add(menu3);
    jmenubar.add(menu4);
    mainframe.setJMenuBar(jmenubar); 
    
        }
      
    public static void main(String[] args) { 
    
        JFrame frame = new JFrame();
        JPanel toppanel = new JPanel();
        File[] drives = File.listRoots();
        
        JToolBar toolbar = new JToolBar();
        JComboBox cb = new JComboBox(drives);
        cb.setBounds(50, 50,90,20);   
        toppanel.add(cb);
        toppanel.add(new JButton("Simple"));
        toppanel.add(new JButton("Details"));
        toolbar.add(toppanel);
       
        
        FileManager f  = new FileManager();
        f.AddMenu(frame);
        
        
        frame.setSize(1000,650);
        frame.setTitle("CECS 544 File Manager");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        JDesktopPane desk = new JDesktopPane();
        //desk.setLayout(new GridBagLayout());
//        JInternalFrame frame1 = new JInternalFrame("Internal Frame",false,true,true,true);
//        frame1.setSize(700, 500);
//        frame1.setVisible(true);
//        desk.add(frame1);

        
        JPanel leftpanel = new JPanel();

        JPanel rightpanel = new JPanel();
        
        //Sroll Pane
        JScrollPane leftscrollpane = new JScrollPane(leftpanel);
        leftscrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); 
        JScrollPane rightscrollpane = new JScrollPane(rightpanel);
        rightscrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
   
        //Get Directory Data
        String GetCurrDir = cb.getSelectedItem().toString();
        FileSystemModel fileSystemModel = new FileSystemModel(new File("D:\\"));
        JTree fileTree = new JTree(fileSystemModel);
        fileTree.setEditable(true);
        leftpanel.add(fileTree);
        
        JSplitPane splitpane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,true, leftscrollpane, rightscrollpane);

        splitpane.setResizeWeight(0.3);
        frame.add(toppanel,BorderLayout.NORTH);
        frame.getContentPane().add(splitpane);
       // frame.add(desk);
     
        frame.setVisible(true);
       
    }   
          
    }

class FileSystemModel implements TreeModel {
  private File root;
 
  private Vector listeners = new Vector();
 
  public FileSystemModel(File rootDirectory) {
    root = rootDirectory;
  }
 
  public Object getRoot() {
    return root;
  }
 
  public Object getChild(Object parent, int index) {
    File directory = (File) parent;
    String[] children = directory.list();
    return new TreeFile(directory, children[index]);
  }
 
  public int getChildCount(Object parent) {
    File file = (File) parent;
    if (file.isDirectory()) {
      String[] fileList = file.list();
      if (fileList != null)
        return file.list().length;
    }
    return 0;
  }
 
  public boolean isLeaf(Object node) {
    File file = (File) node;
    return file.isFile();
  }
 
  public int getIndexOfChild(Object parent, Object child) {
    File directory = (File) parent;
    File file = (File) child;
    String[] children = directory.list();
    for (int i = 0; i < children.length; i++) {
      if (file.getName().equals(children[i])) {
        return i;
      }
    }
    return -1;
 
  }
 
  public void valueForPathChanged(TreePath path, Object value) {
    File oldFile = (File) path.getLastPathComponent();
    String fileParentPath = oldFile.getParent();
    String newFileName = (String) value;
    File targetFile = new File(fileParentPath, newFileName);
    oldFile.renameTo(targetFile);
    File parent = new File(fileParentPath);
    int[] changedChildrenIndices = { getIndexOfChild(parent, targetFile) };
    Object[] changedChildren = { targetFile };
    fireTreeNodesChanged(path.getParentPath(), changedChildrenIndices, changedChildren);
 
  }
 
  private void fireTreeNodesChanged(TreePath parentPath, int[] indices, Object[] children) {
    TreeModelEvent event = new TreeModelEvent(this, parentPath, indices, children);
    Iterator iterator = listeners.iterator();
    TreeModelListener listener = null;
    while (iterator.hasNext()) {
      listener = (TreeModelListener) iterator.next();
      listener.treeNodesChanged(event);
    }
  }
 
  public void addTreeModelListener(TreeModelListener listener) {
    listeners.add(listener);
  }
 
  public void removeTreeModelListener(TreeModelListener listener) {
    listeners.remove(listener);
  }
 
  private class TreeFile extends File {
    public TreeFile(File parent, String child) {
      super(parent, child);
    }
  }
}