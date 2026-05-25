package com.github.davidmoten.shi;

import java.io.IOException;
import java.io.OutputStream;

final class CountingOutputStream extends OutputStream {

    private long count;

    @Override
    public void write(int b) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    long count() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
