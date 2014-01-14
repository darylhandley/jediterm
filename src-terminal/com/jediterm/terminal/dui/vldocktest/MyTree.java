package com.jediterm.terminal.dui.vldocktest;

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
class MyTree extends JPanel implements Dockable {

    DockKey key = new DockKey("myTree");
    JTree tree = new JTree();
    public MyTree() {
        setLayout(new BorderLayout());
        JScrollPane jsp = new JScrollPane(tree);
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
