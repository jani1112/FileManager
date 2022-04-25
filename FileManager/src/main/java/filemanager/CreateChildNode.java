package filemanager;


import java.io.File;
import javax.swing.tree.DefaultMutableTreeNode;

class CreateChildNode implements Runnable {

    private DefaultMutableTreeNode root;

    private File fileRoot;

    public CreateChildNode(File fileRoot, DefaultMutableTreeNode root) {
        this.fileRoot = fileRoot;
        this.root = root;
    }

    @Override
    public void run() {
        createChildren(fileRoot, root);
    }

    private void createChildren(File fileRoot, DefaultMutableTreeNode root)
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


class FileNodes {

    private File file;

    public FileNodes(File file) {
        this.file = file;
    }
    public File getFile() {
        return file;
    }

    @Override
    public String toString() {
        String name = file.getName();
        if (name.equals("")) {
            return file.getAbsolutePath();
        } else {
            return name;
        }
    }
}