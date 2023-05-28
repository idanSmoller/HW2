public class Power extends Function{
    private Function func;
    private int exp;

    public Power(Function func, int exp) {
        this.func = func;
        this.exp = exp;
    }

    @Override
    public double valueAt(double x) {
        return Math.pow(this.func.valueAt(x), this.exp);
    }

    @Override
    public String toString() {
        return "(" + func.toString() + "^" + Integer.toString(exp) + ")";
    }

    @Override
    public Function derivative() {
        if (exp == 1) {
            return func.derivative();
        }
        else {
            return new MultiProduct(new Constant(exp), new Power(func, exp - 1), func.derivative());
        }
    }
}
