import javax.swing.*;
import java.awt.*;

/**
 *  class represents the main window frame of the stopwatch application
 * extends JFrame and manages layout of components within  window
 */
public class StopWatch_Frame extends JFrame {

    // panel that contains all components of stopwatch
    static StopWatch_Panel stopwatchPanel;

    /**
     * constructor for StopWatch_Frame class
     *  sets  frame's properties like title, size, layout and adds the stopwatch panel
     */
    public StopWatch_Frame() {
        // set title of frame that appears in window's title bar
        setTitle("Stopwatch");
        // set the size of  window
        setSize(600, 200);
        // specify that  application should exit when  window is closed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // use BorderLayout for organise component in frame
        setLayout(new BorderLayout());

        //create an instance of StopWatch_Panel to add in center of  frame
        stopwatchPanel = new StopWatch_Panel();
        add(stopwatchPanel, BorderLayout.CENTER);

        //center  window on screen
        setLocationRelativeTo(null);
    }
}

