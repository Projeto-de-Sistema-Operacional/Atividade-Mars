package mars.tools;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import mars.*;

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
        JPanel panel = new JPanel(new BorderLayout());

        JTextArea message = new JTextArea();
        message.setEditable(false);
        message.setLineWrap(true);
        message.setWrapStyleWord(true);
        message.setFont(new Font("Arial", Font.PLAIN, 12));
        message.setText("This is a Preemptive Scheduling Tool." +
                "\nYou can add your UI components and logic here.");

        panel.add(new JScrollPane(message), BorderLayout.CENTER);

        return panel;
    }
}