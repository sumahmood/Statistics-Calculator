package Model;

import Exceptions.IllegalProbabilityException;
import Exceptions.IllegalValueException;

public class GeometricDistribution implements DiscreteProbabilityDistribution {

    private float p;

    // Models a Geometric distribution with the given parameter (probability of success).
    // EFFECTS: Creates a Geometric distribution with the given 'p' parameter.
    //          Throws IllegalProbabilityException if the probability is a value outside the interval (0,1).

    public GeometricDistribution(float p) throws IllegalProbabilityException {
        if (p < 0 || p > 1) {
            throw new IllegalProbabilityException();
        }

        this.p = p;
    }

    public float ExpectedValue() {
        return 1/p;
    }

    public float Variance() {
        return (1-p)/(p*p);
    }

    public float ProbMassFunction(int x) throws IllegalValueException {
        if (x < 1) {
            throw new IllegalValueException();
        }

        return (float) (Math.pow(1-p,x-1)*p);
    }

    public float CumulativeDistributionFunction(int x) throws IllegalValueException {
        if (x < 1) {
            throw new IllegalValueException();
        }

        float returnValue = 0;

        for (int i = 1; i <= x; i++) {
            returnValue += (float) (Math.pow(1-p,i-1)*p);
        }

        return returnValue;
    }
}
