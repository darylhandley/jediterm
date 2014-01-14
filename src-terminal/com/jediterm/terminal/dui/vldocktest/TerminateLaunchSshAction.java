package com.jediterm.terminal.dui.vldocktest;

import com.jediterm.ssh.jsch.JSchTtyConnector;
import com.jediterm.terminal.dui.SshConnectionConfig;
import com.jediterm.terminal.ui.TerminalSession;
import com.jediterm.terminal.ui.TerminalWidget;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Created with IntelliJ IDEA.
 * User: daryl
 * Date: 2013-12-13
 * Time: 2:20 PM
 * To change this template use File | Settings | File Templates.
 */
public class TerminateLaunchSshAction extends AbstractAction {

    private SshConnectionConfig config;
    private TerminateMainFrame terminateMainFrame;

    public TerminateLaunchSshAction(SshConnectionConfig config, TerminateMainFrame terminateMainFrame) {
        super(config.name);
        this.config = config;
        this.terminateMainFrame = terminateMainFrame;
    }

    public void actionPerformed(final ActionEvent e) {
        terminateMainFrame.launchSshSession(config);
    }
}
