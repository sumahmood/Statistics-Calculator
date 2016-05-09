package UI;

import Exceptions.IllegalProbabilityException;
import Exceptions.IllegalValueException;
import Exceptions.TrialsValueException;
import Model.BinomialDistribution;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BinomialInterface extends DistributionSetUp {

    // Creates a pane for the Binomial distribution.
    // EFFECTS: Creates a tabbed pane for the Binomial distribution based on the fields relevant
    //          to that distribution. Also, ensures that the calculations made for the distribution
    //          are accurate and deal with cases where the user inputs invalid values.
    public BinomialInterface(JPanel panel) {
        super();
        JButton n = new JButton("Number of Trials");
        final JTextField nVal = new JTextField("?");
        nVal.setBackground(Color.green);

        panel.setLayout(new GridLayout(8,2));
        panel.add(n);
        panel.add(nVal);
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
                    BinomialDistribution bdist = new BinomialDistribution(Integer.parseInt(nVal.getText()), Float.parseFloat(probVal.getText()));
                    expectedVal.setText(String.valueOf(bdist.ExpectedValue()));
                    varianceVal.setText(String.valueOf(bdist.Variance()));
                    if (!xVal.getText().equals("?")) {
                        float massValue = bdist.ProbMassFunction(Integer.parseInt(xVal.getText()));
                        pmfVal.setText(String.valueOf(massValue));
                        float cumulativeVal = bdist.CumulativeDistributionFunction(Integer.parseInt(xVal.getText()));
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
                    JOptionPane.showMessageDialog(null,"Number of successes is an integer greater than or equal to 1 and less than or equal to number of trials", "Invalid value", JOptionPane.PLAIN_MESSAGE);
                }
                catch (TrialsValueException e4) {
                    JOptionPane.showMessageDialog(null,"Please enter an integer value greater than or equal to 1 for the number of trials", "Invalid value", JOptionPane.PLAIN_MESSAGE);
                }
            }
        });
    }
}