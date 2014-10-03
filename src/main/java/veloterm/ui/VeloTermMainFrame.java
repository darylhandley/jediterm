package veloterm.ui;

import com.vldocking.swing.docking.Dockable;
import com.vldocking.swing.docking.DockingConstants;
import com.vldocking.swing.docking.DockingDesktop;
import veloterm.model.SshConnectionConfig;
import veloterm.util.Log;

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
public class VeloTermMainFrame extends JFrame  {


    final JMenu connectionsMenu = new JMenu("Connections");

    DockingDesktop terminalsDesktop = new DockingDesktop();

    private VeloTermController terminateController = VeloTermController.get();

    private TerminalPanel terminalPanel1;

    public VeloTermMainFrame(){

        // System.setProperty("com.apple.mrj.application.apple.menu.about.name", "My App Name");

        final JMenuBar mb = getJMenuBar();
        this.setJMenuBar(mb);

        this.setTitle("Velocity Terminal");


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
        terminalPanel1 = new TerminalPanel(sshConfig);
        terminalsDesktop.addDockable(terminalPanel1);

        // desk.split(editorPanel, terminalPanel, DockingConstants.SPLIT_BOTTOM);

        TerminalPanel terminalPanel2 = new TerminalPanel(sshConfig);
        terminalsDesktop.split(terminalPanel1, terminalPanel2, DockingConstants.SPLIT_RIGHT);

        TerminalPanel terminalPanel3 = new TerminalPanel(sshConfig);
        terminalsDesktop.split(terminalPanel1, terminalPanel3, DockingConstants.SPLIT_BOTTOM);

        TerminalPanel terminalPanel4 = new TerminalPanel(sshConfig);
        terminalsDesktop.split(terminalPanel2, terminalPanel4, DockingConstants.SPLIT_BOTTOM);


        // need to set the focus so that we can have a focused element when we add our first
        //
//        terminalPanel1.grabFocus();
//        terminalPanel1.requestFocus(false);
//
//        terminalPanel1.setRequestFocusEnabled(true);
//        terminalPanel1.requestFocusInWindow();


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
        Dockable selected = terminalsDesktop.getLastFocused();
        Log.info("selected is " + selected);


        // bit of a hack, coz I can't figure out how to give it
        // focus on start up. may also be because of the getLastFocused method that I added.
        if (selected == null) {
            selected = terminalPanel1;
        }


        terminalsDesktop.createTab(selected, terminalPanel, 0, true);
        // terminalsDesktop.terminalsDesktop.
        terminalPanel.grabFocus();
        terminalPanel.setRequestFocusEnabled(true);
        terminalPanel.requestFocus(false);

        terminalPanel.setRequestFocusEnabled(true);
        terminalPanel.requestFocusInWindow();





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
            connectionsMenu.add(new LaunchSshAction(
                connConfig,
                this
            ));
        }

        return mb;
    }

    public static void main(String[] args){
        final VeloTermMainFrame frame = new VeloTermMainFrame();
        frame.setSize(1400,1100);
        frame.validate();
        SwingUtilities.invokeLater(new Runnable(){
            // in the event dispatch thread
            public void run(){
                frame.setVisible(true);
            }
        });
    }

    private void addToConnectionsMenu(String name, String host, String username, String password) {

        connectionsMenu.add(new LaunchSshAction(
                new SshConnectionConfig(name, host, username, password),
                this
        ));

        System.out.println(name + "|" + host + "|" + username + "|" + password );

    }


}
