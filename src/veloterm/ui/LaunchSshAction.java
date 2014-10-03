package veloterm.ui;

import com.jediterm.ssh.jsch.JSchTtyConnector;
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
public class LaunchSshAction extends AbstractAction {

    private SshConnectionConfig config;
    private TerminalWidget terminalWidget;

    public LaunchSshAction(SshConnectionConfig config, TerminalWidget terminalWidget) {
        super(config.name);
        this.config = config;
        this.terminalWidget = terminalWidget;
    }

    public void actionPerformed(final ActionEvent e) {
        if (terminalWidget.canOpenSession()) {
            JSchTtyConnector sshConnector = new JSchTtyConnector(config.host, config.username, config.password);
            TerminalSession session = terminalWidget.createTerminalSession(sshConnector);
            session.start();
        }
    }
}
