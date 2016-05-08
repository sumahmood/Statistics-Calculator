package UI;

import Exceptions.IllegalProbabilityException;
import Exceptions.IllegalValueException;
import Model.BernoulliDistribution;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BernoulliInterface extends DistributionSetUp {

    public BernoulliInterface(JPanel panel){

        super();
        panel.setLayout(new GridLayout(7,2));
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
                    BernoulliDistribution bdist = new BernoulliDistribution(Float.parseFloat(probVal.getText()));
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
                    JOptionPane.showMessageDialog(null,"Number of successes is either 0 or 1", "Invalid value", JOptionPane.PLAIN_MESSAGE);
                }
            }
        });

    }
}
