import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * class handles functionality of  stopwatch.
 * tracks to write time in hours, minutes, and seconds, starts, pauses, and resets the timer.
 */
public class StopWatch_Timer {

    // tracks  number of seconds run when stopwatch started
  static int second = 0;
    // indicates whether stopwatch is currently running
    static boolean isRunning = false;
    // timer instance that triggers every second
    static Timer timer;
    // JLabel to display time
    static JLabel timeDisplay;

    /**
     * constructor for StopWatch_Timer.
     * initializes  timer and  time to display label.
     */
    public  StopWatch_Timer(JLabel timeDisplay) {
        this.timeDisplay = timeDisplay;
        // set  timer to fire an event every 1000 ms
        timer = new Timer(50, new TimerListener());
    }

    /**
     * method to starts stopwatch when it already running, no action is taken.
     */
    public static void start() {
        if (!isRunning) {
            isRunning = true;  // set stopwatch to running state
            timer.start();     // Start the timer
        }
    }

    /**
     * method to pauses stopwatch and maintain time
     */
    public static void pause() {
        isRunning = false;  // set stopwatch to paused state
        timer.stop();       // stop the timer
    }

    /**
     * method to resets stopwatch to 00:00:00. pauses timer first and resets the time
     */
    public static void reset() {
        pause();             // pause p timer
        second = 0;  // reset time to zero
        updateTimeDisplay(); // update time  to display
    }

    /**
     * method to update time display in HH:MM:SS
     * time is displayed as hours, minutes, and seconds.
     */
  public static  void updateTimeDisplay() {
        // calculate hours minutes and seconds from total time in seconds
        int hours = second / 3600;   // 1 hour = 3600 seconds
        int minutes = (second % 3600) / 60;   // calculate minutes
        int seconds = second % 60;   // calculate remaining seconds

        // update  time label  in HH:MM:SS format
        timeDisplay.setText(String.format("%02d:%02d:%02d", hours, minutes, seconds));
    }

    /**
     *  class listens method  for timer events in second and updates  time.
     */
    public static class TimerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            second++; // incease time by 1 second
            updateTimeDisplay(); // update display with new time
        }
    }
}
