package com.jediterm.terminal.dui.vldocktest;

import com.vldocking.swing.docking.DockKey;
import com.vldocking.swing.docking.Dockable;

import javax.swing.*;
import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: daryl
 * Date: 2013-12-13
 * Time: 5:39 PM
 * To change this template use File | Settings | File Templates.
 */
class MyGridOfButtons extends JPanel implements Dockable {

    DockKey key = new DockKey("myGridOfButtons");

    public MyGridOfButtons() {
        setLayout(new FlowLayout(FlowLayout.TRAILING, 3, 3));
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                add(new JButton("btn" + (i * 3 + j)));
            }
        }
        setPreferredSize(new Dimension(200,300));
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