import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class RegistrationForm {

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
        frame.setLayout(new GridLayout(0, 1));

        // Create panel for form
        JPanel panel = new JPanel(new GridLayout(3, 2));
        frame.add(panel);

        // Name label and field
        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField();
        panel.add(nameLabel);
        panel.add(nameField);

        // Email label and field
        JLabel emailLabel = new JLabel("Email:");
        JTextField emailField = new JTextField();
        panel.add(emailLabel);
        panel.add(emailField);

        // Submit button
        JButton submitButton = new JButton("Register");
        frame.add(submitButton);

        // Output area
        JTextArea outputArea = new JTextArea(10, 30);
        outputArea.setEditable(false);
        frame.add(new JScrollPane(outputArea));

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

