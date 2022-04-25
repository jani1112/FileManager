/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package filemanager;

import java.awt.Component;
import java.io.File;
import javax.swing.Icon;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

/**
 *
 * @author 027950206
 */
public class CreateDirectoryTree {

    CreateDirectoryTree(File GetCurrDir, JPanel leftpanel) {
        DefaultMutableTreeNode root = new DefaultMutableTreeNode(new FileNodes(GetCurrDir));
        DefaultTreeModel treeModel = new DefaultTreeModel(root);

        JTree tree = new JTree(treeModel);
        tree.setCellRenderer(new DefaultTreeCellRenderer() {
            private final Icon loadIcon = UIManager.getIcon("OptionPane.errorIcon");
            private final Icon saveIcon = UIManager.getIcon("OptionPane.informationIcon");
            @Override
            public Component getTreeCellRendererComponent( JTree tree,
                                                           Object value,
                                                           boolean bSelected,
                                                           boolean bExpanded,
                                                           boolean bLeaf,
                                                           int iRow,
                                                           boolean bHasFocus ) {
                Component c = super.getTreeCellRendererComponent(tree, value,
                        bSelected, bExpanded, false, iRow, bHasFocus);

                return c;
            }
        });
        tree.setShowsRootHandles(true);
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
           treemode.reload();
           
             }
    }
    });
             }
    
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
}