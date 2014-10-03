package veloterm.ui;

import com.google.common.collect.Maps;
import com.jediterm.pty.PtyMain;
import com.jediterm.ssh.jsch.JSchTtyConnector;
import com.jediterm.terminal.TtyConnector;
import com.jediterm.terminal.ui.JediTermWidget;
import com.jediterm.terminal.ui.TerminalSession;
import com.jediterm.terminal.ui.TerminalWidget;
import com.jediterm.terminal.ui.UIUtil;
import com.pty4j.PtyProcess;
import com.vldocking.swing.docking.DockKey;
import com.vldocking.swing.docking.Dockable;
import veloterm.model.SshConnectionConfig;

import javax.swing.*;
import java.awt.*;
import java.nio.charset.Charset;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: daryl
 * Date: 2013-12-13
 * Time: 11:02 PM
 * To change this template use File | Settings | File Templates.
 */
public class TerminalPanel extends JPanel implements Dockable {

    private DockKey key = new DockKey("terminalPanel");

    private TerminalWidget myTerminal;

    public TerminalPanel(SshConnectionConfig connConfig) {

        // this should probably be unique, but it seems to be ok for now.
        key = new DockKey("terminalPanel");

        setLayout(new BorderLayout());

        TtyConnector ttyConnector  = null;
        if (connConfig.host.equals("localhost")) {
            ttyConnector = createTerminalTtyConnector();
        } else {
            ttyConnector = new JSchTtyConnector(connConfig.host, connConfig.username, connConfig.password);
        }

        JediTermWidget jtWidget = new JediTermWidget(new VeloTermSettingsProvider());
        TerminalSession session = jtWidget.createTerminalSession(ttyConnector);
        session.start();

        add(jtWidget, BorderLayout.CENTER);

        key.setName(connConfig.name);
        key.setAutoHideEnabled(false);


    }


    public TtyConnector createTerminalTtyConnector() {
        try {
            Map<String, String> envs = Maps.newHashMap(System.getenv());
            envs.put("TERM", "xterm");
            String[] command = new String[]{"/bin/bash", "--login"};

            if (UIUtil.isWindows) {
                command = new String[]{"cmd.exe"};
            }

            PtyProcess process = PtyProcess.exec(command, envs, null);

            return new PtyMain.LoggingPtyProcessTtyConnector(process, Charset.forName("UTF-8"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
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
