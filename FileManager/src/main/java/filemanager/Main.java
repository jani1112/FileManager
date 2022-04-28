package filemanager;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.DropMode;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.TransferHandler;

class ListTransferHandler extends TransferHandler {
   @Override/* w  w  w  .   d e  m   o2    s . c   o   m*/
   public int getSourceActions(JComponent c) {
      return TransferHandler.COPY_OR_MOVE;
   }

   @Override
   protected Transferable createTransferable(JComponent source) {
      // Suppress the unchecked cast warning
      @SuppressWarnings("unchecked")
      JList<String> sourceList = (JList<String>) source;

      String data = sourceList.getSelectedValue();

      // Uses only the first selected item in the list
      Transferable t = new StringSelection(data);
      return t;
   }

   @Override
   protected void exportDone(JComponent source, 
                             Transferable data, int action) {
      // Suppress the unchecked cast warning
      @SuppressWarnings("unchecked")
      JList<String> sourceList = (JList<String>) source;

      String movedItem = sourceList.getSelectedValue();

      if (action == TransferHandler.MOVE) {
         // Remove the moved item
         DefaultListModel<String> listModel = 
                        (DefaultListModel<String>) sourceList.getModel();
         listModel.removeElement(movedItem);
      }
   }

   @Override
   public boolean canImport(TransferHandler.TransferSupport support) {
      // We only support drop, not copy-paste
      if (!support.isDrop()) {
         return false;
      }

      return support.isDataFlavorSupported(DataFlavor.stringFlavor);
   }

   @Override
   public boolean importData(TransferHandler.TransferSupport support) {
      // This is necessary to handle paste
      if (!this.canImport(support)) {
         return false;
      }

      // Get the data
      Transferable t = support.getTransferable();
      String data = null;
      try {
         data = (String) t.getTransferData(DataFlavor.stringFlavor);
         if (data == null) {
            return false;
         }
      } catch (UnsupportedFlavorException | IOException e) {
         e.printStackTrace();
         return false;
      }

      // Get the drop location for the JList
      JList.DropLocation dropLocation = 
                    (JList.DropLocation) support.getDropLocation();

      int dropIndex = dropLocation.getIndex();

      // Suppress the unchecked cast warning
      @SuppressWarnings("unchecked")
      JList<String> targetList = (JList<String>) support.getComponent();

      DefaultListModel<String> listModel = 
                  (DefaultListModel<String>) targetList.getModel();

      if (dropLocation.isInsert()) {
         listModel.add(dropIndex, data);
      } else {
         listModel.set(dropIndex, data);
      }

      return true;
   }
}

public class Main extends JFrame {
   private JLabel newLabel = new JLabel("New:");
   private JTextField newTextField = new JTextField(10);
   private JLabel sourceLabel = new JLabel("Source");
   private JLabel destLabel = new JLabel("Destination");
   private JList<String> sourceList = new JList<>(new DefaultListModel<>());
   private JList<String> destList = new JList<>(new DefaultListModel<>());

   public Main(String title) {
      super(title);
      DefaultListModel<String> sourceModel = 
                 (DefaultListModel<String>) sourceList.getModel();

      DefaultListModel<String> destModel = 
                 (DefaultListModel<String>) destList.getModel();
      for (int i = 0; i < 5; i++) {
         sourceModel.add(i, "Source Item " + i);
         destModel.add(i, "Destination Item " + i);
      }

      Container contentPane = this.getContentPane();

      Box nameBox = Box.createHorizontalBox();
      nameBox.add(newLabel);
      nameBox.add(newTextField);

      Box sourceBox = Box.createVerticalBox();
      sourceBox.add(sourceLabel);
      sourceBox.add(new JScrollPane(sourceList));

      Box destBox = Box.createVerticalBox();
      destBox.add(destLabel);
      destBox.add(new JScrollPane(destList));

      Box listBox = Box.createHorizontalBox();
      listBox.add(sourceBox);
      listBox.add(destBox);

      Box allBox = Box.createVerticalBox();
      allBox.add(nameBox);
      allBox.add(listBox);

      contentPane.add(allBox, BorderLayout.CENTER);

      // Our lists support only single selection
      sourceList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
      destList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

      // Enable Drag and Drop for components
      newTextField.setDragEnabled(true);
      sourceList.setDragEnabled(true);
      destList.setDragEnabled(true);

      // Set the drop mode to Insert
      sourceList.setDropMode(DropMode.INSERT);
      destList.setDropMode(DropMode.INSERT);

      // Set the transfer handler
      sourceList.setTransferHandler(new ListTransferHandler());
      destList.setTransferHandler(new ListTransferHandler());
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(() -> {
         Main frame = new Main("Drag and Drop Frame");
         frame.pack();
         frame.setVisible(true);
      });
   }
}