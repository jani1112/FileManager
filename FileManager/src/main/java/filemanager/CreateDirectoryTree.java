/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package filemanager;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Component;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.SimpleDateFormat;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.table.JTableHeader;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import java.io.IOException;
import java.net.URL;

/**
 *
 * @author 027950206
 */
public class CreateDirectoryTree  {
	JList list;
	JPanel toppanel;
	JFrame frame;
	int flag=0;

    CreateDirectoryTree(File GetCurrDir, JPanel leftpanel, JPanel rightpanell,JPanel toppanel,JFrame frame,JButton j, JButton j1) {
    	this.toppanel=toppanel;
    	this.frame=frame;
        DefaultMutableTreeNode root = new DefaultMutableTreeNode(new FileNodes(GetCurrDir));
        DefaultTreeModel treeModel = new DefaultTreeModel(root);

        JTree tree = new JTree(treeModel);
        DefaultTreeCellRenderer renderer = (DefaultTreeCellRenderer) tree.getCellRenderer();
        //CreateDirectoryTree.setTreeExpandedState(tree, false);
//        UIManager.put("tree.expandedIcon",  new ImageIcon("plusicons.png"));
//        UIManager.put("tree.collapsedIcon", new ImageIcon("plusicons.png"));
//        Icon closedIcon = new ImageIcon("plusicons.png");
//        renderer.setClosedIcon(closedIcon);



       // tree.setCellRenderer(new DefaultTreeCellRenderer() {
           // private final Icon loadIcon = UIManager.getIcon("OptionPane.errorIcon");
           // private final Icon saveIcon = UIManager.getIcon("OptionPane.informationIcon");
//            @Override
//            public Component getTreeCellRendererComponent( JTree tree,
//                                                           Object value,
//                                                           boolean bSelected,
//                                                           boolean bExpanded,
//                                                           boolean bLeaf,
//                                                           int iRow,
//                                                           boolean bHasFocus ) {
//                Component c = super.getTreeCellRendererComponent(tree, value,
//                        bSelected, bExpanded, false, iRow, bHasFocus);
//
//                return c;
//            }
        //});

        tree.setShowsRootHandles(true);
        tree.setRootVisible(true);
        leftpanel.add(tree);
        CreateChildNode ccn = new CreateChildNode(GetCurrDir, root);
        new Thread(ccn).start();
     
        
        //Add Listner
     tree.addTreeSelectionListener(new TreeSelectionListener() {
         
    @Override
    public void valueChanged(TreeSelectionEvent e) {

           TreePath[] paths = tree.getSelectionPaths();
           for (TreePath path : paths != null ? paths : new TreePath[0]) {
           String subdirpath = new String(path.toString());
           String finaldir = subdirpath.replace(", ","").replace("[","").replace("]","");
           File subdir = new File(finaldir);
           DefaultMutableTreeNode root = (DefaultMutableTreeNode) path.getLastPathComponent();
           createlowChildren(subdir,root);
           DefaultTreeModel treemode = (DefaultTreeModel) tree.getModel();
           
           //toppanel.remove();
           j.addActionListener(new ActionListener(){  
        	   public void actionPerformed(ActionEvent e){ 
        		   AddFiletoRPanel(subdir,rightpanell);
        		   
        	                 
        	           }  
        	       });
           
           j1.addActionListener(new ActionListener(){  
        	   public void actionPerformed(ActionEvent e){ 
        		   AddFilewithdeatailstoRPanel(subdir,rightpanell);
        		   
        	                 
        	           }  
        	       });
           frame.invalidate();
           frame.validate();
           frame.repaint();
           AddFiletoRPanel(subdir,rightpanell);
           treemode.reload();
           
             }
    }
    });
             }
    
    
//Create Icon for treenodes
       /** Returns an ImageIcon, or null if the path was invalid.
     * @param path
     * @return  */
    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = CreateDirectoryTree.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
//End of creating icons
    
        private void createlowChildren(File fileRoot, DefaultMutableTreeNode root)
    {
        File[] files = fileRoot.listFiles();
        if ( files != null )
        {
            for( File child : files )
            	
            {

                DefaultMutableTreeNode childNode = new DefaultMutableTreeNode( new FileNodes( child ) );
                if( child.isDirectory() )
                {
                    root.add( childNode );
                    //createChildren( child, childNode );
                }
            }
        }
    }
        private void AddFiletoRPanel(File fileRoot, JPanel right){
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
          list = new JList(model);
          
       
          right.add(list);
          new PopupFeature(list,right);
          right.revalidate();
          right.repaint();
    }
        private void AddFilewithdeatailstoRPanel(File fileRoot, JPanel right){
        	 File[] files = fileRoot.listFiles();
        	 BasicFileAttributes attr;
        	 
        	 //DefaultTableModel tableModel = new DefaultTableModel();
        	 String[][] arr = new String[files.length][3];
        	 int i=0,j=0;
        	 String[] columns = {"FileName", "Modified Date/Time", "Size(bytes)"};
        	 right.removeAll();
        	 DefaultListModel model = new DefaultListModel();
        	 
        	 

        	 
            if ( files != null )

        {   
            for( File child : files )
            { 
                String temp = child.toString();
        	    model.addElement( new MusicFile( child ) );
            	Path path = child.toPath();
            	//System.out.println(path+"hi");

                try {
                	
					attr = Files.readAttributes(path,BasicFileAttributes.class);
					System.out.println("lastModifiedTime: " + attr.lastModifiedTime());
	            	j=1;
	            	//arr[i][j++] = child.getName();
	            	arr[i][j++] = String.valueOf(attr.lastModifiedTime());
	            	arr[i][j++] = String.valueOf(child.length());
	            	i++;
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                

                //System.out.println("creationTime: " + attr.creationTime());

            	
            	//SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
//            	tableModel.addRow(child.getName(),child.lastModified(),child.length());
//            	
//            	jmode.addElement(child.getName()+sdf.format(child.lastModified())+"  "+child.length()+"bytes");
            	//jmode.addElement(child.toPath());
            	//jmodes.addElement(sdf.format(child.lastModified()));
//            	jmode.addElement(child.length()); //add bytes after it

            }
        } 
        JList list = new JList(model);
        list.setBounds(19, 19, 100, 200);
        JTable table = new JTable(arr,columns); 
        table.setCellSelectionEnabled(false);
        table.setBounds(100,200,100,200);
        JTableHeader header = table.getTableHeader();
        table.setShowGrid(false);
  
        right.add(list); 
        right.add(table);
        right.add(header, BorderLayout.NORTH);  
         // right.add(table);
          right.revalidate();
          right.repaint();
    
        list.addMouseListener( new MouseAdapter() {
        	   public void mouseClicked(MouseEvent e) {
        	     if(e.getClickCount() == 2){
        	       MusicFile mf = (MusicFile)list.getModel().getElementAt( list.getSelectedIndex());
        	       File path = mf.getFile();
        	       //String str = FileUtils.readFileToString(path, "UTF-8");
        	       try {
					Runtime.getRuntime().exec("C:\\Users\\anku0\\OneDrive\\Desktop");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

        	       // now play the file
          new PopupFeature(list,right);
        	      // mf.getFile() );
        	     }
        	   }
        	});
}}


 class MusicFile {
	  File mf;

	  public MusicFile(File f){
	     this.mf = f;
	   }
	 
	  public File getFile() {
	    return mf;
	  }
	 // basic method required to display an object in the JList as a String
	  public String toString() {
	     return mf.getName();
	  }
	  // more methods can be added to complete the class
	}