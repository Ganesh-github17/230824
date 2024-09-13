import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class RegistrationForm {

    // A class to represent an attendee
    static class Attendee {
        String name;
        String email;

        Attendee(String name, String email) {
            this.name = name;
            this.email = email;
        }

        @Override
        public String toString() {
            return "Name: " + name + ", Email: " + email;
        }
    }

    // Store the attendees
    private static final ArrayList<Attendee> attendees = new ArrayList<>();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(RegistrationForm::createAndShowGUI);
    }

    private static void createAndShowGUI() {
        // Create the frame
        JFrame frame = new JFrame("Event Registration");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Create panel with GridBagLayout
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        frame.add(panel);

        // GridBagConstraints settings
        gbc.insets = new Insets(5, 5, 5, 5); // Padding
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Name label
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.2;
        JLabel nameLabel = new JLabel("Name:");
        panel.add(nameLabel, gbc);

        // Name field
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 0.8;
        JTextField nameField = new JTextField();
        panel.add(nameField, gbc);

        // Email label
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0.2;
        JLabel emailLabel = new JLabel("Email:");
        panel.add(emailLabel, gbc);

        // Email field
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 0.8;
        JTextField emailField = new JTextField();
        panel.add(emailField, gbc);

        // Submit button
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.NONE;
        JButton submitButton = new JButton("Register");
        panel.add(submitButton, gbc);

        // Output area
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.weighty = 1.0;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        JTextArea outputArea = new JTextArea(10, 30);
        outputArea.setEditable(false);
        panel.add(new JScrollPane(outputArea), gbc);

        // Button action
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String email = emailField.getText();

                if (name.isEmpty() || email.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Name and email cannot be empty", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                Attendee attendee = new Attendee(name, email);
                attendees.add(attendee);
                nameField.setText("");
                emailField.setText("");

                // Display the attendees
                StringBuilder sb = new StringBuilder();
                sb.append("Attendees:\n");
                for (Attendee a : attendees) {
                    sb.append(a).append("\n");
                }
                outputArea.setText(sb.toString());
            }
        });

        // Show the frame
        frame.setVisible(true);
    }
}

