import java.lang.Math;

public abstract class Function {
    private static double TAYLORX0 = 0;

    @Override
    public abstract String toString();

    public abstract double valueAt(double x);

    public abstract Function derivative();

    /**
     * Calculate approximation of root between a and b, using the divide method and return it.
     * The approximation is in epsilon accuracy.
     * @param a the lowest value in the range to search in
     * @param b the highest value in the range to search in
     * @param epsilon the accuracy of the approximation
     * @return the approximation of the root
     */
    public double bisectionMethod(double a, double b, double epsilon) {
        if (this.valueAt(a) * this.valueAt(b) >= 0) {
            // TODO: delete this after checking all HW2
            throw new IllegalArgumentException("bisection got values it shouldn't get - f(a) * f(b) >= 0");
        }
        double left = a, right = b;
        double mid;
        while (right - left > epsilon) {
            mid = (left + right) / 2;
            if (this.valueAt(left) * this.valueAt(mid) > 0) {
                left = mid;
            }
            else{
                // TODO: to ask if need to deal with case mid == 0, because it isn't written but the algorithm isn't
                //  working in some cases if not handles
                right = mid;
            }
        }
        return (left + right) / 2;
    }

    /**
     * Calculate approximation of root between a and b, using the divide method and return it.
     * The approximation is in 10^-5 accuracy.
     * @param a the lowest value in the range to search in
     * @param b the highest value in the range to search in
     * @return the approximation of the root
     */
    public double bisectionMethod(double a, double b) {
        return bisectionMethod(a, b, Math.pow(10.0, -5.0));
    }

    /**
     * Calculate approximation of root near a, using Newton-Raphson method and return it.
     * The approximation is in epsilon accuracy.
     * @param a the x to find approximation near it
     * @param epsilon the accuracy of the approximation
     * @return the approximation of the root
     */
    public double newtonRaphsonMethod(double a, double epsilon) {
        double currElement = a;
        while (Math.abs(this.valueAt(currElement)) >= epsilon) {
            currElement = currElement - (this.valueAt(currElement) / this.derivative().valueAt(currElement));
        }
        return currElement;
    }

    /**
     * Calculate approximation of root near a, using Newton-Raphson method and return it.
     * The approximation is in 10^-5 accuracy.
     * @param a the x to find approximation near it
     * @return the approximation of the root
     */
    public double newtonRaphsonMethod(double a) {
        return newtonRaphsonMethod(Math.pow(10.0, -5.0));
    }

    /**
     * Calculates factorial of integer (and returns the result in double)
     * @param n The number to calculate n!
     * @return double type that represents (n!)
     */
    private static double factorial(int n) {
        // TODO: do you think the function should be in this Class? should be static?
        double doubleN = n;
        double mult = 1.0;
        for(double i = 2; i <= doubleN; i++) {
            mult *= (double) i;
        }
        return mult;
    }

    /**
     * calculate taylor polynomial from order n, near Function.TAYLORX0 and returns it
     * @param n the order of the polynomial
     * @return The taylor polynomial
     */
    public Polynomial taylorPolynomial(int n) {
        double[] coefficients = new double[n];
        Function currDerivative = this;
        for(int i = 0; i <= n; i++) {
            coefficients[i] = currDerivative.valueAt(Function.TAYLORX0) / Function.factorial(n);
        }
        // TODO: make sure the build function works this way
        return new Polynomial(coefficients);
    }
}
