package com.slobokot.leetcodetestengine;

import java.io.Reader;

public class PeekingReader {
    private final Reader reader;
    private boolean isFetched;
    private int fetchedValue;

    public PeekingReader(Reader reader) {
        this.reader = reader;
    }

    public int peek() throws Exception {
        if (isFetched) {
            return fetchedValue;
        }

        isFetched = true;
        fetchedValue = reader.read();
        return fetchedValue;
    }

    public int read() throws Exception {
        if (isFetched) {
            isFetched = false;
            return fetchedValue;
        }

        return reader.read();
    }
}
