public class Polynomial extends Function{
    private final double[] coefficients;

    public Polynomial(double... coefficients) {
        int n = coefficients.length;
        this.coefficients = coefficients.clone();
    }

    @Override
    public double valueAt(double x) {
        double ret = 0;
        double xPower = 1;
        for (int i = 0; i < coefficients.length; i++) {
            ret += coefficients[i] * xPower;
            xPower *= x;
        }

        return ret;
    }

    @Override
    public String toString() {
        String ret = "(";

        ret += Double.toString(coefficients[0]);
        for (int i = 1; i < coefficients.length; i++) {
            ret += " + " + Double.toString(coefficients[i]) + "x^" + Integer.toString(i);
        }
        ret += ")";

        return ret;
    }

    @Override
    public Function derivative() {
        double[] newCoefficients = new double[coefficients.length - 1];
        for (int i = 1; i < coefficients.length; i++) {
            newCoefficients[i - 1] = coefficients[i] * i;
        }

        return new Polynomial(newCoefficients);
    }
}
