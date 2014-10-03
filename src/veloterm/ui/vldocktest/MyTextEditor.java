package veloterm.ui.vldocktest;

import com.vldocking.swing.docking.DockKey;
import com.vldocking.swing.docking.Dockable;

import javax.swing.*;
import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: daryl
 * Date: 2013-12-13
 * Time: 5:38 PM
 * To change this template use File | Settings | File Templates.
 */
class MyTextEditor extends JPanel implements Dockable {
    JTextArea textArea = new JTextArea("A Text Area");

    DockKey key = new DockKey("textEditor");

    public MyTextEditor() {
        setLayout(new BorderLayout());
        JScrollPane jsp = new JScrollPane(textArea);
        jsp.setPreferredSize(new Dimension(300, 400));
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