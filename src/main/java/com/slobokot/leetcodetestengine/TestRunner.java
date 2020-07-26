package com.slobokot.leetcodetestengine;

import com.slobokot.JarResources;
import com.slobokot.leetcodetestengine.assertion.LeetAssertions;
import com.slobokot.leetcodetestengine.convertor.ArrayParameterConverter;
import com.slobokot.leetcodetestengine.convertor.ChainConverter;
import com.slobokot.leetcodetestengine.convertor.ListParameterConverter;
import com.slobokot.leetcodetestengine.convertor.ParameterConverter;
import com.slobokot.leetcodetestengine.convertor.PrimitiveParameterConverter;
import com.slobokot.leetcodetestengine.convertor.StringParameterConverter;
import com.slobokot.leetcodetestengine.parser.TestFileIterator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DynamicTest;

import java.io.StringReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class TestRunner {
    private static final Set<String> defaultMethods;
    private static final ParameterConverter PARAMETER_CONVERTER;
    private static final LeetAssertions leetAssertions;

    static {
        ChainConverter convertor = new ChainConverter()
                .add(new PrimitiveParameterConverter())
                .add(new StringParameterConverter());
        convertor.add(new ArrayParameterConverter(convertor));
        convertor.add(new ListParameterConverter(convertor));
        PARAMETER_CONVERTER = convertor;
        defaultMethods = new HashSet<>();
        defaultMethods.addAll(Arrays.asList("equals",
                "hashCode", "toString", "clone", "finalize", "wait", "getClass", "notify",
                "notifyAll"));
        leetAssertions = new LeetAssertions();
    }

    /**
     * Usage
     *     @TestFactory
     *     List<DynamicTest> leetCodeTests() throws Exception {
     *         return new TestRunner().runLeetCodeTests(
     *                 new ObjectUnderTest(),
     *                 "com/myTest.txt");
     *     }
     * @param object implementation class
     * @param fileName resource file with leetCode tests
     * @return Dynamic tests for Junit5
     * @throws Exception everything
     */
    public List<DynamicTest> runLeetCodeTests(Object object, String fileName) throws Exception {
        Method testMethod = findTestMethod(object);
        TestFileIterator iterator = new TestFileIterator(new StringReader(new JarResources().readAsString(fileName)));
        TestSuiteArgs suiteIterator = new TestSuiteArgs(iterator,
                PARAMETER_CONVERTER,
                testMethod.getParameterTypes(),
                testMethod.getReturnType());
        return suiteIterator.getAllTestArgs()
        .stream()
        .map(x ->
             DynamicTest.dynamicTest(
                    x.getName(),
                     () -> runTest(object, testMethod, x)
            )
        ).collect(Collectors.toList());
    }

    public void runLeetCodeTest(Object object, String fileName, String testName) throws Throwable {
        List<DynamicTest> dynamicTests = runLeetCodeTests(object, fileName);
        for (DynamicTest dynamicTest : dynamicTests) {
            if(dynamicTest.getDisplayName().equals(testName)) {
                dynamicTest.getExecutable().execute();
                return;
            }
        }

        throw new RuntimeException("Test " + testName + " not found");
    }

    void runTest(Object object, Method testMethod, TestArgs args) {
        System.out.println("Running " + args.getName() + ", input:\n" + args.getStringArgs());
        long started = System.nanoTime();
        Object actual;
        try {
            actual = testMethod.invoke(object, args.getArgs());
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        long elapsed = System.nanoTime() - started;

        leetAssertions.assertEquals(args.getResult(), actual);
        System.out.println("Completed in " + TimeUnit.NANOSECONDS.toMillis(elapsed) + "ms");
    }

    private Method findTestMethod(Object object) {
        Method candidate = null;
        for (Method method : object.getClass().getMethods()) {
            if (Modifier.isPublic(method.getModifiers()) &&
                    !defaultMethods.contains(method.getName())) {
                if (candidate != null) {
                    throw new RuntimeException("Multiple public methods found " + candidate + ", " + method);
                }

                candidate = method;
            }
        }

        if (candidate == null)
            throw new RuntimeException("No public method was found");

        return candidate;
    }
}
