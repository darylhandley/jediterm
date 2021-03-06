package veloterm.ui;

import junit.framework.TestCase;
import veloterm.model.SshConnectionConfig;

/**
 * Created with IntelliJ IDEA.
 * User: daryl
 * Date: 2014-01-10
 * Time: 5:07 PM
 * To change this template use File | Settings | File Templates.
 */
public class TerminateControllerTest extends TestCase {

    VeloTermController terminateController = VeloTermController.get();

    public void testLineToConnectionConfig() {

        SshConnectionConfig config = terminateController.lineToConnectionConfig("name|host|username|password");

        assertEquals("name", config.name);
        assertEquals("host", config.host);
        assertEquals("username", config.username);
        assertEquals("password", config.password);

    }

    public void testLineToConnectionConfig_incompleteLine() {

        SshConnectionConfig config = terminateController.lineToConnectionConfig("name|host");

        assertEquals("name", config.name);
        assertEquals("host", config.host);
        assertEquals("", config.username);
        assertEquals("", config.password);

    }

}
