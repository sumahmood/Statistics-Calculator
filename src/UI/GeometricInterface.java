package UI;

import Exceptions.IllegalProbabilityException;
import Exceptions.IllegalValueException;
import Model.GeometricDistribution;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GeometricInterface extends DistributionSetUp {

    // Creates a pane for the Geometric distribution.
    // EFFECTS: Creates a tabbed pane for the Geometric distribution based on the fields relevant
    //          to that distribution. Also, ensures that the calculations made for the distribution
    //          are accurate and deal with cases where the user inputs invalid values.
    public GeometricInterface(JPanel panel) {
        super();
        panel.setLayout(new GridLayout(7, 2));
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
                    GeometricDistribution gdist = new GeometricDistribution(Float.parseFloat(probVal.getText()));
                    expectedVal.setText(String.valueOf(gdist.ExpectedValue()));
                    varianceVal.setText(String.valueOf(gdist.Variance()));
                    if (!xVal.getText().equals("?")) {
                        float massValue = gdist.ProbMassFunction(Integer.parseInt(xVal.getText()));
                        pmfVal.setText(String.valueOf(massValue));
                        float cumulativeVal = gdist.CumulativeDistributionFunction(Integer.parseInt(xVal.getText()));
                        cdfVal.setText(String.valueOf(cumulativeVal));
                    }
                } catch (IllegalArgumentException e1) {
                    JOptionPane.showMessageDialog(null, "Please enter valid numerical values", "Invalid value", JOptionPane.PLAIN_MESSAGE);
                } catch (IllegalProbabilityException e2) {
                    JOptionPane.showMessageDialog(null, "Probability must be between 0 and 1 (inclusive)", "Invalid value", JOptionPane.PLAIN_MESSAGE);
                } catch (IllegalValueException e3) {
                    JOptionPane.showMessageDialog(null, "Number of successes is either 0 or 1", "Invalid value", JOptionPane.PLAIN_MESSAGE);
                }
            }
        });
    }
}
