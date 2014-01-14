package com.jediterm.terminal.dui.vldocktest;

import com.jediterm.terminal.dui.SshConnectionConfig;
import com.vldocking.swing.docking.DockKey;
import com.vldocking.swing.docking.Dockable;
import com.vldocking.swing.docking.DockingConstants;
import com.vldocking.swing.docking.DockingDesktop;

import javax.swing.*;
import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: daryl
 * Date: 2013-12-13
 * Time: 5:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class MyFirstFrame extends JFrame  {

    MyTextEditor editorPanel = new MyTextEditor();
    MyTree treePanel = new MyTree();
    MyGridOfButtons buttonGrid = new MyGridOfButtons();
    MyJTable tablePanel = new MyJTable();

    DockingDesktop desk = new DockingDesktop();

    public MyFirstFrame(){
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        getContentPane().add(desk);

//        getContentPane().add(editorPanel, BorderLayout.CENTER);
//        getContentPane().add(treePanel, BorderLayout.WEST);
//        getContentPane().add(buttonGrid, BorderLayout.NORTH);
//        getContentPane().add(tablePanel, BorderLayout.EAST);

        desk.addDockable(editorPanel);
        // desk.split(editorPanel, treePanel, DockingConstants.SPLIT_LEFT);
        desk.createTab(editorPanel, treePanel, 0);
        desk.split(editorPanel, buttonGrid, DockingConstants.SPLIT_RIGHT);
        desk.split(buttonGrid, tablePanel, DockingConstants.SPLIT_BOTTOM);

        SshConnectionConfig sshConfig = new SshConnectionConfig("Work PC",
                "184.70.0.58:2223", "daryl", "ne1410s");
        TerminalPanel terminalPanel = new TerminalPanel(sshConfig);
        desk.split(editorPanel, terminalPanel, DockingConstants.SPLIT_BOTTOM);


    }

    public static void main(String[] args){
        final MyFirstFrame frame = new MyFirstFrame();
        frame.setSize(800,600);
        frame.validate();
        SwingUtilities.invokeLater(new Runnable(){
            // in the event dispatch thread
            public void run(){
                frame.setVisible(true);
            }
        });
    }
}
