public class MultiSum extends Function{
    protected final Function[] funcs;

    public MultiSum(Function... funcs) {
        //TODO: check deep copy stuff
        this.funcs = funcs.clone();
    }

    @Override
    public double valueAt(double x) {
        double ret = 0;

        for (int i = 0; i < funcs.length; i++) {
            ret += funcs[i].valueAt(x);
        }

        return ret;
    }

    @Override
    public String toString() {
        String ret = "(";

        ret += funcs[0].toString();
        for (int i = 1; i < funcs.length; i++) {
            ret += " + " + funcs[i].toString();
        }
        ret += ")";

        return ret;
    }

    @Override
    public Function derivative() {
        Function[] dFuncs = new Function[funcs.length];

        for (int i = 0; i < funcs.length; i++) {
            dFuncs[i] = funcs[i].derivative();
        }

        return new MultiSum(dFuncs);
    }
}
