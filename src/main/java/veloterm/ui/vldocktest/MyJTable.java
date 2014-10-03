package veloterm.ui.vldocktest;

import com.vldocking.swing.docking.DockKey;
import com.vldocking.swing.docking.Dockable;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: daryl
 * Date: 2013-12-13
 * Time: 5:40 PM
 * To change this template use File | Settings | File Templates.
 */
class MyJTable extends JPanel implements Dockable {

    DockKey key = new DockKey("myJTable");

    JTable table = new JTable();
    public MyJTable() {
        setLayout(new BorderLayout());
        table.setModel(new DefaultTableModel(5, 5));
        JScrollPane jsp = new JScrollPane(table);
        jsp.setPreferredSize(new Dimension(200, 200));
        add(jsp, BorderLayout.CENTER);
    }

    @Override
    public DockKey getDockKey() {
        return key;
    }

    @Override
    public Component getComponent() {
        return this;
    }
}