import java.util.function.Function;

public class HillClimbing {
    public static double hillClimb(Function<Double, Double> function, double initialGuess, double stepSize, int maxIterations) {
        double currentX = initialGuess;
        double currentValue = function.apply(currentX);

        for (int i = 0; i < maxIterations; i++) {
            double nextX = currentX + stepSize;
            double nextValue = function.apply(nextX);

            if (nextValue < currentValue) {
                currentX = nextX;
                currentValue = nextValue;
            } else {
                stepSize = -stepSize;  // Change direction if no improvement
            }
        }

        return currentX;
    }

    public static void main(String[] args) {
        Function<Double, Double> function = x -> x * x - 4 * x + 4; // Example function: x^2 - 4x + 4
        double initialGuess = 0.0;
        double stepSize = 0.1;
        int maxIterations = 100;

        double result = hillClimb(function, initialGuess, stepSize, maxIterations);
        System.out.println("Optimal x: " + result);
        System.out.println("Optimal y: " + function.apply(result));
    }
}
