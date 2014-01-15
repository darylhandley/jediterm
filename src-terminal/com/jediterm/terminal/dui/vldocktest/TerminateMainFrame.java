package com.jediterm.terminal.dui.vldocktest;

import com.jediterm.terminal.dui.LaunchSshAction;
import com.jediterm.terminal.dui.SshConnectionConfig;
import com.jediterm.terminal.dui.TerminateController;
import com.vldocking.swing.docking.Dockable;
import com.vldocking.swing.docking.DockingConstants;
import com.vldocking.swing.docking.DockingDesktop;
import com.vldocking.swing.docking.DockingUtilities;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: daryl
 * Date: 2013-12-13
 * Time: 5:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class TerminateMainFrame extends JFrame  {


    final JMenu connectionsMenu = new JMenu("Connections");

    DockingDesktop terminalsDesktop = new DockingDesktop();

    private TerminateController terminateController = TerminateController.get();

    private Dockable editorPanel = new MyTextEditor();

    public TerminateMainFrame(){

        // System.setProperty("com.apple.mrj.application.apple.menu.about.name", "My App Name");

        final JMenuBar mb = getJMenuBar();
        this.setJMenuBar(mb);

        this.setTitle("Terminate");


        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        getContentPane().add(terminalsDesktop);

//        getContentPane().add(editorPanel, BorderLayout.CENTER);
//        getContentPane().add(treePanel, BorderLayout.WEST);
//        getContentPane().add(buttonGrid, BorderLayout.NORTH);
//        getContentPane().add(tablePanel, BorderLayout.EAST);

        // terminalsDesktop.addDockable(editorPanel);
        // desk.split(editorPanel, treePanel, DockingConstants.SPLIT_LEFT);
        // desk.createTab(editorPanel, treePanel, 0);
        // desk.split(editorPanel, buttonGrid, DockingConstants.SPLIT_RIGHT);
        // desk.split(buttonGrid, tablePanel, DockingConstants.SPLIT_BOTTOM);

        SshConnectionConfig sshConfig = new SshConnectionConfig("Local",
                "localhost", "", "");
        TerminalPanel terminalPanel1 = new TerminalPanel(sshConfig);
        terminalsDesktop.addDockable(terminalPanel1);

        // desk.split(editorPanel, terminalPanel, DockingConstants.SPLIT_BOTTOM);

        TerminalPanel terminalPanel2 = new TerminalPanel(sshConfig);
        terminalsDesktop.split(terminalPanel1, terminalPanel2, DockingConstants.SPLIT_RIGHT);

        TerminalPanel terminalPanel3 = new TerminalPanel(sshConfig);
        terminalsDesktop.split(terminalPanel1, terminalPanel3, DockingConstants.SPLIT_BOTTOM);

        TerminalPanel terminalPanel4 = new TerminalPanel(sshConfig);
        terminalsDesktop.split(terminalPanel2, terminalPanel4, DockingConstants.SPLIT_BOTTOM);


        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(final WindowEvent e) {
                System.exit(0);
            }
        });



//        TerminalPanel terminalPanel3 = new TerminalPanel(sshConfig);
//        desk.split(terminalPanel, terminalPanel3, DockingConstants.SPLIT_RIGHT);


    }

    public void launchSshSession(SshConnectionConfig sshConfig) {
        TerminalPanel terminalPanel = new TerminalPanel(sshConfig);
        Dockable selected = terminalsDesktop.getSelectedDockable();


        // add on top of selected (doesn't work, getSelectedDockable returns null)
        terminalsDesktop.createTab(selected, terminalPanel, 0);


        // add default
        // terminalsDesktop.addDockable(terminalPanel);

    }



    public JMenuBar getJMenuBar() {
        final JMenuBar mb = new JMenuBar();



        // set up the connections menu
        mb.add(connectionsMenu);

        // add a connection for localhost
        addToConnectionsMenu("Local", "localhost", "", "");


        // add a connection to menu bar for all connections loaded from the file
        List<SshConnectionConfig> connConfigs = terminateController.loadConnectionsFromFile();
        for (SshConnectionConfig connConfig : connConfigs) {
            connectionsMenu.add(new TerminateLaunchSshAction(
                connConfig,
                this
            ));
        }

        return mb;
    }

    public static void main(String[] args){
        final TerminateMainFrame frame = new TerminateMainFrame();
        frame.setSize(800,600);
        frame.validate();
        SwingUtilities.invokeLater(new Runnable(){
            // in the event dispatch thread
            public void run(){
                frame.setVisible(true);
            }
        });
    }

    private void addToConnectionsMenu(String name, String host, String username, String password) {

        connectionsMenu.add(new TerminateLaunchSshAction(
                new SshConnectionConfig(name, host, username, password),
                this
        ));

        System.out.println(name + "|" + host + "|" + username + "|" + password );

    }


}
