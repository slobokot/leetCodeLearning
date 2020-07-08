Learning LeetCode

### Writing tests file
For a java method
```
int doSomething(int a, String b, int[] c)
```
following java test
```text
Assert.equals(7, doSomething(1, "foo", new int[]{4,5,6}))
```
Can be represented in a text file as
```text
1
"foo"
[4,5,6]
=7
```
Test cases in a file separated with a blank line
### Running tests
Running all tests in a file
```
    @TestFactory
    public List<DynamicTest> leetCodeTests() throws Exception {
        return new TestRunner().runLeetCodeTests(new Solution(),
                "com/slobokot/problems/dp/EditDistance72.txt");
    }
```

Running a single test
```
    @Test
    public void leetCodeTest2() throws Throwable {
        new TestRunner().runLeetCodeTest(new Solution(),
                "com/slobokot/problems/dp/EditDistance72.txt", "test2");
    }
```