package com.github.davidmoten.shi;

import java.io.IOException;
import java.io.InputStream;

final class CountingInputStream extends InputStream {

    private final InputStream in;

    private long count;

    private long startTime;

    private long ttfb;

    CountingInputStream(InputStream in, long startTime) {
        this.in = in;
        this.startTime = startTime;
    }

    @Override
    public int read() throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private void postRead() {
        if (startTime != -1) {
            ttfb = System.currentTimeMillis() - startTime;
            startTime = -1;
        }
    }

    long count() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    long readTimeToFirstByteAndSetToZero() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
