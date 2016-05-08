package UI;

import javax.swing.*;
import java.awt.*;

public class DistributionSetUp extends JFrame {

    protected final JButton calculate;
    protected JButton prob;
    protected JButton x;
    protected JButton expected;
    protected JButton variance;
    protected JButton pmf;
    protected JButton cdf;
    protected final JTextField probVal;
    protected final JTextField xVal;
    protected final JTextField expectedVal;
    protected final JTextField varianceVal;
    protected final JTextField pmfVal;
    protected final JTextField cdfVal;

    public DistributionSetUp() {

        setSize(800, 600);
        setLayout(new BorderLayout());

        prob = new JButton("Probability of Success: ");
        x = new JButton("Successes: ");
        expected = new JButton("Expected Value: ");
        variance = new JButton("Variance: ");
        pmf = new JButton("P(X = a): ");
        cdf = new JButton("P(X <= a): ");
        calculate = new JButton("Calculate (only input into green coloured fields above)");

        probVal = new JTextField("?");
        probVal.setBackground(Color.green);
        xVal = new JTextField("?");
        xVal.setBackground(Color.green);
        expectedVal = new JTextField("");
        expectedVal.setBackground(Color.cyan);
        expectedVal.setFont(new Font("Arial", Font.PLAIN, 20));
        varianceVal = new JTextField("");
        varianceVal.setBackground(Color.cyan);
        varianceVal.setFont(new Font("Arial", Font.PLAIN, 20));
        pmfVal = new JTextField("");
        pmfVal.setBackground(Color.cyan);
        pmfVal.setFont(new Font("Arial", Font.PLAIN, 20));
        cdfVal = new JTextField("");
        cdfVal.setBackground(Color.cyan);
        cdfVal.setFont(new Font("Arial", Font.PLAIN, 20));
    }
}
