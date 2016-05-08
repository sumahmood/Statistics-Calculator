package Model;

import Exceptions.IllegalProbabilityException;
import Exceptions.IllegalValueException;

public class GeometricDistribution implements DiscreteProbabilityDistribution {

    private float p;

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
