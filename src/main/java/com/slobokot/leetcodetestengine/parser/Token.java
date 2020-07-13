package com.slobokot.leetcodetestengine.parser;

import java.util.Objects;

public class Token {
    private final TokenType type;
    private final String value;
    public final static Token ARRAY_START = new Token(TokenType.ARRAY_START, null);
    public final static Token ARRAY_END = new Token(TokenType.ARRAY_END, null);
    public final static Token SEPARATOR = new Token(TokenType.SEPARATOR, null);
    public final static Token ANSWER = new Token(TokenType.ANSWER, null);
    public final static Token NEW_LINE = new Token(TokenType.NEW_LINE, null);

    public Token(TokenType type, String value) {
        this.type = type;
        this.value = value;
    }

    public TokenType getType() {
        return type;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Token token = (Token) o;
        return type == token.type &&
                Objects.equals(value, token.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, value);
    }

    @Override
    public String toString() {
        switch(type) {
            case QUOTED_STRING:
                return "\"" + value + "\"";
            case NON_QUOTED_STRING:
                return value;
            default:
                return type.name();
        }
    }
}
