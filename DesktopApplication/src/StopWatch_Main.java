import javax.swing.*;

/**
 * class that serves as entry point for  stopwatch application.
 * It initializes and launches stopwatch frame.
 */
public class StopWatch_Main {
    public static void main(String[] args) {
        // ensures that GUI is created and manipulated on EDT for thread safety.
        SwingUtilities.invokeLater(() -> {
            // create and display main frame of the stopwatch application
            StopWatch_Frame frame = new StopWatch_Frame();
            frame.setVisible(true); // make window visible to user
        });
    }
}


