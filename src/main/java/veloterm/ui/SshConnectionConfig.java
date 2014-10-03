package veloterm.ui;

/**
 * Created with IntelliJ IDEA.
 * User: daryl
 * Date: 2013-12-13
 * Time: 2:16 PM
 * To change this template use File | Settings | File Templates.
 */
public class SshConnectionConfig {

    public SshConnectionConfig(String name, String host, String username, String password) {
        this.name = name;
        this.host = host;
        this.username = username;
        this.password = password;
    }


    public String name;
    public String host;
    public String username;
    public String password;


}
