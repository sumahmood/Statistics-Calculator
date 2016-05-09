package UI;

import Exceptions.IllegalProbabilityException;
import Exceptions.IllegalValueException;
import Exceptions.TrialsValueException;
import Model.NegativeBinomialDistribution;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NegativeBinomialInterface extends DistributionSetUp {

    // Creates a pane for the Negative Binomial distribution.
    // EFFECTS: Creates a tabbed pane for the Negative Binomial distribution based on the fields relevant
    //          to that distribution. Also, ensures that the calculations made for the distribution
    //          are accurate and deal with cases where the user inputs invalid values.
    public NegativeBinomialInterface(JPanel panel) {
        super();
        JButton r = new JButton("Number of Successes (integer >= 1)");
        final JTextField rVal = new JTextField("?");
        rVal.setBackground(Color.green);

        panel.setLayout(new GridLayout(8,2));
        panel.add(r);
        panel.add(rVal);
        panel.add(prob);
        panel.add(probVal);
        panel.add(x);
        panel.add(xVal);
        panel.add(expected);
        panel.add(expectedVal);
        panel.add(variance);
        panel.add(varianceVal);
        panel.add(pmf);
        panel.add(pmfVal);
        panel.add(cdf);
        panel.add(cdfVal);
        panel.add(calculate);

        calculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    NegativeBinomialDistribution ndist = new NegativeBinomialDistribution(Integer.parseInt(rVal.getText()), Float.parseFloat(probVal.getText()));
                    expectedVal.setText(String.valueOf(ndist.ExpectedValue()));
                    varianceVal.setText(String.valueOf(ndist.Variance()));
                    if (!xVal.getText().equals("?")) {
                        float massValue = ndist.ProbMassFunction(Integer.parseInt(xVal.getText()));
                        pmfVal.setText(String.valueOf(massValue));
                        float cumulativeVal = ndist.CumulativeDistributionFunction(Integer.parseInt(xVal.getText()));
                        cdfVal.setText(String.valueOf(cumulativeVal));
                    }
                }

                catch (IllegalArgumentException e1) {
                    JOptionPane.showMessageDialog(null,"Please enter valid numerical values", "Invalid value", JOptionPane.PLAIN_MESSAGE);
                }
                catch (IllegalProbabilityException e2) {
                    JOptionPane.showMessageDialog(null,"Probability must be between 0 and 1 (inclusive)", "Invalid value", JOptionPane.PLAIN_MESSAGE);
                }
                catch (IllegalValueException e3) {
                    JOptionPane.showMessageDialog(null,"Number of successes has to be greater than or equal to the number of trials", "Invalid value", JOptionPane.PLAIN_MESSAGE);
                }
                catch (TrialsValueException e4) {
                    JOptionPane.showMessageDialog(null,"Please enter an integer value greater than or equal to 1 for the number of successes", "Invalid value", JOptionPane.PLAIN_MESSAGE);
                }
            }
        });
    }
}
