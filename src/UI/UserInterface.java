package UI;

import javax.swing.*;
import java.awt.*;

public class UserInterface extends JFrame {

    private static final int WIDTH = 800;
    private static final int HEIGHT = 400;

    public UserInterface() {

        JTabbedPane tabbedPane = new JTabbedPane();

        setSize(WIDTH, HEIGHT);
        setLayout(new BorderLayout());

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();
        JPanel panel5 = new JPanel();
        JPanel panel6 = new JPanel();

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

    private void BernoulliPanel(JPanel panel) {
        new BernoulliInterface(panel);
    }

    private void BinomialPanel(JPanel panel) {
        new BinomialInterface(panel);
    }

    private void GeometricPanel(JPanel panel) {
        new GeometricInterface(panel);
    }

    private void NegBinPanel(JPanel panel) {
        new NegativeBinomialInterface(panel);
    }

    private void PoissonPanel(JPanel panel) {
        new PoissonInterface(panel);
    }

    public static void main(String[] args) {
        new UserInterface();
    }
}