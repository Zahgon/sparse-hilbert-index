package com.github.davidmoten.shi;

import java.text.DecimalFormat;

public final class WithStats<T> {

    private final T value;

    private final long recordsRead;

    private final long bytesRead;

    private final long recordsFound;

    private final long timeToFirstByte;

    private final long chunksRead;

    private final long elapsedTime;

    WithStats(T value, long recordsRead, long recordsFound, long bytesRead, long timeToFirstByte, long chunksRead, long elapsedTime) {
        this.value = value;
        this.recordsRead = recordsRead;
        this.recordsFound = recordsFound;
        this.bytesRead = bytesRead;
        this.timeToFirstByte = timeToFirstByte;
        this.chunksRead = chunksRead;
        this.elapsedTime = elapsedTime;
    }

    public boolean hasValue() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public T value() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public long recordsRead() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public double hitRatio() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public long bytesRead() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public long recordsFound() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public long timeToFirstByteMs() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public double timeToFirstByteMsAverage() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public long chunksRead() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public long elapsedTimeMs() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
