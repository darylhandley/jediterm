package veloterm.ui;

import veloterm.model.SshConnectionConfig;

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
    private VeloTermMainFrame terminateMainFrame;

    public LaunchSshAction(SshConnectionConfig config, VeloTermMainFrame terminateMainFrame) {
        super(config.name);
        this.config = config;
        this.terminateMainFrame = terminateMainFrame;
    }

    public void actionPerformed(final ActionEvent e) {
        terminateMainFrame.launchSshSession(config);
    }
}
