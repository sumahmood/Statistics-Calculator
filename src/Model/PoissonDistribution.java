package Model;

import Exceptions.IllegalProbabilityException;
import Exceptions.IllegalValueException;
import Exceptions.TrialsValueException;

public class PoissonDistribution extends CombinationDistributions implements DiscreteProbabilityDistribution {

    float lambda;
    float interval;

    public PoissonDistribution(float lambda, float interval) throws IllegalProbabilityException, TrialsValueException {

        if (lambda <= 0) {
            throw new IllegalProbabilityException();
        }

        if (interval <= 0) {
            throw new TrialsValueException();
        }

        this.lambda = lambda;
        this.interval = interval;
    }

    public float ExpectedValue() {
        return lambda*interval;
    }

    public float Variance() {
        return lambda*interval;
    }

    public float ProbMassFunction(int x) throws IllegalValueException {
        if (x < 0) {
            throw new IllegalValueException();
        }

        return (float) ((Math.pow(lambda*interval,x)*Math.exp(-lambda*interval))/numerator(x));
    }

    public float CumulativeDistributionFunction(int x) throws IllegalValueException {
        if (x < 0) {
            throw new IllegalValueException();
        }

        float returnVal = 0;

        for (int i = 0; i <= x; i++) {
            returnVal += (float) ((Math.pow(lambda*interval,i)*Math.exp(-lambda*interval))/numerator(i));
        }

        return returnVal;
    }
}
