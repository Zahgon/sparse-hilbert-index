package com.github.davidmoten.shi;

import com.github.davidmoten.guavamini.Preconditions;

public final class PositionRange {

    // hilbert curve index ranges covered by this position range
    private final long maxHilbertIndex;

    // highest known position with index less than or equal to lowIndex or the
    // lowest known position if nothing lower
    private final long floorPosition;

    // lowest known position with index less than or equal to highIndex or the
    // highest known position if nothing higher
    private final long ceilingPosition;

    PositionRange(long maxHilbertIndex, long floorPosition, long ceilingPosition) {
        Preconditions.checkArgument(maxHilbertIndex >= 0);
        this.maxHilbertIndex = maxHilbertIndex;
        this.floorPosition = floorPosition;
        this.ceilingPosition = ceilingPosition;
    }

    public long maxHilbertIndex() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public long floorPosition() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public long ceilingPosition() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    PositionRange join(PositionRange other) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
