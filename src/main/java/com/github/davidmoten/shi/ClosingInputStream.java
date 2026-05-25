package com.github.davidmoten.shi;

import java.io.IOException;
import java.io.InputStream;
import io.reactivex.functions.Action;

class ClosingInputStream extends InputStream {

    private final InputStream in;

    private final Action action;

    ClosingInputStream(InputStream in, Action action) {
        this.in = in;
        this.action = action;
    }

    @Override
    public int read() throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void close() throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
