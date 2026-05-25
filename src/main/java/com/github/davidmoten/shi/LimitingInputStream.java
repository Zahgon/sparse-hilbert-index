package com.github.davidmoten.shi;

import java.io.IOException;
import java.io.InputStream;

final class LimitingInputStream extends InputStream {

    private final InputStream in;

    private final long limit;

    private long count;

    LimitingInputStream(InputStream in, long limit) {
        this.in = in;
        this.limit = limit;
    }

    @Override
    public int read() throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
