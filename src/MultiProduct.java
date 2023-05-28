public class MultiProduct extends Function {
    protected final Function[] funcs;

    public MultiProduct(Function... funcs) {
        //TODO: check deep copy stuff
        this.funcs = funcs.clone();
    }

    @Override
    public double valueAt(double x) {
        double ret = 0;

        for (int i = 0; i < funcs.length; i++) {
            ret *= funcs[i].valueAt(x);
        }

        return ret;
    }

    @Override
    public String toString() {
        String ret = "(";

        for (int i = 0; i < funcs.length; i++) {
            ret += funcs[i].toString();
        }
        ret += ")";

        return ret;
    }

    @Override
    public Function derivative() {
        Function[] retFuncs = new Function[funcs.length];
        for (int i = 0; i < funcs.length; i++) {
            Function[] tempFuncs = new Function[funcs.length];

            for (int j = 0; j < funcs.length; j++) {
                tempFuncs[j] = j == i ? funcs[j].derivative() : funcs[j];
            }
            retFuncs[i] = new MultiProduct(tempFuncs);
        }

        return new MultiSum(retFuncs);
    }
}
