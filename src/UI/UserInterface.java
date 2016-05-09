package UI;

import javax.swing.*;
import java.awt.*;

public class UserInterface extends JFrame {

    private static final int WIDTH = 800;
    private static final int HEIGHT = 400;

    // Creates the interface that includes all the distributions with a separate tabbed pane for each distribution.
    // EFFECTS: Creates a tabbed with a number of panels for each of the distributions in the calculator. The interface
    //          for each particular distribution is derived from the interface created for each particular distribution.
    public UserInterface() {

        JTabbedPane tabbedPane = new JTabbedPane();

        setSize(WIDTH, HEIGHT);
        setLayout(new BorderLayout());

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();
        JPanel panel5 = new JPanel();

        tabbedPane.addTab("Bernoulli Distribution", panel1);
        BernoulliPanel(panel1);

        tabbedPane.addTab("Binomial Distribution", panel2);
        BinomialPanel(panel2);

        tabbedPane.addTab("Geometric Distribution", panel3);
        GeometricPanel(panel3);

        tabbedPane.addTab("Negative Binomial Distribution", panel4);
        NegBinPanel(panel4);

        tabbedPane.addTab("Poisson Distribution", panel5);
        PoissonPanel(panel5);

        Container c = getContentPane();

        c.add(tabbedPane, BorderLayout.CENTER);

        setVisible(true);
    }

    // Creates a panel for the Bernoulli Distribution.
    private void BernoulliPanel(JPanel panel) {
        new BernoulliInterface(panel);
    }

    // Creates a panel for the Binomial Distribution.
    private void BinomialPanel(JPanel panel) {
        new BinomialInterface(panel);
    }

    // Creates a panel for the Geometric Distribution.
    private void GeometricPanel(JPanel panel) {
        new GeometricInterface(panel);
    }

    // Creates a panel for the Negative Binomial Distribution.
    private void NegBinPanel(JPanel panel) {
        new NegativeBinomialInterface(panel);
    }

    // Creates a panel for the Poisson Distribution.
    private void PoissonPanel(JPanel panel) {
        new PoissonInterface(panel);
    }

    public static void main(String[] args) {
        new UserInterface();
    }
}