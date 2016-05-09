package UI;


import Exceptions.IllegalProbabilityException;
import Exceptions.IllegalValueException;
import Exceptions.TrialsValueException;
import Model.PoissonDistribution;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PoissonInterface extends DistributionSetUp{

    // Creates a pane for the Poisson distribution.
    // EFFECTS: Creates a tabbed pane for the Poisson distribution based on the fields relevant
    //          to that distribution. Also, ensures that the calculations made for the distribution
    //          are accurate and deal with cases where the user inputs invalid values.
    public PoissonInterface(JPanel panel) {
        super();
        JButton lambda = new JButton("Rate of Poisson Process");
        final JTextField lambdaVal = new JTextField("?");
        lambdaVal.setBackground(Color.green);
        JButton interval = new JButton("Length of Inteval");
        final JTextField intervalVal = new JTextField("?");
        intervalVal.setBackground(Color.green);

        panel.setLayout(new GridLayout(8,2));
        panel.add(lambda);
        panel.add(lambdaVal);
        panel.add(interval);
        panel.add(intervalVal);
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
                    PoissonDistribution pdist = new PoissonDistribution(Float.parseFloat(lambdaVal.getText()), Float.parseFloat(intervalVal.getText()));
                    expectedVal.setText(String.valueOf(pdist.ExpectedValue()));
                    varianceVal.setText(String.valueOf(pdist.Variance()));
                    if (!xVal.getText().equals("?")) {
                        float massValue = pdist.ProbMassFunction(Integer.parseInt(xVal.getText()));
                        pmfVal.setText(String.valueOf(massValue));
                        float cumulativeVal = pdist.CumulativeDistributionFunction(Integer.parseInt(xVal.getText()));
                        cdfVal.setText(String.valueOf(cumulativeVal));
                    }
                }

                catch (IllegalArgumentException e1) {
                    JOptionPane.showMessageDialog(null,"Please enter valid numerical values", "Invalid value", JOptionPane.PLAIN_MESSAGE);
                }
                catch (IllegalProbabilityException e2) {
                    JOptionPane.showMessageDialog(null,"Lambda must be greater than 0", "Invalid value", JOptionPane.PLAIN_MESSAGE);
                }
                catch (IllegalValueException e3) {
                    JOptionPane.showMessageDialog(null,"The number of successes must be greater than or equal to 0", "Invalid value", JOptionPane.PLAIN_MESSAGE);
                }
                catch (TrialsValueException e4) {
                    JOptionPane.showMessageDialog(null,"The interval under consideration must be greater than 0", "Invalid value", JOptionPane.PLAIN_MESSAGE);
                }
            }
        });
    }
}
