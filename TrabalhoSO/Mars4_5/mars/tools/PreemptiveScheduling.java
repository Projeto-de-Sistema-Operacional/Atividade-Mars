package mars.tools;

import javax.swing.*;
import java.awt.*;

public class PreemptiveScheduling extends AbstractMarsToolAndApplication {

    private static String heading = "Preemptive Scheduling Tool";
    private static String version = " Version 1.0";

    public PreemptiveScheduling(String title, String heading) {
        super(title, heading);
    }

    public PreemptiveScheduling() {
        super(heading + ", " + version, heading);
    }

    public static void main(String[] args) {
        new PreemptiveScheduling(heading + ", " + version, heading).go();
    }

    public String getName() {
        return "Preemptive Scheduling";
    }

    protected JComponent buildMainDisplayArea() {
        JPanel panel = new JPanel(null);

        JComboBox<String> choiceBox = new JComboBox<>();
        choiceBox.setBounds(139, 40, 149, 25);

        JLabel preemptiveLabel = new JLabel("Preemptive Scheduling");
        preemptiveLabel.setBounds(139, 14, 150, 25);

        JLabel instructionsLabel = new JLabel("Instructions so far:");
        instructionsLabel.setBounds(35, 73, 120, 25);

        JTextField instructionsTextField = new JTextField();
        instructionsTextField.setBounds(139, 69, 150, 25);

        JLabel interruptionsLabel = new JLabel("Interruptions so far:");
        interruptionsLabel.setBounds(28, 103, 130, 25);

        JTextField interruptionsTextField = new JTextField();
        interruptionsTextField.setBounds(139, 99, 150, 25);

        JLabel timeSoFarLabel = new JLabel("Time so far:");
        timeSoFarLabel.setBounds(70, 133, 90, 25);

        JTextField timeSoFarTextField = new JTextField();
        timeSoFarTextField.setBounds(139, 129, 150, 25);
        timeSoFarTextField.setText("0%");

        JToggleButton onOffToggleButton = new JToggleButton("On/Off");
        onOffToggleButton.setBounds(297, 99, 80, 25);

        JSpinner timerSpinner = new JSpinner();
        timerSpinner.setBounds(139, 161, 150, 25);

        JLabel timeLabel = new JLabel("Time:");
        timeLabel.setBounds(101, 165, 80, 25);

        JTextArea message = new JTextArea();
        message.setEditable(false);
        message.setLineWrap(true);
        message.setWrapStyleWord(true);
        message.setFont(new Font("Arial", Font.PLAIN, 12));
        message.setText("This is a Preemptive Scheduling Tool." +
                "\nYou can add your UI components and logic here.");

        panel.add(choiceBox);
        panel.add(preemptiveLabel);
        panel.add(instructionsLabel);
        panel.add(instructionsTextField);
        panel.add(interruptionsLabel);
        panel.add(interruptionsTextField);
        panel.add(timeSoFarLabel);
        panel.add(timeSoFarTextField);
        panel.add(onOffToggleButton);
        panel.add(timerSpinner);
        panel.add(timeLabel);
        panel.add(new JScrollPane(message), BorderLayout.CENTER);

        return panel;
    }
}