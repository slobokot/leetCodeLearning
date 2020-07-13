package com.slobokot.leetcodetestengine.parser;

import com.slobokot.leetcodetestengine.PeekingReader;

import java.io.Reader;
import java.util.Iterator;

public class TestFileIterator implements Iterator<Token> {

    private final PeekingReader reader;
    private int stack = 0;
    private int line = 1;
    private int column = 1;
    private boolean hasNextCalled;
    private Token token;

    public TestFileIterator(Reader reader) {
        this.reader = new PeekingReader(reader);
    }

    @Override
    public boolean hasNext() {
        try {
            hasNextCalled = true;
            token = null;
            consumeWhitespace();
            int i = reader.peek();
            if (isEOF(i)) return false;
            char c = (char) i;

            switch (c) {
                case '\n':
                    line++;
                case '\r':
                    reader.read();
                    token = Token.NEW_LINE;
                    break;
                case ',':
                    reader.read();
                    token = Token.SEPARATOR;
                    break;
                case '[':
                    reader.read();
                    token = Token.ARRAY_START;
                    stack++;
                    break;
                case ']':
                    reader.read();
                    token = Token.ARRAY_END;
                    stack--;
                    break;
                case '=':
                    reader.read();
                    token = Token.ANSWER;
                    break;
                case '"':
                    consumeQuotedString();
                    break;
                default:
                    consumeNonQuotedString();
                    break;
            }

            return true;
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Token next() {
        if (!hasNextCalled) {
            hasNext();
        }
        hasNextCalled = false;
        return token;
    }

    private void consumeNonQuotedString() throws Exception {
        StringBuilder sb = new StringBuilder();

        while(true) {
            int i = reader.peek();
            if (isEOF(i) || !(Character.isAlphabetic(i) || Character.isDigit(i))) {
                token = new Token(TokenType.NON_QUOTED_STRING, sb.toString());
                return;
            }
            reader.read();
            sb.append((char)i);
        }
    }

    private void consumeWhitespace() throws Exception {
        while(true) {
            int i = reader.peek();
            if (isEOF(i)) {
                return;
            }

            if(isWhiteSpace(i)) {
                reader.read();
            } else {
                return;
            }
        }
    }

    private boolean isWhiteSpace(int i) {
        char c = (char) i;
        return c == ' ' || c =='\t';
    }

    private boolean isEOL(int i) {
        char c = (char) i;
        return c == '\r' || c == '\n';
    }

    private boolean isEOF(int i) {
        return i == -1;
    }

    private boolean isSeparator(int i) {
        char c = (char) i;
        return c == ',';
    }

    private void consumeQuotedString() throws Exception {
        StringBuilder sb = new StringBuilder();
        reader.read();

        while(true) {
            int i = reader.read();
            if (i == -1) {
                throw new RuntimeException("Unexpected end of file");
            }
            char c = (char) i;
            if(c == '"') {
                token = new Token(TokenType.QUOTED_STRING, sb.toString());
                return;
            }
            sb.append(c);
        }
    }

    @Override
    public String toString() {
        return "TestFileIterator{" +
                "line=" + line +
                '}';
    }
}
