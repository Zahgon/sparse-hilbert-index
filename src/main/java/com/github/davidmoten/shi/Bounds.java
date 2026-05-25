package com.github.davidmoten.shi;

import java.util.Arrays;
import com.github.davidmoten.guavamini.Preconditions;

public final class Bounds {

    private final double[] mins;

    private final double[] maxes;

    private Bounds(double[] a, double[] b) {
        Preconditions.checkArgument(a.length > 0);
        Preconditions.checkArgument(a.length == b.length);
        double[] mins = new double[a.length];
        double[] maxes = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            mins[i] = Math.min(a[i], b[i]);
            maxes[i] = Math.max(a[i], b[i]);
        }
        this.mins = mins;
        this.maxes = maxes;
    }

    public static Bounds create(double[] a, double[] b) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public boolean contains(double[] d) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public double[] mins() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public double[] maxes() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
