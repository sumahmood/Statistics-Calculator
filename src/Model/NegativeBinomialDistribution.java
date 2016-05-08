package Model;

import Exceptions.IllegalProbabilityException;
import Exceptions.IllegalValueException;
import Exceptions.TrialsValueException;

public class NegativeBinomialDistribution extends CombinationDistributions implements DiscreteProbabilityDistribution {

    int r;
    float p;

    public NegativeBinomialDistribution(int r, float p) throws IllegalProbabilityException, TrialsValueException {

        if (p < 0 || p > 1) {
            throw new IllegalProbabilityException();
        }

        if (r < 1) {
            throw new TrialsValueException();
        }

        this.r = r;
        this.p = p;
    }

    public float ExpectedValue() {
        return r / p;
    }

    public float Variance() {
        return (r * p) / ((1 - p) * (1 - p));
    }

    public float ProbMassFunction(int x) throws IllegalValueException {
        if (x < r) {
            throw new IllegalValueException();
        }

        return (float) ((choose(x - 1, r - 1)) * Math.pow(p, r) * Math.pow(1 - p, x - r));
    }

    public float CumulativeDistributionFunction(int x) throws IllegalValueException {
        if (x < r) {
            throw new IllegalValueException();
        }

        float returnValue = 0;

        for (int i = r; i <= x; i++) {
            returnValue += (float) ((choose(x - 1, i - 1)) * Math.pow(p, i) * Math.pow(1 - p, x - i));
        }

        return returnValue;
    }
}
