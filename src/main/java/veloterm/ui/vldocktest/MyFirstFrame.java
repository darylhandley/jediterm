package veloterm.ui.vldocktest;

import veloterm.model.SshConnectionConfig;
import com.vldocking.swing.docking.Dockable;
import com.vldocking.swing.docking.DockingConstants;
import com.vldocking.swing.docking.DockingDesktop;
import veloterm.ui.TerminalPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Just a class for testing vldocking stuff.
 */
public class MyFirstFrame extends JFrame {

    MyTextEditor editorPanel = new MyTextEditor();
    MyTextEditor editorPanel2 = new MyTextEditor();
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
        desk.split(editorPanel, treePanel, DockingConstants.SPLIT_LEFT);
        desk.split(editorPanel, buttonGrid, DockingConstants.SPLIT_RIGHT);
        desk.split(buttonGrid, tablePanel, DockingConstants.SPLIT_BOTTOM);
        desk.split(buttonGrid, editorPanel2, DockingConstants.SPLIT_BOTTOM);

        TerminalPanel terminalPanel4 = new TerminalPanel(new SshConnectionConfig("localhost", "localhost", "", ""));
        desk.split(buttonGrid, terminalPanel4, DockingConstants.SPLIT_BOTTOM);

        final JMenuBar mb = getJMenuBar();
        this.setJMenuBar(mb);
    }

    public static void main(String[] args){
        final MyFirstFrame frame = new MyFirstFrame();
        frame.setSize(800, 600);
        frame.validate();
        SwingUtilities.invokeLater(new Runnable(){
            // in the event dispatch thread
            public void run(){
                frame.setVisible(true);
            }
        });
    }

    public JMenuBar getJMenuBar() {
        final JMenuBar mb = new JMenuBar();


        final JMenu firstMenu = new JMenu("Do Stuff");

        // set up the menu
        mb.add(firstMenu);

        firstMenu.add(new AbstractAction("Invoke it") {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("it is invoked");
                Dockable selected = desk.getLastFocused();
                System.out.println("selected is " + selected);
            }
        });



        return mb;
    }
}
