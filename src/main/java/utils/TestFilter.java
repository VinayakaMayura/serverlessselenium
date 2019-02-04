package utils;

import org.junit.runner.Description;
import org.junit.runner.manipulation.Filter;

public class TestFilter extends Filter {

    private final String methodName;

    public TestFilter(String methodName) {
        this.methodName = methodName;
    }

    @Override
    public boolean shouldRun(Description description) {
        return description.getMethodName().equals(methodName);
    }

    @Override
    public String describe() {
        return "Includes tests with method name: " + methodName;
    }
}
