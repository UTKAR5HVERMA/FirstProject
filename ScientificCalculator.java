import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScientificCalculator extends JFrame implements ActionListener {
    private JTextField inputField;
    private JButton[] buttons;
    private String[] buttonLabels = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+",
            "sin", "cos", "tan", "sqrt",
            "(", ")", "C"
    };

    public ScientificCalculator() {
        setTitle("Scientific Calculator");
        setSize(400, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        inputField = new JTextField();
        inputField.setFont(new Font("Arial", Font.PLAIN, 24));
        inputField.setHorizontalAlignment(JTextField.RIGHT);

        buttons = new JButton[buttonLabels.length];
        for (int i = 0; i < buttonLabels.length; i++) {
            buttons[i] = new JButton(buttonLabels[i]);
            buttons[i].setFont(new Font("Arial", Font.PLAIN, 18));
            buttons[i].addActionListener(this);
        }

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(6, 4, 10, 10));
        for (JButton button : buttons) {
            buttonPanel.add(button);
        }

        setLayout(new BorderLayout());
        add(inputField, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if ("=".equals(command)) {
            String expression = inputField.getText();
            try {
                double result = evaluateExpression(expression);
                inputField.setText(Double.toString(result));
            } catch (Exception ex) {
                inputField.setText("Error");
            }
        } else if ("C".equals(command)) {
            inputField.setText("");
        } else {
            inputField.setText(inputField.getText() + command);
        }
    }

    private double evaluateExpression(String expression) {
        // You would need to implement your own expression evaluation logic here
        // This example uses a dummy implementation
        return Math.random() * 100; // Dummy result
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ScientificCalculator().setVisible(true));
    }
}
