package veloterm.ui;

import com.google.common.io.Files;
import veloterm.model.SshConnectionConfig;
import veloterm.util.Log;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.LinkedList;
import java.util.List;

/**
 * Singleton controller for communicating in Terminate app.
 */
public class VeloTermController {
    private static VeloTermController theInstance;

    // supposedly this works on linux and mac but not so great on windows
    // http://stackoverflow.com/questions/585534/what-is-the-best-way-to-find-the-users-home-directory-in-java
    private static String filename = System.getProperty("user.home") + "/.veloterm/connections";

    private VeloTermController() {

    }

    public static VeloTermController get() {
        if (theInstance == null) {
            theInstance = new VeloTermController();
        }
        return theInstance;
    }

    public LinkedList<SshConnectionConfig> loadConnectionsFromFile() {
        LinkedList<SshConnectionConfig> list = new LinkedList<SshConnectionConfig>();

        try {
            File file = new File(filename);
            List<String> lines = Files.readLines(file, Charset.forName("UTF-8"));

            // for each line in the file, add it to the ssh config list
            // each line is a | separated of
            // name|hostname|username|password
            for (String line: lines) {
                list.add(lineToConnectionConfig(line));
            }

        } catch (IOException ioExcp) {
            // should we just swallow this ?
            // throw new RuntimeException("unable to load connections", ioExcp);
            Log.info("unable to load connections");
        }
        return list;
    }

    SshConnectionConfig lineToConnectionConfig(String line) {
        String [] splits = line.split("\\|");

        SshConnectionConfig config = new SshConnectionConfig(
            getAtIndex(splits, 0),
            getAtIndex(splits, 1),
            getAtIndex(splits, 2),
            getAtIndex(splits, 3)
        );

        return config;

    }

    private String getAtIndex(String [] strArray, int index) {
        if (strArray.length > index) {
            return strArray[index];
        } else {
            return "";
        }
    }



}
