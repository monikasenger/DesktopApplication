import javax.swing.*;
import java.awt.*;

/**
 * class panel contains  UI components for  stopwatch
 * displays time and provides buttons for start, pause, and reset stopwatch
 */
public class StopWatch_Panel extends JPanel {

    // label to display time in HH:MM:SS format
    static JLabel timeDisplay;
    // buttons to control stopwatch
    static JButton startButton, pauseButton, resetButton;
    // timer logic that handles time update and control
   static StopWatch_Timer stopwatchTimer;

    /**
     * constructor for StopWatch_Panel class
     * initializes UI components like time display, buttons and sets their actions.
     */
    public StopWatch_Panel() {
        // set layout for panel and background color
        setLayout(new BorderLayout());
        setBackground(new Color(30, 30, 30)); // Dark background for a modern look

        // initialize label that display initial time
        timeDisplay = new JLabel("00:00:00", SwingConstants.CENTER);
        // set font and color for time display
        timeDisplay.setFont(new Font("Courier New", Font.BOLD, 60));
        timeDisplay.setForeground(new Color(170, 0, 255)); // light purple color
        timeDisplay.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // padding around  text
        // add  time display to center of  panel
        add(timeDisplay, BorderLayout.CENTER);

        // create and style  buttons
        startButton = createStyledButton("Start", Color.GREEN); // start button in green
        pauseButton = createStyledButton("Pause", Color.ORANGE); // pause button in orange
        resetButton = createStyledButton("Reset", Color.RED); // reset button in red

        // add action listeners to buttons to handle user clicks
        startButton.addActionListener(e -> stopwatchTimer.start());  // start the timer
        pauseButton.addActionListener(e -> stopwatchTimer.pause());  // pause the timer
        resetButton.addActionListener(e -> stopwatchTimer.reset());  // reset the timer

        // create a panel for holding the buttons, set layout and background color
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 10));  // centered buttons with padding
        buttonPanel.setBackground(new Color(30, 30, 30)); //same background as main panel
        // add buttons to  button panel
        buttonPanel.add(startButton);
        buttonPanel.add(pauseButton);
        buttonPanel.add(resetButton);
        // add  button panel to bottom of  main panel
        add(buttonPanel, BorderLayout.SOUTH);

        // initialize stopwatch timer and pass time in label
        stopwatchTimer = new StopWatch_Timer(timeDisplay);
    }

    /**
     *  method that creates a button with a  background color and padding.
     *
     * @param text  text to be displayed on  button
     * @param color  background color for  button
     * @return  newly created and  JButton
     */
   public static JButton createStyledButton(String text, Color color) {
        // create new button with  text
        JButton button = new JButton(text);
        // set font style and size for  button text
        button.setFont(new Font("Arial", Font.BOLD, 16));
        // set text color to white for button background
        button.setForeground(Color.WHITE);
        // set  background color of  button
        button.setBackground(color);
        // remove  focus outline
        button.setFocusPainted(false);
        // add padding to  button
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        // set  mouse cursor to hand on button
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return button;
    }
}
