package com.slobokot.leetcodetestengine;

import com.slobokot.JarResources;
import com.slobokot.leetcodetestengine.parser.TestFileIterator;
import com.slobokot.leetcodetestengine.parser.Token;
import com.slobokot.leetcodetestengine.parser.TokenType;
import org.junit.jupiter.api.Test;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TestFileIteratorTest {

    @Test
    public void oneCaseNonQuotedString() throws Exception {
        TestFileIterator iterator = new TestFileIterator(new StringReader(new JarResources().readAsString(
                "com/slobokot/leetcodetestengine/TestFileIterator/oneCaseNonQuotedString.txt")));
        List<Token> actual = new ArrayList<>();
        iterator.forEachRemaining(actual::add);
        List<Token> expected = Arrays.asList(
                new Token(TokenType.NON_QUOTED_STRING, "1"),
                Token.NEW_LINE,
                Token.ANSWER,
                new Token(TokenType.NON_QUOTED_STRING, "3"),
                Token.NEW_LINE
        );

        assertEquals(expected, actual);
    }

    @Test
    public void twoCasesQuotedString() throws Exception {
        TestFileIterator iterator = new TestFileIterator(new StringReader(new JarResources().readAsString(
                "com/slobokot/leetcodetestengine/TestFileIterator/twoCasesQuotedString.txt")));
        List<Token> actual = new ArrayList<>();
        iterator.forEachRemaining(actual::add);
        List<Token> expected = Arrays.asList(
                new Token(TokenType.QUOTED_STRING, "1"),
                Token.NEW_LINE,
                Token.ANSWER,
                new Token(TokenType.QUOTED_STRING, "3"),
                Token.NEW_LINE,
                Token.NEW_LINE,
                new Token(TokenType.QUOTED_STRING, "2"),
                Token.NEW_LINE,
                Token.ANSWER,
                new Token(TokenType.QUOTED_STRING, "5"),
                Token.NEW_LINE
        );

        assertEquals(expected, actual);
    }

    @Test
    public void singleDimensionalArrayEmpty() throws Exception {
        TestFileIterator iterator = new TestFileIterator(new StringReader(new JarResources().readAsString(
                "com/slobokot/leetcodetestengine/TestFileIterator/singleDimensionalArrayEmpty.txt")));
        List<Token> actual = new ArrayList<>();
        iterator.forEachRemaining(actual::add);
        List<Token> expected = Arrays.asList(
                Token.ARRAY_START,
                Token.ARRAY_END,
                Token.NEW_LINE
        );

        assertEquals(expected, actual);
    }

    @Test
    public void singleDimensionalArrayOneElement() throws Exception {
        TestFileIterator iterator = new TestFileIterator(new StringReader(new JarResources().readAsString(
                "com/slobokot/leetcodetestengine/TestFileIterator/singleDimensionalArrayOneElement.txt")));
        List<Token> actual = new ArrayList<>();
        iterator.forEachRemaining(actual::add);
        List<Token> expected = Arrays.asList(
                Token.ARRAY_START,
                new Token(TokenType.NON_QUOTED_STRING, "7"),
                Token.ARRAY_END,
                Token.NEW_LINE
        );

        assertEquals(expected, actual);
    }

    @Test
    public void singleDimensionalArrayTwoElements() throws Exception {
        TestFileIterator iterator = new TestFileIterator(new StringReader(new JarResources().readAsString(
                "com/slobokot/leetcodetestengine/TestFileIterator/singleDimensionalArrayTwoElements.txt")));
        List<Token> actual = new ArrayList<>();
        iterator.forEachRemaining(actual::add);
        List<Token> expected = Arrays.asList(
                Token.ARRAY_START,
                new Token(TokenType.NON_QUOTED_STRING, "6"),
                Token.SEPARATOR,
                new Token(TokenType.QUOTED_STRING, "5"),
                Token.SEPARATOR,
                new Token(TokenType.NON_QUOTED_STRING, "3"),
                Token.ARRAY_END,
                Token.NEW_LINE
        );

        assertEquals(expected, actual);
    }

    @Test
    public void twoSingleDimensionalArrays() throws Exception {
        TestFileIterator iterator = new TestFileIterator(new StringReader(new JarResources().readAsString(
                "com/slobokot/leetcodetestengine/TestFileIterator/twoSingleDimensionalArrays.txt")));
        List<Token> actual = new ArrayList<>();
        iterator.forEachRemaining(actual::add);
        List<Token> expected = Arrays.asList(
                Token.ARRAY_START,
                new Token(TokenType.NON_QUOTED_STRING, "1"),
                Token.SEPARATOR,
                new Token(TokenType.NON_QUOTED_STRING, "2"),
                Token.ARRAY_END,
                Token.NEW_LINE,
                Token.ARRAY_START,
                new Token(TokenType.QUOTED_STRING, "4"),
                Token.SEPARATOR,
                new Token(TokenType.NON_QUOTED_STRING, "8"),
                Token.ARRAY_END,
                Token.NEW_LINE,
                Token.ANSWER,
                new Token(TokenType.QUOTED_STRING, "3"),
                Token.NEW_LINE
        );

        assertEquals(expected, actual);
    }

    @Test
    public void twoDimensionalArrayOneElement() throws Exception {
        TestFileIterator iterator = new TestFileIterator(new StringReader(new JarResources().readAsString(
                "com/slobokot/leetcodetestengine/TestFileIterator/twoDimensionalArrayOneElement.txt")));
        List<Token> actual = new ArrayList<>();
        iterator.forEachRemaining(actual::add);
        List<Token> expected = Arrays.asList(
                Token.ARRAY_START,
                Token.NEW_LINE,
                Token.ARRAY_START,
                new Token(TokenType.QUOTED_STRING, "First"),
                Token.SEPARATOR,
                Token.NEW_LINE,
                new Token(TokenType.QUOTED_STRING, "Second"),
                Token.ARRAY_END,
                Token.SEPARATOR,
                Token.NEW_LINE,
                Token.ARRAY_START,
                new Token(TokenType.QUOTED_STRING, "Third"),
                Token.SEPARATOR,
                Token.NEW_LINE,
                new Token(TokenType.QUOTED_STRING, "Forth"),
                Token.ARRAY_END,
                Token.NEW_LINE,
                Token.ARRAY_END,
                Token.NEW_LINE
        );

        assertEquals(expected, actual);
    }

}